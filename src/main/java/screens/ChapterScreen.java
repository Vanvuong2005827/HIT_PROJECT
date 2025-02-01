package screens;

import models.chapter_information.AllChapters;
import models.chapter_information.Chapter;
import models.chapter_information.ChapterImage;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import utils.GetChapters;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.*;

import static utils.customBookGridPanel.resizeImage;

public class ChapterScreen extends JFrame {
    GetChapters getChapter = new GetChapters();
    JFrame previousScreen;
    AllChapters chapters;
    int totalChapters;
    public ChapterScreen(JFrame jf, AllChapters c) {
        previousScreen = jf;
        chapters = c;
        initComponents();
        processData();
        setLocationRelativeTo(null);
    }
    private void initComponents() {

        mainPanel = new JPanel();
        chapterPanelLayeded = new JLayeredPane();
        chapterBackLabel = new JLabel();
        chapterScrollPane = new JScrollPane();
        chapterImgLabel = new JPanel();
        chapterNameLabel = new JLabel();
        chapterNext = new JLabel();
        chapterPrevious = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainPanel.setBackground(new Color(176, 223, 251));

        chapterPanelLayeded.setLayout(new AbsoluteLayout());

        chapterBackLabel.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        chapterBackLabel.setText("<");
        chapterBackLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                backEvent(evt);
            }
        });
        chapterPanelLayeded.add(chapterBackLabel, new AbsoluteConstraints(10, 10, 30, 30));

        chapterScrollPane.setBorder(null);

        chapterImgLabel.setBackground(new Color(176, 223, 251));

        GroupLayout chapterImgLabelLayout = new GroupLayout(chapterImgLabel);
        chapterImgLabel.setLayout(chapterImgLabelLayout);
        chapterImgLabelLayout.setHorizontalGroup(
                chapterImgLabelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 450, Short.MAX_VALUE)
        );
        chapterImgLabelLayout.setVerticalGroup(
                chapterImgLabelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 710, Short.MAX_VALUE)
        );

        chapterScrollPane.setViewportView(chapterImgLabel);

        chapterScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        chapterScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        chapterPanelLayeded.add(chapterScrollPane, new AbsoluteConstraints(0, 50, 450, 680));

        chapterNameLabel.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        chapterPanelLayeded.add(chapterNameLabel, new AbsoluteConstraints(180, 760, 90, 20));

        chapterNext.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        chapterNext.setText("Trang sau");
        chapterNext.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                nextEvent(evt);
            }
        });
        chapterPanelLayeded.add(chapterNext, new AbsoluteConstraints(290, 740, 90, 60));

        chapterPrevious.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        chapterPrevious.setText("Trang trước");
        chapterPrevious.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                previousEvent(evt);
            }
        });
        chapterPanelLayeded.add(chapterPrevious, new AbsoluteConstraints(60, 740, 100, 60));

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(chapterPanelLayeded)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(chapterPanelLayeded)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>


    private void backEvent(MouseEvent evt) {
        previousScreen.setVisible(true);
        this.setVisible(false);
    }

    private void nextEvent(MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void previousEvent(MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void processData(){
        Chapter chapter = getChapter.getChapter(chapters);
        chapterNameLabel.setText("Chapter: " + chapter.getChapter_name());

        chapterImgLabel.setLayout(new BoxLayout(chapterImgLabel, BoxLayout.Y_AXIS));

        String baseUrl = "https://sv1.otruyencdn.com/";
        String preUrl = chapter.getChapter_path() + "/";
        totalChapters = chapter.getChapter_image().size();

        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        ArrayList<Future<JLabel>> futures = new ArrayList<>();

        ImageIO.setUseCache(false);

        for (ChapterImage x : chapter.getChapter_image()) {
            final String fullUrl = baseUrl + preUrl + x.getImage_file();

            Callable<JLabel> task = () -> {
                JLabel imageLabel = new JLabel();
                try {
                    URL url = new URL(fullUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                    connection.setConnectTimeout(4000);
                    connection.setReadTimeout(4000);
                    connection.connect();


                    try (BufferedInputStream in = new BufferedInputStream(connection.getInputStream())) {
                        BufferedImage originalImage = ImageIO.read(in);
                        if (originalImage == null) {
                            throw new IOException("Invalid image data: " + fullUrl);
                        }

                        BufferedImage resizedImage = resizeImage(originalImage, 450, originalImage.getHeight());
                        imageLabel = new JLabel(new ImageIcon(resizedImage));
                    }
                    connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return imageLabel;
            };
            futures.add(executor.submit(task));
        }

        for (Future<JLabel> future : futures) {
            try {
                JLabel imageLabel = future.get();
                SwingUtilities.invokeLater(() -> {
                    chapterImgLabel.add(imageLabel);
                    chapterImgLabel.revalidate();
                    chapterImgLabel.repaint();
                });
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        chapterImgLabel.addMouseListener(dragScrollListenerMainScroll);
        chapterImgLabel.addMouseMotionListener(dragScrollListenerMainScroll);
    }

    MouseAdapter dragScrollListenerMainScroll = new MouseAdapter() {
        private Point origin;
        private final int SCROLL_SPEED = 10;

        @Override
        public void mousePressed(MouseEvent e) {
            origin = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            JViewport viewport = chapterScrollPane.getViewport();
            Point viewPosition = viewport.getViewPosition();
            int deltaY = origin.y - e.getY();

            int newY = viewPosition.y + deltaY / SCROLL_SPEED;

            int maxScrollHeight = totalChapters * 900;

            newY = Math.max(0, Math.min(newY, maxScrollHeight));

            viewport.setViewPosition(new Point(viewPosition.x, newY));
        }
    };

    private JLabel chapterBackLabel;
    private JPanel chapterImgLabel;
    private JLabel chapterNameLabel;
    private JLabel chapterNext;
    private JLayeredPane chapterPanelLayeded;
    private JLabel chapterPrevious;
    private JScrollPane chapterScrollPane;
    private JPanel mainPanel;
}

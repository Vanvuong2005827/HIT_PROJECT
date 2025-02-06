package view.screens.one_book_screens;

import controllers.ChapterController;
import models.book_information.Book;
import models.chapter_information.AllChapters;
import models.chapter_information.Chapter;
import models.chapter_information.ChapterImage;
import data.GetChapters;
import utils.Gradient;

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

import static commons.ColorMain.*;
import static utils.CustomBookGridPanel.resizeImage;
import static utils.NetworkChecker.curFrame;

public class ChapterScreen extends JFrame {
    private GetChapters getChapter = new GetChapters();
    private JFrame previousScreen;
    private ArrayList<AllChapters> chapters;
    private Book curBook;
    private JButton oneBookStartReadButton;
    private int indexChapter;

    public ChapterScreen(JFrame jf, Book b, JButton j, ArrayList<AllChapters> ch, int i) {
        previousScreen = jf;
        indexChapter = i;
        curBook = b;
        oneBookStartReadButton = j;
        chapters = ch;
        initComponents();
        processData();
        setLocationRelativeTo(null);
        new ChapterController(this);
        curFrame = this;
    }

    private void initComponents() {

        mainPanel = new Gradient(colorMain1, colorMain2, colorMain3);
        chapterPanelLayeded = new javax.swing.JLayeredPane();
        chapterBackLabel = new javax.swing.JLabel();
        chapterScrollPane = new javax.swing.JScrollPane();
        chapterImgLabel = new javax.swing.JPanel();
        chapterNameLabel = new javax.swing.JLabel();
        chapterNext = new javax.swing.JLabel();
        chapterPrevious = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        chapterPanelLayeded.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chapterBackLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        chapterBackLabel.setText("<");

        chapterPanelLayeded.add(chapterBackLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        chapterScrollPane.setBorder(null);

        chapterImgLabel.setBackground(colorOpaque);

        javax.swing.GroupLayout chapterImgLabelLayout = new javax.swing.GroupLayout(chapterImgLabel);
        chapterImgLabel.setLayout(chapterImgLabelLayout);
        chapterImgLabelLayout.setHorizontalGroup(chapterImgLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 450, Short.MAX_VALUE));
        chapterImgLabelLayout.setVerticalGroup(chapterImgLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 710, Short.MAX_VALUE));

        chapterScrollPane.setViewportView(chapterImgLabel);

        chapterScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        chapterScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        chapterPanelLayeded.add(chapterScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 450, 680));

        chapterNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        chapterPanelLayeded.add(chapterNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 760, 90, 20));

        chapterNext.setFont(new java.awt.Font("Segoe UI", 1, 14));
        chapterNext.setText("Trang sau");

        chapterPanelLayeded.add(chapterNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 740, 90, 60));

        chapterPrevious.setFont(new java.awt.Font("Segoe UI", 1, 14));
        chapterPrevious.setText("Trang trước");

        chapterPanelLayeded.add(chapterPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 740, 100, 60));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(chapterPanelLayeded));
        mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(chapterPanelLayeded));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }

    public void processData() {
        chapterImgLabel.removeAll();
        SwingUtilities.invokeLater(() -> {
            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                Chapter chapter = getChapter.getChapter(chapters.get(indexChapter));

                @Override
                protected Void doInBackground() {
                    chapterNameLabel.setText("Loading...");
                    chapterImgLabel.setLayout(new BoxLayout(chapterImgLabel, BoxLayout.Y_AXIS));

                    String baseUrl = "https://sv1.otruyencdn.com/";
                    String preUrl = chapter.getChapter_path() + "/";

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
                    return null;
                }

                @Override
                protected void done() {
                    chapterNameLabel.setText("Chapter: " + chapter.getChapter_name());
                }
            };
            worker.execute();
        });


        chapterImgLabel.addMouseListener(dragScrollListenerMainScroll);
        chapterImgLabel.addMouseMotionListener(dragScrollListenerMainScroll);
    }

    private MouseAdapter dragScrollListenerMainScroll = new MouseAdapter() {
        private Point origin;
        private final double SCROLL_FACTOR = 1.0;
        private final int MAX_DELTA = 80;
        private int velocity = 0;
        private Timer inertiaTimer;

        @Override
        public void mousePressed(MouseEvent e) {
            origin = e.getPoint();
            if (inertiaTimer != null && inertiaTimer.isRunning()) {
                inertiaTimer.stop();
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (origin == null) return;

            JViewport viewport = chapterScrollPane.getViewport();
            Point viewPosition = viewport.getViewPosition();

            int deltaY = origin.y - e.getY();
            deltaY = (int) Math.signum(deltaY) * Math.min(MAX_DELTA, Math.abs((int) (deltaY * SCROLL_FACTOR)));

            velocity = deltaY;

            int newY = viewPosition.y + deltaY;
            Component view = viewport.getView();
            int maxScrollHeight = view.getHeight() - viewport.getHeight();

            newY = Math.max(0, Math.min(newY, maxScrollHeight));

            int finalNewY = newY;
            SwingUtilities.invokeLater(() -> viewport.setViewPosition(new Point(viewPosition.x, finalNewY)));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            origin = null;
            applyInertia();
        }

        private void applyInertia() {
            inertiaTimer = new Timer(16, event -> {
                if (Math.abs(velocity) < 1) {
                    ((Timer) event.getSource()).stop();
                    return;
                }

                JViewport viewport = chapterScrollPane.getViewport();
                Point viewPosition = viewport.getViewPosition();
                int newY = viewPosition.y + velocity;
                Component view = viewport.getView();
                int maxScrollHeight = view.getHeight() - viewport.getHeight();
                newY = Math.max(0, Math.min(newY, maxScrollHeight));

                int finalNewY = newY;
                SwingUtilities.invokeLater(() -> viewport.setViewPosition(new Point(viewPosition.x, finalNewY)));

                velocity *= 0.95;
            });
            inertiaTimer.start();
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

    public void setIndexChapter(int indexChapter) {
        this.indexChapter = indexChapter;
    }

    public JFrame getPreviousScreen() {
        return previousScreen;
    }

    public ArrayList<AllChapters> getChapters() {
        return chapters;
    }

    public Book getCurBook() {
        return curBook;
    }

    public JButton getOneBookStartReadButton() {
        return oneBookStartReadButton;
    }

    public MouseAdapter getDragScrollListenerMainScroll() {
        return dragScrollListenerMainScroll;
    }

    public JLabel getChapterBackLabel() {
        return chapterBackLabel;
    }

    public JLabel getChapterNext() {
        return chapterNext;
    }

    public JLabel getChapterPrevious() {
        return chapterPrevious;
    }
}

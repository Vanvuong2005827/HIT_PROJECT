package view.pages;

import controllers.book.OneBookController;
import models.book.Book;
import models.book.BookCategory;
import models.chapter.AllChapters;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

import static commons.ColorMain.colorMain;
import static commons.CurrentUser.bookService;
import static utils.CustomBookGridPanel.customChapterPanel;
import static utils.CustomBookGridPanel.resizeImage;
import static utils.NetworkChecker.curFrame;

public class OneBookPage extends javax.swing.JFrame {
    private JFrame previousScreen;
    private OneBookPage oneBookScreen = this;
    private Book curBook;
    private ArrayList<AllChapters> chapters;
    private String fullUrl = "https://img.otruyenapi.com/uploads/comics/";
    private String name;
    private String status;
    private StringBuilder categories = new StringBuilder();
    private StringBuilder authors = new StringBuilder();

    public OneBookPage(JFrame ps, Book book, ArrayList<AllChapters> chapter) {
        previousScreen = ps;
        curBook = book;
        chapters = chapter;
        processBookInfoData();
        initComponents();
        processBookChapterData();
        setLocationRelativeTo(null);
        new OneBookController(this, previousScreen);
        curFrame = this;
    }

    private void initComponents() {
        bookService.insertBookToDB(curBook);
        oneBookPanel = new javax.swing.JPanel();
        oneBookMainPanel = new javax.swing.JLayeredPane();
        oneBookImgLabel = new javax.swing.JLabel();
        oneBookTabbed = new javax.swing.JTabbedPane();
        oneBookInforPanel = new javax.swing.JPanel();
        oneBookNameTextArea = new javax.swing.JTextArea();
        oneBookStatusLabel = new javax.swing.JLabel();
        oneBookAuthorTextArea = new javax.swing.JTextArea();
        oneBookCategoryTextArea = new javax.swing.JTextArea();
        oneBookStartReadButton = new javax.swing.JButton();
        oneBookFavou = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        oneBookChapterPanel = new javax.swing.JPanel();
        oneBookChapterScroll = new javax.swing.JScrollPane();
        oneBookChapterMainPanel = new javax.swing.JPanel();
        oneBookBackLabel = new javax.swing.JLabel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(450, 800));

        oneBookMainPanel.setBackground(colorMain);
        oneBookMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        try {
            URL urlAllbook = new URL(fullUrl);
            BufferedImage originalImage = ImageIO.read(urlAllbook);
            BufferedImage resizedImage = resizeImage(originalImage, 450, 600);
            oneBookImgLabel = new JLabel(new ImageIcon(resizedImage));
        } catch (IOException e) {
            e.printStackTrace();
            JLabel errorLabel = new JLabel("Không thể tải ảnh!");
            errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            oneBookPanel.add(errorLabel, BorderLayout.CENTER);
        }
        oneBookMainPanel.add(oneBookImgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -170, 450, 800));

        oneBookInforPanel.setBackground(colorMain);

        JTextArea[] textAreas = {oneBookNameTextArea, oneBookAuthorTextArea, oneBookCategoryTextArea};
        for (JTextArea textArea : textAreas) {
            textArea.setBackground(colorMain);
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setEditable(false);
            textArea.setColumns(20);
            textArea.setFont(new java.awt.Font("Segoe UI", 1, 18));
            textArea.setForeground(new java.awt.Color(102, 102, 102));
            textArea.setRows(5);
            textArea.setFocusable(false);
        }

        oneBookStatusLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        oneBookStatusLabel.setForeground(new java.awt.Color(102, 102, 102));

        oneBookStartReadButton.setBackground(colorMain);
        oneBookStartReadButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        oneBookStartReadButton.setText("Bắt đầu đọc");
        oneBookStartReadButton.setBorder(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Yêu thích");

        oneBookFavou.setBackground(bookService.checkFavorite(curBook.getId()));
        jLabel1.setForeground((oneBookFavou.getBackground() == Color.red) ? Color.WHITE : Color.BLACK);
        javax.swing.GroupLayout oneBookFavouLayout = new javax.swing.GroupLayout(oneBookFavou);
        oneBookFavou.setLayout(oneBookFavouLayout);
        oneBookFavouLayout.setHorizontalGroup(oneBookFavouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oneBookFavouLayout.createSequentialGroup().addContainerGap(21, Short.MAX_VALUE).addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(15, 15, 15)));
        oneBookFavouLayout.setVerticalGroup(oneBookFavouLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE));

        javax.swing.GroupLayout oneBookInforPanelLayout = new javax.swing.GroupLayout(oneBookInforPanel);
        oneBookInforPanel.setLayout(oneBookInforPanelLayout);
        oneBookInforPanelLayout.setHorizontalGroup(oneBookInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(oneBookInforPanelLayout.createSequentialGroup().addContainerGap().addGroup(oneBookInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(oneBookAuthorTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE).addComponent(oneBookCategoryTextArea).addComponent(oneBookNameTextArea).addGroup(oneBookInforPanelLayout.createSequentialGroup().addComponent(oneBookStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oneBookInforPanelLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(oneBookStartReadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(oneBookFavou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(10, 10, 10))).addContainerGap()));
        oneBookInforPanelLayout.setVerticalGroup(oneBookInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(oneBookInforPanelLayout.createSequentialGroup().addContainerGap().addComponent(oneBookNameTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(34, 34, 34).addComponent(oneBookStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE).addGroup(oneBookInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oneBookInforPanelLayout.createSequentialGroup().addComponent(oneBookAuthorTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(27, 27, 27).addComponent(oneBookCategoryTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(60, 60, 60).addComponent(oneBookStartReadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(68, 68, 68)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, oneBookInforPanelLayout.createSequentialGroup().addComponent(oneBookFavou, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(78, 78, 78)))));

        oneBookTabbed.addTab("Thông tin truyện", oneBookInforPanel);

        oneBookChapterPanel.setBackground(colorMain);

        oneBookChapterScroll.setBackground(colorMain);
        oneBookChapterScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        oneBookChapterScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        oneBookChapterScroll.setBorder(null);

        oneBookChapterMainPanel.setBackground(colorMain);

        javax.swing.GroupLayout oneBookChapterMainPanelLayout = new javax.swing.GroupLayout(oneBookChapterMainPanel);
        oneBookChapterMainPanel.setLayout(oneBookChapterMainPanelLayout);
        oneBookChapterMainPanelLayout.setHorizontalGroup(oneBookChapterMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 456, Short.MAX_VALUE));
        oneBookChapterMainPanelLayout.setVerticalGroup(oneBookChapterMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 443, Short.MAX_VALUE));

        oneBookChapterScroll.setViewportView(oneBookChapterMainPanel);

        javax.swing.GroupLayout oneBookChapterPanelLayout = new javax.swing.GroupLayout(oneBookChapterPanel);
        oneBookChapterPanel.setLayout(oneBookChapterPanelLayout);
        oneBookChapterPanelLayout.setHorizontalGroup(oneBookChapterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(oneBookChapterScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));
        oneBookChapterPanelLayout.setVerticalGroup(oneBookChapterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(oneBookChapterScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE));

        oneBookTabbed.addTab("Chương", oneBookChapterPanel);

        oneBookMainPanel.setLayer(oneBookTabbed, javax.swing.JLayeredPane.PALETTE_LAYER);
        oneBookMainPanel.add(oneBookTabbed, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 450, 470));

        oneBookBackLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        oneBookBackLabel.setText("<");

        oneBookMainPanel.setLayer(oneBookBackLabel, javax.swing.JLayeredPane.PALETTE_LAYER);
        oneBookMainPanel.add(oneBookBackLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        javax.swing.GroupLayout oneBookPanelLayout = new javax.swing.GroupLayout(oneBookPanel);
        oneBookPanel.setLayout(oneBookPanelLayout);
        oneBookPanelLayout.setHorizontalGroup(oneBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 450, Short.MAX_VALUE).addGroup(oneBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(oneBookPanelLayout.createSequentialGroup().addComponent(oneBookMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE))));
        oneBookPanelLayout.setVerticalGroup(oneBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 800, Short.MAX_VALUE).addGroup(oneBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(oneBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(oneBookPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(oneBookPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));


        oneBookNameTextArea.setText(name);
        oneBookStatusLabel.setText("Trạng thái: " + status);
        oneBookAuthorTextArea.setText("Tác giả: " + authors.toString());
        oneBookCategoryTextArea.setText(categories.toString());

        pack();
    }

    public void processBookInfoData() {
        String thum;
        String title;
        String sta;
        StringBuilder cat = new StringBuilder();
//        StringBuilder au = new StringBuilder();
        try{
            thum = curBook.getThumbnail();
        } catch (Exception e){
            thum = "";
        }
        try{
            title = curBook.getName();
        } catch (Exception e){
            title = "Đang cập nhật";
        }
        try{
            sta = curBook.getStatus();
        } catch (Exception e){
            sta = "Đang cập nhật";
        }
        try{
            for (BookCategory x : curBook.getCategory()) {
                if (cat.length() > 0) {
                    cat.append(", ");
                }
                cat.append(x.getName());
            }
        } catch (Exception e){
            cat.append("Đang cập nhật");
        }
        fullUrl = fullUrl + thum;
        name = title;
        status = sta;
        categories = cat;
        authors.append("Đang cập nhật");
    }

    public void processBookChapterData() {
        Font customFont1 = new Font("Segoe UI", Font.BOLD, 13);
        Color cusColor = Color.WHITE;

        oneBookChapterMainPanel.setLayout(new BoxLayout(oneBookChapterMainPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < chapters.size(); i++) {
            String title = chapters.get(i).getFilename();
            String chapterNumber = "Chapter: " + chapters.get(i).getChapter_name();
            oneBookChapterMainPanel.add(customChapterPanel(oneBookScreen, i, chapters, title, chapterNumber, cusColor, customFont1, oneBookChapterMainPanel, curBook, oneBookStartReadButton));
            oneBookChapterMainPanel.revalidate();
            oneBookChapterMainPanel.repaint();
        }
        oneBookChapterMainPanel.addMouseListener(dragScrollListenerMainScroll);
        oneBookChapterMainPanel.addMouseMotionListener(dragScrollListenerMainScroll);
    }

    private MouseAdapter dragScrollListenerMainScroll = new MouseAdapter() {
        private Point origin;
        private final double SCROLL_FACTOR = 1.5;
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

            JViewport viewport = oneBookChapterScroll.getViewport();
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

                JViewport viewport = oneBookChapterScroll.getViewport();
                Point viewPosition = viewport.getViewPosition();
                int newY = viewPosition.y + velocity;
                Component view = viewport.getView();
                int maxScrollHeight = view.getHeight() - viewport.getHeight();
                newY = Math.max(0, Math.min(newY, maxScrollHeight));

                int finalNewY = newY;
                SwingUtilities.invokeLater(() -> viewport.setViewPosition(new Point(viewPosition.x, finalNewY)));

                velocity *= 0.9;
            });
            inertiaTimer.start();
        }
    };

    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextArea oneBookAuthorTextArea;
    private javax.swing.JLabel oneBookBackLabel;
    private javax.swing.JTextArea oneBookCategoryTextArea;
    private javax.swing.JPanel oneBookChapterMainPanel;
    private javax.swing.JPanel oneBookChapterPanel;
    private javax.swing.JScrollPane oneBookChapterScroll;
    private javax.swing.JPanel oneBookFavou;
    private javax.swing.JLabel oneBookImgLabel;
    private javax.swing.JPanel oneBookInforPanel;
    private javax.swing.JLayeredPane oneBookMainPanel;
    private javax.swing.JTextArea oneBookNameTextArea;
    private javax.swing.JPanel oneBookPanel;
    public javax.swing.JButton oneBookStartReadButton;
    private javax.swing.JLabel oneBookStatusLabel;
    private javax.swing.JTabbedPane oneBookTabbed;

    public Book getCurBook() {
        return curBook;
    }

    public ArrayList<AllChapters> getChapters() {
        return chapters;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getOneBookBackLabel() {
        return oneBookBackLabel;
    }

    public JPanel getOneBookFavou() {
        return oneBookFavou;
    }

    public JButton getOneBookStartReadButton() {
        return oneBookStartReadButton;
    }

    public JTabbedPane getOneBookTabbed() {
        return oneBookTabbed;
    }
}

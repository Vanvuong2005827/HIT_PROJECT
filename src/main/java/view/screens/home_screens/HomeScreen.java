package view.screens.home_screens;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import commons.ColorMain;
import controllers.book.HomeController;
import models.book.Book;
import models.book.BookCategory;
import models.chapter.AllChapters;
import services.BookService;
import data.GetAllBook;
import utils.Gradient;
import data.GetChapters;
import view.pages.HomePage;
import view.pages.OneBookPage;
import view.screens.WaitScreen;
import view.screens.more_book_screens.OneStyleBookScreen;

import static commons.ColorMain.*;
import static utils.CustomBookGridPanel.*;

public class HomeScreen extends javax.swing.JFrame {
    private HomePage homeScreen;
    public HomeScreen(HomePage hs) {
        homeScreen = hs;
        initComponents();
        setLocationRelativeTo(null);
        new HomeController(this, homeScreen);
    }

    private void initComponents() {
        homePanel = new javax.swing.JPanel();
        homeMainScrollPane = new javax.swing.JScrollPane();
        homeMainPanel = new Gradient(colorMain1, colorMain2, colorMain3);
        homePageViewPanel = new javax.swing.JPanel();
        homeSearchLabel = new javax.swing.JLabel();
        homeBellNotifications = new javax.swing.JLabel();
        homeStyleLabel = new javax.swing.JLabel();
        homeStyleScrollPane = new javax.swing.JScrollPane();
        homeStyleMainPanel = new javax.swing.JPanel();
        homeNewBookLabel = new javax.swing.JLabel();
        homeNewBookScrollPane = new javax.swing.JScrollPane();
        homeNewBookGridPanel = new javax.swing.JPanel();
        homeNewBookShow = new javax.swing.JLabel();
        homeStyleShow = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        homeCommingSoonBookShow = new javax.swing.JLabel();
        homeCommingSoonBookScrollPane = new javax.swing.JScrollPane();
        homeCommingSoonBookGridPanel1 = new javax.swing.JPanel();
        homeCommingSoonBookLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        homePageViewPanel.setBackground(colorOpaque);
        homePageViewPanel.setLayout(new java.awt.CardLayout());
        CardLayout cardLayout = (CardLayout) homePageViewPanel.getLayout();
        Timer timer = new Timer(4000, e -> {
            cardLayout.next(homePageViewPanel);
        });
        timer.start();

        homeSearchLabel.setText("Tìm kiếm");
        homeSearchLabel.setFont(new java.awt.Font("Segoe UI", 1, 17));

        homeStyleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        homeStyleLabel.setText("Thể Loại");

        homeStyleScrollPane.setBorder(null);

        homeStyleMainPanel.setBackground(colorFix);
        homeStyleMainPanel.setLayout(new java.awt.GridBagLayout());
        homeStyleScrollPane.setViewportView(homeStyleMainPanel);

        homeNewBookLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        homeNewBookLabel.setText("Truyện mới");

        homeNewBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        homeNewBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        homeNewBookScrollPane.setBorder(null);

        homeNewBookGridPanel.setBackground(colorOpaque);
        homeNewBookGridPanel.setLayout(new java.awt.GridBagLayout());

        homeNewBookScrollPane.setViewportView(homeNewBookGridPanel);

        homeNewBookShow.setForeground(new java.awt.Color(102, 102, 102));
        homeNewBookShow.setText(" Thêm >");

        homeStyleShow.setForeground(new java.awt.Color(102, 102, 102));
        homeStyleShow.setText("Thêm >");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Đề xuất");

        homeCommingSoonBookShow.setForeground(new java.awt.Color(102, 102, 102));
        homeCommingSoonBookShow.setText(" Thêm >");

        homeNewBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        homeNewBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        homeCommingSoonBookScrollPane.setBorder(null);

        homeCommingSoonBookGridPanel1.setBackground(colorOpaque);
        homeCommingSoonBookGridPanel1.setLayout(new java.awt.GridBagLayout());

        homeCommingSoonBookScrollPane.setViewportView(homeCommingSoonBookGridPanel1);

        homeCommingSoonBookLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        homeCommingSoonBookLabel.setText("Sắp ra mắt");

        javax.swing.GroupLayout homeMainPanelLayout = new javax.swing.GroupLayout(homeMainPanel);
        homeMainPanel.setLayout(homeMainPanelLayout);
        homeMainPanelLayout.setHorizontalGroup(
                homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homeMainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(homeStyleScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeMainPanelLayout.createSequentialGroup()
                                                .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(homeMainPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(homeStyleShow))
                                                        .addGroup(homeMainPanelLayout.createSequentialGroup()
                                                                .addComponent(homeCommingSoonBookLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(homeCommingSoonBookShow))
                                                        .addComponent(homeNewBookShow))
                                                .addGap(20, 20, 20))
                                        .addGroup(homeMainPanelLayout.createSequentialGroup()
                                                .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(homeNewBookScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(homeStyleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(homeMainPanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(227, 227, 227)
                                                                .addComponent(homeSearchLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(homeBellNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(homeNewBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(homeCommingSoonBookScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(12, Short.MAX_VALUE))))
                        .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(homeMainPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(homePageViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(14, Short.MAX_VALUE)))
        );
        homeMainPanelLayout.setVerticalGroup(
                homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homeMainPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(homeSearchLabel)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(homeBellNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(212, 212, 212)
                                .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(homeNewBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(homeNewBookShow))
                                .addGap(18, 18, 18)
                                .addComponent(homeNewBookScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(homeCommingSoonBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(homeCommingSoonBookShow))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(homeCommingSoonBookScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(homeStyleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(homeStyleShow))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homeStyleScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(534, Short.MAX_VALUE))
                        .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(homeMainPanelLayout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(homePageViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(696, Short.MAX_VALUE)))
        );

        homeStyleScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        homeMainScrollPane.setViewportView(homeMainPanel);

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
                homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(homeMainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );
        homePanelLayout.setVerticalGroup(
                homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(homeMainScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        homeMainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        homeMainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(homePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(homePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }

    public void processHomePageData() {
        processStyleBookPircture();
        processNewBookPicture();
        processCommingSoonBookPicture();
        processPageViewBookPicture();
    }

    public void processNewBookPicture() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(5, 8, 5, 5);

        GetAllBook lb = new GetAllBook();
        ArrayList<Book> books = lb.getBooksTruyenMoi(1);

        Font customFont1 = new Font("Segoe UI", Font.BOLD, 12);
        Font customFont2 = new Font("Segoe UI", Font.BOLD, 10);

        String baseUrl = "https://img.otruyenapi.com/uploads/comics/";

        int totalPanels = books.size() / 2;
        int columns = 3;

        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        ArrayList<Future<JPanel>> futures = new ArrayList<>();

        for (int i = 0; i < totalPanels; i++) {
            int index = i;
            Callable<JPanel> task = () -> {
                return customBookGrid3(homeScreen, index, 130, 200, 130, 160, books, colorOpaque, baseUrl, customFont1, customFont2, homeNewBookGridPanel);
            };
            futures.add(executor.submit(task));
        }

        for (int i = 0; i < futures.size(); i++) {
            try {
                JPanel panel = futures.get(i).get();
                final int x = i % columns;
                final int y = i / columns;
                SwingUtilities.invokeLater(() -> {
                    GridBagConstraints gbcPanel = (GridBagConstraints) gbc.clone();
                    gbcPanel.gridx = x;
                    gbcPanel.gridy = y;
                    homeNewBookGridPanel.add(panel, gbcPanel);
                    homeNewBookGridPanel.revalidate();
                    homeNewBookGridPanel.repaint();
                });
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }

    public void processCommingSoonBookPicture() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(5, 8, 5, 5);

        GetAllBook lb = new GetAllBook();
        ArrayList<Book> books = lb.getBooksSapRaMat(1);

        String baseUrl = "https://img.otruyenapi.com/uploads/comics/";
        Font customFont1 = new Font("Segoe UI", Font.BOLD, 12);
        Font customFont2 = new Font("Segoe UI", Font.BOLD, 10);

        int totalPanels = books.size() / 2;
        int columns = 3;

        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        ArrayList<Future<JPanel>> futures = new ArrayList<>();

        for (int i = 0; i < totalPanels; i++) {
            int index = i;
            Callable<JPanel> task = () -> {
                return customBookGrid3(homeScreen, index, 130, 200, 130, 160, books, colorOpaque, baseUrl, customFont1, customFont2, homeCommingSoonBookGridPanel1);
            };
            futures.add(executor.submit(task));
        }

        for (int i = 0; i < futures.size(); i++) {
            try {
                JPanel panel = futures.get(i).get();
                final int x = i % columns;
                final int y = i / columns;
                SwingUtilities.invokeLater(() -> {
                    GridBagConstraints gbcPanel = (GridBagConstraints) gbc.clone();
                    gbcPanel.gridx = x;
                    gbcPanel.gridy = y;
                    homeCommingSoonBookGridPanel1.add(panel, gbcPanel);
                    homeCommingSoonBookGridPanel1.revalidate();
                    homeCommingSoonBookGridPanel1.repaint();
                });
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }

    public void processStyleBookPircture() {
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.insets = new Insets(5, 5, 10, 10);

        GetAllBook lb = new GetAllBook();
        ArrayList<Book> books = lb.getBooksTheLoai();
        ColorMain cl = new ColorMain();
        ArrayList<Color> colors = cl.getColorMain();
        int totalColor = colors.size();

        int totalPanels2 = books.size();
        int rows = 2;

        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        ArrayList<Future<JPanel>> futures = new ArrayList<>();

        for (int i = 0; i < totalPanels2 / 2 + 1; i++) {
            int index = i;
            Callable<JPanel> task = () -> {
                JPanel panel = new JPanel(new BorderLayout());
                int indexColor = index;
                if (indexColor >= totalColor) indexColor %= totalColor;
                panel.setBackground(colors.get(indexColor));
                panel.setPreferredSize(new Dimension(100, 50));
                JLabel label1 = new JLabel(books.get(index).getName());
                label1.setFont(new Font("Segoe UI", Font.BOLD, 14));
                label1.setHorizontalAlignment(JLabel.CENTER);
                panel.add(label1, BorderLayout.CENTER);
                panel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String nameStyle = books.get(index).getSlug();
                        homeScreen.setVisible(false);
                        OneStyleBookScreen oneStyleBookPage = new OneStyleBookScreen(homeScreen, nameStyle, label1.getText());
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        homeStyleMainPanel.dispatchEvent(SwingUtilities.convertMouseEvent(panel, e, homeStyleMainPanel));
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        homeStyleMainPanel.dispatchEvent(SwingUtilities.convertMouseEvent(panel, e, homeStyleMainPanel));
                    }
                });
                panel.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        homeStyleMainPanel.dispatchEvent(SwingUtilities.convertMouseEvent(panel, e, homeStyleMainPanel));
                    }
                });
                return panel;
            };
            futures.add(executor.submit(task));
        }

        for (int i = 0; i < futures.size(); i++) {
            try {
                JPanel panel = futures.get(i).get();
                final int x = i / rows;
                final int y = i % rows;
                SwingUtilities.invokeLater(() -> {
                    GridBagConstraints gbcPanel = (GridBagConstraints) gbc2.clone();
                    gbcPanel.gridx = x;
                    gbcPanel.gridy = y;
                    homeStyleMainPanel.add(panel, gbcPanel);
                    homeStyleMainPanel.revalidate();
                    homeStyleMainPanel.repaint();
                });
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }

    public void processPageViewBookPicture() {
        GetAllBook lb = new GetAllBook();
        ColorMain cl = new ColorMain();
        ArrayList<Book> books = lb.getBooksHoanThanh(1);
        ArrayList<Color> colors = cl.getColorMain();

        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        ArrayList<Future<JPanel>> futures = new ArrayList<>();

        for (int i = 0; i < books.size(); i++) {
            int index = i;
            Callable<JPanel> task = () -> {
                JPanel panel = new JPanel(new BorderLayout(10, 10));
                Color cusColor = colors.get(index % colors.size());
                Font customFont = new Font("Segoe UI", Font.BOLD, 13);
                panel.setBackground(cusColor);

                String baseUrlAllBook = "https://img.otruyenapi.com/uploads/comics/";
                String posterPathAllBook = books.get(index).getThumbnail();
                String fullUrlAllBook = baseUrlAllBook + posterPathAllBook;

                JLabel imgLabel = null;
                ImageIO.setUseCache(false);
                try {
                    URL url = new URL(fullUrlAllBook);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                    connection.setConnectTimeout(4000);
                    connection.setReadTimeout(4000);
                    connection.connect();

                    try (BufferedInputStream in = new BufferedInputStream(connection.getInputStream())) {
                        BufferedImage originalImage = ImageIO.read(in);

                        BufferedImage resizedImage = resizeImage(originalImage, 120, 169);
                        imgLabel = new JLabel(new ImageIcon(resizedImage));
                        panel.add(imgLabel, BorderLayout.WEST);
                    }
                    connection.disconnect();
                } catch (Exception e) {
                    imgLabel = new JLabel("Không thể tải ảnh!");
                    imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    panel.add(imgLabel, BorderLayout.CENTER);
                }

                JPanel mainTextPanel = new JPanel();
                mainTextPanel.setBackground(cusColor);
                mainTextPanel.setPreferredSize(new Dimension(320, 160));

                JPanel textPanel = new JPanel(new GridLayout(4, 1, 5, 5));
                textPanel.setBackground(cusColor);
                textPanel.setPreferredSize(new Dimension(288, 158));

                String inputDateTime = books.get(index).getUpdatedAt();
                LocalDateTime dateTime = LocalDateTime.parse(inputDateTime.substring(0, 19));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
                String updateAt = dateTime.format(formatter);

                StringBuilder categories = new StringBuilder();
                for (BookCategory x : books.get(index).getCategory()) {
                    if (categories.length() > 0) {
                        categories.append(", ");
                    }
                    categories.append(x.getName());
                }

                JTextArea titleArea = new JTextArea(books.get(index).getName());
                JTextArea statusArea = new JTextArea("Status: " + books.get(index).getStatus());
                JTextArea updatedAtArea = new JTextArea("Last update: " + updateAt);
                JTextArea categoryArea = new JTextArea(categories.toString());

                JTextArea[] textAreas = {titleArea, statusArea, updatedAtArea, categoryArea};
                for (JTextArea textArea : textAreas) {
                    textArea.setFont(customFont);
                    textArea.setBackground(cusColor);
                    textArea.setWrapStyleWord(true);
                    textArea.setLineWrap(true);
                    textArea.setFocusable(false);
                    textArea.setEditable(false);
                    textPanel.add(textArea);
                    fixDragable(textArea, panel, homeScreen, books, index);
                }

                mainTextPanel.add(textPanel, BorderLayout.CENTER);
                panel.add(mainTextPanel, BorderLayout.CENTER);

                panel.addMouseListener(new MouseAdapter() {
                    GetAllBook getBook = new GetAllBook();
                    GetChapters getChapters = new GetChapters();

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        SwingUtilities.invokeLater(() -> {
                            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                                Book curBook = new Book();
                                ArrayList<AllChapters> chapters = new ArrayList<>();
                                WaitScreen ws = new WaitScreen();
                                BookService bookService = new BookService();

                                @Override
                                protected Void doInBackground() {
                                    ws.setVisible(true);
                                    homeScreen.setVisible(false);
                                    curBook = getBook.getBooksTheoTen(books.get(index).getSlug());
                                    chapters = getChapters.getListChapters(curBook);
                                    return null;
                                }

                                @Override
                                protected void done() {
                                    OneBookPage oneBookScreen = null;
                                    try {
                                        oneBookScreen = new OneBookPage(homeScreen, curBook, chapters);
                                    } catch (Exception ex) {
                                        throw new RuntimeException(ex);
                                    }
                                    if (bookService.checkIfExitBookInUser(curBook.getId())) {

                                        oneBookScreen.oneBookStartReadButton.setText("Tiếp tục đọc chapter " + chapters.get(bookService.getLastReadIndexChapter(curBook.getId())).getChapter_name());
                                    }
                                    oneBookScreen.setVisible(true);
                                    ws.setVisible(false);
                                }
                            };

                            worker.execute();
                        });
                    }
                });

                return panel;
            };

            futures.add(executor.submit(task));
        }

        for (Future<JPanel> future : futures) {
            try {
                JPanel panel = future.get();
                SwingUtilities.invokeLater(() -> {
                    homePageViewPanel.add(panel);
                    homePageViewPanel.revalidate();
                    homePageViewPanel.repaint();
                });
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }

    public JPanel homePanel() {
        return homePanel;
    }

    private javax.swing.JLabel homeBellNotifications;
    private javax.swing.JPanel homeCommingSoonBookGridPanel1;
    private javax.swing.JLabel homeCommingSoonBookLabel;
    private javax.swing.JScrollPane homeCommingSoonBookScrollPane;
    private javax.swing.JLabel homeCommingSoonBookShow;
    private javax.swing.JPanel homeMainPanel;
    private javax.swing.JScrollPane homeMainScrollPane;
    private javax.swing.JPanel homeNewBookGridPanel;
    private javax.swing.JLabel homeNewBookLabel;
    private javax.swing.JScrollPane homeNewBookScrollPane;
    private javax.swing.JLabel homeNewBookShow;
    private javax.swing.JPanel homePageViewPanel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel homeSearchLabel;
    private javax.swing.JLabel homeStyleLabel;
    private javax.swing.JPanel homeStyleMainPanel;
    private javax.swing.JScrollPane homeStyleScrollPane;
    private javax.swing.JLabel homeStyleShow;
    private javax.swing.JLabel jLabel1;

    public JLabel getHomeCommingSoonBookShow() {
        return homeCommingSoonBookShow;
    }

    public JLabel getHomeNewBookShow() {
        return homeNewBookShow;
    }

    public JLabel getHomeStyleShow() {
        return homeStyleShow;
    }

    public JLabel getHomeSearchLabel() {
        return homeSearchLabel;
    }

    public JPanel getHomeMainPanel() {
        return homeMainPanel;
    }

    public JPanel getHomeNewBookGridPanel() {
        return homeNewBookGridPanel;
    }

    public JPanel getHomeCommingSoonBookGridPanel1() {
        return homeCommingSoonBookGridPanel1;
    }

    public JScrollPane getHomeMainScrollPane() {
        return homeMainScrollPane;
    }

    public JPanel getHomeStyleMainPanel() {
        return homeStyleMainPanel;
    }

    public JScrollPane getHomeStyleScrollPane() {
        return homeStyleScrollPane;
    }
}

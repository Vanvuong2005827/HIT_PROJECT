package view.pages.home_screen_pages;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import commons.ColorMain;
import controllers.HomeController;
import models.book_information.Book;
import models.book_information.BookCategory;
import models.chapter_information.AllChapters;
import view.pages.more_book_pages.OneStyleBookPage;
import view.screens.one_book_screens.OneBookScreen;
import services.BookService;
import data.GetAllBook;
import view.screens.main_screens.HomeScreen;
import view.screens.main_screens.WaitScreen;
import utils.Gradient;
import data.GetChapters;

import static commons.ColorMain.*;
import static utils.CustomBookGridPanel.customBookGrid3;
import static utils.CustomBookGridPanel.fixDragable;

public class HomePage extends javax.swing.JFrame {
    private HomeScreen homeScreen;

    public HomePage(HomeScreen hs) {
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
                                        .addGroup(homeMainPanelLayout.createSequentialGroup()
                                                .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(homeMainPanelLayout.createSequentialGroup()
                                                                .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(homeNewBookScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, homeMainPanelLayout.createSequentialGroup()
                                                                                        .addComponent(homeStyleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(homeStyleShow))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, homeMainPanelLayout.createSequentialGroup()
                                                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(227, 227, 227)
                                                                                        .addComponent(homeSearchLabel)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(homeBellNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addGap(0, 6, Short.MAX_VALUE))
                                                        .addGroup(homeMainPanelLayout.createSequentialGroup()
                                                                .addComponent(homeNewBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(homeNewBookShow, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap())
                                        .addGroup(homeMainPanelLayout.createSequentialGroup()
                                                .addComponent(homeCommingSoonBookScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(homeMainPanelLayout.createSequentialGroup()
                                                .addComponent(homeCommingSoonBookLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(homeCommingSoonBookShow)
                                                .addGap(20, 20, 20))))
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
        homeMainScrollPane.addMouseListener(dragScrollListenerMainScroll);
        homeMainScrollPane.addMouseMotionListener(dragScrollListenerMainScroll);

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
        homeNewBookGridPanel.addMouseListener(dragScrollListenerMainScroll);
        homeNewBookGridPanel.addMouseMotionListener(dragScrollListenerMainScroll);
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

        homeCommingSoonBookGridPanel1.addMouseListener(dragScrollListenerMainScroll);
        homeCommingSoonBookGridPanel1.addMouseMotionListener(dragScrollListenerMainScroll);
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
                        WaitScreen ws = new WaitScreen();
                        ws.setVisible(true);
                        homeScreen.setVisible(false);
                        OneStyleBookPage oneStyleBookPage = new OneStyleBookPage(homeScreen, nameStyle, label1.getText(), ws);
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
        homeStyleMainPanel.addMouseListener(dragScrollListenerStyleScroll);
        homeStyleMainPanel.addMouseMotionListener(dragScrollListenerStyleScroll);
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
                JPanel panel = new JPanel(new BorderLayout(30, 10));
                Color cusColor = colors.get(index % colors.size());
                Font customFont = new Font("Segoe UI", Font.BOLD, 13);
                panel.setBackground(cusColor);

                String baseUrlAllBook = "https://img.otruyenapi.com/uploads/comics/";
                String posterPathAllBook = books.get(index).getThumbnail();
                String fullUrlAllBook = baseUrlAllBook + posterPathAllBook;

                try {
                    URL urlAllbook = new URL(fullUrlAllBook);
                    Image imageAllBook = ImageIO.read(urlAllbook);
                    Image resizedImageAllBook = imageAllBook.getScaledInstance(120, 169, Image.SCALE_SMOOTH);
                    JLabel jLabel1 = new JLabel(new ImageIcon(resizedImageAllBook));
                    panel.add(jLabel1, BorderLayout.WEST);
                } catch (IOException e) {
                    e.printStackTrace();
                    JLabel errorLabel = new JLabel("Không thể tải ảnh!");
                    errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    panel.add(errorLabel, BorderLayout.CENTER);
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
                                    OneBookScreen oneBookScreen = new OneBookScreen(homeScreen, curBook, chapters);
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

    private MouseAdapter dragScrollListenerStyleScroll = new MouseAdapter() {
        private Point origin;

        @Override
        public void mousePressed(MouseEvent e) {
            origin = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            JViewport viewport = homeStyleScrollPane.getViewport();
            Point viewPosition = viewport.getViewPosition();
            int deltaX = origin.x - e.getX();

            int newX = viewPosition.x + deltaX;

            int totalWidth = 130 * 100;
            if (totalWidth < homeStyleScrollPane.getWidth()) totalWidth = homeStyleScrollPane.getWidth();
            int panelWidth = totalWidth;
            int viewportWidth = viewport.getWidth();

            if (newX < 0) {
                newX = 0;
            }
            if (newX > panelWidth - viewportWidth) {
                newX = panelWidth - viewportWidth;
            }

            viewport.setViewPosition(new Point(newX, 0));
        }
    };

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

            JViewport viewport = homeMainScrollPane.getViewport();
            Point viewPosition = viewport.getViewPosition();

            int deltaY = origin.y - e.getY();
            deltaY = (int) Math.signum(deltaY) * Math.min(MAX_DELTA, Math.abs((int) (deltaY * SCROLL_FACTOR)));

            velocity = deltaY;

            int newY = viewPosition.y + deltaY;
            int maxScrollHeight = 1450;

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

                JViewport viewport = homeMainScrollPane.getViewport();
                Point viewPosition = viewport.getViewPosition();
                int newY = viewPosition.y + velocity;
                int maxScrollHeight = 1450;
                newY = Math.max(0, Math.min(newY, maxScrollHeight));

                int finalNewY = newY;
                SwingUtilities.invokeLater(() -> viewport.setViewPosition(new Point(viewPosition.x, finalNewY)));

                velocity *= 0.9;
            });
            inertiaTimer.start();
        }
    };

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
}


package screens.home_screen_pages;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

import commons.ColorMain;
import models.book_information.Book;
import models.book_information.BookCategory;
import models.GetAllBook;
import screens.HomeScreen;
import screens.MoreBookScreen;
import screens.WaitScreen;

import static commons.customBookGridPanel.customBookGrid3;

public class HomePage extends javax.swing.JFrame {
    HomeScreen homeScreen;

    public HomePage(HomeScreen hs) {
        homeScreen = hs;
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        homePanel = new javax.swing.JPanel();
        homeMainScrollPane = new javax.swing.JScrollPane();
        homeMainPanel = new javax.swing.JPanel();
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
        setTitle("SignUp");
        setBackground(new java.awt.Color(255, 255, 255));

        homeMainPanel.setBackground(new java.awt.Color(176, 223, 251));

        homePageViewPanel.setBackground(new java.awt.Color(176, 223, 251));
        homePageViewPanel.setLayout(new java.awt.CardLayout());
        CardLayout cardLayout = (CardLayout) homePageViewPanel.getLayout();
        Timer timer = new Timer(4000, e -> {
            // Chuyển sang panel tiếp theo
            cardLayout.next(homePageViewPanel);
        });
        timer.start();

        homeSearchLabel.setText("Tìm kiếm");

        homeStyleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        homeStyleLabel.setText("Thể Loại");

        homeStyleScrollPane.setBorder(null);

        homeStyleMainPanel.setBackground(new java.awt.Color(176, 223, 251));
        homeStyleMainPanel.setLayout(new java.awt.GridBagLayout());
        homeStyleScrollPane.setViewportView(homeStyleMainPanel);
        homeStyleMainPanel.addMouseListener(dragScrollListenerStyleScroll);
        homeStyleMainPanel.addMouseMotionListener(dragScrollListenerStyleScroll);

        homeNewBookLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        homeNewBookLabel.setText("Truyện mới");

        homeNewBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        homeNewBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        homeNewBookScrollPane.setBorder(null);

        homeNewBookGridPanel.setBackground(new java.awt.Color(176, 223, 251));
        homeNewBookGridPanel.setLayout(new java.awt.GridBagLayout());


        homeNewBookScrollPane.setViewportView(homeNewBookGridPanel);

        homeNewBookShow.setForeground(new java.awt.Color(102, 102, 102));
        homeNewBookShow.setText(" Thêm >");
        homeNewBookShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moreBookEvent(evt);
            }
        });

        homeStyleShow.setForeground(new java.awt.Color(102, 102, 102));
        homeStyleShow.setText("Thêm >");
        homeStyleShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moreBookEvent3(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Đề xuất");

        homeCommingSoonBookShow.setForeground(new java.awt.Color(102, 102, 102));
        homeCommingSoonBookShow.setText(" Thêm >");
        homeCommingSoonBookShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moreBookEvent2(evt);
            }
        });

        homeNewBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        homeNewBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        homeCommingSoonBookScrollPane.setBorder(null);

        homeCommingSoonBookGridPanel1.setBackground(new java.awt.Color(176, 223, 251));
        homeCommingSoonBookGridPanel1.setLayout(new java.awt.GridBagLayout());

        homeCommingSoonBookScrollPane.setViewportView(homeCommingSoonBookGridPanel1);

        homeCommingSoonBookLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
                                                .addGap(12, 12, 12))))
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
                        .addComponent(homeMainScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
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
                        .addComponent(homePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(homePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

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
        gbc.insets = new Insets(5, 5, 5, 5);

        GetAllBook lb = new GetAllBook();
        ArrayList<Book> books = lb.getBooksTruyenMoi();

        Font customFont1 = new Font("Segoe UI", Font.BOLD, 12);
        Font customFont2 = new Font("Segoe UI", Font.BOLD, 10);

        String baseUrl = "https://img.otruyenapi.com/uploads/comics/";

        int totalPanels = books.size() / 2;
        int columns = 3;

        for (int i = 0; i < totalPanels; i++) {
            JPanel panel = customBookGrid3(i, 130, 200, 130, 160, books, homeMainPanel.getBackground(), baseUrl, customFont1, customFont2);
            gbc.gridx = i % columns;
            gbc.gridy = i / columns;

            homeNewBookGridPanel.add(panel, gbc);
        }
        homeNewBookGridPanel.revalidate();
        homeNewBookGridPanel.repaint();
        homeNewBookGridPanel.addMouseListener(dragScrollListenerMainScroll);
        homeNewBookGridPanel.addMouseMotionListener(dragScrollListenerMainScroll);
    }

    public void processCommingSoonBookPicture() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);

        GetAllBook lb = new GetAllBook();
        ArrayList<Book> books = lb.getBooksSapRaMat();

        String baseUrl = "https://img.otruyenapi.com/uploads/comics/";
        Font customFont1 = new Font("Segoe UI", Font.BOLD, 12);
        Font customFont2 = new Font("Segoe UI", Font.BOLD, 10);

        int totalPanels = books.size() / 2;
        int columns = 3;

        for (int i = 0; i < totalPanels; i++) {
            JPanel panel = customBookGrid3(i, 130, 200, 130, 160, books, homeMainPanel.getBackground(), baseUrl, customFont1, customFont2);
            gbc.gridx = i % columns;
            gbc.gridy = i / columns;

            homeCommingSoonBookGridPanel1.add(panel, gbc);
        }
        homeCommingSoonBookGridPanel1.revalidate();
        homeCommingSoonBookGridPanel1.repaint();
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


        for (int i = 0; i < totalPanels2 / 2 - 1; i++) {
            JPanel panel = new JPanel(new BorderLayout());
            int indexColor = i;
            if (indexColor >= totalColor) indexColor %= totalColor;
            panel.setBackground(colors.get(indexColor));
            panel.setPreferredSize(new Dimension(100, 50));
            JLabel label1 = new JLabel(books.get(i).getName());
            label1.setFont(new Font("Segoe UI", Font.BOLD, 14));
            label1.setHorizontalAlignment(JLabel.CENTER);
            panel.add(label1, BorderLayout.CENTER);
            gbc2.gridx = i / rows;
            gbc2.gridy = i % rows;
            homeStyleMainPanel.add(panel, gbc2);
        }
        homeStyleMainPanel.revalidate();
        homeStyleMainPanel.repaint();
    }

    public void processPageViewBookPicture() {
        GetAllBook lb = new GetAllBook();
        ColorMain cl = new ColorMain();
        ArrayList<Book> books = lb.getBooksHoanThanh();
        ArrayList<Color> colors = cl.getColorMain();

        for (int i = 0; i < books.size(); i++) {
            // Panel chính
            JPanel panel = new JPanel(new BorderLayout(10, 10));
            Color cusColor = colors.get(i);
            Font customFont = new Font("Segoe UI", Font.BOLD, 13);
            panel.setBackground(cusColor);

            // Gen ảnh
            String baseUrlAllBook = "https://img.otruyenapi.com/uploads/comics/";
            String posterPathAllBook = books.get(i).getThumbnail();
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

            // Phan text ben phai
            JPanel mainTextPanel = new JPanel();
            mainTextPanel.setBackground(cusColor);
            mainTextPanel.setPreferredSize(new Dimension(320, 160));

            // Panel chua text
            JPanel textPanel = new JPanel(new GridLayout(4, 1, 5, 5)); // 2 hàng, 1 cột
            textPanel.setBackground(cusColor);
            textPanel.setPreferredSize(new Dimension(288, 158));

            // Xu ly updateLast
            String inputDateTime = books.get(i).getUpdatedAt();
            LocalDateTime dateTime = LocalDateTime.parse(inputDateTime.substring(0, 19));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
            String updateAt = dateTime.format(formatter);

            StringBuilder categories = new StringBuilder();
            for (BookCategory x : books.get(i).getCategory()) {
                if (categories.length() > 0) {
                    categories.append(", ");
                }
                categories.append(x.getName());
            }

            // Cac text area
            JPanel emptyPanel = new JPanel();
            JTextArea titleArea = new JTextArea(books.get(i).getName());
            JTextArea statusArea = new JTextArea("Status: " + books.get(i).getStatus());
            JTextArea updatedAtArea = new JTextArea("Last update: " + updateAt);
            JTextArea categoryArea = new JTextArea(categories.toString());

            // Cấu hình text area
            emptyPanel.setSize(new Dimension(50, 1));
            emptyPanel.setBackground(cusColor);

            titleArea.setFont(customFont);
            titleArea.setBackground(cusColor);
            titleArea.setWrapStyleWord(true);
            titleArea.setLineWrap(true);
            titleArea.setFocusable(false);
            titleArea.setEditable(false);

            statusArea.setFont(customFont);
            statusArea.setBackground(cusColor);
            statusArea.setLineWrap(true);
            statusArea.setWrapStyleWord(true);
            statusArea.setFocusable(false);
            statusArea.setEditable(false);

            updatedAtArea.setFont(customFont);
            updatedAtArea.setBackground(cusColor);
            updatedAtArea.setLineWrap(true);
            updatedAtArea.setWrapStyleWord(true);
            updatedAtArea.setFocusable(false);
            updatedAtArea.setEditable(false);

            categoryArea.setFont(customFont);
            categoryArea.setBackground(cusColor);
            categoryArea.setLineWrap(true);
            categoryArea.setWrapStyleWord(true);
            categoryArea.setFocusable(false);
            categoryArea.setEditable(false);

            // Add vao phan chua text
            textPanel.add(titleArea);
            textPanel.add(statusArea);
            textPanel.add(updatedAtArea);
            textPanel.add(categoryArea);

            // Add vao panel ben phai
            mainTextPanel.add(emptyPanel);
            mainTextPanel.add(textPanel, BorderLayout.CENTER);
            mainTextPanel.add(emptyPanel);

            // Add vao panel chinh
            panel.add(mainTextPanel, BorderLayout.CENTER);

            homePageViewPanel.add(panel);
        }
        homePageViewPanel.revalidate();
        homePageViewPanel.repaint();
    }

    public JPanel homePanel() {
        return homePanel;
    }

    private void moreBookEvent(java.awt.event.MouseEvent evt) {
        WaitScreen ws = new WaitScreen();
        ws.setVisible(true);
        homeScreen.setVisible(false);
        MoreBookScreen mb = new MoreBookScreen(homeScreen, 0, ws);
    }

    private void moreBookEvent2(java.awt.event.MouseEvent evt) {
        WaitScreen ws = new WaitScreen();
        ws.setVisible(true);
        homeScreen.setVisible(false);
        MoreBookScreen mb = new MoreBookScreen(homeScreen, 1, ws);
    }

    private void moreBookEvent3(java.awt.event.MouseEvent evt) {
        WaitScreen ws = new WaitScreen();
        ws.setVisible(true);
        homeScreen.setVisible(false);
        MoreBookScreen mb = new MoreBookScreen(homeScreen, 3, ws);
    }

    MouseAdapter dragScrollListenerStyleScroll = new MouseAdapter() {
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

    MouseAdapter dragScrollListenerMainScroll = new MouseAdapter() {
        private Point origin;
        private final int SCROLL_SPEED = 10;

        @Override
        public void mousePressed(MouseEvent e) {
            origin = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            JViewport viewport = homeMainScrollPane.getViewport();
            Point viewPosition = viewport.getViewPosition();
            int deltaY = origin.y - e.getY();

            int maxScrollHeight = 1430;

            int newY = viewPosition.y + deltaY / SCROLL_SPEED;

            newY = Math.max(0, Math.min(newY, maxScrollHeight));

            viewport.setViewPosition(new Point(viewPosition.x, newY));
        }
    };
    // Variables declaration - do not modify
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
    // End of variables declaration
}


package screens.pages;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import models.book_information.Book;
import models.book_information.ListBook;

public class HomePage extends javax.swing.JFrame {

    public HomePage() {
        initComponents();
        processData();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        homePanel = new javax.swing.JPanel();
        homeMainScrollPane = new javax.swing.JScrollPane();
        homeMainPanel = new javax.swing.JPanel();
        homePageViewPanel = new javax.swing.JPanel();
        homePageView1 = new javax.swing.JPanel();
        homePageView2 = new javax.swing.JPanel();
        homePageView3 = new javax.swing.JPanel();
        homeSearchLabel = new javax.swing.JLabel();
        homeBellNotifications = new javax.swing.JLabel();
        homeStyleLabel = new javax.swing.JLabel();
        homeStyleScrollPane = new javax.swing.JScrollPane();
        homeStyleMainPanel = new javax.swing.JPanel();
        homeAllBookLabel = new javax.swing.JLabel();
        homeAllBookScrollPane = new javax.swing.JScrollPane();
        homeAllBookGridPanel = new javax.swing.JPanel();
        homeAllBookShow = new javax.swing.JLabel();
        homeStyleShow = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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

        homePageView1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout homePageView1Layout = new javax.swing.GroupLayout(homePageView1);
        homePageView1.setLayout(homePageView1Layout);
        homePageView1Layout.setHorizontalGroup(
                homePageView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        homePageView1Layout.setVerticalGroup(
                homePageView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        homePageViewPanel.add(homePageView1, "card2");

        homePageView2.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout homePageView2Layout = new javax.swing.GroupLayout(homePageView2);
        homePageView2.setLayout(homePageView2Layout);
        homePageView2Layout.setHorizontalGroup(
                homePageView2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        homePageView2Layout.setVerticalGroup(
                homePageView2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        homePageViewPanel.add(homePageView2, "card3");

        homePageView3.setBackground(new java.awt.Color(153, 255, 255));

        javax.swing.GroupLayout homePageView3Layout = new javax.swing.GroupLayout(homePageView3);
        homePageView3.setLayout(homePageView3Layout);
        homePageView3Layout.setHorizontalGroup(
                homePageView3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        homePageView3Layout.setVerticalGroup(
                homePageView3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        homePageViewPanel.add(homePageView3, "card4");

        homeSearchLabel.setText("Tìm kiếm");

        homeStyleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        homeStyleLabel.setText("Thể Loại");

        homeStyleScrollPane.setBorder(null);

        homeStyleMainPanel.setBackground(new java.awt.Color(176, 223, 251));
        //GridBagConstraints gbc2 = new GridBagConstraints();
        //gbc2.fill = GridBagConstraints.BOTH; // Panel lấp đầy không gian
        ////gbc2.weightx = 1.0; // Chia đều không gian ngang giữa các cột
        //gbc2.weighty = 1.0;
        //gbc2.insets = new Insets(5, 5, 5, 15); // Khoảng cách giữa các panel
        //String baseUrlStyle = "https://image.tmdb.org/t/p/w500"; // Thay bằng URL gốc của bạn
        //String posterPathStyle = "/d8Ryb8AunYAuycVKDp5HpdWPKgC.jpg";
        //String fullUrlStyle = baseUrlStyle + posterPathStyle;
        //
        //int totalPanels2 = 10; // Tổng số panel con
        //
        //for (int i = 0; i < totalPanels2; i++) {
        // JPanel panel = new JPanel(new BorderLayout());
        //    panel.setBackground(new Color(100 + (i * 20) % 155, 150, 200));
        //    panel.setPreferredSize(new Dimension(130, 150));
        //    // Set ảnh
        //    try {
        //        // Tải ảnh từ URL
        //        URL url = new URL(fullUrlStyle);
        //        Image image = ImageIO.read(url);
        //
        //        // Resize ảnh (nếu cần)
        //        Image resizedImage = image.getScaledInstance(130, 150,Image.SCALE_SMOOTH);
        //
        //        // Đặt ảnh vào JLabel
        //        JLabel jLabel1 = new JLabel(new ImageIcon(resizedImage));
        //        jLabel1.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa ảnh
        //        jLabel1.setVerticalAlignment(SwingConstants.CENTER);
        //        panel.add(jLabel1);
        //    } catch (IOException e) {
        //        e.printStackTrace();
        //        JLabel errorLabel = new JLabel("Không thể tải ảnh!");
        //        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //        panel.add(errorLabel, BorderLayout.CENTER);
        //    }
        //
        //    gbc2.gridx = i; // Cột hiện tại (0, 1, 2)
        //    gbc2.gridy = 1; // Hàng hiện tại (tăng dần khi đủ 3 cột
        //    homeStyleMainPanel.add(panel, gbc2);
        //}
        //homeStyleMainPanel.revalidate();
        //homeStyleMainPanel.repaint();
        homeStyleMainPanel.setLayout(new java.awt.GridBagLayout());
        homeStyleScrollPane.setViewportView(homeStyleMainPanel);
        homeStyleMainPanel.addMouseListener(dragScrollListenerStyleScroll);
        homeStyleMainPanel.addMouseMotionListener(dragScrollListenerStyleScroll);

        homeAllBookLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        homeAllBookLabel.setText("Tất cả truyện");

        homeAllBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        homeAllBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        homeAllBookScrollPane.setBorder(null);

        homeAllBookGridPanel.setBackground(new java.awt.Color(176, 223, 251));
        homeAllBookGridPanel.setLayout(new java.awt.GridBagLayout());
        //GridBagConstraints gbc = new GridBagConstraints();
        //gbc.fill = GridBagConstraints.BOTH; // Panel lấp đầy không gian
        //gbc.weightx = 1.0; // Chia đều không gian ngang giữa các cột
        //gbc.insets = new Insets(5, 5, 5, 5); // Khoảng cách giữa các panel
        //
        //String baseUrl = "https://image.tmdb.org/t/p/w500"; // Thay bằng URL gốc của bạn
        //String posterPath = "/d8Ryb8AunYAuycVKDp5HpdWPKgC.jpg";
        //String fullUrl = baseUrl + posterPath;
        //
        //int totalPanels = 20; // Tổng số panel con
        //int columns = 3;      // Số cột trong grid
        //
        //for (int i = 0; i < totalPanels; i++) {
        //    JPanel panel = new JPanel(new BorderLayout());
        //    panel.setBackground(new Color(100 + (i * 20) % 155, 150, 200));
        //    panel.setPreferredSize(new Dimension(130, 170));
        //    // Set ảnh
        //    try {
        //        // Tải ảnh từ URL
        //        URL url = new URL(fullUrl);
        //        Image image = ImageIO.read(url);
        //
        //        // Resize ảnh (nếu cần)
        //        Image resizedImage = image.getScaledInstance(130, 170, Image.SCALE_SMOOTH);
        //
        //        // Đặt ảnh vào JLabel
        //        JLabel jLabel1 = new JLabel(new ImageIcon(resizedImage));
        //        jLabel1.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa ảnh
        //        jLabel1.setVerticalAlignment(SwingConstants.CENTER);
        //        panel.add(jLabel1, BorderLayout.CENTER);
        //    } catch (IOException e) {
        //        e.printStackTrace();
        //        JLabel errorLabel = new JLabel("Không thể tải ảnh!");
        //        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //        panel.add(errorLabel, BorderLayout.CENTER);
        //    }
        //
        //    gbc.gridx = i % columns; // Cột hiện tại (0, 1, 2)
        //    gbc.gridy = i / columns; // Hàng hiện tại (tăng dần khi đủ 3 cột)
        //
        //    homeAllBookGridPanel.add(panel, gbc);
        //}
        //homeAllBookGridPanel.revalidate();
        //homeAllBookGridPanel.repaint();
        //homeAllBookGridPanel.addMouseListener(dragScrollListenerMainScroll);
        //homeAllBookGridPanel.addMouseMotionListener(dragScrollListenerMainScroll);
        homeAllBookScrollPane.setViewportView(homeAllBookGridPanel);

        homeAllBookShow.setForeground(new java.awt.Color(102, 102, 102));
        homeAllBookShow.setText(" Thêm >");

        homeStyleShow.setForeground(new java.awt.Color(102, 102, 102));
        homeStyleShow.setText("Thêm >");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Đề xuất");

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
                                                                        .addComponent(homeAllBookScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                                                .addComponent(homeAllBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(homeAllBookShow, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap())))
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
                                .addGap(187, 187, 187)
                                .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(homeStyleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(homeStyleShow))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(homeStyleScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(homeAllBookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(homeAllBookShow))
                                .addGap(18, 18, 18)
                                .addComponent(homeAllBookScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(552, Short.MAX_VALUE))
                        .addGroup(homeMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(homeMainPanelLayout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(homePageViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(669, Short.MAX_VALUE)))
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
    public void processData(){
        // Sử dụng SwingWorker để tải ảnh
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                processAllBookPicture();
                processStyleBookPircture();
                return null;
            }

            @Override
            protected void done() {
            }
        };

        worker.execute();
    }

    public void processAllBookPicture(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Panel lấp đầy không gian
        gbc.weightx = 1.0; // Chia đều không gian ngang giữa các cột
        gbc.insets = new Insets(5, 5, 5, 5); // Khoảng cách giữa các panel

        // Lâấy danh sách book
        ListBook lb = new ListBook();
        ArrayList<Book> books = lb.getBooks();

        int totalPanels = books.size(); // Tổng số panel con
        int columns = 2;      // Số cột trong grid

        for (int i = 0; i < totalPanels; i++) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(new Color(100 + (i * 20) % 155, 150, 200));
            panel.setPreferredSize(new Dimension(195, 250));
            String baseUrlAllBook = "https://img.otruyenapi.com/uploads/comics/";
            String posterPathAllBook = books.get(i).getThumbnail();
            String fullUrlAllBook = baseUrlAllBook + posterPathAllBook;
            // Set ảnh
            try {
                // Tải ảnh từ URL
                URL urlAllbook = new URL(fullUrlAllBook);
                Image imageAllBook = ImageIO.read(urlAllbook);

                // Resize ảnh (nếu cần)
                Image resizedImageAllBook = imageAllBook.getScaledInstance(195, 250, Image.SCALE_SMOOTH);

                // Đặt ảnh vào JLabel
                JLabel jLabel1 = new JLabel(new ImageIcon(resizedImageAllBook));
                jLabel1.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa ảnh
                jLabel1.setVerticalAlignment(SwingConstants.CENTER);
                panel.add(jLabel1, BorderLayout.CENTER);
            } catch (IOException e) {
                e.printStackTrace();
                JLabel errorLabel = new JLabel("Không thể tải ảnh!");
                errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(errorLabel, BorderLayout.CENTER);
            }

            gbc.gridx = i % columns; // Cột hiện tại (0, 1, 2)
            gbc.gridy = i / columns; // Hàng hiện tại (tăng dần khi đủ 3 cột)

            homeAllBookGridPanel.add(panel, gbc);
        }
        homeAllBookGridPanel.revalidate();
        homeAllBookGridPanel.repaint();
        homeAllBookGridPanel.addMouseListener(dragScrollListenerMainScroll);
        homeAllBookGridPanel.addMouseMotionListener(dragScrollListenerMainScroll);
    }

    public void processStyleBookPircture(){
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.BOTH; // Panel lấp đầy không gian
        //gbc2.weightx = 1.0; // Chia đều không gian ngang giữa các cột
        gbc2.weighty = 1.0;
        gbc2.insets = new Insets(5, 5, 5, 15); // Khoảng cách giữa các panel

        int totalPanels2 = 10; // Tổng số panel con

        for (int i = 0; i < totalPanels2; i++) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(new Color(100 + (i * 20) % 155, 150, 200));
            panel.setPreferredSize(new Dimension(170, 150));
            String baseUrlStyleBook = "https://image.tmdb.org/t/p/w500"; // Thay bằng URL gốc của bạn
            String posterPathStyleBook = "/d8Ryb8AunYAuycVKDp5HpdWPKgC.jpg";
            String fullUrlStyle = baseUrlStyleBook + posterPathStyleBook;

            // Set ảnh
            try {

                // Tải ảnh từ URL
                URL urlStyle = new URL(fullUrlStyle);
                Image imageStyle = ImageIO.read(urlStyle);

                // Resize ảnh (nếu cần)
                Image resizedImageStyleBook = imageStyle.getScaledInstance(170, 150,Image.SCALE_SMOOTH);

                // Đặt ảnh vào JLabel
                JLabel jLabel1 = new JLabel(new ImageIcon(resizedImageStyleBook));
                jLabel1.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa ảnh
                jLabel1.setVerticalAlignment(SwingConstants.CENTER);
                panel.add(jLabel1);
            } catch (IOException e) {
                e.printStackTrace();
                JLabel errorLabel = new JLabel("Không thể tải ảnh!");
                errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(errorLabel, BorderLayout.CENTER);
            }

            gbc2.gridx = i; // Cột hiện tại (0, 1, 2)
            gbc2.gridy = 1; // Hàng hiện tại (tăng dần khi đủ 3 cột
            homeStyleMainPanel.add(panel, gbc2);
        }
        homeStyleMainPanel.revalidate();
        homeStyleMainPanel.repaint();
    }

    public JPanel homePanel(){
        return homePanel;
    }

    MouseAdapter dragScrollListenerStyleScroll = new MouseAdapter() {
        private Point origin;

        @Override
        public void mousePressed(MouseEvent e) {
            origin = e.getPoint(); // Lấy vị trí ban đầu khi nhấn chuột
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            JViewport viewport = homeStyleScrollPane.getViewport();
            Point viewPosition = viewport.getViewPosition(); // Vị trí hiện tại của view
            int deltaX = origin.x - e.getX(); // Tính khoảng cách kéo
            int deltaY = origin.y - e.getY();
            // Tính vị trí mới
            int newX = viewPosition.x + deltaX;
            int newY = viewPosition.y + deltaY;

            // Lấy kích thước của JPanel và Viewport
            int totalWidth = 130*100;
            if (totalWidth < homeStyleScrollPane.getWidth()) totalWidth = homeStyleScrollPane.getWidth();
            int panelWidth = totalWidth;
            int viewportWidth = viewport.getWidth();

            // Giới hạn vị trí kéo
            if (newX < 0) {
                newX = 0; // Không cho kéo quá bên trái
            }
            if (newX > panelWidth - viewportWidth) {
                newX = panelWidth - viewportWidth; // Không cho kéo quá bên phải
            }

            newY = 0; // Không cho phép kéo lên hoặc kéo xuống

            // Cập nhật vị trí của Viewport
            viewport.setViewPosition(new Point(newX, newY));
        }
    };

    MouseAdapter dragScrollListenerMainScroll = new MouseAdapter() {
        private Point origin;
        private final int SCROLL_SPEED = 10; // Tốc độ cuộn (số càng lớn thì cuộn càng chậm)

        @Override
        public void mousePressed(MouseEvent e) {
            origin = e.getPoint(); // Vị trí ban đầu khi nhấn chuột
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            JViewport viewport = homeMainScrollPane.getViewport();
            Point viewPosition = viewport.getViewPosition(); // Vị trí hiện tại của viewport
            int deltaX = origin.x - e.getX(); // Tính khoảng cách kéo ngang
            int deltaY = origin.y - e.getY(); // Tính khoảng cách kéo dọc

            // Tính vị trí mới của viewport
            int newX = viewPosition.x + deltaX / SCROLL_SPEED ;
            int newY = viewPosition.y + deltaY / SCROLL_SPEED;

            // Cần fix giới hạn kéo theo các panel con
            // Đảm bảo không cuộn vượt quá giới hạn
            newX = Math.max(0, Math.min(newX, homeMainPanel.getWidth() - viewport.getWidth()));
            newY = Math.max(0, Math.min(newY, homeMainPanel.getHeight() - viewport.getHeight()));

            // Cập nhật vị trí viewport

            viewport.setViewPosition(new Point(0, newY));
        }
    };
    // Variables declaration - do not modify
    private javax.swing.JPanel homeAllBookGridPanel;
    private javax.swing.JLabel homeAllBookLabel;
    private javax.swing.JScrollPane homeAllBookScrollPane;
    private javax.swing.JLabel homeAllBookShow;
    private javax.swing.JLabel homeBellNotifications;
    private javax.swing.JPanel homeMainPanel;
    private javax.swing.JScrollPane homeMainScrollPane;
    private javax.swing.JPanel homePageView1;
    private javax.swing.JPanel homePageView2;
    private javax.swing.JPanel homePageView3;
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

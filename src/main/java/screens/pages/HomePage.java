
package screens.pages;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import commons.ColorMain;
import models.book_information.Book;
import models.book_information.BookCategory;
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

        homeSearchLabel.setText("Tìm kiếm");

        homeStyleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        homeStyleLabel.setText("Thể Loại");

        homeStyleScrollPane.setBorder(null);

        homeStyleMainPanel.setBackground(new java.awt.Color(176, 223, 251));
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

        homeAllBookGridPanel.addMouseListener(dragScrollListenerMainScroll);
        homeAllBookGridPanel.addMouseMotionListener(dragScrollListenerMainScroll);

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
                                .addGap(199, 199, 199)
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
                                        .addComponent(homePageViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(671, Short.MAX_VALUE)))
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
        // Need fix
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                processAllBookPicture();
                processPageViewBookPicture();
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
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);

        ListBook lb = new ListBook();
        ArrayList<Book> books = lb.getBooksTruyenMoi();

        int totalPanels = books.size();
        int columns = 2;

        for (int i = 0; i < totalPanels; i++) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(new Color(100 + (i * 20) % 155, 150, 200));
            panel.setPreferredSize(new Dimension(195, 250));
            String baseUrlAllBook = "https://img.otruyenapi.com/uploads/comics/";
            String posterPathAllBook = books.get(i).getThumbnail();
            String fullUrlAllBook = baseUrlAllBook + posterPathAllBook;

            try {
                URL urlAllbook = new URL(fullUrlAllBook);
                Image imageAllBook = ImageIO.read(urlAllbook);

                Image resizedImageAllBook = imageAllBook.getScaledInstance(195, 250, Image.SCALE_SMOOTH);

                JLabel jLabel1 = new JLabel(new ImageIcon(resizedImageAllBook));
                jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel1.setVerticalAlignment(SwingConstants.CENTER);
                panel.add(jLabel1, BorderLayout.CENTER);
            } catch (IOException e) {
                e.printStackTrace();
                JLabel errorLabel = new JLabel("Không thể tải ảnh!");
                errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(errorLabel, BorderLayout.CENTER);
            }

            gbc.gridx = i % columns;
            gbc.gridy = i / columns;

            homeAllBookGridPanel.add(panel, gbc);
        }
        homeAllBookGridPanel.revalidate();
        homeAllBookGridPanel.repaint();
        homeAllBookGridPanel.addMouseListener(dragScrollListenerMainScroll);
        homeAllBookGridPanel.addMouseMotionListener(dragScrollListenerMainScroll);
    }

    public void processStyleBookPircture(){
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.weighty = 1.0;
        gbc2.insets = new Insets(5, 5, 5, 15);

        int totalPanels2 = 10;

        for (int i = 0; i < totalPanels2; i++) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(new Color(100 + (i * 20) % 155, 150, 200));
            panel.setPreferredSize(new Dimension(170, 150));
            String baseUrlStyleBook = "https://image.tmdb.org/t/p/w500";
            String posterPathStyleBook = "/d8Ryb8AunYAuycVKDp5HpdWPKgC.jpg";
            String fullUrlStyle = baseUrlStyleBook + posterPathStyleBook;

            try {
                URL urlStyle = new URL(fullUrlStyle);
                Image imageStyle = ImageIO.read(urlStyle);

                Image resizedImageStyleBook = imageStyle.getScaledInstance(170, 150,Image.SCALE_SMOOTH);

                JLabel jLabel1 = new JLabel(new ImageIcon(resizedImageStyleBook));
                jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
                jLabel1.setVerticalAlignment(SwingConstants.CENTER);
                panel.add(jLabel1);
            } catch (IOException e) {
                e.printStackTrace();
                JLabel errorLabel = new JLabel("Không thể tải ảnh!");
                errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(errorLabel, BorderLayout.CENTER);
            }

            gbc2.gridx = i;
            gbc2.gridy = 1;
            homeStyleMainPanel.add(panel, gbc2);
        }
        homeStyleMainPanel.revalidate();
        homeStyleMainPanel.repaint();
    }

    public void processPageViewBookPicture(){
        ListBook lb = new ListBook();
        ColorMain cl = new ColorMain();
        ArrayList<Book> books = lb.getBooksHoanThanh();
        ArrayList<Color> colors = cl.getColorMain();

        for(int i = 0; i < books.size(); i++){
            // Panel chính
            JPanel panel = new JPanel(new BorderLayout(10, 10));
            Color cusColor = colors.get(i);
            Font customFont = new Font("Segoe UI", Font.BOLD, 13);
            panel.setBackground(cusColor);

            // Gen ảnh
            String baseUrlAllBook = "https://img.otruyenapi.com/uploads/comics/";
            String posterPathAllBook = books.get(i).getThumbnail();
            String fullUrlAllBook = baseUrlAllBook + posterPathAllBook;
            try{
                URL urlAllbook = new URL(fullUrlAllBook);
                Image imageAllBook = ImageIO.read(urlAllbook);
                Image resizedImageAllBook = imageAllBook.getScaledInstance(120, 169, Image.SCALE_SMOOTH);
                JLabel jLabel1 = new JLabel(new ImageIcon(resizedImageAllBook));

                panel.add(jLabel1, BorderLayout.WEST);
            }  catch (IOException e) {
                e.printStackTrace();
                JLabel errorLabel = new JLabel("Không thể tải ảnh!");
                errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(errorLabel, BorderLayout.CENTER);
            }

            // Phan text ben phai
            JPanel mainTextPanel = new JPanel();
            mainTextPanel.setBackground(cusColor);
            mainTextPanel.setPreferredSize(new Dimension(320,160));

            // Panel chua text
            JPanel textPanel = new JPanel(new GridLayout(4, 1, 5, 5)); // 2 hàng, 1 cột
            textPanel.setBackground(cusColor);
            textPanel.setPreferredSize(new Dimension(288,158));

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
            emptyPanel.setSize(new Dimension(50,1));
            emptyPanel.setBackground(cusColor);

            titleArea.setFont(customFont);
            titleArea.setBackground(cusColor);
            titleArea.setWrapStyleWord(true);
            titleArea.setLineWrap(true);
            titleArea.setEditable(false);

            statusArea.setFont(customFont);
            statusArea.setBackground(cusColor);
            statusArea.setLineWrap(true);
            statusArea.setWrapStyleWord(true);
            statusArea.setEditable(false);

            updatedAtArea.setFont(customFont);
            updatedAtArea.setBackground(cusColor);
            updatedAtArea.setLineWrap(true);
            updatedAtArea.setWrapStyleWord(true);
            updatedAtArea.setEditable(false);

            categoryArea.setFont(customFont);
            categoryArea.setBackground(cusColor);
            categoryArea.setLineWrap(true);
            categoryArea.setWrapStyleWord(true);
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

    public JPanel homePanel(){
        return homePanel;
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


            int totalWidth = 130*100;
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

            int newY = viewPosition.y + deltaY / SCROLL_SPEED;

            newY = Math.max(0, Math.min(newY, homeMainPanel.getHeight() - viewport.getHeight()));

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

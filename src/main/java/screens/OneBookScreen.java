package screens;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class OneBookScreen extends javax.swing.JFrame {
    JFrame previousScreen;

    public OneBookScreen(JFrame ps) {
        previousScreen = ps;
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        oneBookPanel = new javax.swing.JPanel();
        oneBookMainPanel = new javax.swing.JLayeredPane();
        oneBookImgLabel = new javax.swing.JLabel();
        oneBookTabbed = new javax.swing.JTabbedPane();
        oneBookInforPanel = new javax.swing.JPanel();
        oneBookNameTextArea = new javax.swing.JTextArea();
        oneBookDescriptionTextArea = new javax.swing.JTextArea();
        oneBookStatusLabel = new javax.swing.JLabel();
        oneBookAuthorTextArea = new javax.swing.JTextArea();
        oneBookCategoryTextArea = new javax.swing.JTextArea();
        oneBookStartReadButton = new javax.swing.JButton();
        oneBookChapterPanel = new javax.swing.JPanel();
        oneBookBackLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(450, 800));

        oneBookMainPanel.setBackground(new java.awt.Color(176, 223, 251));
        oneBookMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        String fullUrl = "https://img.otruyenapi.com/uploads/comics/tu-linh-su-thien-tai-cua-hoc-vien-thumb.jpg";
        try {
            URL urlAllbook = new URL(fullUrl);
            Image imageAllBook = ImageIO.read(urlAllbook);

            Image resizedImageAllBook = imageAllBook.getScaledInstance(450, 600, Image.SCALE_SMOOTH);

            oneBookImgLabel = new JLabel(new ImageIcon(resizedImageAllBook));
        } catch (IOException e) {
            e.printStackTrace();
            JLabel errorLabel = new JLabel("Không thể tải ảnh!");
            errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            oneBookPanel.add(errorLabel, BorderLayout.CENTER);
        }
        oneBookMainPanel.add(oneBookImgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -170, 450, 800));

        oneBookInforPanel.setBackground(new java.awt.Color(176, 223, 251));

        oneBookNameTextArea.setEditable(false);
        oneBookNameTextArea.setColumns(20);
        oneBookNameTextArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        oneBookNameTextArea.setRows(5);
        oneBookNameTextArea.setFocusable(false);

        oneBookDescriptionTextArea.setEditable(false);
        oneBookDescriptionTextArea.setColumns(20);
        oneBookDescriptionTextArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        oneBookDescriptionTextArea.setRows(5);
        oneBookDescriptionTextArea.setFocusable(false);

        oneBookStatusLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        oneBookAuthorTextArea.setEditable(false);
        oneBookAuthorTextArea.setColumns(20);
        oneBookAuthorTextArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        oneBookAuthorTextArea.setRows(5);
        oneBookAuthorTextArea.setFocusable(false);

        oneBookCategoryTextArea.setEditable(false);
        oneBookCategoryTextArea.setColumns(20);
        oneBookCategoryTextArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        oneBookCategoryTextArea.setRows(5);
        oneBookCategoryTextArea.setFocusable(false);

        oneBookStartReadButton.setBackground(new java.awt.Color(204, 255, 204));
        oneBookStartReadButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        oneBookStartReadButton.setText("Bắt đầu đọc");
        oneBookStartReadButton.setBorder(null);
        oneBookStartReadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startReadEvent(evt);
            }
        });

        javax.swing.GroupLayout oneBookInforPanelLayout = new javax.swing.GroupLayout(oneBookInforPanel);
        oneBookInforPanel.setLayout(oneBookInforPanelLayout);
        oneBookInforPanelLayout.setHorizontalGroup(
                oneBookInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(oneBookInforPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(oneBookInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(oneBookDescriptionTextArea)
                                        .addGroup(oneBookInforPanelLayout.createSequentialGroup()
                                                .addComponent(oneBookStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(oneBookAuthorTextArea)
                                        .addComponent(oneBookCategoryTextArea)
                                        .addComponent(oneBookNameTextArea))
                                .addContainerGap())
                        .addGroup(oneBookInforPanelLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(oneBookStartReadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(65, Short.MAX_VALUE))
        );
        oneBookInforPanelLayout.setVerticalGroup(
                oneBookInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(oneBookInforPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(oneBookNameTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oneBookDescriptionTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oneBookStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oneBookAuthorTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oneBookCategoryTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(oneBookStartReadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(79, Short.MAX_VALUE))
        );

        oneBookTabbed.addTab("Thông tin truyện", oneBookInforPanel);

        oneBookChapterPanel.setBackground(new java.awt.Color(176, 223, 251));

        javax.swing.GroupLayout oneBookChapterPanelLayout = new javax.swing.GroupLayout(oneBookChapterPanel);
        oneBookChapterPanel.setLayout(oneBookChapterPanelLayout);
        oneBookChapterPanelLayout.setHorizontalGroup(
                oneBookChapterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 450, Short.MAX_VALUE)
        );
        oneBookChapterPanelLayout.setVerticalGroup(
                oneBookChapterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 435, Short.MAX_VALUE)
        );

        oneBookTabbed.addTab("Chương", oneBookChapterPanel);

        oneBookMainPanel.setLayer(oneBookTabbed, javax.swing.JLayeredPane.PALETTE_LAYER);
        oneBookMainPanel.add(oneBookTabbed, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 450, 470));

        oneBookBackLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        oneBookBackLabel.setText("<");
        oneBookBackLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backEvent(evt);
            }
        });
        oneBookMainPanel.setLayer(oneBookBackLabel, javax.swing.JLayeredPane.PALETTE_LAYER);
        oneBookMainPanel.add(oneBookBackLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        javax.swing.GroupLayout oneBookPanelLayout = new javax.swing.GroupLayout(oneBookPanel);
        oneBookPanel.setLayout(oneBookPanelLayout);
        oneBookPanelLayout.setHorizontalGroup(
                oneBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 450, Short.MAX_VALUE)
                        .addGroup(oneBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(oneBookPanelLayout.createSequentialGroup()
                                        .addComponent(oneBookMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );
        oneBookPanelLayout.setVerticalGroup(
                oneBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addGroup(oneBookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(oneBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(oneBookPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(oneBookPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void backEvent(java.awt.event.MouseEvent evt) {
        previousScreen.setVisible(true);
        this.setVisible(false);
    }

    private void startReadEvent(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }


    private javax.swing.JTextArea oneBookAuthorTextArea;
    private javax.swing.JLabel oneBookBackLabel;
    private javax.swing.JTextArea oneBookCategoryTextArea;
    private javax.swing.JPanel oneBookChapterPanel;
    private javax.swing.JTextArea oneBookDescriptionTextArea;
    private javax.swing.JLabel oneBookImgLabel;
    private javax.swing.JPanel oneBookInforPanel;
    private javax.swing.JLayeredPane oneBookMainPanel;
    private javax.swing.JTextArea oneBookNameTextArea;
    private javax.swing.JPanel oneBookPanel;
    private javax.swing.JButton oneBookStartReadButton;
    private javax.swing.JLabel oneBookStatusLabel;
    private javax.swing.JTabbedPane oneBookTabbed;
}

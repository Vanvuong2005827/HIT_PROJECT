package screens.home_screen_pages;

import java.io.File;
import javax.swing.JPanel;

import screens.HomeScreen;

import static commons.CurrentUser.userAccount;
import static commons.CurrentUser.userInfo;

public class AccountPage extends javax.swing.JFrame {
    HomeScreen homeScreen;
    private String basePath = new File("").getAbsolutePath();
    public AccountPage(HomeScreen hs) {
        homeScreen = hs;
        initComponents();
        accountGmailLabel.setText(userInfo.getEmail());
        accountPhoneNumberLabel.setText(userInfo.getPhoneNumber());
        accountUsernameLabel.setText(userAccount.getUsername());
        accountStatusAccountLabel.setText("active");
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        accountTTTKLabel = new javax.swing.JLabel();
        accountNameLabel = new javax.swing.JLabel();
        accountGmailLabel = new javax.swing.JLabel();
        accountPhoneNumberLabel = new javax.swing.JLabel();
        accountUsernameLabel = new javax.swing.JLabel();
        accountStatusAccountLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        accountChangePassLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        accountForgotPassLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        accountNightModeLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        accountRemoveLabel = new javax.swing.JLabel();
        accountLogoutButton = new javax.swing.JButton();
        accountChangeNameLabel = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.revalidate();
        jPanel1.repaint();
        jPanel1.setBackground(new java.awt.Color(176, 223, 251));

        jLabel2.setIcon(new javax.swing.ImageIcon(basePath + "\\src\\main\\java\\assets\\user.png"));

        accountTTTKLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        accountTTTKLabel.setText("Thông tin tài khoản");

        accountNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));

        accountGmailLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));

        accountPhoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));

        accountUsernameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));

        accountStatusAccountLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel5.setText("Gmail: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel6.setText("Phone Number: ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel7.setText("Username: ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel8.setText("Account status: ");

        accountChangePassLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        accountChangePassLabel.setForeground(new java.awt.Color(102, 102, 102));
        accountChangePassLabel.setText("Đổi mật khẩu                                          ->");
        accountChangePassLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changePassEvent(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        accountForgotPassLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        accountForgotPassLabel.setForeground(new java.awt.Color(102, 102, 102));
        accountForgotPassLabel.setText("Quên mật khẩu?                                     ->");
        accountForgotPassLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPassEvent(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));

        accountNightModeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        accountNightModeLabel.setForeground(new java.awt.Color(102, 102, 102));
        accountNightModeLabel.setText("Đổi màu nền                                           ->");
        accountNightModeLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                changeThemeEvent(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(153, 153, 153));

        accountRemoveLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        accountRemoveLabel.setForeground(new java.awt.Color(102, 102, 102));
        accountRemoveLabel.setText("Xóa tài khoản                                         ->");
        accountRemoveLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeAccEvent(evt);
            }
        });

        accountLogoutButton.setBackground(new java.awt.Color(204, 255, 255));
        accountLogoutButton.setFont(new java.awt.Font("Segoe UI", 1, 18));
        accountLogoutButton.setText("ĐĂNG XUẤT");
        accountLogoutButton.setBorder(null);
        accountLogoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutEvent(evt);
            }
        });

        accountChangeNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        accountChangeNameLabel.setForeground(new java.awt.Color(102, 102, 102));
        accountChangeNameLabel.setText("Đổi tên hiện thị                                       ->");
        accountChangeNameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeNameEvent(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(135, 135, 135)
                                                .addComponent(accountTTTKLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(83, 83, 83)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(2, 2, 2)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel5)
                                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(jLabel7))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(accountUsernameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                                                        .addComponent(accountPhoneNumberLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(accountGmailLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(accountNameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(accountStatusAccountLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addComponent(accountLogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(accountRemoveLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(accountNightModeLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(accountChangeNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(accountChangePassLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(accountForgotPassLabel, javax.swing.GroupLayout.Alignment.LEADING)))))
                                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(accountTTTKLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(accountNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(accountGmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(accountPhoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(accountUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(accountStatusAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addGap(106, 106, 106)
                                .addComponent(accountChangeNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accountChangePassLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accountForgotPassLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accountNightModeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accountRemoveLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                                .addComponent(accountLogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void logoutEvent(java.awt.event.MouseEvent evt) {
        homeScreen.backToLogin();
    }

    private void changeNameEvent(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void changePassEvent(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void forgotPassEvent(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void changeThemeEvent(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
    }

    private void removeAccEvent(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }




    public JPanel accountPanel(){
        return jPanel1;
    }

    private javax.swing.JLabel accountChangeNameLabel;
    private javax.swing.JLabel accountChangePassLabel;
    private javax.swing.JLabel accountForgotPassLabel;
    private javax.swing.JLabel accountGmailLabel;
    private javax.swing.JButton accountLogoutButton;
    private javax.swing.JLabel accountNameLabel;
    private javax.swing.JLabel accountNightModeLabel;
    private javax.swing.JLabel accountPhoneNumberLabel;
    private javax.swing.JLabel accountRemoveLabel;
    private javax.swing.JLabel accountStatusAccountLabel;
    private javax.swing.JLabel accountTTTKLabel;
    private javax.swing.JLabel accountUsernameLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
}

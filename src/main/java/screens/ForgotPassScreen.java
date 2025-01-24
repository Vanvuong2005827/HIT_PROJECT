package screens;

import java.io.File;

public class ForgotPassScreen extends javax.swing.JFrame {
    private String basePath = new File("").getAbsolutePath();
    public ForgotPassScreen() {
        initComponents();
        setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        forgorPassMainPanel = new javax.swing.JPanel();
        forgotPassBack = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        forgotPassEmailLabel = new javax.swing.JLabel();
        forgotPassEmailTextField = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        forgotPassCodeLabel = new javax.swing.JLabel();
        forgotPassCodeTextField = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        forgotPassGetCodeButton = new javax.swing.JButton();
        forgotPassShowMessage = new javax.swing.JLabel();
        forgotPassUsernameLabel = new javax.swing.JLabel();
        forgotPassUsernameTextField = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        forgotPassConfirmButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        forgorPassMainPanel.setBackground(new java.awt.Color(176, 223, 251));

        forgotPassBack.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        forgotPassBack.setText("<");
        forgotPassBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backEvent(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Quên mật khẩu");

        forgotPassEmailLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        forgotPassEmailLabel.setText("Email liên kết:");

        forgotPassEmailTextField.setBackground(new java.awt.Color(176, 223, 251));
        forgotPassEmailTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        forgotPassEmailTextField.setBorder(null);

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));

        forgotPassCodeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        forgotPassCodeLabel.setText("Mã xác thực:");

        forgotPassCodeTextField.setBackground(new java.awt.Color(176, 223, 251));
        forgotPassCodeTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        forgotPassCodeTextField.setBorder(null);

        jTextField4.setBackground(new java.awt.Color(204, 204, 204));

        forgotPassGetCodeButton.setBackground(new java.awt.Color(204, 255, 204));
        forgotPassGetCodeButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        forgotPassGetCodeButton.setText("Lấy mã");
        forgotPassGetCodeButton.setBorder(null);
        forgotPassGetCodeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getCodeEvent(evt);
            }
        });

        forgotPassShowMessage.setForeground(new java.awt.Color(255, 0, 51));

        forgotPassUsernameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        forgotPassUsernameLabel.setText("Username");

        forgotPassUsernameTextField.setBackground(new java.awt.Color(176, 223, 251));
        forgotPassUsernameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        forgotPassUsernameTextField.setBorder(null);

        jTextField3.setBackground(new java.awt.Color(204, 204, 204));

        forgotPassConfirmButton.setBackground(new java.awt.Color(204, 255, 204));
        forgotPassConfirmButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        forgotPassConfirmButton.setText("Xác nhận");
        forgotPassConfirmButton.setBorder(null);
        forgotPassConfirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmEvent(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\boyzs\\Desktop\\Java\\JAVA_SWING_PROJECT\\pet_project\\src\\main\\java\\assets\\christmas-tree-15498_256.gif")); // NOI18N

        javax.swing.GroupLayout forgorPassMainPanelLayout = new javax.swing.GroupLayout(forgorPassMainPanel);
        forgorPassMainPanel.setLayout(forgorPassMainPanelLayout);
        forgorPassMainPanelLayout.setHorizontalGroup(
                forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                .addComponent(forgotPassBack, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(128, 128, 128)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                .addComponent(forgotPassEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField2)
                                                        .addComponent(forgotPassEmailTextField)))
                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                .addComponent(forgotPassCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(forgotPassCodeTextField)
                                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(forgotPassGetCodeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                                .addComponent(forgotPassConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                .addComponent(forgotPassUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField3)
                                                        .addComponent(forgotPassUsernameTextField)
                                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                                .addComponent(forgotPassShowMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 22, Short.MAX_VALUE)))))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forgorPassMainPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(133, 133, 133))
        );
        forgorPassMainPanelLayout.setVerticalGroup(
                forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(forgotPassBack, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(forgotPassShowMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(forgotPassUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(forgotPassUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(forgotPassGetCodeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(forgotPassEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(forgotPassEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(forgotPassCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(forgotPassCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forgorPassMainPanelLayout.createSequentialGroup()
                                                                .addGap(41, 41, 41)
                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(46, 46, 46)
                                .addComponent(forgotPassConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(253, 253, 253))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(forgorPassMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(forgorPassMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void backEvent(java.awt.event.MouseEvent evt) {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        this.setVisible(false);
    }

    private void getCodeEvent(java.awt.event.MouseEvent evt) {
        String email = forgotPassEmailTextField.getText();
        String username = forgotPassUsernameTextField.getText();
        String code = forgotPassCodeTextField.getText();

        if (username.isEmpty()){
            forgotPassShowMessage.setText("Please enter your username");
            return;
        }
        if (email.isEmpty()){
            forgotPassShowMessage.setText("Please enter your email address");
            return;
        }


    }

    private void confirmEvent(java.awt.event.MouseEvent evt) {
        String email = forgotPassEmailTextField.getText();
        String username = forgotPassUsernameTextField.getText();
        String code = forgotPassCodeTextField.getText();

        if (username.isEmpty()){
            forgotPassShowMessage.setText("Please enter your username");
            return;
        }
        if (email.isEmpty()){
            forgotPassShowMessage.setText("Please enter your email address");
            return;
        }
        if (code.isEmpty()){
            forgotPassShowMessage.setText("Please enter the code sent to your email");
            return;
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JPanel forgorPassMainPanel;
    private javax.swing.JLabel forgotPassBack;
    private javax.swing.JLabel forgotPassCodeLabel;
    private javax.swing.JTextField forgotPassCodeTextField;
    private javax.swing.JButton forgotPassConfirmButton;
    private javax.swing.JLabel forgotPassEmailLabel;
    private javax.swing.JTextField forgotPassEmailTextField;
    private javax.swing.JButton forgotPassGetCodeButton;
    private javax.swing.JLabel forgotPassShowMessage;
    private javax.swing.JLabel forgotPassUsernameLabel;
    private javax.swing.JTextField forgotPassUsernameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration
}

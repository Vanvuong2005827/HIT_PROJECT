package screens;

import services.LoginService;
import services.UserServices;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static services.LoginService.*;
public class LoginScreen extends javax.swing.JFrame {

    private void showCustomDialog(String message) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Notification");
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout());

        JLabel label = new JLabel(message, SwingConstants.CENTER);
        dialog.add(label, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dialog.dispose());
        dialog.add(closeButton, BorderLayout.SOUTH);

        dialog.setModal(true);
        dialog.setVisible(true);
    }

    public LoginScreen() {
        initComponents();
        setLocationRelativeTo(null);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        loginMainPanel = new javax.swing.JPanel();
        loginLoginTabbed = new javax.swing.JTabbedPane();
        loginLoginPanel = new javax.swing.JPanel();
        loginUsernameLabel = new javax.swing.JLabel();
        loginPasswordLabel = new javax.swing.JLabel();
        loginUsernameTextField = new javax.swing.JTextField();
        loginPasswordTextField = new javax.swing.JPasswordField();
        loginForgotPassLabel = new javax.swing.JLabel();
        loginRememberCheckbox = new javax.swing.JCheckBox();
        loginButton = new javax.swing.JButton();
        loginSignUpPanel = new javax.swing.JPanel();
        signUpUsernameLabel = new javax.swing.JLabel();
        signUpUsernameTextField = new javax.swing.JTextField();
        signUpPasswordTextField = new javax.swing.JPasswordField();
        signUpPasswordLabel = new javax.swing.JLabel();
        signUpFullnamLabel = new javax.swing.JLabel();
        signUpFullnameTextField = new javax.swing.JTextField();
        signUpButton = new javax.swing.JButton();
        signUpReEnterPasswordLabel1 = new javax.swing.JLabel();
        signUpReEnterPasswordLabel2 = new javax.swing.JLabel();
        signUpReEnterPasswordTextField = new javax.swing.JPasswordField();
        loginLogo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));

        loginMainPanel.setBackground(new java.awt.Color(176, 223, 251));

        loginLoginTabbed.setBackground(new java.awt.Color(255, 255, 255));
        loginLoginTabbed.setToolTipText("");
        loginLoginTabbed.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginLoginTabbed.setFocusable(false);
        loginLoginTabbed.setMinimumSize(new java.awt.Dimension(47, 65));

        loginLoginPanel.setBackground(new java.awt.Color(255, 255, 255));

        loginUsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loginUsernameLabel.setForeground(new java.awt.Color(102, 102, 102));
        loginUsernameLabel.setText("Username");

        loginPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loginPasswordLabel.setForeground(new java.awt.Color(102, 102, 102));
        loginPasswordLabel.setText("Password");

        loginForgotPassLabel.setForeground(new java.awt.Color(102, 102, 102));
        loginForgotPassLabel.setText("Forgot Password");
        loginForgotPassLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPassEvent(evt);
            }
        });

        loginRememberCheckbox.setBackground(new java.awt.Color(255, 255, 255));
        loginRememberCheckbox.setForeground(new java.awt.Color(102, 102, 102));
        loginRememberCheckbox.setText("Remember me");
        loginRememberCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginRememberCheckboxActionPerformed(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(176, 223, 251));
        loginButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("LOGIN");
        loginButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginEvent(evt);
            }
        });

        javax.swing.GroupLayout loginLoginPanelLayout = new javax.swing.GroupLayout(loginLoginPanel);
        loginLoginPanel.setLayout(loginLoginPanelLayout);
        loginLoginPanelLayout.setHorizontalGroup(
                loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(loginForgotPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(loginPasswordLabel)
                                                                        .addComponent(loginUsernameLabel))
                                                                .addGap(39, 39, 39)
                                                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(loginUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(loginPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                                .addGap(4, 4, 4)
                                                                .addComponent(loginRememberCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(40, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLoginPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))
        );
        loginLoginPanelLayout.setVerticalGroup(
                loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(loginUsernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(loginPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginForgotPassLabel)
                                        .addComponent(loginRememberCheckbox))
                                .addGap(41, 41, 41)
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(132, Short.MAX_VALUE))
        );

        loginLoginTabbed.addTab("LOGIN", loginLoginPanel);

        loginSignUpPanel.setBackground(new java.awt.Color(255, 255, 255));

        signUpUsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signUpUsernameLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpUsernameLabel.setText("Username");

        signUpPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signUpPasswordLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpPasswordLabel.setText("Password");

        signUpFullnamLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signUpFullnamLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpFullnamLabel.setText("Full name");

        signUpButton.setBackground(new java.awt.Color(176, 223, 251));
        signUpButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(255, 255, 255));
        signUpButton.setText("Sign Up");
        signUpButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpEvent(evt);
            }
        });

        signUpReEnterPasswordLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signUpReEnterPasswordLabel1.setForeground(new java.awt.Color(102, 102, 102));
        signUpReEnterPasswordLabel1.setText("Re-enter");

        signUpReEnterPasswordLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signUpReEnterPasswordLabel2.setForeground(new java.awt.Color(102, 102, 102));
        signUpReEnterPasswordLabel2.setText("Password");

        javax.swing.GroupLayout loginSignUpPanelLayout = new javax.swing.GroupLayout(loginSignUpPanel);
        loginSignUpPanel.setLayout(loginSignUpPanelLayout);
        loginSignUpPanelLayout.setHorizontalGroup(
                loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginSignUpPanelLayout.createSequentialGroup()
                                                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(76, 76, 76))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginSignUpPanelLayout.createSequentialGroup()
                                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(signUpPasswordLabel)
                                                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                                                                .addComponent(signUpReEnterPasswordLabel1)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(signUpReEnterPasswordLabel2))
                                                                        .addComponent(signUpUsernameLabel)
                                                                        .addComponent(signUpFullnamLabel))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(signUpFullnameTextField)
                                                                        .addComponent(signUpUsernameTextField)
                                                                        .addComponent(signUpPasswordTextField)
                                                                        .addComponent(signUpReEnterPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(48, 48, 48))))
        );
        loginSignUpPanelLayout.setVerticalGroup(
                loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signUpFullnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpFullnamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(signUpUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(signUpPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signUpReEnterPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpReEnterPasswordLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpReEnterPasswordLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(71, 71, 71)
                                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87))
        );

        loginLoginTabbed.addTab("SIGN UP", loginSignUpPanel);

        loginLogo.setBackground(new java.awt.Color(153, 153, 0));

        javax.swing.GroupLayout loginLogoLayout = new javax.swing.GroupLayout(loginLogo);
        loginLogo.setLayout(loginLogoLayout);
        loginLogoLayout.setHorizontalGroup(
                loginLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 156, Short.MAX_VALUE)
        );
        loginLogoLayout.setVerticalGroup(
                loginLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 86, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcom to my comic");

        javax.swing.GroupLayout loginMainPanelLayout = new javax.swing.GroupLayout(loginMainPanel);
        loginMainPanel.setLayout(loginMainPanelLayout);
        loginMainPanelLayout.setHorizontalGroup(
                loginMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(loginLoginTabbed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginMainPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(loginMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginMainPanelLayout.createSequentialGroup()
                                                .addComponent(loginLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(145, 145, 145))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginMainPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(74, 74, 74))))
        );
        loginMainPanelLayout.setVerticalGroup(
                loginMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginMainPanelLayout.createSequentialGroup()
                                .addContainerGap(98, Short.MAX_VALUE)
                                .addComponent(loginLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(loginLoginTabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(loginMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(loginMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void forgotPassEvent(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void loginEvent(java.awt.event.ActionEvent evt) {
        LoginService LoginService = new LoginService();
        if (LoginService.authenticate(loginUsernameTextField.getText(),loginPasswordTextField.getText())){
            LoginScreen loginScreen = this;
            HomeScreen hs = new HomeScreen();
            WaitScreen ws = new WaitScreen();
            ws.setVisible(true);
            loginScreen.setVisible(false);
            Timer timer = new Timer(4200, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ws.setVisible(false);
                    hs.setVisible(true);
                }
            });
            timer.setRepeats(false); // Đảm bảo timer chỉ chạy một lần
            timer.start();
        } else {
//            JOptionPane.showMessageDialog(null, "Invalid username or password");
            showCustomDialog("Invalid username or password");
        }

    }

    private void signUpEvent(java.awt.event.ActionEvent evt) {
        if (signUpFullnameTextField == null){
            JOptionPane.showMessageDialog(null, "Please enter full name");
            System.out.println("123");
        }

//        if (s)
    }

    private void loginRememberCheckboxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginForgotPassLabel;
    private javax.swing.JPanel loginLoginPanel;
    private javax.swing.JTabbedPane loginLoginTabbed;
    private javax.swing.JPanel loginLogo;
    private javax.swing.JPanel loginMainPanel;
    private javax.swing.JLabel loginPasswordLabel;
    private javax.swing.JPasswordField loginPasswordTextField;
    private javax.swing.JCheckBox loginRememberCheckbox;
    private javax.swing.JPanel loginSignUpPanel;
    private javax.swing.JLabel loginUsernameLabel;
    private javax.swing.JTextField loginUsernameTextField;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel signUpFullnamLabel;
    private javax.swing.JTextField signUpFullnameTextField;
    private javax.swing.JLabel signUpPasswordLabel;
    private javax.swing.JPasswordField signUpPasswordTextField;
    private javax.swing.JLabel signUpReEnterPasswordLabel1;
    private javax.swing.JLabel signUpReEnterPasswordLabel2;
    private javax.swing.JPasswordField signUpReEnterPasswordTextField;
    private javax.swing.JLabel signUpUsernameLabel;
    private javax.swing.JTextField signUpUsernameTextField;
    // End of variables declaration
}

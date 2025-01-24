package screens;

import commons.CheckRegex;
import models.User.UserAccount;
import services.LoginService;
import services.RegisterService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

import static commons.CurrentUser.*;

public class LoginScreen extends javax.swing.JFrame {
    LoginScreen loginScreen = this;

    private String basePath = new File("").getAbsolutePath();
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
        loginMessageLabel = new javax.swing.JLabel();
        loginSignUpPanel = new javax.swing.JPanel();
        signUpUsernameLabel = new javax.swing.JLabel();
        signUpUsernameTextField = new javax.swing.JTextField();
        signUpPasswordTextField = new javax.swing.JPasswordField();
        signUpPasswordLabel = new javax.swing.JLabel();
        signUpButton = new javax.swing.JButton();
        signUpReEnterPasswordLabel1 = new javax.swing.JLabel();
        signUpReEnterPasswordLabel2 = new javax.swing.JLabel();
        signUpReEnterPasswordTextField = new javax.swing.JPasswordField();
        signUpMessageLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

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
        loginRememberCheckbox.setBorder(null);
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

        loginMessageLabel.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout loginLoginPanelLayout = new javax.swing.GroupLayout(loginLoginPanel);
        loginLoginPanel.setLayout(loginLoginPanelLayout);
        loginLoginPanelLayout.setHorizontalGroup(
                loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(loginUsernameLabel)
                                                                        .addComponent(loginPasswordLabel))
                                                                .addGap(41, 41, 41)
                                                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(loginPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(loginUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(loginMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(59, 59, 59))
                                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                                .addComponent(loginRememberCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(loginForgotPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(41, 41, 41))))
                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                .addGap(84, 84, 84)
                                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginLoginPanelLayout.setVerticalGroup(
                loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(loginMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginUsernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                        .addComponent(loginUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(loginPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginForgotPassLabel)
                                        .addComponent(loginRememberCheckbox))
                                .addGap(53, 53, 53)
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(130, Short.MAX_VALUE))
        );

        loginLoginTabbed.addTab("LOGIN", loginLoginPanel);

        loginSignUpPanel.setBackground(new java.awt.Color(255, 255, 255));

        signUpUsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signUpUsernameLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpUsernameLabel.setText("Username");

        signUpPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signUpPasswordLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpPasswordLabel.setText("Password");

        signUpButton.setBackground(new java.awt.Color(176, 223, 251));
        signUpButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(255, 255, 255));
        signUpButton.setText("Sign Up");
        signUpButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        signUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpEvent(evt);
            }
        });

        signUpReEnterPasswordLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signUpReEnterPasswordLabel1.setForeground(new java.awt.Color(102, 102, 102));
        signUpReEnterPasswordLabel1.setText("Re-enter");

        signUpReEnterPasswordLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signUpReEnterPasswordLabel2.setForeground(new java.awt.Color(102, 102, 102));
        signUpReEnterPasswordLabel2.setText("Password");

        signUpMessageLabel.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout loginSignUpPanelLayout = new javax.swing.GroupLayout(loginSignUpPanel);
        loginSignUpPanel.setLayout(loginSignUpPanelLayout);
        loginSignUpPanelLayout.setHorizontalGroup(
                loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(signUpMessageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(signUpPasswordLabel)
                                                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                                                .addGap(59, 59, 59)
                                                                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                                                                .addComponent(signUpReEnterPasswordLabel1)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(signUpReEnterPasswordLabel2))
                                                                        .addComponent(signUpUsernameLabel))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(signUpUsernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                                                        .addComponent(signUpPasswordTextField)
                                                                        .addComponent(signUpReEnterPasswordTextField))))
                                                .addGap(0, 35, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        loginSignUpPanelLayout.setVerticalGroup(
                loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addComponent(signUpMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signUpUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(signUpPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signUpReEnterPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpReEnterPasswordLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpReEnterPasswordLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(125, 125, 125))
        );

        loginLoginTabbed.addTab("SIGN UP", loginSignUpPanel);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcom to my comic");

        jLabel2.setIcon(new javax.swing.ImageIcon(basePath + "\\src\\main\\java\\assets\\a-book-114_256.gif")); // NOI18N

        javax.swing.GroupLayout loginMainPanelLayout = new javax.swing.GroupLayout(loginMainPanel);
        loginMainPanel.setLayout(loginMainPanelLayout);
        loginMainPanelLayout.setHorizontalGroup(
                loginMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(loginLoginTabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginMainPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(loginMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74))
        );
        loginMainPanelLayout.setVerticalGroup(
                loginMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginMainPanelLayout.createSequentialGroup()
                                .addContainerGap(32, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        ForgotPassScreen fg = new ForgotPassScreen();
        this.setVisible(false);
        fg.setVisible(true);
    }

    private void loginEvent(java.awt.event.ActionEvent evt) {

        String userName = loginUsernameTextField.getText();
        String password = loginPasswordTextField.getText();

        if (userName.isEmpty()){
            loginMessageLabel.setText("Please enter your username");
            return;
        }
        if (password.isEmpty()){
            loginMessageLabel.setText("Please enter your password");
            return;
        }

        if (loginService.authenticate(userName,loginPasswordTextField.getText())){

            userAccount = userServices.getUserByUsername(userName);
            userInfo = userServices.getUserInfoByUserAccount(userAccount);

            LoginScreen loginScreen = this;

            WaitScreen ws = new WaitScreen();
            ws.setVisible(true);
            loginScreen.setVisible(false);
            HomeScreen hs = new HomeScreen(this, ws);

        } else {
            loginMessageLabel.setText("Invalid username or password");
        }

    }

    private void signUpEvent(java.awt.event.MouseEvent evt) {
        String userName = signUpUsernameTextField.getText();
        String password = signUpPasswordTextField.getText();
        String reEnterPassword = signUpReEnterPasswordTextField.getText();

        if (userName.isEmpty()){
            signUpMessageLabel.setText("Please enter your username");
            return;
        }

        if (password.isEmpty()){
            signUpMessageLabel.setText("Please enter your password");
            return;
        }

        if (reEnterPassword.isEmpty()){
            signUpMessageLabel.setText("Please reenter your password");
            return;
        }

        if (!password.equals(reEnterPassword)){
            signUpMessageLabel.setText("Passwords do not match");
            return;
        }

        if (!CheckRegex.checkValidUserName(userName)){
            signUpMessageLabel.setText("Username must 8-20 length (a-z, A-Z, 0-9). No char _, . in first/last");
            return;
        }

        if (!CheckRegex.checkValidPassword(password)){
            signUpMessageLabel.setText("Password at least 8 chars, 1 uppercase, 1 lowercase, 1 number.");
            return;
        }

        userAccount = new UserAccount(userName, password);
        if (!registerService.register(userAccount)){
            signUpMessageLabel.setText("Username already exists");
            return;
        } else {
            SignUpScreen su = new SignUpScreen();
            this.setVisible(false);
            su.setVisible(true);
        }
    }

    private void loginRememberCheckboxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginForgotPassLabel;
    private javax.swing.JPanel loginLoginPanel;
    private javax.swing.JTabbedPane loginLoginTabbed;
    private javax.swing.JPanel loginLogo;
    private javax.swing.JPanel loginMainPanel;
    private javax.swing.JLabel loginMessageLabel;
    private javax.swing.JLabel loginPasswordLabel;
    private javax.swing.JPasswordField loginPasswordTextField;
    private javax.swing.JCheckBox loginRememberCheckbox;
    private javax.swing.JPanel loginSignUpPanel;
    private javax.swing.JLabel loginUsernameLabel;
    private javax.swing.JTextField loginUsernameTextField;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel signUpMessageLabel;
    private javax.swing.JLabel signUpPasswordLabel;
    private javax.swing.JPasswordField signUpPasswordTextField;
    private javax.swing.JLabel signUpReEnterPasswordLabel1;
    private javax.swing.JLabel signUpReEnterPasswordLabel2;
    private javax.swing.JPasswordField signUpReEnterPasswordTextField;
    private javax.swing.JLabel signUpUsernameLabel;
    private javax.swing.JTextField signUpUsernameTextField;
    // End of variables declaration
}

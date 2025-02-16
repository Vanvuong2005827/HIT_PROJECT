package view.screens.auth_screens;

import controllers.account.LoginController;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;

import static commons.ColorMain.*;
import static commons.CurrentUser.*;
import static utils.NetworkChecker.curFrame;

public class LoginScreen extends JFrame {
    private String basePath = new File("").getAbsolutePath();

    public LoginScreen() {
        initComponents();
        new LoginController(this);
        setLocationRelativeTo(null);
        curFrame = this;
    }

    private void initComponents() {
        loginMainPanel = new JPanel();
        loginLoginTabbed = new JTabbedPane();
        loginLoginPanel = new JPanel();
        loginUsernameLabel = new JLabel();
        loginPasswordLabel = new JLabel();
        loginUsernameTextField = new JTextField();
        loginPasswordTextField = new JPasswordField();
        loginForgotPassLabel = new JLabel();
        loginRememberCheckbox = new JCheckBox();
        loginButton = new JButton();
        loginMessageLabel = new JLabel();
        loginEyeLabel = new javax.swing.JLabel();
        loginEyeLabel2 = new javax.swing.JLabel();
        loginSignUpPanel = new JPanel();
        signUpUsernameLabel = new JLabel();
        signUpUsernameTextField = new JTextField();
        signUpPasswordTextField = new JPasswordField();
        signUpPasswordLabel = new JLabel();
        signUpButton = new JButton();
        signUpReEnterPasswordLabel1 = new JLabel();
        signUpReEnterPasswordLabel2 = new JLabel();
        signUpReEnterPasswordTextField = new JPasswordField();
        signUpMessageLabel = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setBackground(colorDefault);
        setUndecorated(true);

        loginMainPanel.setBackground(colorDefault);

        loginLoginTabbed.setBackground(new Color(255, 255, 255));
        loginLoginTabbed.setToolTipText("");
        loginLoginTabbed.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        loginLoginTabbed.setFocusable(false);
        loginLoginTabbed.setMinimumSize(new Dimension(47, 65));

        loginLoginPanel.setBackground(new Color(255, 255, 255));

        loginUsernameLabel.setIcon(IconFontSwing.buildIcon(FontAwesome.USER_CIRCLE_O, 23, Color.GRAY));

        loginPasswordLabel.setIcon(IconFontSwing.buildIcon(FontAwesome.KEY, 23, Color.GRAY));

        loginForgotPassLabel.setForeground(new Color(102, 102, 102));
        loginForgotPassLabel.setText("Quên mật khẩu");

        loginRememberCheckbox.setBackground(new Color(255, 255, 255));
        loginRememberCheckbox.setForeground(new Color(102, 102, 102));
        loginRememberCheckbox.setText("Nhớ tài khoản");
        loginRememberCheckbox.setBorder(null);

        loginButton.setBackground(colorDefault);
        loginButton.setFont(new Font("Segoe UI", 1, 18));
        loginButton.setForeground(Color.black);
        loginButton.setText("ĐĂNG NHẬP ");
        loginButton.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
        loginButton.setIcon(IconFontSwing.buildIcon(FontAwesome.SIGN_IN, 20, Color.black));
        loginButton.setHorizontalTextPosition(SwingConstants.LEFT);

        loginMessageLabel.setForeground(new Color(255, 51, 51));

        loginEyeLabel.setIcon(IconFontSwing.buildIcon(FontAwesome.EYE_SLASH, 23, Color.black));
        loginEyeLabel2.setIcon(IconFontSwing.buildIcon(FontAwesome.EYE_SLASH, 23, Color.black));

        javax.swing.GroupLayout loginLoginPanelLayout = new javax.swing.GroupLayout(loginLoginPanel);
        loginLoginPanel.setLayout(loginLoginPanelLayout);
        loginLoginPanelLayout.setHorizontalGroup(
                loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(loginUsernameLabel)
                                                        .addComponent(loginPasswordLabel))
                                                .addGap(41, 41, 41)
                                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                                .addComponent(loginMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLoginPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(loginUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                                                .addComponent(loginPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(loginEyeLabel)))))
                                                .addGap(43, 43, 43))
                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                .addComponent(loginRememberCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(loginForgotPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(56, 56, 56))))
                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(84, Short.MAX_VALUE))
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
                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(loginPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(loginPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(loginEyeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(loginLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(loginRememberCheckbox))
                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(loginForgotPassLabel)))
                                .addGap(53, 53, 53)
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(130, Short.MAX_VALUE))
        );

        loginLoginTabbed.addTab("ĐĂNG NHẬP", loginLoginPanel);

        loginSignUpPanel.setBackground(new Color(255, 255, 255));

        signUpUsernameLabel.setIcon(IconFontSwing.buildIcon(FontAwesome.USER_CIRCLE_O, 23, Color.GRAY));

        signUpPasswordLabel.setIcon(IconFontSwing.buildIcon(FontAwesome.KEY, 23, Color.GRAY));

        signUpButton.setBackground(colorDefault);
        signUpButton.setFont(new Font("Segoe UI", 1, 18));
        signUpButton.setForeground(Color.black);
        signUpButton.setText("ĐĂNG KÍ");
        signUpButton.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));

        signUpReEnterPasswordLabel1.setFont(new Font("Segoe UI", 0, 14));
        signUpReEnterPasswordLabel1.setForeground(new Color(102, 102, 102));
        signUpReEnterPasswordLabel1.setText("Nhập lại");

        signUpReEnterPasswordLabel2.setFont(new Font("Segoe UI", 0, 14));
        signUpReEnterPasswordLabel2.setForeground(new Color(102, 102, 102));
        signUpReEnterPasswordLabel2.setText("mật khẩu");

        signUpMessageLabel.setForeground(new Color(255, 51, 51));

        javax.swing.GroupLayout loginSignUpPanelLayout = new javax.swing.GroupLayout(loginSignUpPanel);
        loginSignUpPanel.setLayout(loginSignUpPanelLayout);
        loginSignUpPanelLayout.setHorizontalGroup(
                loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(signUpMessageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 78, Short.MAX_VALUE))
                                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(signUpPasswordLabel)
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
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(loginEyeLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                        .addComponent(signUpPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(loginEyeLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(loginSignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signUpReEnterPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpReEnterPasswordLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpReEnterPasswordLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(125, 125, 125))
        );

        loginLoginTabbed.addTab("ĐĂNG KÍ", loginSignUpPanel);

        jLabel1.setFont(new Font("Segoe UI", 1, 24));
        jLabel1.setForeground(Color.black);
        jLabel1.setText("Welcom to our comic");

        jLabel2.setIcon(new ImageIcon(basePath + "\\src\\main\\java\\assets\\logoBrand.png"));

        GroupLayout loginMainPanelLayout = new GroupLayout(loginMainPanel);
        loginMainPanel.setLayout(loginMainPanelLayout);
        loginMainPanelLayout.setHorizontalGroup(
                loginMainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(loginLoginTabbed, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, loginMainPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(loginMainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
                                .addGap(74, 74, 74))
        );
        loginMainPanelLayout.setVerticalGroup(
                loginMainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, loginMainPanelLayout.createSequentialGroup()
                                .addContainerGap(32, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loginLoginTabbed, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(loginMainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(loginMainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        String SaveUsername = "";
        loginUsernameTextField.setText(pref.get("username", SaveUsername));
        String SavePassword = "";
        loginPasswordTextField.setText(pref.get("password", SavePassword));
    }


    private JLabel jLabel1;
    private JLabel jLabel2;
    private JButton loginButton;
    private javax.swing.JLabel loginEyeLabel;
    private javax.swing.JLabel loginEyeLabel2;
    private JLabel loginForgotPassLabel;
    private JPanel loginLoginPanel;
    private JTabbedPane loginLoginTabbed;
    private JPanel loginMainPanel;
    private JLabel loginMessageLabel;
    private JLabel loginPasswordLabel;
    private JPasswordField loginPasswordTextField;
    private JCheckBox loginRememberCheckbox;
    private JPanel loginSignUpPanel;
    private JLabel loginUsernameLabel;
    private JTextField loginUsernameTextField;
    private JButton signUpButton;
    private JLabel signUpMessageLabel;
    private JLabel signUpPasswordLabel;
    private JPasswordField signUpPasswordTextField;
    private JLabel signUpReEnterPasswordLabel1;
    private JLabel signUpReEnterPasswordLabel2;
    private JPasswordField signUpReEnterPasswordTextField;
    private JLabel signUpUsernameLabel;
    private JTextField signUpUsernameTextField;

    public JTabbedPane getLoginLoginTabbed() {
        return loginLoginTabbed;
    }

    public JLabel getLoginForgotPassLabel() {
        return loginForgotPassLabel;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JTextField getLoginUsernameTextField() {
        return loginUsernameTextField;
    }

    public JPasswordField getLoginPasswordTextField() {
        return loginPasswordTextField;
    }

    public JLabel getLoginMessageLabel() {
        return loginMessageLabel;
    }

    public JCheckBox getLoginRememberCheckbox() {
        return loginRememberCheckbox;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JLabel getSignUpMessageLabel() {
        return signUpMessageLabel;
    }

    public JPasswordField getSignUpPasswordTextField() {
        return signUpPasswordTextField;
    }

    public JPasswordField getSignUpReEnterPasswordTextField() {
        return signUpReEnterPasswordTextField;
    }

    public JTextField getSignUpUsernameTextField() {
        return signUpUsernameTextField;
    }

    public JLabel getLoginEyeLabel() {
        return loginEyeLabel;
    }

    public JLabel getLoginEyeLabel2() {
        return loginEyeLabel2;
    }

}

package screens;

import models.User.UserHistoryBooks;
import models.User.UserIP;
import models.book_information.Book;
import utils.CheckRegex;
import models.User.UserAccount;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static commons.CurrentUser.*;

public class LoginScreen extends JFrame {
    private String basePath = new File("").getAbsolutePath();

    public LoginScreen() {
        initComponents();
        setLocationRelativeTo(null);
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
        setBackground(new Color(255, 255, 255));
        setUndecorated(true);

        loginMainPanel.setBackground(new Color(176, 223, 251));

        loginLoginTabbed.setBackground(new Color(255, 255, 255));
        loginLoginTabbed.setToolTipText("");
        loginLoginTabbed.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        loginLoginTabbed.setFocusable(false);
        loginLoginTabbed.setMinimumSize(new Dimension(47, 65));

        loginLoginPanel.setBackground(new Color(255, 255, 255));

        loginUsernameLabel.setFont(new Font("Segoe UI", 0, 14));
        loginUsernameLabel.setForeground(new Color(102, 102, 102));
        loginUsernameLabel.setText("Tài khoản");

        loginPasswordLabel.setFont(new Font("Segoe UI", 0, 14));
        loginPasswordLabel.setForeground(new Color(102, 102, 102));
        loginPasswordLabel.setText("Mật khẩu");

        loginForgotPassLabel.setForeground(new Color(102, 102, 102));
        loginForgotPassLabel.setText("Quên mật khẩu");
        loginForgotPassLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                forgotPassEvent(evt);
            }
        });

        loginRememberCheckbox.setBackground(new Color(255, 255, 255));
        loginRememberCheckbox.setForeground(new Color(102, 102, 102));
        loginRememberCheckbox.setText("Nhớ tài khoản");
        loginRememberCheckbox.setBorder(null);
        loginRememberCheckbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginRememberCheckboxActionPerformed(evt);
            }
        });

        loginButton.setBackground(new Color(176, 223, 251));
        loginButton.setFont(new Font("Segoe UI", 1, 18));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setText("ĐĂNG NHẬP");
        loginButton.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginEvent(evt);
            }
        });

        loginMessageLabel.setForeground(new Color(255, 51, 51));

        GroupLayout loginLoginPanelLayout = new GroupLayout(loginLoginPanel);
        loginLoginPanel.setLayout(loginLoginPanelLayout);
        loginLoginPanelLayout.setHorizontalGroup(
                loginLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                .addGroup(loginLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(loginLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                                .addGroup(loginLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(loginUsernameLabel)
                                                                        .addComponent(loginPasswordLabel))
                                                                .addGap(41, 41, 41)
                                                                .addGroup(loginLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(loginPasswordTextField, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(loginUsernameTextField, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(loginMessageLabel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(59, 59, 59))
                                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                                .addComponent(loginRememberCheckbox, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(loginForgotPassLabel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(41, 41, 41))))
                                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                                .addGap(84, 84, 84)
                                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginLoginPanelLayout.setVerticalGroup(
                loginLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(loginLoginPanelLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(loginMessageLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(loginLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginUsernameTextField, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                        .addComponent(loginUsernameLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(loginLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginPasswordLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(loginPasswordTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(loginLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginForgotPassLabel)
                                        .addComponent(loginRememberCheckbox))
                                .addGap(53, 53, 53)
                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(130, Short.MAX_VALUE))
        );

        loginLoginTabbed.addTab("ĐĂNG NHẬP", loginLoginPanel);

        loginSignUpPanel.setBackground(new Color(255, 255, 255));

        signUpUsernameLabel.setFont(new Font("Segoe UI", 0, 14));
        signUpUsernameLabel.setForeground(new Color(102, 102, 102));
        signUpUsernameLabel.setText("Tài khoản");

        signUpPasswordLabel.setFont(new Font("Segoe UI", 0, 14));
        signUpPasswordLabel.setForeground(new Color(102, 102, 102));
        signUpPasswordLabel.setText("Mật khẩu");

        signUpButton.setBackground(new Color(176, 223, 251));
        signUpButton.setFont(new Font("Segoe UI", 1, 18));
        signUpButton.setForeground(new Color(255, 255, 255));
        signUpButton.setText("ĐĂNG KÍ");
        signUpButton.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
        signUpButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                signUpEvent(evt);
            }
        });

        signUpReEnterPasswordLabel1.setFont(new Font("Segoe UI", 0, 14));
        signUpReEnterPasswordLabel1.setForeground(new Color(102, 102, 102));
        signUpReEnterPasswordLabel1.setText("Nhập lại");

        signUpReEnterPasswordLabel2.setFont(new Font("Segoe UI", 0, 14));
        signUpReEnterPasswordLabel2.setForeground(new Color(102, 102, 102));
        signUpReEnterPasswordLabel2.setText("mật khẩu");

        signUpMessageLabel.setForeground(new Color(255, 51, 51));

        GroupLayout loginSignUpPanelLayout = new GroupLayout(loginSignUpPanel);
        loginSignUpPanel.setLayout(loginSignUpPanelLayout);
        loginSignUpPanelLayout.setHorizontalGroup(
                loginSignUpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(loginSignUpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(signUpMessageLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                                .addGroup(loginSignUpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(signUpPasswordLabel)
                                                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                                                .addGap(59, 59, 59)
                                                                .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                                                .addGroup(loginSignUpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                                                                .addComponent(signUpReEnterPasswordLabel1)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(signUpReEnterPasswordLabel2))
                                                                        .addComponent(signUpUsernameLabel))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(loginSignUpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(signUpUsernameTextField, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                                                        .addComponent(signUpPasswordTextField)
                                                                        .addComponent(signUpReEnterPasswordTextField))))
                                                .addGap(0, 35, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        loginSignUpPanelLayout.setVerticalGroup(
                loginSignUpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(loginSignUpPanelLayout.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addComponent(signUpMessageLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(loginSignUpPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(signUpUsernameTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpUsernameLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(loginSignUpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(signUpPasswordTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpPasswordLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(loginSignUpPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(signUpReEnterPasswordTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpReEnterPasswordLabel2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpReEnterPasswordLabel1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addGap(125, 125, 125))
        );

        loginLoginTabbed.addTab("ĐĂNG KÍ", loginSignUpPanel);

        jLabel1.setFont(new Font("Segoe UI", 1, 24));
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Welcom to my comic");

        jLabel2.setIcon(new ImageIcon(basePath + "\\src\\main\\java\\assets\\a-book-114_256.gif"));

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


    private void forgotPassEvent(MouseEvent evt) {
        ForgotPassScreen fg = new ForgotPassScreen(this);
        this.setVisible(false);
        fg.setVisible(true);
    }

    private void loginEvent(ActionEvent evt) {
        UserIP userIP = new UserIP();
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            userIP = userServices.getUserIPByIP(localhost.getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String userName = loginUsernameTextField.getText().trim();
        String password = loginPasswordTextField.getText().trim();
        if (userName.isEmpty()) {
            loginMessageLabel.setText("Xin mời nhập tên tài khoản");
            return;
        }
        if (password.isEmpty()) {
            loginMessageLabel.setText("Xin mời nhập mật khẩu");
            return;
        }

        if (userIP.getTime().isAfter(LocalDateTime.now())) {
            Duration duration = Duration.between(LocalDateTime.now(), userIP.getTime());
            long minutes = duration.toMinutes();
            long seconds = duration.getSeconds() % 60;
            loginMessageLabel.setText("Thử lại sau: " + minutes + " phút " + seconds + " giây");
            return;
        }

        if (loginService.authenticate(userName, password)) {
            userAccount = userServices.getUserByUsername(userName);
            userInfo = userServices.getUserInfoByUserAccount(userAccount);

            if (loginRememberCheckbox.isSelected()) {
                loginService.saveUser(userName, password);
            }

            LoginScreen loginScreen = this;
            WaitScreen ws = new WaitScreen();
            ws.setVisible(true);
            loginScreen.setVisible(false);
            HomeScreen hs = new HomeScreen(this, ws);



        } else {
            loginMessageLabel.setText("Sai tên đăng nhập hoặc mật khẩu");
            cnt++;
            if (cnt == 5) {
                userServices.plusTime(userIP,5);
                cnt = 0;
            }
        }
    }

    private void signUpEvent(MouseEvent evt) {
        String userName = signUpUsernameTextField.getText();
        String password = signUpPasswordTextField.getText();
        String reEnterPassword = signUpReEnterPasswordTextField.getText();

        if (userName.isEmpty()) {
            signUpMessageLabel.setText("Xin mời nhập tên tài khoản");
            return;
        }

        if (password.isEmpty()) {
            signUpMessageLabel.setText("Xin mời nhập mật khẩu");
            return;
        }

        if (reEnterPassword.isEmpty()) {
            signUpMessageLabel.setText("Xin mời nhập lại mật khẩu");
            return;
        }

        if (!password.equals(reEnterPassword)) {
            signUpMessageLabel.setText("Mật khẩu không khớp");
            return;
        }

        if (!CheckRegex.checkValidUserName(userName)) {
            signUpMessageLabel.setText("Tài khoản phải dài 8-20 (a-z, A-Z, 0-9). Không có kí tự _, . ở đầu/cuối");
            return;
        }

        if (!CheckRegex.checkValidPassword(password)) {
            signUpMessageLabel.setText("Mật khẩu ít nhất 8 kí tự, 1 in hoa, 1 in thường, 1 số.");
            return;
        }
        password = encryptorService.hasing(password);
        userAccount = new UserAccount(userName, password);
        if (!registerService.register(userAccount)) {
            signUpMessageLabel.setText("Tài khoản đã tồn tại");
            return;
        } else {
            SignUpScreen su = new SignUpScreen();
            this.setVisible(false);
            su.setVisible(true);
        }
    }

    private void loginRememberCheckboxActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JButton loginButton;
    private JLabel loginForgotPassLabel;
    private JPanel loginLoginPanel;
    private JTabbedPane loginLoginTabbed;
    private JPanel loginLogo;
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
    private int cnt = 0;
}

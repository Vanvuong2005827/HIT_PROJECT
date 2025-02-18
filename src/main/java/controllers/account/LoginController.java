package controllers.account;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import models.user.Role;
import models.user.UserAccount;
import models.user.UserIP;
import view.admin_view.AdminHomePage;
import view.user_view.screens.account_screens.ForgotPassScreen;
import view.user_view.screens.auth_screens.LoginScreen;
import view.user_view.screens.auth_screens.SignUpScreen;
import view.user_view.screens.pages.HomePage;
import view.WaitScreen;
import utils.RegexChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.time.Duration;
import java.time.LocalDateTime;

import static commons.ColorMain.*;
import static commons.ColorMain.colorFix;
import static commons.CurrentUser.*;

public class LoginController {
    private LoginScreen loginScreen;
    private int cnt = 0;

    public LoginController(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
        fixedTabbed();
        forgotPassEvent();
        loginEvent();
        signUpEvent();
        showPasswordEvent();
    }

    private void fixedTabbed() {
        int tabWidth = 201;
        for (int i = 0; i < loginScreen.getLoginLoginTabbed().getTabCount(); i++) {
            loginScreen.getLoginLoginTabbed().setTabComponentAt(i, new JLabel(loginScreen.getLoginLoginTabbed().getTitleAt(i)) {
                {
                    setPreferredSize(new Dimension(tabWidth, 30));
                    setHorizontalAlignment(SwingConstants.CENTER);
                }
            });
        }
    }

    private static Color hextoColor(String hex) {
        return Color.decode(hex);
    }

    public void getGradientInUser() {
        if (userInfo.getColorMain1() != null) {
            colorMain1 = hextoColor(userInfo.getColorMain1());
        }

        if (userInfo.getColorMain2() != null) {
            colorMain2 = hextoColor(userInfo.getColorMain2());
        }

        if (userInfo.getColorMain3() != null) {
            colorMain3 = hextoColor(userInfo.getColorMain3());
        }

        if (userInfo.getColorFix() != null) {
            colorFix = hextoColor(userInfo.getColorFix());
        }
    }

    private void forgotPassEvent() {
        loginScreen.getLoginForgotPassLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                ForgotPassScreen fg = new ForgotPassScreen(loginScreen);
                fg.setVisible(true);
                loginScreen.setVisible(false);
            }
        });
    }

    private void loginEvent() {
        loginScreen.getLoginButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                String userName = loginScreen.getLoginUsernameTextField().getText().trim();
                String password = loginScreen.getLoginPasswordTextField().getText().trim();
                if (userName.isEmpty()) {
                    loginScreen.getLoginMessageLabel().setText("Xin mời nhập tên tài khoản");
                    return;
                }
                if (password.isEmpty()) {
                    loginScreen.getLoginMessageLabel().setText("Xin mời nhập mật khẩu");
                    return;
                }
                SwingWorker<Void, Void> worker = new SwingWorker<>() {
                    boolean isLogin = false;
                    WaitScreen ws = new WaitScreen();

                    @Override
                    protected Void doInBackground() {
                        ws.setVisible(true);
                        loginScreen.setVisible(false);
                        UserIP userIP = new UserIP();
                        try {
                            InetAddress localhost = InetAddress.getLocalHost();
                            userIP = userServices.getUserIPByIP(localhost.getHostAddress());
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        }

                        try {
                            if (userIP.getTime().isAfter(LocalDateTime.now())) {
                                Duration duration = Duration.between(LocalDateTime.now(), userIP.getTime());
                                long minutes = duration.toMinutes();
                                long seconds = duration.getSeconds() % 60;
                                loginScreen.getLoginMessageLabel().setText("Thử lại sau: " + minutes + " phút " + seconds + " giây");
                                return null;
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        }


                        try {
                            if (loginService.authenticate(userName, password)) {
                                isLogin = true;
                                try {
                                    userAccount = userServices.getUserByUsername(userName);
                                } catch (Exception e) {
                                    isLogin = false;
                                    JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                }
                                try {
                                    userInfo = userServices.getUserInfoByUserAccount(userAccount);
                                } catch (Exception e) {
                                    isLogin = false;
                                    JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                }

                                getGradientInUser();

                                if (loginScreen.getLoginRememberCheckbox().isSelected()) {
                                    try {
                                        loginService.saveUser(userName, password);
                                    } catch (Exception e) {
                                        isLogin = false;
                                        JOptionPane.showMessageDialog(null, "Lưu không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            } else {
                                loginScreen.getLoginMessageLabel().setText("Sai tên đăng nhập hoặc mật khẩu");
                                cnt++;
                                if (cnt == 5) {
                                    try {
                                        userServices.plusTime(userIP, 5);
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                    }
                                    cnt = 0;
                                }
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Lỗi kết nối mạng! Vui lòng kiểm tra Internet.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        }
                        return null;
                    }

                    @Override
                    protected void done() {
                        if (isLogin == true) {
                            if (userAccount.getRole() == Role.USER) {
                                HomePage hs = new HomePage(loginScreen, ws);
                            }
                            else {
                                AdminHomePage as = new AdminHomePage(loginScreen, ws);
                            }
                        }
                    }
                };
                worker.execute();
            }
        });
    }

    private void signUpEvent() {
        loginScreen.getSignUpButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                String userName = loginScreen.getSignUpUsernameTextField().getText();
                String password = loginScreen.getSignUpPasswordTextField().getText();
                String reEnterPassword = loginScreen.getSignUpReEnterPasswordTextField().getText();

                if (userName.isEmpty()) {
                    loginScreen.getSignUpMessageLabel().setText("Xin mời nhập tên tài khoản");
                    return;
                }

                if (password.isEmpty()) {
                    loginScreen.getSignUpMessageLabel().setText("Xin mời nhập mật khẩu");
                    return;
                }

                if (reEnterPassword.isEmpty()) {
                    loginScreen.getSignUpMessageLabel().setText("Xin mời nhập lại mật khẩu");
                    return;
                }

                if (!password.equals(reEnterPassword)) {
                    loginScreen.getSignUpMessageLabel().setText("Mật khẩu không khớp");
                    return;
                }

                if (!RegexChecker.checkValidUserName(userName)) {
                    loginScreen.getSignUpMessageLabel().setText("Tài khoản phải dài 8-20 (a-z, A-Z, 0-9). Không có kí tự _, . ở đầu/cuối");
                    return;
                }

                if (!RegexChecker.checkValidPassword(password)) {
                    loginScreen.getSignUpMessageLabel().setText("Mật khẩu ít nhất 8 kí tự, 1 in hoa, 1 in thường, 1 số.");
                    return;
                }
                password = encryptorService.hashing(password);
                userAccount = new UserAccount(userName, password);
                try {
                    if (!registerService.register(userAccount)) {
                        loginScreen.getSignUpMessageLabel().setText("Tài khoản đã tồn tại");
                    } else {
                        SignUpScreen su = new SignUpScreen(loginScreen);
                        su.setVisible(true);
                        loginScreen.setVisible(false);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Đăng kí không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void showPasswordEvent() {
        loginScreen.getLoginEyeLabel().addMouseListener(new MouseAdapter() {
            private boolean isVisible = false;

            @Override
            public void mouseClicked(MouseEvent evt) {
                isVisible = !isVisible;
                if (isVisible) {
                    loginScreen.getLoginEyeLabel().setIcon(IconFontSwing.buildIcon(FontAwesome.EYE, 23, Color.black));
                    loginScreen.getLoginPasswordTextField().setEchoChar((char) 0);
                } else {
                    loginScreen.getLoginEyeLabel().setIcon(IconFontSwing.buildIcon(FontAwesome.EYE_SLASH, 23, Color.black));
                    loginScreen.getLoginPasswordTextField().setEchoChar('•');
                }
            }
        });
        loginScreen.getLoginEyeLabel2().addMouseListener(new MouseAdapter() {
            private boolean isVisible = false;

            @Override
            public void mouseClicked(MouseEvent evt) {
                isVisible = !isVisible;
                if (isVisible) {
                    loginScreen.getLoginEyeLabel2().setIcon(IconFontSwing.buildIcon(FontAwesome.EYE, 23, Color.black));
                    loginScreen.getSignUpPasswordTextField().setEchoChar((char) 0);
                    loginScreen.getSignUpReEnterPasswordTextField().setEchoChar((char) 0);
                } else {
                    loginScreen.getLoginEyeLabel2().setIcon(IconFontSwing.buildIcon(FontAwesome.EYE_SLASH, 23, Color.black));
                    loginScreen.getSignUpPasswordTextField().setEchoChar('•');
                    loginScreen.getSignUpReEnterPasswordTextField().setEchoChar('•');
                }
            }
        });
    }
}

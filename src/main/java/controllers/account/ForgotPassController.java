package controllers.account;

import models.user.UserAccount;
import models.user.UserInfo;
import view.screens.account_screens.ChangePassSecondScreen;
import view.screens.account_screens.ForgotPassScreen;
import utils.RegexChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static commons.CurrentUser.*;

public class ForgotPassController {
    private JFrame previousFrame;
    private ForgotPassScreen forgotPassScreen;
    private String AnsCode = "";
    private int Count = 60;

    public ForgotPassController(JFrame jf, ForgotPassScreen forgotPassScreen) {
        this.previousFrame = jf;
        this.forgotPassScreen = forgotPassScreen;
        backEvent();
        getCodeEvent();
        confirmEvent();
    }

    private void backEvent() {
        forgotPassScreen.getForgotPassBack().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                previousFrame.setVisible(true);
                forgotPassScreen.setVisible(false);
            }
        });
    }

    private void getCodeEvent() {
        forgotPassScreen.getForgotPassGetCodeButton().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                String email = forgotPassScreen.getForgotPassEmailTextField().getText().trim();
                String username = forgotPassScreen.getForgotPassUsernameTextField().getText().trim();

                if (username.isEmpty()) {
                    forgotPassScreen.getForgotPassShowMessage().setText("Mời nhập tên tài khoản");
                    return;
                }
                if (email.isEmpty()) {
                    forgotPassScreen.getForgotPassShowMessage().setText("Mời nhập email");
                    return;
                }

                if (!RegexChecker.checkValidEmail(email)) {
                    forgotPassScreen.getForgotPassShowMessage().setText("Email không hợp lệ");
                    return;
                }

                UserAccount userAccount1 = null;
                try {
                    userAccount1 = userServices.getUserByUsername(username);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                if (userAccount1 == null) {
                    forgotPassScreen.getForgotPassShowMessage().setText("Không tìm thấy tài khoản");
                    return;
                } else {
                    UserInfo userInfo1 = null;
                    try {
                        userInfo1 = userServices.getUserInfoByUserAccount(userAccount1);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                    if (!userInfo1.getEmail().equals(email)) {
                        forgotPassScreen.getForgotPassShowMessage().setText("Email không trùng khớp");
                        return;
                    }
                }

                if (Count != 60) {
                    return;
                }

                try {
                    SwingWorker<Void, Void> worker = new SwingWorker<>() {
                        @Override
                        protected Void doInBackground() {
                            forgotPassScreen.getForgotPassWatingLabel().setText("Đang gửi...");
                            forgotPassScreen.getForgotPassWatingLabel().setForeground(Color.gray);
                            try {
                                AnsCode = forgetPasswordService.getCode(email);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Gửi không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                            }
                            return null;
                        }

                        @Override
                        protected void done() {
                            forgotPassScreen.getForgotPassWatingLabel().setText("Mã đã được gửi, vui lòng kiểm tra email");
                            forgotPassScreen.getForgotPassWatingLabel().setForeground(Color.gray);
                            waitToSendCode();
                        }
                    };

                    worker.execute();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi kết nối mạng! Vui lòng kiểm tra Internet.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void waitToSendCode() {
        Timer timer = new Timer(1000, e -> {
            if (Count > 0) {
                Count--;
                forgotPassScreen.getForgotPassWatingLabel().setText("Gửi lại trong: " + Count + "s");
            } else {
                ((Timer) e.getSource()).stop();
                Count = 60;
            }
        });
        timer.start();
    }

    private void confirmEvent() {
        forgotPassScreen.getForgotPassConfirmButton().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                String email = forgotPassScreen.getForgotPassEmailTextField().getText().trim();
                String username = forgotPassScreen.getForgotPassUsernameTextField().getText().trim();
                String code = forgotPassScreen.getForgotPassCodeTextField().getText().trim();


                if (username.isEmpty()) {
                    forgotPassScreen.getForgotPassShowMessage().setText("Mời nhập tên tài khoản");
                    return;
                }

                if (email.isEmpty()) {
                    forgotPassScreen.getForgotPassShowMessage().setText("Mời nhập email");
                    return;
                }

                if (code.isEmpty()) {
                    forgotPassScreen.getForgotPassShowMessage().setText("Mời nhập mã xác thực");
                    return;
                }

                if (AnsCode.equals(code)) {
                    try {
                        userAccount = userServices.getUserByUsername(username);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                    ChangePassSecondScreen changPassScreenSecond = new ChangePassSecondScreen(previousFrame);
                    changPassScreenSecond.setVisible(true);
                    forgotPassScreen.setVisible(false);
                } else {
                    forgotPassScreen.getForgotPassShowMessage().setText("Mã không hợp lệ");
                }


            }
        });
    }
}

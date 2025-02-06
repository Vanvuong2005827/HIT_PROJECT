package controllers.account;

import view.screens.account_screens.ChangePassScreen;
import view.screens.account_screens.ChangePassSecondScreen;
import view.screens.account_screens.ForgotPassScreen;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static commons.CurrentUser.*;
import static commons.CurrentUser.userAccount;

public class ChangePassController {
    private JFrame previousScreen;
    private ChangePassScreen changePassScreen;
    private ChangePassSecondScreen changePassScreenSecond;

    public ChangePassController(JFrame jf, ChangePassScreen changePassScreen) {
        this.previousScreen = jf;
        this.changePassScreen = changePassScreen;
        backEvent1();
        confirmEvent1();
        forgotPassEvent();
    }

    public ChangePassController(JFrame jf, ChangePassSecondScreen changePassScreenSecond) {
        this.previousScreen = jf;
        this.changePassScreenSecond = changePassScreenSecond;
        backEvent2();
        confirmEvent2();
    }

    private void backEvent1() {
        changePassScreen.getjLabel1().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                previousScreen.setVisible(true);
                changePassScreen.setVisible(false);
            }
        });
    }

    private void confirmEvent1() {
        changePassScreen.getChangePassConfirmButton().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                String oldPass = changePassScreen.getChangePassOldPassTextField().getText().trim();
                String newPass = changePassScreen.getChangePassNewPassTextField().getText().trim();
                String reEnterPass = changePassScreen.getChangePassReEnterPassTextField().getText().trim();

                if (oldPass.isEmpty()) {
                    changePassScreen.getChangePassShowMessageLabel().setText("Xin mời nhập mật khẩu cũ");
                    return;
                }
                if (newPass.isEmpty()) {
                    changePassScreen.getChangePassShowMessageLabel().setText("Xin mời nhập mật khẩu mới");
                    return;
                }

                if (reEnterPass.isEmpty()) {
                    changePassScreen.getChangePassShowMessageLabel().setText("Xin mời nhập lại mật khẩu mới");
                    return;
                }

                if (!newPass.equals(reEnterPass)) {
                    changePassScreen.getChangePassShowMessageLabel().setText("Mật khẩu nhập lại không khớp");
                    return;
                }

                if (!encryptorService.checkPassword(oldPass, userAccount.getPassword())) {
                    changePassScreen.getChangePassShowMessageLabel().setText("Mật khẩu cũ không khớp vui lòng nhập lại");
                } else {
                    try {
                        forgetPasswordService.ChangePassword(userAccount, reEnterPass);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Đổi không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                    previousScreen.setVisible(true);
                    changePassScreen.setVisible(false);

                }
            }
        });
    }

    private void forgotPassEvent() {
        changePassScreen.getChangePassForgotPassLabel().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ForgotPassScreen fg = new ForgotPassScreen(changePassScreen);
                fg.setVisible(true);
                changePassScreen.setVisible(false);
            }
        });
    }

    private void backEvent2() {
        changePassScreenSecond.getjLabel1().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                previousScreen.setVisible(true);
                changePassScreenSecond.setVisible(false);
            }
        });
    }

    private void confirmEvent2() {
        changePassScreenSecond.getChangePassConfirmButton().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                String newPass = changePassScreenSecond.getChangePassNewPassTextField().getText().trim();
                String reEnterPass = changePassScreenSecond.getChangePassReEnterPassTextField().getText().trim();

                if (newPass.isEmpty()) {
                    changePassScreenSecond.getChangePassShowMessageLabel().setText("Xin mời nhập mật khẩu mới");
                    return;
                }

                if (reEnterPass.isEmpty()) {
                    changePassScreenSecond.getChangePassShowMessageLabel().setText("Xin mời nhập lại mật khẩu mới");
                    return;
                }

                if (!newPass.equals(reEnterPass)) {
                    changePassScreenSecond.getChangePassShowMessageLabel().setText("Mật khẩu nhập lại không khớp");
                } else {
                    try {
                        forgetPasswordService.ChangePassword(userAccount, reEnterPass);
                        userAccount = null;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Đổi không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                    previousScreen.setVisible(true);
                    changePassScreenSecond.setVisible(false);

                }
            }
        });

    }
}

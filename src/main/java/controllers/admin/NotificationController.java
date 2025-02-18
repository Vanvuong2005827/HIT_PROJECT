package controllers.admin;

import models.user.UserInfo;
import view.admin_view.home_screens.NotificationScreen;
import view.user_view.screens.auth_screens.LoginScreen;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static commons.CurrentUser.userAccount;
import static commons.CurrentUser.userInfo;

public class NotificationController {
    private NotificationScreen notificationScreen;
    private LoginScreen loginScreen;
    private JFrame previousScreen;

    public NotificationController(NotificationScreen notificationScreen, LoginScreen loginScreen, JFrame previousScreen) {
        this.notificationScreen = notificationScreen;
        this.loginScreen = loginScreen;
        this.previousScreen = previousScreen;
        logOutEvent();
        cancelEvent();
        confirmEvent();
    }

    private void logOutEvent(){
        notificationScreen.getNotificationLogoutLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginScreen.setVisible(true);
                previousScreen.setVisible(false);
                userAccount = null;
                userInfo = new UserInfo();
            }
        });
    }

    private void cancelEvent(){
        notificationScreen.getNotificationCancelLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                notificationScreen.getNotificationTextArea().setText("");
            }
        });
    }

    private void  confirmEvent(){
        notificationScreen.getNotificationConfirmLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String message = notificationScreen.getNotificationTextArea().getText();
                if (message.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Xin mời nhập thông báo", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                notificationScreen.getNotificationTextArea().setText("");
                JOptionPane.showMessageDialog(null, "Thông báo đã được gửi đi", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}

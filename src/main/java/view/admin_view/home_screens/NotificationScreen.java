package view.admin_view.home_screens;

import controllers.admin.NotificationController;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import utils.Gradient;
import view.user_view.screens.auth_screens.LoginScreen;

import javax.swing.*;

import java.awt.*;

import static commons.ColorMain.*;
import static utils.NetworkChecker.curFrame;

public class NotificationScreen extends JFrame{
    public NotificationScreen(LoginScreen loginScreen, JFrame previousScreen) {
        initComponents();
        new NotificationController(this, loginScreen, previousScreen);
        curFrame = this;
    }

    private void initComponents() {

        notificationMainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        notificationLogoutLabel = new javax.swing.JLabel();
        notificationTextArea = new javax.swing.JTextArea();
        notificationCancelLabel = new javax.swing.JLabel();
        notificationConfirmLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        notificationMainPanel.setBackground(colorFix);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gửi thông báo");

        notificationLogoutLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        notificationLogoutLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notificationLogoutLabel.setText("Đăng xuất ");
        notificationLogoutLabel.setIcon(IconFontSwing.buildIcon(FontAwesome.SIGN_OUT, 18, Color.black));
        notificationLogoutLabel.setHorizontalTextPosition(SwingConstants.LEFT);

        notificationTextArea.setColumns(20);
        notificationTextArea.setRows(5);

        notificationCancelLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        notificationCancelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notificationCancelLabel.setText("Hủy");

        notificationConfirmLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        notificationConfirmLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notificationConfirmLabel.setText("Xác nhận gửi");

        javax.swing.GroupLayout notificationMainPanelLayout = new javax.swing.GroupLayout(notificationMainPanel);
        notificationMainPanel.setLayout(notificationMainPanelLayout);
        notificationMainPanelLayout.setHorizontalGroup(
                notificationMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(notificationMainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(notificationTextArea)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notificationMainPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(notificationLogoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88))
                        .addGroup(notificationMainPanelLayout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(notificationMainPanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(notificationCancelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addComponent(notificationConfirmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
        );
        notificationMainPanelLayout.setVerticalGroup(
                notificationMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(notificationMainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(notificationTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addGroup(notificationMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(notificationCancelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(notificationConfirmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addComponent(notificationLogoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(notificationMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(notificationMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel notificationCancelLabel;
    private javax.swing.JLabel notificationConfirmLabel;
    private javax.swing.JLabel notificationLogoutLabel;
    private javax.swing.JPanel notificationMainPanel;
    private javax.swing.JTextArea notificationTextArea;

    public JPanel getNotificationMainPanel() {
        return notificationMainPanel;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getNotificationCancelLabel() {
        return notificationCancelLabel;
    }

    public JLabel getNotificationConfirmLabel() {
        return notificationConfirmLabel;
    }

    public JLabel getNotificationLogoutLabel() {
        return notificationLogoutLabel;
    }

    public JTextArea getNotificationTextArea() {
        return notificationTextArea;
    }

    public void setNotificationConfirmLabel(String text) {
        this.notificationConfirmLabel.setText(text);
    }
}

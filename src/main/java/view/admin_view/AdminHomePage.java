package view.admin_view;

import view.WaitScreen;
import view.admin_view.home_screens.ListUserScreen;
import view.admin_view.home_screens.NotificationScreen;
import view.user_view.screens.auth_screens.LoginScreen;

import javax.swing.*;
import java.awt.*;

import static commons.ColorMain.colorMain3;
import static utils.NetworkChecker.curFrame;

public class AdminHomePage extends JFrame {
    private ListUserScreen listUserScreen = new ListUserScreen();
    private NotificationScreen notificationScreen;
    public AdminHomePage(LoginScreen loginScreen, WaitScreen waitScreen) {
        initComponents();
        setLocationRelativeTo(null);
        notificationScreen = new NotificationScreen(loginScreen, this);
        jTabbedPane1.addTab("Người dùng", listUserScreen.getListUserMainPanel());
        jTabbedPane1.addTab("Gửi thông báo", notificationScreen.getNotificationMainPanel());
        jTabbedPane1.setBackgroundAt(0, colorMain3);
        jTabbedPane1.setBackgroundAt(1, colorMain3);
        jTabbedPane1.setForegroundAt(0, Color.BLACK);
        jTabbedPane1.setForegroundAt(1, Color.BLACK);
        fixedTabbed();
        waitScreen.setVisible(false);
        this.setVisible(true);
        curFrame = this;
    }
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        pack();
    }

    private void fixedTabbed() {
        int tabWidth = 201;
        for (int i = 0; i < jTabbedPane1.getTabCount(); i++) {
            jTabbedPane1.setTabComponentAt(i, new JLabel(jTabbedPane1.getTitleAt(i)) {
                {
                    setPreferredSize(new Dimension(tabWidth, 30));
                    setHorizontalAlignment(SwingConstants.CENTER);
                }
            });
        }
    }

    private javax.swing.JTabbedPane jTabbedPane1;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package screens;

import java.awt.Color;

import screens.home_screen_pages.HomePage;
import screens.home_screen_pages.AccountPage;
import screens.home_screen_pages.FavouritePage;
import screens.home_screen_pages.RecentPage;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class HomeScreen extends javax.swing.JFrame {
    LoginScreen loginScreen;
    WaitScreen waitScreen;
    HomeScreen homeScreen = this;
    HomePage hp = new HomePage(this);
    RecentPage rp = new RecentPage(this);
    FavouritePage fp = new FavouritePage(this);
    AccountPage ap = new AccountPage(this);
    public HomeScreen(LoginScreen ls, WaitScreen ws) {
        loginScreen = ls;
        waitScreen = ws;
        initComponents();
        setLocationRelativeTo(null);
        processData();
        jTabbedPane1.addTab("Trang chủ", hp.homePanel());
        jTabbedPane1.addTab("Lịch sử", rp.recentPanel());
        jTabbedPane1.addTab("Yêu thích", fp.favouritePanel());
        jTabbedPane1.addTab("Tài khoản", ap.accountPanel());
        Color customColor = new Color(51, 204, 255);
        jTabbedPane1.setBackgroundAt(0, customColor);
        jTabbedPane1.setBackgroundAt(1, customColor);
        jTabbedPane1.setBackgroundAt(2, customColor);
        jTabbedPane1.setBackgroundAt(3, customColor);
        // Thay đổi màu chữ của các tab
        jTabbedPane1.setForegroundAt(0, Color.WHITE);
        jTabbedPane1.setForegroundAt(1, Color.WHITE);
        jTabbedPane1.setForegroundAt(2, Color.WHITE);
        jTabbedPane1.setForegroundAt(3, Color.WHITE);
        changeTab();
    }

    public void processData() {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                hp.processHomePageData();
                return null;
            }

            @Override
            protected void done() {
                homeScreen.setVisible(true);
                waitScreen.setVisible(false);
            }
        };

        worker.execute();
    }

    public void backToLogin() {
        loginScreen.setVisible(true);
        this.setVisible(false);
    }

    public void changeTab() {
        jTabbedPane1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = jTabbedPane1.getSelectedIndex();
                if (selectedIndex == 1){
                    SwingWorker<Void, Void> worker = new SwingWorker<>() {
                        @Override
                        protected Void doInBackground() {
//                            waitScreen.setVisible(true);
//                            homeScreen.setVisible(false);
                            rp.processRecentBook();
                            return null;
                        }

                        @Override
                        protected void done() {
//                            homeScreen.setVisible(true);
//                            waitScreen.setVisible(false);
                        }
                    };

                    worker.execute();
                }
                else if (selectedIndex == 2){
                 // Favourite
                }
            }
        });
    }

    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(176, 223, 251));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 800));

        pack();
    }

    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package screens;

import java.awt.Color;

import models.User.UserInfo;
import screens.home_screen_pages.HomePage;
import screens.home_screen_pages.AccountPage;
import screens.home_screen_pages.FavouritePage;
import screens.home_screen_pages.RecentPage;

import javax.swing.*;

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
        jTabbedPane1.setBackgroundAt(0, customColor); // Tab "Home" có nền đỏ
        jTabbedPane1.setBackgroundAt(1, customColor); // Tab "Recent" có nền xanh
        jTabbedPane1.setBackgroundAt(2, customColor);
        jTabbedPane1.setBackgroundAt(3, customColor);
        // Thay đổi màu chữ của các tab
        jTabbedPane1.setForegroundAt(0, Color.WHITE); // Màu chữ của tab "Home"
        jTabbedPane1.setForegroundAt(1, Color.WHITE); // Màu chữ của tab "Recent"
        jTabbedPane1.setForegroundAt(2, Color.WHITE);
        jTabbedPane1.setForegroundAt(3, Color.WHITE);

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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(176, 223, 251));

        jTabbedPane1.setBackground(new java.awt.Color(176, 223, 251));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>


    // Variables declaration - do not modify
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration
}

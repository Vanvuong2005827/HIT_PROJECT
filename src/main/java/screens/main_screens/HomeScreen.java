/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package screens.main_screens;

import java.awt.*;

import screens.home_screen_pages.HomePage;
import screens.home_screen_pages.AccountPage;
import screens.home_screen_pages.FavouritePage;
import screens.home_screen_pages.RecentPage;
import screens.login_screens.LoginScreen;
import screens.login_screens.SignUpScreen;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static commons.ColorMain.colorMain3;
import static commons.CurrentUser.*;

public class HomeScreen extends javax.swing.JFrame {
    private LoginScreen loginScreen;
    private WaitScreen waitScreen;
    private HomeScreen homeScreen = this;
    private HomePage hp = new HomePage(this);
    private RecentPage rp = new RecentPage(this);
    private FavouritePage fp = new FavouritePage(this);
    private AccountPage ap = new AccountPage(this);

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
        jTabbedPane1.setBackgroundAt(0, colorMain3);
        jTabbedPane1.setBackgroundAt(1, colorMain3);
        jTabbedPane1.setBackgroundAt(2, colorMain3);
        jTabbedPane1.setBackgroundAt(3, colorMain3);
        // Thay đổi màu chữ của các tab
        jTabbedPane1.setForegroundAt(0, Color.BLACK);
        jTabbedPane1.setForegroundAt(1, Color.BLACK);
        jTabbedPane1.setForegroundAt(2, Color.BLACK);
        jTabbedPane1.setForegroundAt(3, Color.BLACK);
        changeTab();

        int tabWidth = 88;
        for (int i = 0; i < jTabbedPane1.getTabCount(); i++) {
            jTabbedPane1.setTabComponentAt(i, new JLabel(jTabbedPane1.getTitleAt(i)) {
                {
                    setPreferredSize(new Dimension(tabWidth, 30));
                    setHorizontalAlignment(SwingConstants.CENTER);
                }
            });
        }
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
                if (userInfo.getFullName() == null){
                    int confirm = JOptionPane.showConfirmDialog(homeScreen, "Vui lòng điền thông tin cá nhân!", "Thông báo", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        SignUpScreen signUpScreen = new SignUpScreen(loginScreen);
                        signUpScreen.setVisible(true);
                        homeScreen.setVisible(false);
                    }
                    else{
                        backToLogin();
                    }
                }
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
                if (selectedIndex == 1) {
                    SwingWorker<Void, Void> worker = new SwingWorker<>() {
                        @Override
                        protected Void doInBackground() {
                            rp.processRecentBook();
                            return null;
                        }

                        @Override
                        protected void done() {
                        }
                    };

                    worker.execute();
                } else if (selectedIndex == 2) {
                    SwingWorker<Void, Void> worker = new SwingWorker<>() {
                        @Override
                        protected Void doInBackground() {
                            fp.processFavouriteBook();
                            return null;
                        }

                        @Override
                        protected void done() {
                        }
                    };
                    worker.execute();
                }
            }
        });
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jPanel1;
}

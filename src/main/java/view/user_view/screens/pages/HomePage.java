package view.user_view.screens.pages;

import view.user_view.screens.auth_screens.LoginScreen;
import view.user_view.screens.auth_screens.SignUpScreen;
import view.WaitScreen;
import view.user_view.screens.home_screens.*;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static commons.ColorMain.colorDefault;
import static commons.ColorMain.*;
import static commons.CurrentUser.*;
import static utils.NetworkChecker.curFrame;
import static utils.NetworkChecker.isConnected;

public class HomePage extends javax.swing.JFrame {
    private LoginScreen loginScreen;
    private WaitScreen waitScreen;
    private HomePage homeScreen = this;
    private HomeScreen hp = new HomeScreen(this);
    private RecentScreen rp = new RecentScreen(this);
    private FavouriteScreen fp = new FavouriteScreen(this);
    private AccountScreen ap = new AccountScreen(this);
    private ChatBotScreen cb = new ChatBotScreen();

    public HomePage(LoginScreen ls, WaitScreen ws) {
        loginScreen = ls;
        waitScreen = ws;
        initComponents();
        setLocationRelativeTo(null);
        processData();
        jTabbedPane1.addTab("Trang chủ", hp.homePanel());
        jTabbedPane1.addTab("Lịch sử", rp.recentPanel());
        jTabbedPane1.addTab("Yêu thích", fp.favouritePanel());
        jTabbedPane1.addTab("Chat Bot", cb.getChatPanel());
        jTabbedPane1.addTab("Tài khoản", ap.accountPanel());
        jTabbedPane1.setBackgroundAt(0, colorMain3);
        jTabbedPane1.setBackgroundAt(1, colorMain3);
        jTabbedPane1.setBackgroundAt(2, colorMain3);
        jTabbedPane1.setBackgroundAt(3, colorMain3);
        jTabbedPane1.setBackgroundAt(4, colorMain3);
        // Thay đổi màu chữ của các tab
        jTabbedPane1.setForegroundAt(0, Color.BLACK);
        jTabbedPane1.setForegroundAt(1, Color.BLACK);
        jTabbedPane1.setForegroundAt(2, Color.BLACK);
        jTabbedPane1.setForegroundAt(3, Color.BLACK);
        jTabbedPane1.setForegroundAt(4, Color.BLACK);
        changeTab();

        int tabWidth = 66;
        for (int i = 0; i < jTabbedPane1.getTabCount(); i++) {
            jTabbedPane1.setTabComponentAt(i, new JLabel(jTabbedPane1.getTitleAt(i)) {
                {
                    setPreferredSize(new Dimension(tabWidth, 30));
                    setHorizontalAlignment(SwingConstants.CENTER);
                }
            });
        }
        curFrame = this;
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
                if (!isConnected) {return;}
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
        colorMain1 = colorDefault;
        colorMain2 = colorDefault;
        colorMain3 = colorDefault;
        colorFix = colorDefault;
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
                            rp.getMainPanel().removeAll();
                            rp.getMainPanel().revalidate();
                            rp.getMainPanel().repaint();
                            rp.setCurPage(0);
                            rp.processRecentBook();
                            return null;
                        }

                        @Override
                        protected void done() {
                            if (!isConnected) {
                                rp.getMainPanel().removeAll();
                                rp.getMainPanel().repaint();
                                rp.getMainPanel().revalidate();
                            }
                        }
                    };

                    worker.execute();
                } else if (selectedIndex == 2) {
                    SwingWorker<Void, Void> worker = new SwingWorker<>() {
                        @Override
                        protected Void doInBackground() {
                            fp.getMainPanel().removeAll();
                            fp.getMainPanel().revalidate();
                            fp.getMainPanel().repaint();
                            fp.setCurPage(0);
                            fp.processFavouriteBook();
                            return null;
                        }

                        @Override
                        protected void done() {
                            if (!isConnected) {
                                fp.getMainPanel().removeAll();
                                fp.getMainPanel().repaint();
                                fp.getMainPanel().revalidate();
                            }
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

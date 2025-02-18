package view.admin_view;

import view.WaitScreen;
import view.user_view.screens.auth_screens.LoginScreen;

import javax.swing.*;
import java.awt.*;

public class AdminHomePage extends JFrame {
    private WaitScreen waitScreen;
    private LoginScreen loginScreen;
    public AdminHomePage(LoginScreen loginScreen, WaitScreen waitScreen) {
        this.loginScreen = loginScreen;
        this.waitScreen = waitScreen;
        initComponents();
        fixedTabbed();
        waitScreen.setVisible(false);
        this.setVisible(true);
    }
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

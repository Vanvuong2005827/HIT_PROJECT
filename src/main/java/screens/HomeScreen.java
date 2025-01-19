/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package screens;

import java.awt.Color;
import screens.pages.HomePage;
import javax.swing.JPanel;
import screens.pages.AccountPage;
import screens.pages.FavouritePage;
import screens.pages.RecentPage;

public class HomeScreen extends javax.swing.JFrame {

    public HomeScreen() {
        initComponents();
        setLocationRelativeTo(null);
        HomePage hp = new HomePage();
        RecentPage rp = new RecentPage();
        FavouritePage fp = new FavouritePage();
        AccountPage ap = new AccountPage();
        jTabbedPane1.addTab("Home", hp.homePanel());
        jTabbedPane1.addTab("Recent", rp.recentPanel());
        jTabbedPane1.addTab("Favourite", fp.recentPanel());
        jTabbedPane1.addTab("Profile", ap.recentPanel());
        Color customColor = new Color(51,204,255);
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


    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
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
    }// </editor-fold>


    // Variables declaration - do not modify
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration
}

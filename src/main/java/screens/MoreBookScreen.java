package screens;

import screens.more_book_pages.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MoreBookScreen extends javax.swing.JFrame {
    HomeScreen homeScreen;
    public MoreBookScreen(HomeScreen hs, int indexTabbed) {
        homeScreen = hs;
        initComponents();
        setLocationRelativeTo(null);
        NewBookPage np = new NewBookPage(this);
        CommingSoonBookPage cp = new CommingSoonBookPage();
        ReleaseBookPage rp = new ReleaseBookPage();
        CompletedBookPage cdp = new CompletedBookPage();
        StyleBookPage sp = new StyleBookPage();

        jTabbedPane1.addTab("Truyện mới", np.newBookPanel());
        jTabbedPane1.addTab("Sắp ra mắt", cp.commingSoonBookPanel());
        jTabbedPane1.addTab("Đang phát hành", rp.releaseBookPanel());
        jTabbedPane1.addTab("Hoàn thành", cdp.completedBookPanel());
        jTabbedPane1.addTab("Thể loại", sp.styleBookPanel());
        Color customColor = new Color(51,204,255);
        jTabbedPane1.setBackgroundAt(0, customColor);
        jTabbedPane1.setBackgroundAt(1, customColor);
        jTabbedPane1.setBackgroundAt(2, customColor);
        jTabbedPane1.setBackgroundAt(3, customColor);
        jTabbedPane1.setBackgroundAt(4, customColor);
        // Thay đổi màu chữ của các tab
        jTabbedPane1.setForegroundAt(0, Color.WHITE);
        jTabbedPane1.setForegroundAt(1, Color.WHITE);
        jTabbedPane1.setForegroundAt(2, Color.WHITE);
        jTabbedPane1.setForegroundAt(3, Color.WHITE);
        jTabbedPane1.setForegroundAt(4, Color.WHITE);

        jTabbedPane1.setSelectedIndex(indexTabbed);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainPanel.setBackground(new java.awt.Color(176, 223, 251));

        jTabbedPane1.setBackground(new java.awt.Color(176, 223, 251));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("  <");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backEvent(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 387, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    public void backEvent(java.awt.event.MouseEvent evt){
        homeScreen.setVisible(true);
        this.setVisible(false);
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration
}

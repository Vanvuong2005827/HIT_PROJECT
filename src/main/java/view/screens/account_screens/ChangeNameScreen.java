package view.screens.account_screens;

import controllers.account.ChangeNameController;

import javax.swing.*;
import java.io.File;

import static commons.ColorMain.colorFix;
import static utils.NetworkChecker.curFrame;

public class ChangeNameScreen extends javax.swing.JFrame {
    private JLabel label;
    private String basePath = new File("").getAbsolutePath();

    public ChangeNameScreen(JLabel l) {
        label = l;
        initComponents();
        setLocationRelativeTo(null);
        new ChangeNameController(this, label);
        curFrame = this;
    }

    private void initComponents() {
        changeNameMainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        changeNameMainPanel.setBackground(colorFix);
        changeNameMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(basePath + "\\src\\main\\java\\assets\\output-onlinegiftools.gif"));
        changeNameMainPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, -1, 120));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bạn muốn đổi tên ?");
        changeNameMainPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 170, 30));
        changeNameMainPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 80, 210));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel4.setText("Tên mới:");
        changeNameMainPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 80, -1));

        jTextField1.setBackground(colorFix);
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jTextField1.setBorder(null);
        changeNameMainPanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 260, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Hủy");
        changeNameMainPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 120, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Xác nhận");
        changeNameMainPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(changeNameMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(changeNameMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel changeNameMainPanel;

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }
}

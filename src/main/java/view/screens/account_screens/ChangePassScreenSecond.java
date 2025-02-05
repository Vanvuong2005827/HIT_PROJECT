package view.screens.account_screens;

import controllers.ChangePassController;
import utils.Gradient;

import javax.swing.*;
import java.io.File;

import static commons.ColorMain.*;

public class ChangePassScreenSecond extends javax.swing.JFrame {
    private JFrame previousFrame;
    private String basePath = new File("").getAbsolutePath();

    public ChangePassScreenSecond(JFrame jf) {
        previousFrame = jf;
        initComponents();
        setLocationRelativeTo(null);
        new ChangePassController(previousFrame, this);
    }

    private void initComponents() {
        changPassPanel = new Gradient(colorMain1, colorMain2, colorMain3);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        changePassNewPassLabel = new javax.swing.JLabel();
        changePassReEnterPassLabel = new javax.swing.JLabel();
        changePassNewPassTextField = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        changePassReEnterPassTextField = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        changePassConfirmButton = new javax.swing.JButton();
        changePassShowMessageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setText("<");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel2.setText("Đổi mật khẩu");

        jLabel3.setIcon(new javax.swing.ImageIcon(basePath + "\\src\\main\\java\\assets\\wind-mill-6875_256.gif"));

        changePassNewPassLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        changePassNewPassLabel.setText("Mật khẩu mới: ");

        changePassReEnterPassLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        changePassReEnterPassLabel.setText("Nhập lại mật khẩu:");

        changePassNewPassTextField.setBackground(colorFix);
        changePassNewPassTextField.setBorder(null);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(204, 204, 204));

        changePassReEnterPassTextField.setBackground(colorFix);
        changePassReEnterPassTextField.setBorder(null);

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(204, 204, 204));

        changePassConfirmButton.setBackground(colorFix);
        changePassConfirmButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        changePassConfirmButton.setText("Xác nhận");
        changePassConfirmButton.setBorder(null);
        changePassShowMessageLabel.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout changPassPanelLayout = new javax.swing.GroupLayout(changPassPanel);
        changPassPanel.setLayout(changPassPanelLayout);
        changPassPanelLayout.setHorizontalGroup(
                changPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(changPassPanelLayout.createSequentialGroup()
                                .addGroup(changPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(changPassPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(134, 134, 134)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(changPassPanelLayout.createSequentialGroup()
                                                .addGap(94, 94, 94)
                                                .addGroup(changPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(changePassShowMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(changPassPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(changPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(changPassPanelLayout.createSequentialGroup()
                                                                .addGap(142, 142, 142)
                                                                .addGroup(changPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jTextField3)
                                                                        .addComponent(changePassNewPassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(changPassPanelLayout.createSequentialGroup()
                                                                .addGroup(changPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(changePassNewPassLabel)
                                                                        .addComponent(changePassReEnterPassLabel))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(changPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jTextField4)
                                                                        .addComponent(changePassReEnterPassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(changPassPanelLayout.createSequentialGroup()
                                                .addGap(93, 93, 93)
                                                .addComponent(changePassConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        changPassPanelLayout.setVerticalGroup(
                changPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(changPassPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(changPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(57, 57, 57)
                                .addComponent(jLabel3)
                                .addGap(32, 32, 32)
                                .addComponent(changePassShowMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(changPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(changePassNewPassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(changePassNewPassLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(changPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(changePassReEnterPassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(changePassReEnterPassLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(changePassConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(314, 314, 314))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(changPassPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(changPassPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private javax.swing.JPanel changPassPanel;
    private javax.swing.JButton changePassConfirmButton;
    private javax.swing.JLabel changePassNewPassLabel;
    private javax.swing.JTextField changePassNewPassTextField;
    private javax.swing.JLabel changePassReEnterPassLabel;
    private javax.swing.JTextField changePassReEnterPassTextField;
    private javax.swing.JLabel changePassShowMessageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JTextField getChangePassReEnterPassTextField() {
        return changePassReEnterPassTextField;
    }

    public JTextField getChangePassNewPassTextField() {
        return changePassNewPassTextField;
    }

    public JButton getChangePassConfirmButton() {
        return changePassConfirmButton;
    }

    public JLabel getChangePassShowMessageLabel() {
        return changePassShowMessageLabel;
    }
}

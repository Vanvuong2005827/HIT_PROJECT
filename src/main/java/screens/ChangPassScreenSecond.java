package screens;

import javax.swing.*;
import java.io.File;

import static commons.CurrentUser.forgetPasswordService;
import static commons.CurrentUser.userAccount;

public class ChangPassScreenSecond extends javax.swing.JFrame {
    JFrame previousFrame;
    private String basePath = new File("").getAbsolutePath();

    public ChangPassScreenSecond(JFrame jf) {
        previousFrame = jf;
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        changPassPanel = new javax.swing.JPanel();
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

        changPassPanel.setBackground(new java.awt.Color(176, 223, 251));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("<");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backEvent(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Đổi mật khẩu");

        jLabel3.setIcon(new javax.swing.ImageIcon(basePath + "\\src\\main\\java\\assets\\wind-mill-6875_256.gif")); // NOI18N

        changePassNewPassLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        changePassNewPassLabel.setText("Mật khẩu mới: ");

        changePassReEnterPassLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        changePassReEnterPassLabel.setText("Nhập lại mật khẩu:");

        changePassNewPassTextField.setBackground(new java.awt.Color(176, 223, 251));
        changePassNewPassTextField.setBorder(null);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(204, 204, 204));

        changePassReEnterPassTextField.setBackground(new java.awt.Color(176, 223, 251));
        changePassReEnterPassTextField.setBorder(null);

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(204, 204, 204));

        changePassConfirmButton.setBackground(new java.awt.Color(204, 255, 204));
        changePassConfirmButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        changePassConfirmButton.setText("Confirm");
        changePassConfirmButton.setBorder(null);
        changePassConfirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmEvent(evt);
            }
        });

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

    private void backEvent(java.awt.event.MouseEvent evt) {
        previousFrame.setVisible(true);
        this.setVisible(false);
    }

    private void confirmEvent(java.awt.event.MouseEvent evt) {
        String newPass = changePassNewPassTextField.getText().trim();
        String reEnterPass = changePassReEnterPassTextField.getText().trim();

        if (newPass.isEmpty()){
            changePassShowMessageLabel.setText("Xin mời nhập mật khẩu mới");
            return;
        }

        if (reEnterPass.isEmpty()){
            changePassShowMessageLabel.setText("Xin mời nhập lại mật khẩu mới");
            return;
        }

        if (!newPass.equals(reEnterPass)){
            changePassShowMessageLabel.setText("Mật khẩu nhập lại không khớp");
            return;
        } else {
            forgetPasswordService.ChangePassword(userAccount.getUsername(), reEnterPass);
            userAccount = null;
            previousFrame.setVisible(true);
            this.setVisible(false);
            JOptionPane.showMessageDialog(this, "Đổi Mật Khẩu Thành Công!");
        }

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
}

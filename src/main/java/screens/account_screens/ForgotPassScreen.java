package screens.account_screens;

import utils.CheckRegex;
import models.User.UserAccount;
import models.User.UserInfo;
import utils.get_color.Gradient;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import static commons.ColorMain.*;
import static commons.CurrentUser.*;

public class ForgotPassScreen extends javax.swing.JFrame {
    private String AnsCode = "";
    private String basePath = new File("").getAbsolutePath();
    private JFrame previousFrame;

    public ForgotPassScreen(JFrame jf) {
        previousFrame = jf;
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        forgorPassMainPanel = new Gradient(colorMain1, colorMain2, colorMain3);
        forgotPassBack = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        forgotPassEmailLabel = new javax.swing.JLabel();
        forgotPassEmailTextField = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        forgotPassCodeLabel = new javax.swing.JLabel();
        forgotPassCodeTextField = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        forgotPassGetCodeButton = new javax.swing.JButton();
        forgotPassShowMessage = new javax.swing.JLabel();
        forgotPassUsernameLabel = new javax.swing.JLabel();
        forgotPassUsernameTextField = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        forgotPassConfirmButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        forgotPassWatingLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        forgotPassBack.setFont(new java.awt.Font("Segoe UI", 1, 24));
        forgotPassBack.setText("<");
        forgotPassBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backEvent(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Quên mật khẩu");

        forgotPassEmailLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        forgotPassEmailLabel.setText("Email liên kết:");

        forgotPassEmailTextField.setBackground(colorFix);
        forgotPassEmailTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        forgotPassEmailTextField.setBorder(null);

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));

        forgotPassCodeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        forgotPassCodeLabel.setText("Mã xác thực:");

        forgotPassCodeTextField.setBackground(colorFix);
        forgotPassCodeTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        forgotPassCodeTextField.setBorder(null);

        jTextField4.setBackground(new java.awt.Color(204, 204, 204));

        forgotPassGetCodeButton.setBackground(new java.awt.Color(204, 255, 204));
        forgotPassGetCodeButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        forgotPassGetCodeButton.setText("Lấy mã");
        forgotPassGetCodeButton.setBorder(null);
        forgotPassGetCodeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getCodeEvent(evt);
            }
        });

        forgotPassShowMessage.setForeground(new java.awt.Color(255, 0, 51));

        forgotPassUsernameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        forgotPassUsernameLabel.setText("Tài khoản");

        forgotPassUsernameTextField.setBackground(colorFix);
        forgotPassUsernameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        forgotPassUsernameTextField.setBorder(null);

        jTextField3.setBackground(new java.awt.Color(204, 204, 204));

        forgotPassConfirmButton.setBackground(colorFix);
        forgotPassConfirmButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        forgotPassConfirmButton.setText("Xác nhận");
        forgotPassConfirmButton.setBorder(null);
        forgotPassConfirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmEvent(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(basePath + "\\src\\main\\java\\assets\\christmas-tree-15498_256.gif"));

        javax.swing.GroupLayout forgorPassMainPanelLayout = new javax.swing.GroupLayout(forgorPassMainPanel);
        forgorPassMainPanel.setLayout(forgorPassMainPanelLayout);
        forgorPassMainPanelLayout.setHorizontalGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(forgorPassMainPanelLayout.createSequentialGroup().addContainerGap().addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(forgorPassMainPanelLayout.createSequentialGroup().addComponent(forgotPassBack, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(128, 128, 128).addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)).addGroup(forgorPassMainPanelLayout.createSequentialGroup().addComponent(forgotPassEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTextField2).addComponent(forgotPassEmailTextField))).addGroup(forgorPassMainPanelLayout.createSequentialGroup().addComponent(forgotPassCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(forgorPassMainPanelLayout.createSequentialGroup().addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(forgotPassCodeTextField, javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)).addGap(18, 18, 18).addComponent(forgotPassGetCodeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGroup(forgorPassMainPanelLayout.createSequentialGroup().addComponent(forgotPassConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)).addComponent(forgotPassWatingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))).addGroup(forgorPassMainPanelLayout.createSequentialGroup().addComponent(forgotPassUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTextField3).addComponent(forgotPassUsernameTextField).addGroup(forgorPassMainPanelLayout.createSequentialGroup().addComponent(forgotPassShowMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 22, Short.MAX_VALUE))))).addContainerGap()).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forgorPassMainPanelLayout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel2).addGap(133, 133, 133)));
        forgorPassMainPanelLayout.setVerticalGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(forgorPassMainPanelLayout.createSequentialGroup().addContainerGap().addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(forgotPassBack, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE).addGap(18, 18, 18).addComponent(forgotPassShowMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(forgotPassUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(forgotPassUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(forgotPassGetCodeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(forgorPassMainPanelLayout.createSequentialGroup().addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(forgotPassEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(forgotPassEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(forgorPassMainPanelLayout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(forgotPassCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(forgotPassCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forgorPassMainPanelLayout.createSequentialGroup().addGap(41, 41, 41).addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(forgotPassWatingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(47, 47, 47).addComponent(forgotPassConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(228, 228, 228)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(forgorPassMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(forgorPassMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }

    private void backEvent(java.awt.event.MouseEvent evt) {
        previousFrame.setVisible(true);
        this.setVisible(false);
    }

    private void getCodeEvent(java.awt.event.MouseEvent evt) {
        String email = forgotPassEmailTextField.getText().trim();
        String username = forgotPassUsernameTextField.getText().trim();

        if (username.isEmpty()) {
            forgotPassShowMessage.setText("Mời nhập tên tài khoản");
            return;
        }
        if (email.isEmpty()) {
            forgotPassShowMessage.setText("Mời nhập email");
            return;
        }

        if (!CheckRegex.checkValidEmail(email)) {
            forgotPassShowMessage.setText("Email không hợp lệ");
            return;
        }

        UserAccount userAccount1 = userServices.getUserByUsername(username);
        if (userAccount1 == null) {
            forgotPassShowMessage.setText("Không tìm thấy tài khoản");
            return;
        } else {
            UserInfo userInfo1 = userServices.getUserInfoByUserAccount(userAccount1);
            if (!userInfo1.getEmail().equals(email)) {
                forgotPassShowMessage.setText("Email không trùng khớp");
                return;
            }
        }

        if (Count != 60) {
            return;
        }

        try {
            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() {
                    forgotPassWatingLabel.setText("Đang gửi...");
                    forgotPassWatingLabel.setForeground(Color.gray);
                    AnsCode = forgetPasswordService.getCode(email);
                    return null;
                }

                @Override
                protected void done() {
                    forgotPassWatingLabel.setText("Mã đã được gửi, vui lòng kiểm tra email");
                    forgotPassWatingLabel.setForeground(Color.gray);
                    waitToSendCode();
                }
            };

            worker.execute();
        } catch (Exception e) {
            e.printStackTrace();
            forgotPassShowMessage.setText("An error occurred while generating ans code");
        }
    }

    private void waitToSendCode() {
        Timer timer = new Timer(1000, e -> {
            if (Count > 0) {
                Count--;
                forgotPassWatingLabel.setText("Gửi lại trong: " + Count + "s");
            } else {
                ((Timer) e.getSource()).stop();
                Count = 60;
            }
        });
        timer.start();
    }

    private void confirmEvent(java.awt.event.MouseEvent evt) {
        String email = forgotPassEmailTextField.getText().trim();
        String username = forgotPassUsernameTextField.getText().trim();
        String code = forgotPassCodeTextField.getText().trim();


        if (username.isEmpty()) {
            forgotPassShowMessage.setText("Mời nhập tên tài khoản");
            return;
        }

        if (email.isEmpty()) {
            forgotPassShowMessage.setText("Mời nhập email");
            return;
        }

        if (code.isEmpty()) {
            forgotPassShowMessage.setText("Mời nhập mã xác thực");
            return;
        }

        if (AnsCode.equals(code)) {
            userAccount = userServices.getUserByUsername(username);
            ChangPassScreenSecond changPassScreenSecond = new ChangPassScreenSecond(previousFrame);
            changPassScreenSecond.setVisible(true);
            this.setVisible(false);
        } else {
            forgotPassShowMessage.setText("Mã không hợp lệ");
        }


    }

    private javax.swing.JPanel forgorPassMainPanel;
    private javax.swing.JLabel forgotPassBack;
    private javax.swing.JLabel forgotPassCodeLabel;
    private javax.swing.JTextField forgotPassCodeTextField;
    private javax.swing.JButton forgotPassConfirmButton;
    private javax.swing.JLabel forgotPassEmailLabel;
    private javax.swing.JTextField forgotPassEmailTextField;
    private javax.swing.JButton forgotPassGetCodeButton;
    private javax.swing.JLabel forgotPassShowMessage;
    private javax.swing.JLabel forgotPassUsernameLabel;
    private javax.swing.JTextField forgotPassUsernameTextField;
    private javax.swing.JLabel forgotPassWatingLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private int Count = 60;
}

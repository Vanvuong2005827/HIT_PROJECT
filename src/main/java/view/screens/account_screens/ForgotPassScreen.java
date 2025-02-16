package view.screens.account_screens;

import controllers.account.ForgotPassController;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import utils.Gradient;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import static commons.ColorMain.*;
import static utils.NetworkChecker.curFrame;

public class ForgotPassScreen extends javax.swing.JFrame {
    private String basePath = new File("").getAbsolutePath();
    private JFrame previousFrame;

    public ForgotPassScreen(JFrame jf) {
        previousFrame = jf;
        initComponents();
        setLocationRelativeTo(null);
        new ForgotPassController(previousFrame, this);
        curFrame = this;
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setText("Quên mật khẩu");

        forgotPassEmailLabel.setText("     ");
        forgotPassEmailLabel.setIcon(IconFontSwing.buildIcon(FontAwesome.ENVELOPE, 23, Color.black));
        forgotPassEmailLabel.setHorizontalTextPosition(SwingConstants.LEFT);

        forgotPassEmailTextField.setBackground(colorMain2);
        forgotPassEmailTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        forgotPassEmailTextField.setBorder(null);

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));

        forgotPassCodeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14));
        forgotPassCodeLabel.setText("Mã xác thực:");

        forgotPassCodeTextField.setBackground(colorMain2);
        forgotPassCodeTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        forgotPassCodeTextField.setBorder(null);

        jTextField4.setBackground(new java.awt.Color(204, 204, 204));

        forgotPassGetCodeButton.setBackground(new java.awt.Color(204, 255, 204));
        forgotPassGetCodeButton.setFont(new java.awt.Font("Segoe UI", 1, 14));
        forgotPassGetCodeButton.setText("Lấy mã");
        forgotPassGetCodeButton.setBorder(null);

        forgotPassShowMessage.setForeground(new java.awt.Color(255, 0, 51));

        forgotPassUsernameLabel.setText("     ");
        forgotPassUsernameLabel.setIcon(IconFontSwing.buildIcon(FontAwesome.USER_CIRCLE_O, 23, Color.black));
        forgotPassUsernameLabel.setHorizontalTextPosition(SwingConstants.LEFT);

        forgotPassUsernameTextField.setBackground(colorMain2);
        forgotPassUsernameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        forgotPassUsernameTextField.setBorder(null);

        jTextField3.setBackground(new java.awt.Color(204, 204, 204));

        forgotPassConfirmButton.setBackground(colorFix);
        forgotPassConfirmButton.setFont(new java.awt.Font("Segoe UI", 1, 16));
        forgotPassConfirmButton.setText("Xác nhận ");
        forgotPassConfirmButton.setBorder(null);
        forgotPassConfirmButton.setIcon(IconFontSwing.buildIcon(FontAwesome.CHECK, 23, Color.black));
        forgotPassConfirmButton.setHorizontalTextPosition(SwingConstants.LEFT);

        jLabel2.setIcon(new javax.swing.ImageIcon(basePath + "\\src\\main\\java\\assets\\christmas-tree-15498_256.gif"));

        javax.swing.GroupLayout forgorPassMainPanelLayout = new javax.swing.GroupLayout(forgorPassMainPanel);
        forgorPassMainPanel.setLayout(forgorPassMainPanelLayout);
        forgorPassMainPanelLayout.setHorizontalGroup(
                forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                .addComponent(forgotPassBack, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(128, 128, 128)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                .addComponent(forgotPassEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField2)
                                                        .addComponent(forgotPassEmailTextField)))
                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                .addComponent(forgotPassCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(forgotPassCodeTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(forgotPassGetCodeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                                .addComponent(forgotPassConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(forgotPassWatingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                .addComponent(forgotPassUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField3)
                                                        .addComponent(forgotPassUsernameTextField)
                                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                                .addComponent(forgotPassShowMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 22, Short.MAX_VALUE)))))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forgorPassMainPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(133, 133, 133))
        );
        forgorPassMainPanelLayout.setVerticalGroup(
                forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(forgotPassBack, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(forgotPassShowMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(forgotPassUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(forgotPassUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(forgotPassGetCodeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(forgotPassEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(forgotPassEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(forgorPassMainPanelLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(forgorPassMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(forgotPassCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(forgotPassCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, forgorPassMainPanelLayout.createSequentialGroup()
                                                                .addGap(41, 41, 41)
                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(forgotPassWatingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(forgotPassConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(228, 228, 228))
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(forgorPassMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(forgorPassMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
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

    public JLabel getForgotPassBack() {
        return forgotPassBack;
    }

    public JTextField getForgotPassCodeTextField() {
        return forgotPassCodeTextField;
    }

    public JButton getForgotPassConfirmButton() {
        return forgotPassConfirmButton;
    }

    public JTextField getForgotPassEmailTextField() {
        return forgotPassEmailTextField;
    }

    public JButton getForgotPassGetCodeButton() {
        return forgotPassGetCodeButton;
    }

    public JLabel getForgotPassShowMessage() {
        return forgotPassShowMessage;
    }

    public JTextField getForgotPassUsernameTextField() {
        return forgotPassUsernameTextField;
    }

    public JLabel getForgotPassWatingLabel() {
        return forgotPassWatingLabel;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }


}

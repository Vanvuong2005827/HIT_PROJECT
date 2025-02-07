package view.screens.auth_screens;

import controllers.account.SignUpController;
import utils.Gradient;

import javax.swing.*;
import java.io.File;

import static commons.ColorMain.*;
import static utils.NetworkChecker.curFrame;

public class SignUpScreen extends javax.swing.JFrame {
    private String basePath = new File("").getAbsolutePath();
    private JFrame loginScreen;

    public SignUpScreen(JFrame l) {
        loginScreen = l;
        initComponents();
        setLocationRelativeTo(null);
        new SignUpController(this);
        curFrame = this;
    }

    private void initComponents() {
        signUpMainPanel = new Gradient(colorMain1, colorMain2, colorMain3);
        signUpGif = new javax.swing.JLabel();
        signUpBackButton = new javax.swing.JButton();
        signUpFullNameLabel = new javax.swing.JLabel();
        signUpHeaderLabel = new javax.swing.JLabel();
        signUpBornYearLabel = new javax.swing.JLabel();
        signUpGenderLabel = new javax.swing.JLabel();
        signUpPhoneNumberLabel = new javax.swing.JLabel();
        signUpGamailLabel = new javax.swing.JLabel();
        signUpLine1 = new javax.swing.JTextField();
        signUpFullNameTextField = new javax.swing.JTextField();
        signUpLine2 = new javax.swing.JTextField();
        signUpLine3 = new javax.swing.JTextField();
        signUpGmailTextField = new javax.swing.JTextField();
        signUpPhoneNumberTextField = new javax.swing.JTextField();
        signUpYearOfBirth = new javax.swing.JComboBox<>();
        signUpMaleCheckBox = new javax.swing.JCheckBox();
        signUpFemaleCheckBox = new javax.swing.JCheckBox();
        signUpAge = new javax.swing.JLabel();
        signUpConfirmButton = new javax.swing.JButton();
        signUpOtherCheckBox = new javax.swing.JCheckBox();
        signUpMessageLabel = new javax.swing.JLabel();
        signUpGamailCodeLabel = new javax.swing.JLabel();
        signUpGmailCodeTextField = new javax.swing.JTextField();
        signUpLine4 = new javax.swing.JTextField();
        signUpButtonSendCode = new javax.swing.JButton();
        signUpSendingLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        signUpGif.setIcon(new javax.swing.ImageIcon(basePath + "\\src\\main\\java\\assets\\angry-2498_256.gif"));

        signUpBackButton.setBackground(colorMain1);
        signUpBackButton.setFont(new java.awt.Font("Segoe UI", 1, 24));
        signUpBackButton.setText("<");
        signUpBackButton.setBorder(null);

        signUpFullNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 16));
        signUpFullNameLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpFullNameLabel.setText("Họ tên :");

        signUpHeaderLabel.setFont(new java.awt.Font("Segoe UI", 1, 20));
        signUpHeaderLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpHeaderLabel.setText("Thông tin tài khoản");

        signUpBornYearLabel.setFont(new java.awt.Font("Segoe UI", 1, 16));
        signUpBornYearLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpBornYearLabel.setText("Năm sinh :");

        signUpGenderLabel.setFont(new java.awt.Font("Segoe UI", 1, 16));
        signUpGenderLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpGenderLabel.setText("Giới tính :");

        signUpPhoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 16));
        signUpPhoneNumberLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpPhoneNumberLabel.setText("Số điện thoại :");

        signUpGamailLabel.setFont(new java.awt.Font("Segoe UI", 1, 16));
        signUpGamailLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpGamailLabel.setText("Gmail : ");

        signUpLine1.setForeground(new java.awt.Color(102, 102, 102));
        signUpLine1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        signUpFullNameTextField.setBackground(colorMain2);
        signUpFullNameTextField.setBorder(null);

        signUpLine2.setForeground(new java.awt.Color(102, 102, 102));
        signUpLine2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        signUpLine3.setForeground(new java.awt.Color(102, 102, 102));
        signUpLine3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        signUpGmailTextField.setBackground(colorMain2);
        signUpGmailTextField.setBorder(null);

        signUpPhoneNumberTextField.setBackground(colorMain2);
        signUpPhoneNumberTextField.setBorder(null);

        signUpYearOfBirth.setBackground(colorMain2);
        signUpYearOfBirth.setMaximumRowCount(30);
        signUpYearOfBirth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"0", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012"}));
        signUpYearOfBirth.setBorder(null);

        signUpMaleCheckBox.setBackground(colorMain2);
        signUpMaleCheckBox.setForeground(new java.awt.Color(102, 102, 102));
        signUpMaleCheckBox.setText("Nam");
        signUpMaleCheckBox.setBorder(null);

        signUpFemaleCheckBox.setBackground(colorMain2);
        signUpFemaleCheckBox.setForeground(new java.awt.Color(102, 102, 102));
        signUpFemaleCheckBox.setText("Nữ");
        signUpFemaleCheckBox.setBorder(null);

        signUpConfirmButton.setBackground(colorFix);
        signUpConfirmButton.setFont(new java.awt.Font("Segoe UI", 1, 24));
        signUpConfirmButton.setForeground(new java.awt.Color(102, 102, 102));
        signUpConfirmButton.setText("Xác nhận");
        signUpConfirmButton.setBorder(null);

        signUpOtherCheckBox.setBackground(colorMain2);
        signUpOtherCheckBox.setForeground(new java.awt.Color(102, 102, 102));
        signUpOtherCheckBox.setText("Khác");
        signUpOtherCheckBox.setBorder(null);

        signUpMessageLabel.setForeground(new java.awt.Color(255, 51, 51));

        signUpGamailCodeLabel.setFont(new java.awt.Font("Segoe UI", 1, 16));
        signUpGamailCodeLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpGamailCodeLabel.setText("Mã xác thực:");

        signUpGmailCodeTextField.setBackground(colorFix);
        signUpGmailCodeTextField.setBorder(null);

        signUpLine4.setBackground(new java.awt.Color(102, 102, 102));
        signUpLine4.setForeground(new java.awt.Color(102, 102, 102));
        signUpLine4.setBorder(null);

        signUpButtonSendCode.setBackground(new java.awt.Color(204, 255, 204));
        signUpButtonSendCode.setFont(new java.awt.Font("Segoe UI", 1, 14));
        signUpButtonSendCode.setText("Lấy mã");
        signUpButtonSendCode.setBorder(null);

        javax.swing.GroupLayout signUpMainPanelLayout = new javax.swing.GroupLayout(signUpMainPanel);
        signUpMainPanel.setLayout(signUpMainPanelLayout);
        signUpMainPanelLayout.setHorizontalGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(signUpMainPanelLayout.createSequentialGroup().addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(signUpMainPanelLayout.createSequentialGroup().addContainerGap().addComponent(signUpBackButton).addGap(91, 91, 91).addComponent(signUpHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(signUpMainPanelLayout.createSequentialGroup().addGap(81, 81, 81).addComponent(signUpGif, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(signUpMainPanelLayout.createSequentialGroup().addGap(17, 17, 17).addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(signUpMainPanelLayout.createSequentialGroup().addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(signUpGamailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(signUpPhoneNumberLabel).addComponent(signUpFullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(signUpGamailCodeLabel).addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(signUpGenderLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(signUpBornYearLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(signUpLine2).addComponent(signUpLine1).addComponent(signUpLine3).addComponent(signUpFullNameTextField).addComponent(signUpGmailTextField).addComponent(signUpPhoneNumberTextField).addGroup(signUpMainPanelLayout.createSequentialGroup().addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(signUpYearOfBirth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(signUpMainPanelLayout.createSequentialGroup().addComponent(signUpMaleCheckBox).addGap(36, 36, 36).addComponent(signUpFemaleCheckBox))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(signUpAge, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signUpMainPanelLayout.createSequentialGroup().addComponent(signUpOtherCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(9, 9, 9)))))).addComponent(signUpMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(signUpMainPanelLayout.createSequentialGroup().addGap(136, 136, 136).addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(signUpSendingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(signUpMainPanelLayout.createSequentialGroup().addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(signUpLine4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(signUpGmailCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addComponent(signUpButtonSendCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))).addGroup(signUpMainPanelLayout.createSequentialGroup().addGap(76, 76, 76).addComponent(signUpConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))).addGap(44, 44, 44)));
        signUpMainPanelLayout.setVerticalGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(signUpMainPanelLayout.createSequentialGroup().addContainerGap().addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(signUpBackButton).addComponent(signUpHeaderLabel)).addGap(5, 5, 5).addComponent(signUpGif, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(19, 19, 19).addComponent(signUpMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(signUpFullNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(signUpFullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(signUpLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(19, 19, 19).addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(signUpBornYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(signUpYearOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(signUpAge, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(26, 26, 26).addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(signUpGenderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(signUpMaleCheckBox).addComponent(signUpFemaleCheckBox).addComponent(signUpOtherCheckBox)).addGap(27, 27, 27).addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(signUpPhoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(signUpPhoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(signUpLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(31, 31, 31).addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(signUpGmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(signUpGamailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(signUpLine3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(26, 26, 26).addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(signUpGamailCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(signUpGmailCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(signUpMainPanelLayout.createSequentialGroup().addGap(22, 22, 22).addComponent(signUpLine4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(signUpButtonSendCode, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(signUpSendingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE).addComponent(signUpConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(77, 77, 77)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(signUpMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(signUpMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        pack();
    }

    private javax.swing.JLabel signUpAge;
    private javax.swing.JButton signUpBackButton;
    private javax.swing.JLabel signUpBornYearLabel;
    private javax.swing.JButton signUpConfirmButton;
    private javax.swing.JButton signUpButtonSendCode;
    private javax.swing.JCheckBox signUpFemaleCheckBox;
    private javax.swing.JLabel signUpFullNameLabel;
    private javax.swing.JTextField signUpFullNameTextField;
    private javax.swing.JLabel signUpGamailCodeLabel;
    private javax.swing.JLabel signUpGamailLabel;
    private javax.swing.JLabel signUpGenderLabel;
    private javax.swing.JLabel signUpGif;
    private javax.swing.JTextField signUpGmailCodeTextField;
    private javax.swing.JTextField signUpGmailTextField;
    private javax.swing.JLabel signUpHeaderLabel;
    private javax.swing.JTextField signUpLine1;
    private javax.swing.JTextField signUpLine2;
    private javax.swing.JTextField signUpLine3;
    private javax.swing.JTextField signUpLine4;
    private javax.swing.JPanel signUpMainPanel;
    private javax.swing.JCheckBox signUpMaleCheckBox;
    private javax.swing.JLabel signUpMessageLabel;
    private javax.swing.JCheckBox signUpOtherCheckBox;
    private javax.swing.JLabel signUpPhoneNumberLabel;
    private javax.swing.JTextField signUpPhoneNumberTextField;
    private javax.swing.JLabel signUpSendingLabel;
    private javax.swing.JComboBox<String> signUpYearOfBirth;

    public JFrame getLoginScreen() {
        return loginScreen;
    }

    public JButton getSignUpBackButton() {
        return signUpBackButton;
    }

    public JButton getSignUpButtonSendCode() {
        return signUpButtonSendCode;
    }

    public JLabel getSignUpMessageLabel() {
        return signUpMessageLabel;
    }

    public JLabel getSignUpSendingLabel() {
        return signUpSendingLabel;
    }

    public JTextField getSignUpGmailTextField() {
        return signUpGmailTextField;
    }

    public JTextField getSignUpFullNameTextField() {
        return signUpFullNameTextField;
    }

    public JTextField getSignUpGmailCodeTextField() {
        return signUpGmailCodeTextField;
    }

    public JTextField getSignUpPhoneNumberTextField() {
        return signUpPhoneNumberTextField;
    }

    public JButton getSignUpConfirmButton() {
        return signUpConfirmButton;
    }

    public JComboBox<String> getSignUpYearOfBirth() {
        return signUpYearOfBirth;
    }

    public JCheckBox getSignUpFemaleCheckBox() {
        return signUpFemaleCheckBox;
    }

    public JCheckBox getSignUpMaleCheckBox() {
        return signUpMaleCheckBox;
    }

    public JCheckBox getSignUpOtherCheckBox() {
        return signUpOtherCheckBox;
    }
}

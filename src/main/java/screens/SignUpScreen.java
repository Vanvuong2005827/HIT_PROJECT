
package screens;

public class SignUpScreen extends javax.swing.JFrame {

    public SignUpScreen() {
        initComponents();
        setLocationRelativeTo(null);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        signUpMainPanel = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        signUpMainPanel.setBackground(new java.awt.Color(176, 223, 251));

        signUpGif.setIcon(new javax.swing.ImageIcon("C:\\Users\\boyzs\\Desktop\\Java\\Design\\ui_design\\src\\main\\java\\assets\\angry-2498_256.gif")); // NOI18N

        signUpBackButton.setBackground(new java.awt.Color(176, 223, 251));
        signUpBackButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        signUpBackButton.setText("<");
        signUpBackButton.setBorder(null);
        signUpBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backEvent(evt);
            }
        });

        signUpFullNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        signUpFullNameLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpFullNameLabel.setText("Full name :");

        signUpHeaderLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        signUpHeaderLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpHeaderLabel.setText("Account Information");

        signUpBornYearLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        signUpBornYearLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpBornYearLabel.setText("Year of birth :");

        signUpGenderLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        signUpGenderLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpGenderLabel.setText("Gender :");

        signUpPhoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        signUpPhoneNumberLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpPhoneNumberLabel.setText("Phone Number :");

        signUpGamailLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        signUpGamailLabel.setForeground(new java.awt.Color(102, 102, 102));
        signUpGamailLabel.setText("Gmail : ");

        signUpLine1.setBackground(new java.awt.Color(176, 223, 251));
        signUpLine1.setForeground(new java.awt.Color(102, 102, 102));
        signUpLine1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        signUpFullNameTextField.setBackground(new java.awt.Color(176, 223, 251));
        signUpFullNameTextField.setBorder(null);

        signUpLine2.setBackground(new java.awt.Color(176, 223, 251));
        signUpLine2.setForeground(new java.awt.Color(102, 102, 102));
        signUpLine2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        signUpLine3.setBackground(new java.awt.Color(176, 223, 251));
        signUpLine3.setForeground(new java.awt.Color(102, 102, 102));
        signUpLine3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        signUpGmailTextField.setBackground(new java.awt.Color(176, 223, 251));
        signUpGmailTextField.setBorder(null);

        signUpPhoneNumberTextField.setBackground(new java.awt.Color(176, 223, 251));
        signUpPhoneNumberTextField.setBorder(null);

        signUpYearOfBirth.setBackground(new java.awt.Color(176, 223, 251));
        signUpYearOfBirth.setMaximumRowCount(30);
        signUpYearOfBirth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012" }));
        signUpYearOfBirth.setBorder(null);

        signUpMaleCheckBox.setBackground(new java.awt.Color(176, 223, 251));
        signUpMaleCheckBox.setForeground(new java.awt.Color(102, 102, 102));
        signUpMaleCheckBox.setText("Male");
        signUpMaleCheckBox.setBorder(null);

        signUpFemaleCheckBox.setBackground(new java.awt.Color(176, 223, 251));
        signUpFemaleCheckBox.setForeground(new java.awt.Color(102, 102, 102));
        signUpFemaleCheckBox.setText("Female");
        signUpFemaleCheckBox.setBorder(null);

        signUpConfirmButton.setBackground(new java.awt.Color(176, 223, 251));
        signUpConfirmButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        signUpConfirmButton.setForeground(new java.awt.Color(102, 102, 102));
        signUpConfirmButton.setText("Confirm");
        signUpConfirmButton.setBorder(null);
        signUpConfirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpConfirmEvent(evt);
            }
        });

        signUpOtherCheckBox.setBackground(new java.awt.Color(176, 223, 251));
        signUpOtherCheckBox.setForeground(new java.awt.Color(102, 102, 102));
        signUpOtherCheckBox.setText("Other");
        signUpOtherCheckBox.setBorder(null);
        signUpOtherCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpOtherCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout signUpMainPanelLayout = new javax.swing.GroupLayout(signUpMainPanel);
        signUpMainPanel.setLayout(signUpMainPanelLayout);
        signUpMainPanelLayout.setHorizontalGroup(
                signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(signUpMainPanelLayout.createSequentialGroup()
                                .addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(signUpMainPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(signUpBackButton)
                                                .addGap(91, 91, 91)
                                                .addComponent(signUpHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(signUpMainPanelLayout.createSequentialGroup()
                                                .addGap(81, 81, 81)
                                                .addComponent(signUpGif, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(signUpMainPanelLayout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(signUpGamailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(signUpPhoneNumberLabel)
                                                        .addComponent(signUpGenderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(signUpBornYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(signUpFullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(signUpLine2)
                                                        .addComponent(signUpLine1)
                                                        .addComponent(signUpLine3)
                                                        .addComponent(signUpFullNameTextField)
                                                        .addComponent(signUpGmailTextField)
                                                        .addComponent(signUpPhoneNumberTextField)
                                                        .addGroup(signUpMainPanelLayout.createSequentialGroup()
                                                                .addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(signUpYearOfBirth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(signUpMainPanelLayout.createSequentialGroup()
                                                                                .addComponent(signUpMaleCheckBox)
                                                                                .addGap(36, 36, 36)
                                                                                .addComponent(signUpFemaleCheckBox)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(signUpAge, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signUpMainPanelLayout.createSequentialGroup()
                                                                                .addComponent(signUpOtherCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(9, 9, 9))))))
                                        .addGroup(signUpMainPanelLayout.createSequentialGroup()
                                                .addGap(76, 76, 76)
                                                .addComponent(signUpConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(55, Short.MAX_VALUE))
        );
        signUpMainPanelLayout.setVerticalGroup(
                signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(signUpMainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signUpBackButton)
                                        .addComponent(signUpHeaderLabel))
                                .addGap(5, 5, 5)
                                .addComponent(signUpGif, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signUpFullNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpFullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signUpLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signUpBornYearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpYearOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpAge, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signUpGenderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpMaleCheckBox)
                                        .addComponent(signUpFemaleCheckBox)
                                        .addComponent(signUpOtherCheckBox))
                                .addGap(27, 27, 27)
                                .addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signUpPhoneNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpPhoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signUpLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(signUpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(signUpGmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(signUpGamailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signUpLine3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(signUpConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(176, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(signUpMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(signUpMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void signUpConfirmEvent(java.awt.event.MouseEvent evt) {
        LoginScreen ls = new LoginScreen();
        this.setVisible(false);
        ls.setVisible(true);
    }

    private void backEvent(java.awt.event.MouseEvent evt) {
        LoginScreen ls = new LoginScreen();
        this.setVisible(false);
        ls.setVisible(true);
    }

    private void signUpOtherCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    // Variables declaration - do not modify
    private javax.swing.JLabel signUpAge;
    private javax.swing.JButton signUpBackButton;
    private javax.swing.JLabel signUpBornYearLabel;
    private javax.swing.JButton signUpConfirmButton;
    private javax.swing.JCheckBox signUpFemaleCheckBox;
    private javax.swing.JLabel signUpFullNameLabel;
    private javax.swing.JTextField signUpFullNameTextField;
    private javax.swing.JLabel signUpGamailLabel;
    private javax.swing.JLabel signUpGenderLabel;
    private javax.swing.JLabel signUpGif;
    private javax.swing.JTextField signUpGmailTextField;
    private javax.swing.JLabel signUpHeaderLabel;
    private javax.swing.JTextField signUpLine1;
    private javax.swing.JTextField signUpLine2;
    private javax.swing.JTextField signUpLine3;
    private javax.swing.JPanel signUpMainPanel;
    private javax.swing.JCheckBox signUpMaleCheckBox;
    private javax.swing.JCheckBox signUpOtherCheckBox;
    private javax.swing.JLabel signUpPhoneNumberLabel;
    private javax.swing.JTextField signUpPhoneNumberTextField;
    private javax.swing.JComboBox<String> signUpYearOfBirth;
    // End of variables declaration
}

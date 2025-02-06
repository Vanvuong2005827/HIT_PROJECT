package controllers;

import view.screens.login_screens.LoginScreen;
import view.screens.login_screens.SignUpScreen;
import utils.RegexChecker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import static commons.CurrentUser.*;
import static commons.CurrentUser.userAccount;

public class SignUpController {
    private SignUpScreen signUpScreen;
    private String AnsCode = "";
    private int Count = 60;

    public SignUpController(SignUpScreen signUpScreen) {
        this.signUpScreen = signUpScreen;
        backEvent();
        sendCodeEvent();
        confirmEvent();
        setStateChange();
    }

    private void backEvent() {
        signUpScreen.getSignUpBackButton().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                signUpScreen.getLoginScreen().setVisible(true);
                signUpScreen.setVisible(false);
            }
        });
    }

    private void sendCodeEvent() {
        signUpScreen.getSignUpButtonSendCode().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                String Gmail = signUpScreen.getSignUpGmailTextField().getText().trim();

                if (Gmail.isEmpty()) {
                    signUpScreen.getSignUpMessageLabel().setText("Xin mời nhập email");
                    return;
                }

                if (!RegexChecker.checkValidEmail(Gmail)) {
                    signUpScreen.getSignUpMessageLabel().setText("Email không tồn tại");
                    return;
                }

                if (Count != 60) {
                    return;
                }


                try {
                    SwingWorker<Void, Void> worker = new SwingWorker<>() {
                        @Override
                        protected Void doInBackground() {
                            signUpScreen.getSignUpMessageLabel().setText("");
                            signUpScreen.getSignUpSendingLabel().setText("Đang gửi...");
                            signUpScreen.getSignUpSendingLabel().setForeground(Color.gray);
                            try {
                                AnsCode = forgetPasswordService.getCode(Gmail);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                            }
                            return null;
                        }

                        @Override
                        protected void done() {
                            signUpScreen.getSignUpSendingLabel().setText("Mã đã được gửi, vui lòng kiểm tra email");
                            signUpScreen.getSignUpSendingLabel().setForeground(Color.gray);
                            waitToSendCode();
                        }
                    };

                    worker.execute();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi kết nối mạng! Vui lòng kiểm tra Internet.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void waitToSendCode() {
        Timer timer = new Timer(1000, e -> {
            if (Count > 0) {
                Count--;
                signUpScreen.getSignUpSendingLabel().setText("Gửi lại trong: " + Count + "s");
            } else {
                ((Timer) e.getSource()).stop();
                Count = 60;
            }
        });
        timer.start();
    }

    private void confirmEvent() {
        signUpScreen.getSignUpConfirmButton().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                String fullname = signUpScreen.getSignUpFullNameTextField().getText().trim();
                String yearOfBirth = Objects.requireNonNull(signUpScreen.getSignUpYearOfBirth().getSelectedItem()).toString().trim();
                String gender = null;
                try {
                    gender = userServices.selectGender(signUpScreen.getSignUpMaleCheckBox().isSelected(), signUpScreen.getSignUpFemaleCheckBox().isSelected(), signUpScreen.getSignUpOtherCheckBox().isSelected());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                String phoneNumber = signUpScreen.getSignUpPhoneNumberTextField().getText().trim();
                String Gmail = signUpScreen.getSignUpGmailTextField().getText().trim();

                if (fullname.isEmpty()) {
                    signUpScreen.getSignUpMessageLabel().setText("Xin mời nhập họ tên");
                    return;
                }
                if (yearOfBirth.equals("0")) {
                    signUpScreen.getSignUpMessageLabel().setText("Xin mời nhập năm sinh");
                    return;
                }
                if (phoneNumber.isEmpty()) {
                    signUpScreen.getSignUpMessageLabel().setText("Xin mời nhập số điện thoại");
                    return;
                }
                if (Gmail.isEmpty()) {
                    signUpScreen.getSignUpMessageLabel().setText("Xin mời nhập email");
                    return;
                }
                if (!RegexChecker.checkValidEmail(Gmail)) {
                    signUpScreen.getSignUpMessageLabel().setText("Email không tồn tại");
                    return;
                }

                if (!RegexChecker.checkValidPhoneNumber(phoneNumber)) {
                    signUpScreen.getSignUpMessageLabel().setText("Số điện thoại không hợp lệ");
                    return;
                }

                if (signUpScreen.getSignUpGmailCodeTextField().getText().trim().isEmpty()) {
                    signUpScreen.getSignUpMessageLabel().setText("Mời nhập mã xác thực");
                    return;
                }

                if (!AnsCode.equals(signUpScreen.getSignUpGmailCodeTextField().getText().trim())) {
                    signUpScreen.getSignUpMessageLabel().setText("Mã xác thực không đúng");
                }

                try {
                    userServices.updateInformation(userAccount, fullname, yearOfBirth, gender, phoneNumber, Gmail);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Không cập nhật được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                userAccount = null;

                LoginScreen ls = new LoginScreen();
                ls.setVisible(true);
                signUpScreen.setVisible(false);
            }
        });
    }

    private void setStateChange() {
        ItemListener itemListener = this::itemStateChanged;
        signUpScreen.getSignUpMaleCheckBox().addItemListener(itemListener);
        signUpScreen.getSignUpFemaleCheckBox().addItemListener(itemListener);
        signUpScreen.getSignUpOtherCheckBox().addItemListener(itemListener);
    }

    private void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            JCheckBox selected = (JCheckBox) e.getSource();
            if (selected == signUpScreen.getSignUpMaleCheckBox()) {
                signUpScreen.getSignUpFemaleCheckBox().setSelected(false);
                signUpScreen.getSignUpOtherCheckBox().setSelected(false);
            } else if (selected == signUpScreen.getSignUpFemaleCheckBox()) {
                signUpScreen.getSignUpMaleCheckBox().setSelected(false);
                signUpScreen.getSignUpOtherCheckBox().setSelected(false);
            } else if (selected == signUpScreen.getSignUpOtherCheckBox()) {
                signUpScreen.getSignUpMaleCheckBox().setSelected(false);
                signUpScreen.getSignUpFemaleCheckBox().setSelected(false);
            }
        }
    }
}

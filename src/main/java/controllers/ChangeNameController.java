package controllers;

import view.screens.account_screens.ChangeNameScreen;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static commons.CurrentUser.userInfo;
import static commons.CurrentUser.userServices;

public class ChangeNameController {
    private ChangeNameScreen changeNameScreen;
    private JLabel label;

    public ChangeNameController(ChangeNameScreen changeNameScreen, JLabel label) {
        this.changeNameScreen = changeNameScreen;
        this.label = label;
        cancelEvent();
        confirmEvent();
    }

    private void cancelEvent() {
        changeNameScreen.getjLabel5().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                changeNameScreen.setVisible(false);
            }
        });
    }

    private void confirmEvent() {
        changeNameScreen.getjLabel6().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                try {
                    label.setText(changeNameScreen.getjTextField1().getText().trim());
                    userServices.changeUserFullName(userInfo.getId(), changeNameScreen.getjTextField1().getText().trim());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                changeNameScreen.setVisible(false);
            }
        });
    }
}

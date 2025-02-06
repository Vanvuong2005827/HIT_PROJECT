package services;

import models.user.UserAccount;

import javax.swing.*;

import static dao.ConnectDB.*;

public class RegisterService {
    private UserServices userServices;

    public RegisterService() {
        userServices = new UserServices();
    }

    public boolean register(UserAccount user) throws Exception {
        try {
            if (!userServices.isUsernameExists(user.getUsername())) {
                collection.insertOne(user);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}

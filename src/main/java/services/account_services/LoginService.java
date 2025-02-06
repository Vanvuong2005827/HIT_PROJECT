package services.account_services;

import models.user.UserAccount;
import services.UserServices;

import javax.swing.*;

import static commons.CurrentUser.encryptorService;
import static commons.CurrentUser.pref;

public class LoginService {
    private final UserServices userServices;

    public LoginService() {
        userServices = new UserServices();
    }

    public boolean authenticate(String username, String password) throws Exception {
        UserAccount user = null;
        try {
            user = userServices.getUserByUsername(username);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (user != null && encryptorService.checkPassword(password, user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public void saveUser(String username, String password) {
        pref.put("username", username);
        pref.put("password", password);
    }

}



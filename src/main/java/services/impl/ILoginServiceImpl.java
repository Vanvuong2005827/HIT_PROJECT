package services.impl;

import models.user.UserAccount;
import services.ILoginService;

import javax.swing.*;

import static commons.CurrentUser.encryptorService;
import static commons.CurrentUser.pref;

public class ILoginServiceImpl implements ILoginService {
    private final IUserServicesImpl IUserServicesImpl;

    public ILoginServiceImpl() {
        IUserServicesImpl = new IUserServicesImpl();
    }

    public boolean authenticate(String username, String password) throws Exception {
        UserAccount user = null;
        try {
            user = IUserServicesImpl.getUserByUsername(username);
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



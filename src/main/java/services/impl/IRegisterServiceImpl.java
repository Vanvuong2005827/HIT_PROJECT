package services.impl;

import models.user.UserAccount;
import services.IRegisterService;

import javax.swing.*;

import static dao.ConnectDB.*;

public class IRegisterServiceImpl implements IRegisterService {
    private IUserServicesImpl IUserServicesImpl;

    public IRegisterServiceImpl() {
        IUserServicesImpl = new IUserServicesImpl();
    }

    public boolean register(UserAccount user) throws Exception {
        try {
            if (!IUserServicesImpl.isUsernameExists(user.getUsername())) {
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

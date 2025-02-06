package services.account_services;

import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;

public class EncryptorService {
    public String hasing(String plainText) {
        return BCrypt.hashpw(plainText, BCrypt.gensalt());
    }

    public boolean checkPassword(String plainText, String hashedPassword) {
        try {
            return BCrypt.checkpw(plainText, hashedPassword);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}

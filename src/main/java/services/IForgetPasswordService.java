package services;

import models.user.UserAccount;

public interface IForgetPasswordService {
    String getCode(String gmail);
    void ChangePassword(UserAccount user, String newPassword);
}

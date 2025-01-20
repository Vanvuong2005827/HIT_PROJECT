package services;

import models.User.UserAccount;

public class LoginService {
    private UserServices userServices;
    public LoginService() {
        userServices = new UserServices();
    }
    public boolean authenticate(String username, String password) {
        UserAccount user = userServices.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;

        } else {
            return false;
        }
    }
}



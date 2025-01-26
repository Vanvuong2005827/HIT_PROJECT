package services;

import models.User.UserAccount;

import java.util.prefs.Preferences;

import static commons.CurrentUser.pref;

public class LoginService {
    private final UserServices userServices;
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

    public void saveUser(String username, String password) {
        pref.put("username", username);
        pref.put("password", password);
        System.out.println("Saved");
    }

}



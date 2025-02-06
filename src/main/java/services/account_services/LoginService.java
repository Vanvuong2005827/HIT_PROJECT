package services.account_services;

import models.user.UserAccount;
import services.UserServices;

import static commons.CurrentUser.encryptorService;
import static commons.CurrentUser.pref;

public class LoginService {
    private final UserServices userServices;

    public LoginService() {
        userServices = new UserServices();
    }

    public boolean authenticate(String username, String password) throws Exception {
        UserAccount user = userServices.getUserByUsername(username);
        if (user != null && encryptorService.checkPassword(password, user.getPassword())) {
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



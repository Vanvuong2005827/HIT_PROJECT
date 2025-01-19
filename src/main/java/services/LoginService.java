package services;

import org.bson.Document;

public class LoginService {
    private UserServices userServices;
    public LoginService() {
        userServices = new UserServices();
    }
    public boolean authenticate(String username, String password) {
        Document user = userServices.getUserByUsername(username);
        if (user != null && user.get("password").equals(password)) {
            return true;

        } else {
            return false;
        }
    }
}



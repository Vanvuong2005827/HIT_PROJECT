package services;

import models.User.UserAccount;
import org.bson.Document;

import static DAO.ConnectDB.*;
public class RegisterService {
    private Document user;
    private UserServices userServices;
    public RegisterService() {
        userServices = new UserServices();
    }

    public boolean register(UserAccount user) {
        if (!userServices.isUsernameExists(user.getUsername())) {
            collection.insertOne(user);
            return true;
        } else {
            return false;
        }
    }
}

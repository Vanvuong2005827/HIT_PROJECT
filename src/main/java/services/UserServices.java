package services;

import models.User;
import org.bson.Document;

import static DAO.ConnectDB.*;


public class UserServices {


    public boolean isUsernameExists(String username) {
        User found = collection.find(new org.bson.Document("username", username)).first();
        return found != null;
        //true là có username trong DB và ngược lại
    }

    public User getUserByUsername(String username) {
        User found = collection.find(new org.bson.Document("username", username)).first();
        if (found != null) {
            return found;
        } else {
            return null;
        }
    }

    public String getRoleByUsername(String username) {
        User found = collection.find(new org.bson.Document("username", username)).first();
        if (found != null) {
            return found.getRole().name();
        } else {
            return null;
        }
    }

}

package services;

import com.google.gson.Gson;
import models.User;
import org.bson.Document;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import javax.print.Doc;

import static DAO.ConnectDB.*;
public class RegisterService {
    private Document user;
    private UserServices userServices;
    public RegisterService() {
        userServices = new UserServices();
    }

    public boolean register(User user) {
        if (!userServices.isUsernameExists(user.getUsername())) {
            collection.insertOne(user);
            return true;
        } else {
            return false;
        }
    }
}

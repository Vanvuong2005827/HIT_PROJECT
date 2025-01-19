package services;

import org.bson.Document;
import static DAO.ConnectDB.*;
public class RegisterService {
    private Document user;
    private UserServices userServices;
    public RegisterService() {
        userServices = new UserServices();
    }

    public boolean register(String username, String password) {
        user = new Document("username", username).append("password", password).append("role", "user");
        if (userServices.isUsernameExists((String) user.get("username"))) {
            collection.insertOne(user);
            return true;
        } else {
            return false;
        }
    }
}

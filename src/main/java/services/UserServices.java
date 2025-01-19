package services;

import org.bson.Document;

import static DAO.ConnectDB.*;


public class UserServices {


    public boolean isUsernameExists(String username) {
        Document found = (Document) collection.find(new Document("username", username)).first();
        return found != null;
    }

    public Document getUserByUsername(String username) {
        Document found = (Document) collection.find(new Document("username", username)).first();
        if (found != null) {
            return found;
        } else {
            return null;
        }
    }

    public String getRoleByUsername(String username) {
        Document found = (Document) collection.find(new Document("username", username));
        if (found != null) {
            return found.getString("role");
        } else {
            return null;
        }
    }

}

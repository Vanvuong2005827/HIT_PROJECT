package services;

import models.User.UserAccount;
import models.User.UserInfo;

import static DAO.ConnectDB.*;


public class UserServices {


    public boolean isUsernameExists(String username) {
        UserAccount found = collection.find(new org.bson.Document("username", username)).first();
        return found != null;
        //true là có username trong DB và ngược lại
    }

    public UserAccount getUserByUsername(String username) {
        UserAccount found = collection.find(new org.bson.Document("username", username)).first();
        if (found != null) {
            return found;
        } else {
            return null;
        }
    }

    public UserInfo getUserInfoByUserAccount(UserAccount userAccount) {
        UserInfo found = collectionInfo.find(new org.bson.Document("_id", userAccount.getId())).first();
        if (found != null) {
            return found;
        } else {
            return new UserInfo();
        }
    }

    public String getRoleByUsername(String username) {
        UserAccount found = collection.find(new org.bson.Document("username", username)).first();
        if (found != null) {
            return found.getRole().name();
        } else {
            return null;
        }
    }

    public void updateInformation(UserAccount user, String fullname, String yearOfBirth, String Gender, String phoneNumber, String email) {

        UserInfo userInfo = new UserInfo(fullname, Integer.parseInt(yearOfBirth), email, phoneNumber, Gender, user);
        collectionInfo.insertOne(userInfo);
    }

    public String selectGender(boolean male, boolean female, boolean orther) {
        if (male) return "male";
        if (female) return "female";
        if (orther) return "orther";
        return "";
    }

}
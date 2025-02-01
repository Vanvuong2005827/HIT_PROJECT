package services;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import models.User.UserAccount;
import models.User.UserIP;
import models.User.UserInfo;

import java.time.LocalDateTime;

import static DAO.ConnectDB.*;
import static commons.CurrentUser.encryptorService;


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
        if (userAccount == null) {
            return new UserInfo();
        }
        UserInfo found = collectionInfo.find(new org.bson.Document("_id", userAccount.getId())).first();
        if (found != null) {
            return found;
        } else {
            return new UserInfo();
        }
    }

    public UserIP getUserIPByIP(String IP) {
        UserIP found = collectionIp.find(new org.bson.Document("ip", IP)).first();
        if (found != null) {
            return found;
        } else {
            UserIP ip = new UserIP(IP);
            collectionIp.insertOne(ip);
            return ip;
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

    public void plusTime(UserIP userIP, int plusMinutesInto) {
        collectionIp.updateOne(
                Filters.eq("ip", userIP.getIp()),
                Updates.set("time", LocalDateTime.now().plusMinutes(plusMinutesInto))
        );
    }

    public String selectGender(boolean male, boolean female, boolean other) {
        if (male) return "male";
        if (female) return "female";
        if (other) return "other";
        return "";
    }

}
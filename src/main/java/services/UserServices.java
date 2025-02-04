package services;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import models.User.UserAccount;
import models.User.UserIP;
import models.User.UserInfo;
import org.bson.types.ObjectId;

import java.awt.*;
import java.time.LocalDateTime;

import static DAO.ConnectDB.*;
import static commons.CurrentUser.userAccount;


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
            collectionInfo.insertOne(new UserInfo(userAccount.getId()));
            return new UserInfo(userAccount.getId());
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

    public void changeUserFullName(ObjectId userId, String newFullname) {
        collectionInfo.updateOne(Filters.eq("_id", userId), Updates.set("fullName", newFullname));
    }

    public void plusTime(UserIP userIP, int plusMinutesInto) {
        collectionIp.updateOne(Filters.eq("ip", userIP.getIp()), Updates.set("time", LocalDateTime.now().plusMinutes(plusMinutesInto)));
    }

    public String selectGender(boolean male, boolean female, boolean other) {
        if (male) return "male";
        if (female) return "female";
        if (other) return "other";
        return "";
    }

    public String colorToHex(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

    public void updateGradientColorToUser(Color one, Color two, Color three, Color fix) {
        collectionInfo.updateOne(Filters.eq("_id", userAccount.getId()), Updates.combine(Updates.set("colorMain1", colorToHex(one)), Updates.set("colorMain2", colorToHex(two)), Updates.set("colorMain3", colorToHex(three)), Updates.set("colorFix", colorToHex(fix))));
    }

}
package services;

import models.user.UserAccount;
import models.user.UserIP;
import models.user.UserInfo;
import org.bson.types.ObjectId;

import java.awt.*;
import java.util.ArrayList;

public interface IUserServices {
    boolean isUsernameExists(String username);
    UserAccount getUserByUsername(String username);
    UserInfo getUserInfoByUserAccount(UserAccount userAccount);
    UserIP getUserIPByIP(String IP);
    String getRoleByUsername(String username);
    void updateInformation(UserAccount user, String fullname, String yearOfBirth, String Gender, String phoneNumber, String email);
    void changeUserFullName(ObjectId userId, String newFullname) throws Exception;
    void plusTime(UserIP userIP, int plusMinutesInto) throws Exception;
    String selectGender(boolean male, boolean female, boolean other) throws Exception;
    String colorToHex(Color color) throws Exception;
    void updateGradientColorToUser(Color one, Color two, Color three, Color fix) throws Exception;
    ArrayList<UserAccount> getAllUsers();
    boolean sentMessage(String gmail, String content) throws Exception;
}

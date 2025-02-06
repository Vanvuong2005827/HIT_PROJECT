package services;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import models.user.UserAccount;
import models.user.UserIP;
import models.user.UserInfo;
import org.bson.types.ObjectId;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

import static dao.ConnectDB.*;
import static commons.CurrentUser.userAccount;


public class UserServices {
    public boolean isUsernameExists(String username) throws Exception {
        try {
            UserAccount found = collection.find(new org.bson.Document("username", username)).first();
            return found != null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối, vui lòng kiểm tra lại đường truyền hoặc là báo lại Admin");
        }
        //true là có username trong DB và ngược lại
        return false;
    }

    public UserAccount getUserByUsername(String username) throws Exception {
        try {
            UserAccount found = collection.find(new org.bson.Document("username", username)).first();
            if (found != null) {
                return found;
            } else {
                return null;
            }
        } catch (NoClassDefFoundError e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối, vui lòng kiểm tra lại đường truyền hoặc là báo lại Admin");
        }
        return null;
    }

    public UserInfo getUserInfoByUserAccount(UserAccount userAccount) throws Exception {
        try {
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối, vui lòng kiểm tra lại đường truyền hoặc là báo lại Admin");
        }

        return null;
    }

    public UserIP getUserIPByIP(String IP) throws Exception {
        try {
            UserIP found = collectionIp.find(new org.bson.Document("ip", IP)).first();
            if (found != null) {
                return found;
            } else {
                UserIP ip = new UserIP(IP);
                collectionIp.insertOne(ip);
                return ip;
            }
        } catch (NoClassDefFoundError e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối, vui lòng kiểm tra lại đường truyền hoặc là báo lại Admin");
        }

        return null;
    }

    public String getRoleByUsername(String username) throws Exception {
        try {
            UserAccount found = collection.find(new org.bson.Document("username", username)).first();
            if (found != null) {
                return found.getRole().name();
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối, vui lòng kiểm tra lại đường truyền hoặc là báo lại Admin");
        }
        return null;
    }

    public void updateInformation(UserAccount user, String fullname, String yearOfBirth, String Gender, String phoneNumber, String email) throws Exception {
        try {

            UserInfo userInfo = new UserInfo(fullname, Integer.parseInt(yearOfBirth), email, phoneNumber, Gender, user);
            collectionInfo.insertOne(userInfo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối, vui lòng kiểm tra lại đường truyền hoặc là báo lại Admin");
        }

    }

    public void changeUserFullName(ObjectId userId, String newFullname) throws Exception {
        try {
            collectionInfo.updateOne(Filters.eq("_id", userId), Updates.set("fullName", newFullname));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối, vui lòng kiểm tra lại đường truyền hoặc là báo lại Admin");
        }

    }

    public void plusTime(UserIP userIP, int plusMinutesInto) throws Exception {
        try {
            collectionIp.updateOne(Filters.eq("ip", userIP.getIp()), Updates.set("time", LocalDateTime.now().plusMinutes(plusMinutesInto)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối, vui lòng kiểm tra lại đường truyền hoặc là báo lại Admin");
        }
    }

    public String selectGender(boolean male, boolean female, boolean other) throws Exception {
        try {
            if (male) return "male";
            if (female) return "female";
            if (other) return "other";
            return "";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối, vui lòng kiểm tra lại đường truyền hoặc là báo lại Admin");
        }
        return "";
    }

    public String colorToHex(Color color) throws Exception {
        try {
            return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi không xác định, vui lòng kiểm tra lại đường truyền hoặc là báo lại Admin");
        }
        return "";
    }

    public void updateGradientColorToUser(Color one, Color two, Color three, Color fix) throws Exception {
        try {
            collectionInfo.updateOne(Filters.eq("_id", userAccount.getId()), Updates.combine(Updates.set("colorMain1", colorToHex(one)), Updates.set("colorMain2", colorToHex(two)), Updates.set("colorMain3", colorToHex(three)), Updates.set("colorFix", colorToHex(fix))));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi không xác định, vui lòng kiểm tra lại đường truyền hoặc là báo lại Admin");
        }
    }

}
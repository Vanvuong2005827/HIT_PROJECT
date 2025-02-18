package services.impl;

import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import models.user.UserAccount;
import models.user.UserIP;
import models.user.UserInfo;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import services.IUserServices;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import static dao.ConnectDB.*;
import static commons.CurrentUser.userAccount;


public class IUserServicesImpl implements IUserServices {
    public boolean isUsernameExists(String username){
        try {
            UserAccount found = collection.find(new org.bson.Document("username", username)).first();
            return found != null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public UserAccount getUserByUsername(String username){
        try {
            UserAccount found = collection.find(new org.bson.Document("username", username)).first();
            if (found != null) {
                return found;
            } else {
                return null;
            }
        } catch (NoClassDefFoundError e) {
            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public UserInfo getUserInfoByUserAccount(UserAccount userAccount){
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
            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    public UserIP getUserIPByIP(String IP){
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
            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

    public String getRoleByUsername(String username){
        try {
            UserAccount found = collection.find(new org.bson.Document("username", username)).first();
            if (found != null) {
                return found.getRole().name();
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public void updateInformation(UserAccount user, String fullname, String yearOfBirth, String Gender, String phoneNumber, String email){
        try {

            UserInfo userInfo = new UserInfo(fullname, Integer.parseInt(yearOfBirth), email, phoneNumber, Gender, user);
            collectionInfo.insertOne(userInfo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không cập nhật được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void changeUserFullName(ObjectId userId, String newFullname) throws Exception {
        try {
            collectionInfo.updateOne(Filters.eq("_id", userId), Updates.set("fullName", newFullname));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không đổi được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void plusTime(UserIP userIP, int plusMinutesInto) throws Exception {
        try {
            collectionIp.updateOne(Filters.eq("ip", userIP.getIp()), Updates.set("time", LocalDateTime.now().plusMinutes(plusMinutesInto)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String selectGender(boolean male, boolean female, boolean other) throws Exception {
        try {
            if (male) return "male";
            if (female) return "female";
            if (other) return "other";
            return "";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return "";
    }

    public String colorToHex(Color color) throws Exception {
        try {
            return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return "";
    }

    public void updateGradientColorToUser(Color one, Color two, Color three, Color fix) throws Exception {
        try {
            collectionInfo.updateOne(Filters.eq("_id", userAccount.getId()), Updates.combine(Updates.set("colorMain1", colorToHex(one)), Updates.set("colorMain2", colorToHex(two)), Updates.set("colorMain3", colorToHex(three)), Updates.set("colorFix", colorToHex(fix))));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không cập nhật được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<UserAccount> getAllUsers() {
        return collection.find().into(new java.util.ArrayList<>());
    }

    public ArrayList<String> getAllDistinctEmails() {
        return collectionInfo.distinct("email", String.class)
                .filter(Filters.eq("notification", true))
                .into(new ArrayList<>());
    }

    public boolean updateUserStatus(String username, String newStatus) {
        try {
            Bson filter = Filters.eq("username", username);
            collection.updateOne(filter, Updates.set("status", newStatus));
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể cập nhật trạng thái. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean sentMessage(String gmail, String content) throws Exception {
        String to = gmail;
        String from = "wu.kongv1999@gmail.com";
        final String username = "wu.kongv1999@gmail.com";

        final String password = "jldp onmx roho qytx";

        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Thông báo!");

            // Nội dung email
            String htmlContent = "<div style=\"font-family: Arial, sans-serif; text-align: center; background-color: #f9f9f9; padding: 20px;\">" + content + "</div>";

            message.setContent(htmlContent, "text/html; charset=UTF-8");

            Transport.send(message);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public void setNotification(ObjectId userId, boolean notification) {
        try {
            collectionInfo.updateOne(Filters.eq("_id", userId), Updates.set("notification", notification));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
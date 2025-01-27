package services;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import models.User.UserAccount;

import javax.swing.*;
import java.util.Properties;
import java.util.Random;

import static DAO.ConnectDB.collection;
import static commons.CurrentUser.*;

public class ForgetPasswordService {
    public String getCode(String gmail){
        Random rand = new Random();
        int randomNum = rand.nextInt(999999);
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
            message.setSubject("this is your code to recovery password, don't share it to anyone: " + randomNum);
            message.setContent("<p>The text and the <strong>image</strong></p>", "text/html");

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return String.valueOf(randomNum);
    }

    public void ChangePassword(UserAccount user, String newpassword){
        try {
            collection.updateOne(
                    Filters.eq("username", user.getUsername()),
                    Updates.set("password", encryptorService.hasing(newpassword))
            );
            userAccount = userServices.getUserByUsername(user.getUsername());
        } catch (Exception e) {
            System.out.println(e.getMessage() + ": Error while updating password");
        }
    }
}

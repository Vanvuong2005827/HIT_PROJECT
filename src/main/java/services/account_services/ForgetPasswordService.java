package services.account_services;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import models.user.UserAccount;

import javax.swing.*;
import java.util.Properties;
import java.util.Random;

import static dao.ConnectDB.collection;
import static commons.CurrentUser.*;

public class ForgetPasswordService {

    public String getCode(String gmail) {
        Random rand = new Random();
        int randomNum = 100000 + rand.nextInt(900000);
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
            message.setSubject("Xác minh tài khoản KVComic của bạn");

            // Nội dung email
            String htmlContent = "<div style=\"font-family: Arial, sans-serif; text-align: center; background-color: #f9f9f9; padding: 20px;\">" +
                    "<div style=\"max-width: 600px; margin: auto; background: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\">" +
                    "<h2 style=\"color: #333;\">Xin chào,</h2>" +
                    "<p style=\"font-size: 16px; color: #555;\">Để tiếp tục thiết lập tài khoản KVComic, vui lòng xác minh tài khoản của bạn bằng mã bên dưới:</p>" +
                    "<div style=\"font-size: 32px; font-weight: bold; color: #2c3e50; margin: 20px 0;\">" + randomNum + "</div>" +
                    "<p style=\"font-size: 14px; color: #999;\">Mã này sẽ hết hạn sau 5 ngày. Vui lòng không tiết lộ mã này cho người khác.</p>" +
                    "</div>" +
                    "<p style=\"font-size: 12px; color: #aaa; margin-top: 20px;\">© 2024 KVComic. Bảo lưu mọi quyền.</p>" +
                    "</div>";

            message.setContent(htmlContent, "text/html; charset=UTF-8");

            Transport.send(message);
            System.out.println("Email đã được gửi thành công.");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Lỗi: Mật khẩu email không được tìm thấy trong biến môi trường.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi gửi email.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối mạng! Vui lòng kiểm tra Internet.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        return String.valueOf(randomNum);
    }

    public void ChangePassword(UserAccount user, String newPassword) {
        try {
            if (user == null) {
                throw new NullPointerException("User không tồn tại.");
            }
            if (newPassword == null || newPassword.length() < 6) {
                throw new IllegalArgumentException("Mật khẩu phải có ít nhất 6 ký tự.");
            }

            collection.updateOne(
                    Filters.eq("username", user.getUsername()),
                    Updates.set("password", encryptorService.hasing(newPassword))
            );

            userAccount = userServices.getUserByUsername(user.getUsername());
            System.out.println("Mật khẩu đã được cập nhật thành công.");

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Lỗi: User không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối mạng! Vui lòng kiểm tra Internet.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}

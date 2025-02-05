package services.account_services;

import org.bson.Document;
import org.bson.types.ObjectId;

import javax.swing.*;

import static dao.ConnectDB.*;

public class DelAccountService {
    public void delAccount(ObjectId idUser) {
        try {
            collection.deleteMany(new Document("_id", idUser));
            collectionHistory.deleteMany(new Document("userId", idUser));
            collectionInfo.deleteMany(new Document("_id", idUser));
            collectionIp.deleteMany(new Document("_id", idUser));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi Không Xác Định, Vui Lòng Liên Hệ Với Admin Qua Email: Vanvuong2005827@gmail.com");
        }
    }
}

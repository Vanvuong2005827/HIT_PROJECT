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
            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}

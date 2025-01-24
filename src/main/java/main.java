import com.mongodb.client.model.Filters;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.Updates;
import models.User.UserAccount;
import org.bson.conversions.Bson;
import screens.HomeScreen;
import screens.LoginScreen;
import static DAO.ConnectDB.*;
import DAO.ConnectDB;
import screens.MoreBookScreen;
import services.ForgetPasswordService;

import java.io.File;

public class main {
    public static void main(String[] args) {
        new ConnectDB();
        LoginScreen lg = new LoginScreen();
        lg.setVisible(true);
    }
}
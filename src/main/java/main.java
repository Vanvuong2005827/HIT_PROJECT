import models.User;
import org.bson.Document;
import screens.LoginScreen;
import services.LoginService;
import services.LoginService;
import services.RegisterService;
import services.UserServices;
import DAO.ConnectDB.*;

import static DAO.ConnectDB.collection;

public class main {
    public static void main(String[] args) {
        LoginScreen lg = new LoginScreen();
        lg.setVisible(true);
    }
}

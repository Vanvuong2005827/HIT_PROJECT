import screens.LoginScreen;
import DAO.ConnectDB;

import static commons.CurrentUser.pref;

public class main {
    public static void main(String[] args) {
        new ConnectDB();
        LoginScreen lg = new LoginScreen();
        lg.setVisible(true);
    }
}
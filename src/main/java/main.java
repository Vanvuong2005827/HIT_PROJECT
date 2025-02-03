import screens.LoginScreen;
import DAO.ConnectDB;

import static commons.ColorMain.getColorGradient;


public class main {
    public static void main(String[] args) {
        new ConnectDB();
        getColorGradient();
        LoginScreen lg = new LoginScreen();
        lg.setVisible(true);
    }
}
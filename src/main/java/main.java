import screens.LoginScreen;
import DAO.ConnectDB;

public class main {
    public static void main(String[] args) {
        new ConnectDB();
        LoginScreen lg = new LoginScreen();
        lg.setVisible(true);
    }
}
import screens.login_screens.LoginScreen;
import DAO.ConnectDB;
import javax.swing.*;
import static commons.ColorMain.getColorGradient;


public class main {
    public static void main(String[] args) {
        new ConnectDB();
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatIntelliJLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        getColorGradient();
        LoginScreen lg = new LoginScreen();
        lg.setVisible(true);
    }
}
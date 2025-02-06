import view.screens.login_screens.LoginScreen;
import dao.ConnectDB;
import javax.swing.*;
import static commons.ColorMain.getColorGradient;


public class main {
    public static void main(String[] args) {
        try {
            new ConnectDB();
        } catch (ExceptionInInitializerError e){
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại kết nối internet của bạn");
        }

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
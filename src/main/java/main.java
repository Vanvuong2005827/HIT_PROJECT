import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import utils.NetworkChecker;
import view.screens.auth_screens.LoginScreen;
import dao.ConnectDB;
import javax.swing.*;
import static commons.ColorMain.getColorGradient;
import static commons.CurrentUser.encryptorService;


public class main {
    public static void main(String[] args) {
        NetworkChecker.startNetworkMonitoring();
        IconFontSwing.register(FontAwesome.getIconFont());
        new ConnectDB();
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatIntelliJLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        getColorGradient();
        SwingUtilities.invokeLater(() -> {
            LoginScreen lg = new LoginScreen();
            lg.setVisible(true);
        });
    }
}
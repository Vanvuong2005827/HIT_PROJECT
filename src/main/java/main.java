import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import utils.NetworkChecker;
import view.user_view.screens.auth_screens.LoginScreen;
import dao.ConnectDB;
import javax.swing.*;
import static commons.ColorMain.getColorGradient;
import static dao.ConnectDB.collection;
import static dao.ConnectDB.collectionInfo;


public class main {
    public static void main(String[] args) {
//        System.setProperty("sun.java2d.uiScale", "1");
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
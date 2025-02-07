import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import utils.NetworkChecker;
import view.screens.auth_screens.LoginScreen;
import dao.ConnectDB;
import javax.swing.*;
import static commons.ColorMain.getColorGradient;
import static dao.ConnectDB.collectionFavourite;


public class main {
    public static void main(String[] args) {
        NetworkChecker.startNetworkMonitoring();
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
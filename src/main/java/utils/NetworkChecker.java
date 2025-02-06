package utils;

import view.screens.main_screens.DisconnectScreen;

import javax.swing.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkChecker {
    private static boolean isConnected = true;
    public static JFrame curFrame = null;

    public static boolean checkInternetConnection() {
        try {
            URL url = new URL("https://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(3000);
            connection.connect();
            return (connection.getResponseCode() == 200);
        } catch (IOException e) {
            return false;
        }
    }

    public static void startNetworkMonitoring() {
        new Thread(() -> {
            while (true) {
                boolean currentStatus = checkInternetConnection();
                DisconnectScreen d = new DisconnectScreen();
                if (!currentStatus) {
                    if (isConnected) {
                        d.setVisible(true);
                        curFrame.setVisible(false);
                        curFrame.dispose();
                    }
                    isConnected = false;
                } else {
                    isConnected = true;
                    curFrame.setVisible(true);
                    d.setVisible(false);
                }

                try {
                    Thread.sleep(isConnected ? 5000 : 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
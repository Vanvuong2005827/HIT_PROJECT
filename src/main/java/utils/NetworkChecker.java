package utils;

import view.screens.DisconnectScreen;

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
                if (!currentStatus) {
                    if (isConnected) {
                        DisconnectScreen d = new DisconnectScreen();
                        d.setVisible(true);
                        curFrame.setVisible(false);
                        curFrame.dispose();
                    }
                    isConnected = false;
                } else {
                    isConnected = true;
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
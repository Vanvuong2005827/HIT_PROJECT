package utils;

import view.screens.DisconnectScreen;

import javax.swing.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkChecker {
    public static boolean isConnected = true;
    public static JFrame curFrame = null;
    public static DisconnectScreen disconnectScreen = null;

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
            boolean wasConnected = true;
            while (true) {
                boolean currentStatus = checkInternetConnection();
                if (!currentStatus) {
                    if (wasConnected) {
                        disconnectScreen = new DisconnectScreen();
                        disconnectScreen.setVisible(true);
                        curFrame.setVisible(false);
                    }
                    isConnected = false;
                } else {
                    if (!wasConnected){
                        if (disconnectScreen != null) {
                            disconnectScreen.setVisible(false);
                            disconnectScreen.dispose();
                            disconnectScreen = null;
                        }
                        curFrame.setVisible(true);
                    }
                    isConnected = true;
                }
                wasConnected = currentStatus;
                try {
                    Thread.sleep(isConnected ? 5000 : 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
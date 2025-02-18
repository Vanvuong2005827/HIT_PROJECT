package utils;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import java.awt.*;

import static commons.ColorMain.colorMain1;

public class CustomChatMessage {
    public static JLabel customChat(String message, boolean isUser) {
        String formattedMessage;
        if (isUser){
            formattedMessage = "<html><p style='width: 230px; word-wrap: break-word;text-align: right;margin: 0;'>" + message + "</p></html>";
        }
        else formattedMessage = "<html><p style='width: 250px; word-wrap: break-word;text-align: left;margin: 0;'>" + message + "</p></html>";

        JLabel label = new JLabel(formattedMessage);
        label.setOpaque(true);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        if (isUser) {
            label.setHorizontalAlignment(SwingConstants.RIGHT);
            label.setIcon(IconFontSwing.buildIcon(FontAwesome.USER, 15, Color.black));
            label.setHorizontalTextPosition(SwingConstants.LEFT);
        } else {
            label.setHorizontalAlignment(SwingConstants.LEFT);
            label.setIcon(IconFontSwing.buildIcon(FontAwesome.SIMPLYBUILT, 15, Color.black));
            label.setHorizontalTextPosition(SwingConstants.RIGHT);
        }

        return label;
    }

}

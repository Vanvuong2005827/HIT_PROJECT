package commons;

import models.ColorTuple;
import java.awt.*;
import java.util.ArrayList;

public class ColorMain {
    public static ArrayList<Color> listColorNormal = new ArrayList<>();
    public static ArrayList<ColorTuple> listColorGradient = new ArrayList<>();

    public ArrayList<Color> getColorMain() {
        ArrayList<Color> colors = new ArrayList<>();
        colors.add(new Color(176, 223, 251));
        colors.add(new Color(135, 206, 250)); // Sky Blue
        colors.add(new Color(176, 242, 245)); // Light Cyan
        colors.add(new Color(224, 238, 251)); // Very Light Blue
        colors.add(new Color(144, 203, 223)); // Light Steel Blue
        colors.add(new Color(251, 223, 176)); // Light Peach/Apricot
        colors.add(new Color(255, 204, 153)); // Peach c
        colors.add(new Color(247, 216, 171)); // Creamy Yellow
        colors.add(new Color(251, 176, 223)); // Pink Pastel
        colors.add(new Color(223, 251, 176)); // Soft Lime Green
        colors.add(new Color(245, 245, 245)); // Trắng xám nhạt
        colors.add(new Color(224, 224, 224)); // Gray Light
        colors.add(new Color(251, 207, 176)); // Light Peach
        colors.add(new Color(176, 251, 202)); // Mint Green
        colors.add(new Color(239, 176, 251)); // Lavender
        colors.add(Color.white);
        listColorNormal = colors;
        return colors;
    }

    public static void getColorGradient() {
        ArrayList<ColorTuple> colors = new ArrayList<>();
        colors.add(new ColorTuple(new Color(238, 174, 202), //
                new Color(148, 187, 233), //
                new Color(165, 232, 246), //
                new Color(156, 209, 239) //
        ));
        colors.add(new ColorTuple(new Color(255, 221, 210), // Light Peach
                new Color(255, 198, 187), // Soft Salmon
                new Color(255, 173, 173),  // Light Coral
                new Color(255, 185, 180) //
        ));
        colors.add(new ColorTuple(new Color(204, 237, 225), // Pale Aqua
                new Color(179, 229, 215), // Soft Mint
                new Color(153, 215, 200),  // Light Teal
                new Color(166, 222, 207) //
        ));
        colors.add(new ColorTuple(new Color(255, 244, 214), // Light Cream
                new Color(255, 229, 180), // Soft Apricot
                new Color(255, 216, 160),  // Pale Gold
                new Color(255, 222, 169) //
        ));
        colors.add(new ColorTuple(new Color(230, 220, 250), // Lavender Mist
                new Color(205, 195, 235), // Soft Lilac
                new Color(180, 170, 220),  // Light Mauve
                new Color(192, 182, 227) //
        ));
        colors.add(new ColorTuple(new Color(220, 230, 235), // Light Mist Blue
                new Color(200, 215, 225), // Soft Gray Blue
                new Color(180, 200, 215),  // Pale Slate Blue
                new Color(180, 212, 235) //
        ));
        colors.add(new ColorTuple(new Color(245, 235, 220), // Light Latte
                new Color(230, 215, 190), // Warm Mocha
                new Color(210, 195, 170),  // Soft Coffee Brown
                new Color(220, 205, 180) //
        ));
        colors.add(new ColorTuple(new Color(220, 235, 215), // Soft Mint Green
                new Color(200, 220, 190), // Warm Sage
                new Color(180, 200, 170),  // Pale Olive Green
                new Color(190, 210, 180) //
        ));
        colors.add(new ColorTuple(new Color(245, 220, 225), // Light Rosewood
                new Color(230, 200, 205), // Dusty Blush
                new Color(210, 180, 185),  // Warm Terracotta Pink
                new Color(220, 190, 195) //
        ));
        colors.add(new ColorTuple(new Color(255, 225, 205), // Soft Apricot
                new Color(250, 200, 175), // Warm Peach
                new Color(240, 180, 150),  // Pale Coral
                new Color(245, 190, 162) //
        ));
        colors.add(new ColorTuple(new Color(200, 220, 180), // Soft Olive Green
                new Color(225, 205, 150), // Warm Beige
                new Color(250, 190, 120),  // Pale Goldenrod
                new Color(237, 197, 135) //
        ));
        colors.add(new ColorTuple(new Color(190, 210, 220), // Cool Slate Blue
                new Color(215, 185, 160), // Warm Taupe
                new Color(230, 160, 120),  // Soft Ember Orange
                new Color(222, 172, 139) //
        ));
        colors.add(new ColorTuple(new Color(200, 230, 255), // Soft Sky Blue
                new Color(230, 200, 220), // Light Blush Pink
                new Color(250, 180, 200),  // Warm Rose
                new Color(239, 190, 210) //
        ));
        colors.add(new ColorTuple(new Color(220, 200, 180), // Light Mocha
                new Color(200, 220, 170), // Soft Olive Green
                new Color(180, 230, 160),  // Warm Pastel Green
                new Color(190, 224, 165) //
        ));
        colors.add(new ColorTuple(new Color(230, 180, 170), // Soft Sunset Red
                new Color(210, 190, 180), // Warm Beige
                new Color(190, 170, 160),  // Muted Taupe
                new Color(200, 180, 170) //
        ));
        colors.add(new ColorTuple(new Color(240, 200, 160), // Warm Sand Yellow
                new Color(220, 180, 200), // Soft Mauve
                new Color(200, 160, 230),  // Light Plum Purple
                new Color(210, 170, 214) //
        ));
        listColorGradient = colors;
    }

    public static Color colorMain = new Color(176, 223, 251);
    public static Color colorMain1 =  colorMain;
    public static Color colorMain2 =  colorMain;
    public static Color colorMain3 =  colorMain;
    public static Color colorFix =  colorMain;
    public static Color colorOpaque = new Color(0, 0, 0, 0);
}

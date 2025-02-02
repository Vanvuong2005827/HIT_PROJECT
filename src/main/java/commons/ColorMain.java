package commons;

import java.awt.*;
import java.util.ArrayList;

public class ColorMain {
    public static ArrayList<Color> listColor = new ArrayList<>();

    public ArrayList<Color> getColorMain(){
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
        listColor = colors;
        return colors;
    }

    public static Color colorMain = new Color(176, 223, 251);
}

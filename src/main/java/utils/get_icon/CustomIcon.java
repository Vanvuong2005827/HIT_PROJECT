package utils.get_icon;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class CustomIcon extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawHeart(g2d, 1, 1, 15);
    }

    private void drawHeart(Graphics2D g, int x, int y, int size) {
        g.setColor(Color.RED);

        int width = size;
        int height = size;

        GeneralPath heart = new GeneralPath();
        heart.moveTo(x, y + height / 4);
        heart.curveTo(x, y - height / 2, x + width, y - height / 2, x + width, y + height / 4);
        heart.curveTo(x + width, y + height, x + width / 2, y + height + height / 3, x + width / 2, y + height + height / 3);
        heart.curveTo(x + width / 2, y + height + height / 3, x, y + height, x, y + height / 4);
        heart.closePath();

        g.fill(heart);
    }

//    private void drawBell(Graphics2D g, int x, int y, int width, int height) {
//        g.setColor(Color.YELLOW);
//        g.fillArc(x, y, width, height, 0, 180);
//        g.fillRect(x + width / 4, y + height / 2, width / 2, height / 3);
//        g.setColor(Color.BLACK);
//        g.fillOval(x + width / 2 - 5, y + height - 10, 10, 10);
//    }
}

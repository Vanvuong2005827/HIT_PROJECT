package utils.get_color;

import javax.swing.*;
import java.awt.*;

public class Gradient extends JPanel {
    private Color color1;
    private Color color2;
    private Color color3;

    public Gradient(Color color1, Color color2, Color color3) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        GradientPaint gradient1 = new GradientPaint(0, 0, color1, 0, height / 2, color2);
        g2d.setPaint(gradient1);
        g2d.fillRect(0, 0, width, height / 2);

        GradientPaint gradient2 = new GradientPaint(0, height / 2, color2, 0, height, color3);
        g2d.setPaint(gradient2);
        g2d.fillRect(0, height / 2, width, height / 2);
    }
}
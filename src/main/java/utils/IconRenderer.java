package utils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class IconRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);

        if (value instanceof Icon) {
            label.setIcon((Icon) value);
        } else {
            label.setIcon(null);
        }

        if (isSelected) {
            label.setBackground(table.getSelectionBackground());
        } else {
            label.setBackground(Color.WHITE);
        }
        label.setOpaque(true);
        return label;
    }

    public static void setIconRenderer(JTable table, int columnIndex) {
        table.getColumnModel().getColumn(columnIndex).setCellRenderer(new IconRenderer());
    }
}

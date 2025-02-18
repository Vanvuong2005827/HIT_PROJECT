package controllers.admin;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import view.admin_view.home_screens.ListUserScreen;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListUserController {
    private ListUserScreen listUserScreen;
    private DefaultTableModel model;

    public ListUserController(ListUserScreen listUserScreen, DefaultTableModel model) {
        this.listUserScreen = listUserScreen;
        this.model = model;
        searchEvent();
        banEvent();
    }

    private void searchEvent(){
        listUserScreen.getjLabel2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                scrollToMatchingRow();
            }
        });
        listUserScreen.getListUserSearchTextField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    scrollToMatchingRow();
                }
            }
        });
    }

    private void scrollToMatchingRow() {
        String searchText = listUserScreen.getListUserSearchTextField().getText().toLowerCase();
        for (int row = 0; row < listUserScreen.getjTable1().getRowCount(); row++) {
            String cellValue = listUserScreen.getjTable1().getValueAt(row, 1).toString().toLowerCase();
            if (cellValue.contains(searchText)) {
                Rectangle rect = listUserScreen.getjTable1().getCellRect(row, 0, true);
                listUserScreen.getjTable1().scrollRectToVisible(rect);
                break;
            }
        }
    }

    private void banEvent(){
        listUserScreen.getjTable1().addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = listUserScreen.getjTable1().rowAtPoint(e.getPoint());
                int col = listUserScreen.getjTable1().columnAtPoint(e.getPoint());

                if (col == 2) {
                    Icon currentIcon = (Icon) listUserScreen.getjTable1().getValueAt(row, col);
                    Icon newIcon = null;
                    if (currentIcon == IconFontSwing.buildIcon(FontAwesome.CHECK, 23, Color.GREEN)) {
                        newIcon = IconFontSwing.buildIcon(FontAwesome.BAN, 23, Color.RED);
                    } else {
                        newIcon = IconFontSwing.buildIcon(FontAwesome.CHECK, 23, Color.GREEN);
                    }
                    model.setValueAt(newIcon, row, col);

                    model.fireTableCellUpdated(row, col);
                }
            }
        });
    }
}

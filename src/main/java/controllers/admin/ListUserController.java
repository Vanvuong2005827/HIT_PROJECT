package controllers.admin;

import view.admin_view.home_screens.ChangeStatus2Screen;
import view.admin_view.home_screens.ChangeStatusScreen;
import view.admin_view.home_screens.ListUserScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static commons.CurrentUser.userAccount;
import static commons.CurrentUser.userServices;

public class ListUserController {
    private ListUserScreen listUserScreen;

    public ListUserController(ListUserScreen listUserScreen) {
        this.listUserScreen = listUserScreen;
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
        String searchText = listUserScreen.getListUserSearchTextField().getText();
        for (int row = 0; row < listUserScreen.getjTable1().getRowCount(); row++) {
            String cellValue = listUserScreen.getjTable1().getValueAt(row, 1).toString();
            if (cellValue.equals(searchText)) {
                Rectangle rect = listUserScreen.getjTable1().getCellRect(row, 0, true);
                listUserScreen.getjTable1().scrollRectToVisible(rect);

                highlightRow(listUserScreen.getjTable1(), row);
                break;
            }
        }
    }

    private void banEvent(){
        listUserScreen.getjTable1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = listUserScreen.getjTable1().rowAtPoint(e.getPoint());
                int col = listUserScreen.getjTable1().columnAtPoint(e.getPoint());

                if (col >= 1) {
                    String username = listUserScreen.getjTable1().getValueAt(row, 1).toString();
                    userAccount = userServices.getUserByUsername(username);
                    if (userAccount.getStatus().equals("BAN")){
                        ChangeStatus2Screen changeStatus2Screen = new ChangeStatus2Screen(listUserScreen);
                        changeStatus2Screen.setVisible(true);
                    }
                    else
                    {
                        ChangeStatusScreen changeStatusScreen = new ChangeStatusScreen(listUserScreen);
                        changeStatusScreen.setVisible(true);
                    }
                }
            }
        });
    }

    private void highlightRow(JTable table, int row) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int rowIndex, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, rowIndex, column);
                if (rowIndex == row && (column == 0 || column == 1)) {
                    comp.setBackground(Color.YELLOW);
                } else {
                    comp.setBackground(Color.WHITE);
                }
                return comp;
            }
        };

        for (int col = 0; col < 2; col++) {
            table.getColumnModel().getColumn(col).setCellRenderer(renderer);
        }

        table.repaint();

        new Timer(2000, e -> resetRowColor(table, row)).start();
    }

    private void resetRowColor(JTable table, int row) {
        DefaultTableCellRenderer defaultRenderer = new DefaultTableCellRenderer();
        for (int col = 0; col < 2; col++) {
            table.getColumnModel().getColumn(col).setCellRenderer(defaultRenderer);
        }
        table.repaint();
    }


}

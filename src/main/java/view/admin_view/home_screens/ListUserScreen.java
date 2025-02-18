package view.admin_view.home_screens;

import controllers.admin.ListUserController;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import models.user.UserAccount;
import services.impl.IUserServicesImpl;
import utils.IconRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;

import static commons.ColorMain.colorFix;
import static utils.IconRenderer.setIconRenderer;
import static utils.NetworkChecker.curFrame;


public class ListUserScreen extends JFrame {
    public ListUserScreen() {
        initComponents();
        addTable();
        new ListUserController(this);
        curFrame = this;
    }

    private void initComponents() {

        listUserMainPanel = new javax.swing.JPanel();
        listUserScroll = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        listUserSearchTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listUserMainPanel.setBackground(colorFix);

        String[] columnNames = {"STT", "Tên tài khoản", ""};
        Object[][] data = {};

        model = new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jTable1.setModel(model);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setRowSelectionAllowed(false);

        listUserScroll.setViewportView(jTable1);

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTable1.getTableHeader().setFont(new java.awt.Font("Segoe UI", 1, 16));
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(330);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(10);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new IconRenderer());

        jTable1.setRowHeight(30);
        jTable1.setIntercellSpacing(new Dimension(0, 10));

        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                comp.setBackground(Color.WHITE);
                return comp;
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16));
        jLabel1.setText("Tìm kiếm");

        javax.swing.GroupLayout listUserMainPanelLayout = new javax.swing.GroupLayout(listUserMainPanel);
        listUserMainPanel.setLayout(listUserMainPanelLayout);
        listUserMainPanelLayout.setHorizontalGroup(
                listUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(listUserScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(listUserMainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(listUserSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addContainerGap())
        );
        listUserMainPanelLayout.setVerticalGroup(
                listUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listUserMainPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(listUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(listUserMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(listUserSearchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(listUserScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(listUserMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(listUserMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setIcon(IconFontSwing.buildIcon(FontAwesome.SEARCH, 18, Color.black));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

        pack();
    }


    public void addTable() {
        IUserServicesImpl u = new IUserServicesImpl();
        ArrayList<UserAccount> users = u.getAllUsers();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int cnt = 1;
        for (UserAccount a : users) {
            Icon icon;
            if (a.getStatus().equals("BAN")) {
                icon = IconFontSwing.buildIcon(FontAwesome.BAN, 23, Color.RED);
            } else {
                icon = IconFontSwing.buildIcon(FontAwesome.CHECK, 23, Color.GREEN);
            }
            model.addRow(new Object[]{cnt, a.getUsername(), icon});
            cnt++;
        }
        setIconRenderer(jTable1, 2);
    }


    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel listUserMainPanel;
    private javax.swing.JScrollPane listUserScroll;
    private javax.swing.JTextField listUserSearchTextField;
    private DefaultTableModel model;

    public JPanel getListUserMainPanel() {
        return listUserMainPanel;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public JScrollPane getListUserScroll() {
        return listUserScroll;
    }

    public JTextField getListUserSearchTextField() {
        return listUserSearchTextField;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}

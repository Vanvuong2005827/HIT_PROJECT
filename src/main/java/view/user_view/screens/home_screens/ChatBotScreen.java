package view.user_view.screens.home_screens;

import controllers.other.ChatBotController;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

import javax.swing.*;
import java.awt.*;

import static commons.ColorMain.*;


public class ChatBotScreen extends JFrame {
    public ChatBotScreen() {
        initComponents();
        new ChatBotController(this);
    }

    private void initComponents() {

        chatPanel = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        chatMainPanel = new javax.swing.JPanel();
        chatScroll = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();

        jTextField1.setBorder(null);

        jLabel1.setIcon(IconFontSwing.buildIcon(FontAwesome.PAPER_PLANE, 30, Color.BLUE));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTextField1.setBackground(new Color(240, 240, 240));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        chatPanel.setBackground(colorMain2);
        mainPanel.setBackground(colorFix);

        chatScroll.setBackground(colorMain2);

        chatScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        chatScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);


        mainPanel.setLayout(new GridBagLayout());
        chatMainPanel.setPreferredSize(new Dimension(450, 720));
        chatScroll.setViewportView(mainPanel);

        javax.swing.GroupLayout newBookMainPanelLayout = new javax.swing.GroupLayout(chatMainPanel);
        chatMainPanel.setLayout(newBookMainPanelLayout);
        newBookMainPanelLayout.setHorizontalGroup(
                newBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chatScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        newBookMainPanelLayout.setVerticalGroup(
                newBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chatScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout chatPanelLayout = new javax.swing.GroupLayout(chatPanel);
        chatPanel.setLayout(chatPanelLayout);
        chatPanelLayout.setHorizontalGroup(
                chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(chatPanelLayout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(chatMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        chatPanelLayout.setVerticalGroup(
                chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(chatPanelLayout.createSequentialGroup()
                                .addComponent(chatMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(chatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 40, Short.MAX_VALUE))
        );

        jTextField1.setBorder(BorderFactory.createCompoundBorder(
                jTextField1.getBorder(),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)
        ));

        pack();
    }

    private javax.swing.JPanel chatMainPanel;
    private javax.swing.JPanel chatPanel;
    private javax.swing.JScrollPane chatScroll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel mainPanel;

    public JPanel getChatPanel() {
        return chatPanel;
    }

    public JScrollPane getChatScroll() {
        return chatScroll;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}

package screens.more_book_pages;

import screens.MoreBookScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewBookPage extends javax.swing.JFrame {
    MoreBookScreen moreBookScreen;
    public NewBookPage(MoreBookScreen m) {
        moreBookScreen = m;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        newBookMainPanel = new javax.swing.JPanel();
        newBookScrollPane = new javax.swing.JScrollPane();
        newBookPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        newBookMainPanel.setBackground(new java.awt.Color(176, 223, 251));

        newBookScrollPane.setBackground(new java.awt.Color(176, 223, 251));
        newBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        newBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        newBookPanel.setBackground(new java.awt.Color(176, 223, 251));
        newBookPanel.setLayout(new java.awt.GridBagLayout());

        newBookPanel.addMouseListener(dragScrollListenerMainScroll);
        newBookPanel.addMouseMotionListener(dragScrollListenerMainScroll);

        newBookScrollPane.setViewportView(newBookPanel);

        javax.swing.GroupLayout newBookMainPanelLayout = new javax.swing.GroupLayout(newBookMainPanel);
        newBookMainPanel.setLayout(newBookMainPanelLayout);
        newBookMainPanelLayout.setHorizontalGroup(
                newBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(newBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        newBookMainPanelLayout.setVerticalGroup(
                newBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(newBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(newBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(newBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    public JPanel newBookPanel(){
        return newBookMainPanel;
    }

    MouseAdapter dragScrollListenerMainScroll = new MouseAdapter() {
        private Point origin;
        private final int SCROLL_SPEED = 10;

        @Override
        public void mousePressed(MouseEvent e) {
            origin = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            JViewport viewport = newBookScrollPane.getViewport();
            Point viewPosition = viewport.getViewPosition();
            int deltaY = origin.y - e.getY();

            int newY = viewPosition.y + deltaY / SCROLL_SPEED;

            int maxScrollHeight = 1430;

            newY = Math.max(0, Math.min(newY, maxScrollHeight));

            viewport.setViewPosition(new Point(viewPosition.x, newY));
        }
    };

    // Variables declaration - do not modify
    private javax.swing.JPanel newBookMainPanel;
    private javax.swing.JPanel newBookPanel;
    private javax.swing.JScrollPane newBookScrollPane;
    // End of variables declaration
}

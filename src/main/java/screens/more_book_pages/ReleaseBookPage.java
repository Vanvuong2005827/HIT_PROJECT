package screens.more_book_pages;

import models.book_information.Book;
import models.GetAllBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static commons.customBookGridPanel.customBookGrid1;

public class ReleaseBookPage extends javax.swing.JFrame {

    public ReleaseBookPage() {
        initComponents();
        releaseBookProcess();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        releaseBookMainPanel = new javax.swing.JPanel();
        releaseBookScrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        releaseBookMainPanel.setBackground(new java.awt.Color(176, 223, 251));

        releaseBookScrollPane.setBackground(new java.awt.Color(176, 223, 251));
        releaseBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        releaseBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mainPanel.setBackground(new java.awt.Color(176, 223, 251));

        mainPanel.setLayout(new java.awt.GridBagLayout());
        releaseBookScrollPane.setViewportView(mainPanel);

        javax.swing.GroupLayout newBookMainPanelLayout = new javax.swing.GroupLayout(releaseBookMainPanel);
        releaseBookMainPanel.setLayout(newBookMainPanelLayout);
        newBookMainPanelLayout.setHorizontalGroup(
                newBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(releaseBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        newBookMainPanelLayout.setVerticalGroup(
                newBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBookMainPanelLayout.createSequentialGroup()
                                .addComponent(releaseBookScrollPane)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(releaseBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(releaseBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    public void releaseBookProcess(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        GetAllBook lb = new GetAllBook();
        ArrayList<Book> books = lb.getBooksDangPhatHanh();
        Font customFont1 = new Font("Segoe UI", Font.BOLD, 13);
        String baseUrl = "https://img.otruyenapi.com/uploads/comics/";
        Color cusColor = mainPanel.getBackground();


        for(int i = 0; i < books.size() - 1; i++){
            JPanel childPanel = customBookGrid1(i, 400, 190, 114, 187, books, cusColor, baseUrl, customFont1, false);
            gbc.gridx = 1;
            gbc.gridy = i;
            mainPanel.add(childPanel, gbc);
        }
        mainPanel.revalidate();
        mainPanel.repaint();
        mainPanel.addMouseListener(dragScrollListenerMainScroll);
        mainPanel.addMouseMotionListener(dragScrollListenerMainScroll);
    }

    public JPanel releaseBookPanel(){
        return releaseBookMainPanel;
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
            JViewport viewport = releaseBookScrollPane.getViewport();
            Point viewPosition = viewport.getViewPosition();
            int deltaY = origin.y - e.getY();

            int newY = viewPosition.y + deltaY / SCROLL_SPEED;

            int maxScrollHeight = 400 * 24;

            newY = Math.max(0, Math.min(newY, maxScrollHeight));

            viewport.setViewPosition(new Point(viewPosition.x, newY));
        }
    };

    // Variables declaration - do not modify
    private javax.swing.JPanel releaseBookMainPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane releaseBookScrollPane;
    // End of variables declaration
}


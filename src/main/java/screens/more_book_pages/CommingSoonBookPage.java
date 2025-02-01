package screens.more_book_pages;

import models.book_information.Book;
import screens.MoreBookScreen;
import utils.GetAllBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.*;

import static utils.customBookGridPanel.customBookGrid1;

public class CommingSoonBookPage extends javax.swing.JFrame {
    MoreBookScreen moreBookScreen;
    int totalBooks;
    public CommingSoonBookPage(MoreBookScreen m) {
        moreBookScreen = m;
        initComponents();
    }

    private void initComponents() {

        commingSoonBookMainPanel = new javax.swing.JPanel();
        commingSoonBookScrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        commingSoonBookMainPanel.setBackground(new java.awt.Color(176, 223, 251));

        commingSoonBookScrollPane.setBackground(new java.awt.Color(176, 223, 251));
        commingSoonBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        commingSoonBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mainPanel.setBackground(new java.awt.Color(176, 223, 251));

        mainPanel.setLayout(new java.awt.GridBagLayout());
        commingSoonBookScrollPane.setViewportView(mainPanel);

        javax.swing.GroupLayout newBookMainPanelLayout = new javax.swing.GroupLayout(commingSoonBookMainPanel);
        commingSoonBookMainPanel.setLayout(newBookMainPanelLayout);
        newBookMainPanelLayout.setHorizontalGroup(
                newBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(commingSoonBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        newBookMainPanelLayout.setVerticalGroup(
                newBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBookMainPanelLayout.createSequentialGroup()
                                .addComponent(commingSoonBookScrollPane)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(commingSoonBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(commingSoonBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public void processCommingSoonBook(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        GetAllBook lb = new GetAllBook();
        ArrayList<Book> books = lb.getBooksSapRaMat(2);
        Font customFont1 = new Font("Segoe UI", Font.BOLD, 13);
        String baseUrl = "https://img.otruyenapi.com/uploads/comics/";
        Color cusColor = mainPanel.getBackground();

        totalBooks = books.size();
        int maxThreads = 80;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        ArrayList<Future<JPanel>> futures = new ArrayList<>();
        for (int i = 0; i < totalBooks; i++) {
            int index = i;
            Callable<JPanel> task = () -> {
                return customBookGrid1(moreBookScreen, index, 400, 190, 114, 187, books, cusColor, baseUrl, customFont1, mainPanel);
            };
            futures.add(executor.submit(task));
        }
        for (int i = 0; i < futures.size(); i++) {
            try {
                JPanel panel = futures.get(i).get();
                final int x = 1;
                final int y = i;
                SwingUtilities.invokeLater(() -> {
                    GridBagConstraints gbcPanel = (GridBagConstraints) gbc.clone();
                    gbcPanel.gridx = x;
                    gbcPanel.gridy = y;
                    mainPanel.add(panel, gbcPanel);
                    mainPanel.revalidate();
                    mainPanel.repaint();
                });
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        mainPanel.addMouseListener(dragScrollListenerMainScroll);
        mainPanel.addMouseMotionListener(dragScrollListenerMainScroll);
    }

    public JPanel commingSoonBookPanel(){
        return commingSoonBookMainPanel;
    }

    MouseAdapter dragScrollListenerMainScroll = new MouseAdapter() {
        private Point origin;
        private final int SCROLL_SPEED = 1;

        @Override
        public void mousePressed(MouseEvent e) {
            origin = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            JViewport viewport = commingSoonBookScrollPane.getViewport();
            Point viewPosition = viewport.getViewPosition();
            int deltaY = origin.y - e.getY();

            int newY = viewPosition.y + deltaY * SCROLL_SPEED;

            int maxScrollHeight = 400 * totalBooks;

            newY = Math.max(0, Math.min(newY, maxScrollHeight));

            viewport.setViewPosition(new Point(viewPosition.x, newY));
        }
    };

    private javax.swing.JPanel commingSoonBookMainPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane commingSoonBookScrollPane;
}

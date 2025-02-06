package view.screens.home_screens;

import controllers.book.SearchController;
import models.book.Book;
import utils.Gradient;
import data.GetAllBook;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.*;

import static commons.ColorMain.*;
import static utils.CustomBookGridPanel.customBookGrid1;
import static utils.NetworkChecker.curFrame;

public class SearchScreen extends JFrame {
    private JFrame searchPage = this;
    private JFrame previousScreen;
    private int totalBooks;

    public SearchScreen(JFrame j) {
        previousScreen = j;
        initComponents();
        setLocationRelativeTo(null);
        new SearchController(this, previousScreen);
        curFrame = this;
    }

    private void initComponents() {
        searchMainPanel = new javax.swing.JPanel();
        searchBackLabel = new javax.swing.JLabel();
        searchSearchTextField = new javax.swing.JTextField();
        searchSearchLabel = new javax.swing.JLabel();
        searchScrollPane = new javax.swing.JScrollPane();
        mainPanel = new Gradient(colorMain1, colorMain2, colorMain3);
        searchKeywordLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        searchMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBackLabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        searchBackLabel.setText("<");

        searchMainPanel.add(searchBackLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 50));

        searchSearchTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        searchMainPanel.add(searchSearchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 330, 33));

        searchSearchLabel.setFont(new java.awt.Font("Segoe UI", 1, 12));
        searchSearchLabel.setText("Tìm kiếm");
        searchMainPanel.add(searchSearchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 60, 30));

        mainPanel.setLayout(new java.awt.GridBagLayout());
        searchScrollPane.setViewportView(mainPanel);

        searchMainPanel.add(searchScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 450, 690));

        searchKeywordLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchMainPanel.add(searchKeywordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 430, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(searchMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(searchMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        searchMainPanel.setBackground(colorMain2);
        searchScrollPane.setBackground(colorMain2);
        searchScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        searchScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pack();
    }

    public void processSeachBook(String keyword) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        GetAllBook lb = new GetAllBook();
        ArrayList<Book> books = lb.getBooksTheoKeywords(keyword, searchKeywordLabel);
        Font customFont1 = new Font("Segoe UI", Font.BOLD, 13);
        String baseUrl = "https://img.otruyenapi.com/uploads/comics/";

        totalBooks = books.size();
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        ArrayList<Future<JPanel>> futures = new ArrayList<>();
        for (int i = 0; i < totalBooks; i++) {
            int index = i;
            Callable<JPanel> task = () -> {
                return customBookGrid1(searchPage, index, 400, 190, 114, 187, books, colorOpaque, baseUrl, customFont1, mainPanel);
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
                });
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        mainPanel.revalidate();
        mainPanel.repaint();
        mainPanel.addMouseListener(dragScrollListenerMainScroll);
        mainPanel.addMouseMotionListener(dragScrollListenerMainScroll);
    }

    private MouseAdapter dragScrollListenerMainScroll = new MouseAdapter() {
        private Point origin;
        private final double SCROLL_FACTOR = 1.0;
        private final int MAX_DELTA = 80;
        private int velocity = 0;
        private Timer inertiaTimer;

        @Override
        public void mousePressed(MouseEvent e) {
            origin = e.getPoint();
            if (inertiaTimer != null && inertiaTimer.isRunning()) {
                inertiaTimer.stop();
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (origin == null) return;

            JViewport viewport = searchScrollPane.getViewport();
            Point viewPosition = viewport.getViewPosition();

            int deltaY = origin.y - e.getY();
            deltaY = (int) Math.signum(deltaY) * Math.min(MAX_DELTA, Math.abs((int) (deltaY * SCROLL_FACTOR)));

            velocity = deltaY;

            int newY = viewPosition.y + deltaY;
            Component view = viewport.getView();
            int maxScrollHeight = view.getHeight() - viewport.getHeight();

            newY = Math.max(0, Math.min(newY, maxScrollHeight));

            int finalNewY = newY;
            SwingUtilities.invokeLater(() -> viewport.setViewPosition(new Point(viewPosition.x, finalNewY)));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            origin = null;
            applyInertia();
        }

        private void applyInertia() {
            inertiaTimer = new Timer(16, event -> {
                if (Math.abs(velocity) < 1) {
                    ((Timer) event.getSource()).stop();
                    return;
                }

                JViewport viewport = searchScrollPane.getViewport();
                Point viewPosition = viewport.getViewPosition();
                int newY = viewPosition.y + velocity;
                Component view = viewport.getView();
                int maxScrollHeight = view.getHeight() - viewport.getHeight();
                newY = Math.max(0, Math.min(newY, maxScrollHeight));

                int finalNewY = newY;
                SwingUtilities.invokeLater(() -> viewport.setViewPosition(new Point(viewPosition.x, finalNewY)));

                velocity *= 0.9;
            });
            inertiaTimer.start();
        }
    };

    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel searchBackLabel;
    private javax.swing.JLabel searchKeywordLabel;
    private javax.swing.JPanel searchMainPanel;
    private javax.swing.JScrollPane searchScrollPane;
    private javax.swing.JLabel searchSearchLabel;
    private javax.swing.JTextField searchSearchTextField;

    public JTextField getSearchSearchTextField() {
        return searchSearchTextField;
    }

    public JLabel getSearchSearchLabel() {
        return searchSearchLabel;
    }

    public JLabel getSearchKeywordLabel() {
        return searchKeywordLabel;
    }

    public JLabel getSearchBackLabel() {
        return searchBackLabel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public int getTotalBooks() {
        return totalBooks;
    }
}

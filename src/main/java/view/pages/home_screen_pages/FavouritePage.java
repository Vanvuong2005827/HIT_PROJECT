package view.pages.home_screen_pages;

import models.book_information.Book;
import view.screens.main_screens.HomeScreen;
import services.BookService;
import utils.Gradient;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.*;

import static commons.ColorMain.*;
import static commons.ColorMain.colorFix;
import static utils.CustomBookGridPanel.customBookGrid1;

public class FavouritePage extends javax.swing.JFrame {
    private HomeScreen homeScreen;
    private int totalBooks;

    public FavouritePage(HomeScreen hs) {
        homeScreen = hs;
        initComponents();
    }

    private void initComponents() {

        favouriteBookMainPanel = new javax.swing.JPanel();
        favouriteBookScrollPane = new javax.swing.JScrollPane();
        mainPanel = new Gradient(colorMain1, colorMain2, colorMain3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        favouriteBookMainPanel.setBackground(colorFix);
        favouriteBookScrollPane.setBackground(colorFix);

        favouriteBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        favouriteBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mainPanel.setLayout(new java.awt.GridBagLayout());
        favouriteBookScrollPane.setViewportView(mainPanel);

        javax.swing.GroupLayout favouriteBookMainPanelLayout = new javax.swing.GroupLayout(favouriteBookMainPanel);
        favouriteBookMainPanel.setLayout(favouriteBookMainPanelLayout);
        favouriteBookMainPanelLayout.setHorizontalGroup(favouriteBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(favouriteBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));
        favouriteBookMainPanelLayout.setVerticalGroup(favouriteBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(favouriteBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(favouriteBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(favouriteBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        pack();
    }

    private MouseAdapter dragScrollListenerMainScroll = new MouseAdapter() {
        private Point origin;
        private final double SCROLL_FACTOR = 1.5;
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

            JViewport viewport = favouriteBookScrollPane.getViewport();
            Point viewPosition = viewport.getViewPosition();

            int deltaY = origin.y - e.getY();
            deltaY = (int) Math.signum(deltaY) * Math.min(MAX_DELTA, Math.abs((int) (deltaY * SCROLL_FACTOR)));

            velocity = deltaY;

            int newY = viewPosition.y + deltaY;
            int maxScrollHeight = 400 * totalBooks;

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

                JViewport viewport = favouriteBookScrollPane.getViewport();
                Point viewPosition = viewport.getViewPosition();
                int newY = viewPosition.y + velocity;
                int maxScrollHeight = 400 * totalBooks;
                newY = Math.max(0, Math.min(newY, maxScrollHeight));

                int finalNewY = newY;
                SwingUtilities.invokeLater(() -> viewport.setViewPosition(new Point(viewPosition.x, finalNewY)));

                velocity *= 0.9;
            });
            inertiaTimer.start();
        }
    };

    public void processFavouriteBook() {
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        BookService bookService = new BookService();
        ArrayList<Book> books = bookService.getAllFavorites();
        Font customFont1 = new Font("Segoe UI", Font.BOLD, 13);
        String baseUrl = "https://img.otruyenapi.com/uploads/comics/";
        totalBooks = books.size();
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        ArrayList<Future<JPanel>> futures = new ArrayList<>();
        for (int i = 0; i < totalBooks; i++) {
            int index = i;
            Callable<JPanel> task = () -> {
                return customBookGrid1(homeScreen, index, 450, 190, 114, 187, books, colorOpaque, baseUrl, customFont1, mainPanel);
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
        mainPanel.removeMouseListener(dragScrollListenerMainScroll);
        mainPanel.removeMouseMotionListener(dragScrollListenerMainScroll);

        mainPanel.addMouseListener(dragScrollListenerMainScroll);
        mainPanel.addMouseMotionListener(dragScrollListenerMainScroll);
    }

    public JPanel favouritePanel() {
        return favouriteBookMainPanel;
    }

    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel favouriteBookMainPanel;
    private javax.swing.JScrollPane favouriteBookScrollPane;
}

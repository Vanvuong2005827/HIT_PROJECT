package view.screens.home_screens;

import controllers.book.FavouriteController;
import models.book.Book;
import services.BookService;
import utils.Gradient;
import view.pages.HomePage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.*;

import static commons.ColorMain.*;
import static commons.ColorMain.colorFix;
import static utils.CustomBookGridPanel.customBookGrid1;

public class FavouriteScreen extends javax.swing.JFrame {
    private HomePage homeScreen;
    private int totalBooks;

    public FavouriteScreen(HomePage hs) {
        homeScreen = hs;
        initComponents();
        new FavouriteController(this);
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
    }

    public JPanel favouritePanel() {
        return favouriteBookMainPanel;
    }

    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel favouriteBookMainPanel;
    private javax.swing.JScrollPane favouriteBookScrollPane;

    public JScrollPane getFavouriteBookScrollPane() {
        return favouriteBookScrollPane;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}

package view.screens.more_book_screens;

import controllers.book.CommingSoonBookController;
import models.book.Book;
import data.GetAllBook;
import utils.Gradient;
import view.pages.MoreBookPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.*;

import static commons.ColorMain.*;
import static utils.CustomBookGridPanel.customBookGrid1;

public class CommingSoonBookScreen extends javax.swing.JFrame {
    private MoreBookPage moreBookScreen;
    private int totalBooks;

    public CommingSoonBookScreen(MoreBookPage m) {
        moreBookScreen = m;
        initComponents();
        new CommingSoonBookController(this);
    }

    private void initComponents() {
        commingSoonBookMainPanel = new javax.swing.JPanel();
        commingSoonBookScrollPane = new javax.swing.JScrollPane();
        mainPanel = new Gradient(colorMain1, colorMain2, colorMain3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        commingSoonBookMainPanel.setBackground(colorMain2);

        commingSoonBookScrollPane.setBackground(colorMain2);
        commingSoonBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        commingSoonBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mainPanel.setLayout(new java.awt.GridBagLayout());
        commingSoonBookScrollPane.setViewportView(mainPanel);

        javax.swing.GroupLayout commingSoonBookMainPanelLayout = new javax.swing.GroupLayout(commingSoonBookMainPanel);
        commingSoonBookMainPanel.setLayout(commingSoonBookMainPanelLayout);
        commingSoonBookMainPanelLayout.setHorizontalGroup(
                commingSoonBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(commingSoonBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        commingSoonBookMainPanelLayout.setVerticalGroup(
                commingSoonBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(commingSoonBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
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

    public void processCommingSoonBook() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        GetAllBook lb = new GetAllBook();
        ArrayList<Book> books = lb.getBooksSapRaMat(2);
        Font customFont1 = new Font("Segoe UI", Font.BOLD, 13);
        String baseUrl = "https://img.otruyenapi.com/uploads/comics/";

        totalBooks = books.size();
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        ArrayList<Future<JPanel>> futures = new ArrayList<>();
        for (int i = 0; i < totalBooks; i++) {
            int index = i;
            Callable<JPanel> task = () -> {
                return customBookGrid1(moreBookScreen, index, 400, 190, 114, 187, books, colorOpaque, baseUrl, customFont1, mainPanel);
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
    }

    public JPanel commingSoonBookPanel() {
        return commingSoonBookMainPanel;
    }

    private javax.swing.JPanel commingSoonBookMainPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane commingSoonBookScrollPane;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JScrollPane getCommingSoonBookScrollPane() {
        return commingSoonBookScrollPane;
    }
}

package view.screens.more_book_screens;

import controllers.book.CommingSoonBookController;
import controllers.book.CompletedBookController;
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

public class CompletedBookScreen extends javax.swing.JFrame {
    private MoreBookPage moreBookScreen;
    private int totalBooks;
    public CompletedBookScreen(MoreBookPage m) {
        moreBookScreen = m;
        initComponents();
        new CompletedBookController(this);
    }

    private void initComponents() {

        completedBookMainPanel = new javax.swing.JPanel();
        completedBookScrollPane = new javax.swing.JScrollPane();
        mainPanel = new Gradient(colorMain1, colorMain2, colorMain3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        completedBookMainPanel.setBackground(colorMain2);

        completedBookScrollPane.setBackground(colorMain2);
        completedBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        completedBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mainPanel.setLayout(new java.awt.GridBagLayout());
        completedBookScrollPane.setViewportView(mainPanel);

        javax.swing.GroupLayout completedBookMainPanelLayout = new javax.swing.GroupLayout(completedBookMainPanel);
        completedBookMainPanel.setLayout(completedBookMainPanelLayout);
        completedBookMainPanelLayout.setHorizontalGroup(
                completedBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(completedBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        completedBookMainPanelLayout.setVerticalGroup(
                completedBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(completedBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(completedBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(completedBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public void processCompletedBook(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        GetAllBook lb = new GetAllBook();
        ArrayList<Book> books = lb.getBooksHoanThanh(2);
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

    public JPanel completedBookPanel(){
        return completedBookMainPanel;
    }

    private javax.swing.JPanel completedBookMainPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane completedBookScrollPane;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JScrollPane getCompletedBookScrollPane() {
        return completedBookScrollPane;
    }
}


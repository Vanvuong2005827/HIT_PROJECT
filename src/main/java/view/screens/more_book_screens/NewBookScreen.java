package view.screens.more_book_screens;

import controllers.book.NewBookController;
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

public class NewBookScreen extends javax.swing.JFrame {
    private MoreBookPage moreBookScreen;
    private int totalBooks;

    public NewBookScreen(MoreBookPage m) {
        moreBookScreen = m;
        initComponents();
        new NewBookController(this);
    }

    private void initComponents() {

        newBookMainPanel = new javax.swing.JPanel();
        newBookScrollPane = new javax.swing.JScrollPane();
        mainPanel = new Gradient(colorMain1, colorMain2, colorMain3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        newBookMainPanel.setBackground(colorMain2);

        newBookScrollPane.setBackground(colorMain2);

        newBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        newBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);


        mainPanel.setLayout(new java.awt.GridBagLayout());
        newBookScrollPane.setViewportView(mainPanel);

        javax.swing.GroupLayout newBookMainPanelLayout = new javax.swing.GroupLayout(newBookMainPanel);
        newBookMainPanel.setLayout(newBookMainPanelLayout);
        newBookMainPanelLayout.setHorizontalGroup(
                newBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(newBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        newBookMainPanelLayout.setVerticalGroup(
                newBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(newBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
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
    }

    public void processNewBook() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        GetAllBook lb = new GetAllBook();
        ArrayList<Book> books = lb.getBooksTruyenMoi(2);
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
                });
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public JPanel newBookPanel() {
        return newBookMainPanel;
    }

    private javax.swing.JPanel newBookMainPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane newBookScrollPane;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JScrollPane getNewBookScrollPane() {
        return newBookScrollPane;
    }
}

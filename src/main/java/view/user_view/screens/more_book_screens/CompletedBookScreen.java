package view.user_view.screens.more_book_screens;

import controllers.book.CompletedBookController;
import models.book.Book;
import data.GetAllBook;
import utils.Gradient;
import view.user_view.pages.MoreBookPage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.*;

import static commons.ColorMain.*;
import static utils.CustomBookGridPanel.customBookGrid1;
import static utils.NetworkChecker.isConnected;

public class CompletedBookScreen extends javax.swing.JFrame {
    private MoreBookPage moreBookScreen;
    private JLabel loadingLabel = new JLabel("Loading...", SwingConstants.CENTER);
    private boolean isLoading = false;
    int curPage = 0;

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

    public void processCompletedBook() {
        if (isLoading) return;

        curPage++;
        isLoading = true;
        loadingLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loadingLabel.setForeground(Color.GRAY);

        SwingUtilities.invokeLater(() -> {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.0;
            gbc.gridx = 1;
            gbc.gridy = mainPanel.getComponentCount();

            mainPanel.add(loadingLabel, gbc);
            mainPanel.revalidate();
            mainPanel.repaint();
        });

        SwingWorker<ArrayList<JPanel>, Void> worker = new SwingWorker<>() {
            @Override
            protected ArrayList<JPanel> doInBackground() throws Exception {
                GetAllBook lb = new GetAllBook();
                ArrayList<Book> books = lb.getBooksHoanThanh(curPage);
                ArrayList<JPanel> bookPanels = new ArrayList<>();
                String baseUrl = "https://img.otruyenapi.com/uploads/comics/";
                Font customFont1 = new Font("Segoe UI", Font.BOLD, 13);

                ExecutorService executor = Executors.newFixedThreadPool(10);
                ArrayList<Future<JPanel>> futures = new ArrayList<>();

                for (int i = 0; i < books.size(); i++) {
                    int index = i;
                    Callable<JPanel> task = () -> customBookGrid1(moreBookScreen, index, 400, 190, 114, 187, books, colorOpaque, baseUrl, customFont1, mainPanel);
                    futures.add(executor.submit(task));
                }

                for (Future<JPanel> future : futures) {
                    bookPanels.add(future.get());
                }

                executor.shutdown();
                return bookPanels;
            }

            @Override
            protected void done() {
                if (!isConnected) {return;}
                try {
                    ArrayList<JPanel> bookPanels = get();

                    SwingUtilities.invokeLater(() -> {
                        mainPanel.remove(loadingLabel);
                        for (JPanel panel : bookPanels) {
                            GridBagConstraints gbc = new GridBagConstraints();
                            gbc.fill = GridBagConstraints.BOTH;
                            gbc.weightx = 1.0;
                            gbc.gridx = 1;
                            gbc.gridy = mainPanel.getComponentCount();
                            mainPanel.add(panel, gbc);
                        }
                        mainPanel.revalidate();
                        mainPanel.repaint();
                        isLoading = false;
                    });
                } catch (Exception e) {
                    loadingLabel.setText("Không lấy được dữ liệu");
                    isLoading = false;
                }
            }
        };
        worker.execute();
    }

    public JPanel completedBookPanel() {
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


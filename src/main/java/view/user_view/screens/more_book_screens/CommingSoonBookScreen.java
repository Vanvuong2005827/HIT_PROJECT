package view.user_view.screens.more_book_screens;

import controllers.book.CommingSoonBookController;
import models.book.Book;
import data.GetAllBook;
import utils.Gradient;
import view.user_view.screens.pages.MoreBookPage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.*;

import static commons.ColorMain.*;
import static utils.CustomBookGridPanel.customBookGrid1;
import static utils.NetworkChecker.isConnected;

public class CommingSoonBookScreen extends javax.swing.JFrame {
    private MoreBookPage moreBookScreen;
    private JLabel loadingLabel = new JLabel("Loading...", SwingConstants.CENTER);
    private boolean isLoading = false;
    int curPage = 0;

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
                ArrayList<Book> books = lb.getBooksSapRaMat(curPage);
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

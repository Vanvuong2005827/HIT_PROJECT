
package view.screens.home_screens;

import controllers.book.RecentController;
import data.GetAllBook;
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
import static utils.CustomBookGridPanel.customBookGrid1;
import static utils.NetworkChecker.isConnected;


public class RecentScreen extends javax.swing.JFrame {
    private HomePage homeScreen;
    private JLabel loadingLabel = new JLabel("Loading...", SwingConstants.CENTER);
    private boolean isLoading = false;
    private int curPage = 0;

    public RecentScreen(HomePage hs) {
        homeScreen = hs;
        initComponents();
        new RecentController(this);
    }

    private void initComponents() {

        recentBookMainPanel = new javax.swing.JPanel();
        recentBookScrollPane = new javax.swing.JScrollPane();
        mainPanel = new Gradient(colorMain1, colorMain2, colorMain3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        recentBookMainPanel.setBackground(colorFix);
        recentBookScrollPane.setBackground(colorFix);

        recentBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        recentBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mainPanel.setLayout(new java.awt.GridBagLayout());
        recentBookScrollPane.setViewportView(mainPanel);

        javax.swing.GroupLayout recentBookMainPanelLayout = new javax.swing.GroupLayout(recentBookMainPanel);
        recentBookMainPanel.setLayout(recentBookMainPanelLayout);
        recentBookMainPanelLayout.setHorizontalGroup(
                recentBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(recentBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        recentBookMainPanelLayout.setVerticalGroup(
                recentBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(recentBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(recentBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(recentBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public void processRecentBook() {
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
                BookService bookService = new BookService();
                ArrayList<Book> books = bookService.getBooksByPage(curPage, 4);
                ArrayList<JPanel> bookPanels = new ArrayList<>();
                String baseUrl = "https://img.otruyenapi.com/uploads/comics/";
                Font customFont1 = new Font("Segoe UI", Font.BOLD, 13);

                ExecutorService executor = Executors.newFixedThreadPool(10);
                ArrayList<Future<JPanel>> futures = new ArrayList<>();

                for (int i = 0; i < books.size(); i++) {
                    int index = i;
                    Callable<JPanel> task = () -> customBookGrid1(homeScreen, index, 450, 190, 114, 187, books, colorOpaque, baseUrl, customFont1, mainPanel);
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
                    if (bookPanels.isEmpty()) {
                        loadingLabel.setText("Danh sách trống");
                        isLoading = false;
                        return;
                    }
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

    public JPanel recentPanel() {
        return recentBookMainPanel;
    }

    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel recentBookMainPanel;
    private javax.swing.JScrollPane recentBookScrollPane;

    public JScrollPane getRecentBookScrollPane() {
        return recentBookScrollPane;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }
}

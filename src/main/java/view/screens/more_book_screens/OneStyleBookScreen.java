package view.screens.more_book_screens;

import controllers.book.OneStyleBookController;
import models.book.Book;
import data.GetAllBook;
import utils.Gradient;
import view.screens.WaitScreen;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.*;

import static commons.ColorMain.*;
import static utils.CustomBookGridPanel.customBookGrid1;
import static utils.NetworkChecker.curFrame;
import static utils.NetworkChecker.isConnected;

public class OneStyleBookScreen extends javax.swing.JFrame {
    private String nameStyle;
    private JFrame previousScreen;
    private OneStyleBookScreen oneStyleBookPage = this;
    private JLabel loadingLabel = new JLabel("Loading...", SwingConstants.CENTER);
    private boolean isLoading = false;
    int curPage = 0;

    public OneStyleBookScreen(JFrame hs, String n, String nn) {
        previousScreen = hs;
        nameStyle = n;
        initComponents();
        jLabel2.setText(nn);
        processData();
        setLocationRelativeTo(null);
        new OneStyleBookController(this);
        curFrame = this;
    }

    private void initComponents() {

        styleBookMainPanel = new javax.swing.JPanel();
        styleBookScrollPane = new javax.swing.JScrollPane();
        mainPanel = new Gradient(colorMain1, colorMain2, colorMain3);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        styleBookScrollPane.setBorder(null);
        styleBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        styleBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mainPanel.setLayout(new java.awt.GridBagLayout());
        styleBookScrollPane.setViewportView(mainPanel);
        styleBookMainPanel.setBackground(colorMain1);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(styleBookMainPanel);
        styleBookMainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(styleBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE));
        mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup().addComponent(styleBookScrollPane).addContainerGap()));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setText("<");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backEvent(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18));
        javax.swing.GroupLayout styleBookMainPanelLayout = new javax.swing.GroupLayout(styleBookMainPanel);
        styleBookMainPanel.setLayout(styleBookMainPanelLayout);
        styleBookMainPanelLayout.setHorizontalGroup(styleBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(styleBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE).addGroup(styleBookMainPanelLayout.createSequentialGroup().addContainerGap().addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(123, 123, 123)));
        styleBookMainPanelLayout.setVerticalGroup(styleBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, styleBookMainPanelLayout.createSequentialGroup().addGroup(styleBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(styleBookMainPanelLayout.createSequentialGroup().addContainerGap().addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(styleBookScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(styleBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(styleBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }

    private void backEvent(java.awt.event.MouseEvent evt) {
        previousScreen.setVisible(true);
        oneStyleBookPage.setVisible(false);
    }

    public void processData() {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                processStyleBook();
                return null;
            }

            @Override
            protected void done() {
                oneStyleBookPage.setVisible(true);
            }
        };

        worker.execute();
    }

    public void processStyleBook() {
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
                ArrayList<Book> books = lb.getBooksTungTheLoai(curPage, nameStyle);
                ArrayList<JPanel> bookPanels = new ArrayList<>();
                String baseUrl = "https://img.otruyenapi.com/uploads/comics/";
                Font customFont1 = new Font("Segoe UI", Font.BOLD, 13);

                ExecutorService executor = Executors.newFixedThreadPool(10);
                ArrayList<Future<JPanel>> futures = new ArrayList<>();

                for (int i = 0; i < books.size(); i++) {
                    int index = i;
                    Callable<JPanel> task = () -> customBookGrid1(oneStyleBookPage, index, 400, 190, 114, 187, books, colorOpaque, baseUrl, customFont1, mainPanel);
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

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel styleBookMainPanel;
    private javax.swing.JScrollPane styleBookScrollPane;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JScrollPane getStyleBookScrollPane() {
        return styleBookScrollPane;
    }
}

package screens.more_book_pages;

import models.book_information.Book;
import screens.main_screens.WaitScreen;
import utils.get_data.GetAllBook;
import utils.get_color.Gradient;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.*;

import static commons.ColorMain.*;
import static utils.CustomBookGridPanel.customBookGrid1;

public class StyleBookScreen extends javax.swing.JFrame {
    private String nameStyle;
    private JFrame previousScreen;
    private WaitScreen waitScreen;
    private StyleBookScreen styleBookScreen = this;
    private int totalBooks;

    public StyleBookScreen(JFrame hs, String n, String nn, WaitScreen w) {
        previousScreen = hs;
        nameStyle = n;
        waitScreen = w;
        initComponents();
        jLabel2.setText(nn);
        processData();
        setLocationRelativeTo(null);
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
        styleBookScreen.setVisible(false);
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
                styleBookScreen.setVisible(true);
                waitScreen.setVisible(false);
            }
        };

        worker.execute();
    }

    public void processStyleBook() {
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        GetAllBook lb = new GetAllBook();
        ArrayList<Book> books = lb.getBooksTungTheLoai(2, nameStyle);
        Font customFont1 = new Font("Segoe UI", Font.BOLD, 13);
        String baseUrl = "https://img.otruyenapi.com/uploads/comics/";

        totalBooks = books.size();
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        ArrayList<Future<JPanel>> futures = new ArrayList<>();
        for (int i = 0; i < totalBooks; i++) {
            int index = i;
            Callable<JPanel> task = () -> {
                return customBookGrid1(styleBookScreen, index, 450, 190, 114, 187, books, colorOpaque, baseUrl, customFont1, mainPanel);
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

            JViewport viewport = styleBookScrollPane.getViewport();
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

                JViewport viewport = styleBookScrollPane.getViewport();
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

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel styleBookMainPanel;
    private javax.swing.JScrollPane styleBookScrollPane;
}

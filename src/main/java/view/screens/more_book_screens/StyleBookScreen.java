package view.screens.more_book_screens;

import commons.ColorMain;
import controllers.book.StyleBookController;
import models.book.Book;
import data.GetAllBook;
import utils.Gradient;
import view.screens.WaitScreen;
import view.pages.MoreBookPage;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.concurrent.*;

import static commons.ColorMain.*;
import static commons.ColorMain.colorMain3;

public class StyleBookScreen extends javax.swing.JFrame {
    private MoreBookPage moreBookScreen;
    private int totalBooks;

    public StyleBookScreen(MoreBookPage m) {
        moreBookScreen = m;
        initComponents();
        new StyleBookController(this);
    }

    private void initComponents() {

        styleBookMainPanel = new javax.swing.JPanel();
        styleBookScrollPane = new javax.swing.JScrollPane();
        mainPanel = new Gradient(colorMain1, colorMain2, colorMain3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        styleBookMainPanel.setBackground(colorMain2);

        styleBookScrollPane.setBackground(colorMain2);
        styleBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        styleBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mainPanel.setLayout(new java.awt.GridBagLayout());
        styleBookScrollPane.setViewportView(mainPanel);

        javax.swing.GroupLayout styleBookMainPanelLayout = new javax.swing.GroupLayout(styleBookMainPanel);
        styleBookMainPanel.setLayout(styleBookMainPanelLayout);
        styleBookMainPanelLayout.setHorizontalGroup(
                styleBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(styleBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        styleBookMainPanelLayout.setVerticalGroup(
                styleBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(styleBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(styleBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(styleBookMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    public void processStyleBook() {
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.insets = new Insets(10, 15, 10, 15);

        GetAllBook lb = new GetAllBook();
        ArrayList<Book> books = lb.getBooksTheLoai();
        totalBooks = books.size();
        ColorMain cl = new ColorMain();
        ArrayList<Color> colors = cl.getColorMain();
        int totalColor = colors.size();

        int cols = 2;
        int maxThreads = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        ArrayList<Future<JPanel>> futures = new ArrayList<>();

        for (int i = 0; i < totalBooks; i++) {
            int index = i;
            Callable<JPanel> task = () -> {
                JPanel panel = new JPanel(new BorderLayout());
                int indexColor = index;
                if (indexColor >= totalColor) indexColor %= totalColor;
                panel.setBackground(colors.get(indexColor));
                panel.setPreferredSize(new Dimension(165, 80));
                JLabel label1 = new JLabel(books.get(index).getName());
                label1.setFont(new Font("Segoe UI", Font.BOLD, 24));
                label1.setHorizontalAlignment(JLabel.CENTER);
                panel.add(label1, BorderLayout.CENTER);
                panel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String nameStyle = books.get(index).getSlug();
                        WaitScreen ws = new WaitScreen();
                        ws.setVisible(true);
                        moreBookScreen.setVisible(false);
                        OneStyleBookScreen oneStyleBookPage = new OneStyleBookScreen(moreBookScreen, nameStyle, label1.getText(), ws);
                        ;
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        mainPanel.dispatchEvent(SwingUtilities.convertMouseEvent(panel, e, mainPanel));
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        mainPanel.dispatchEvent(SwingUtilities.convertMouseEvent(panel, e, mainPanel));
                    }
                });
                panel.addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        mainPanel.dispatchEvent(SwingUtilities.convertMouseEvent(panel, e, mainPanel));
                    }
                });
                return panel;
            };
            futures.add(executor.submit(task));
        }

        for (int i = 0; i < futures.size(); i++) {
            try {
                JPanel panel = futures.get(i).get();
                final int x = i % cols;
                final int y = i / cols;
                SwingUtilities.invokeLater(() -> {
                    GridBagConstraints gbcPanel = (GridBagConstraints) gbc2.clone();
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

        executor.shutdown();
    }

    public JPanel styleBookPanel() {
        return styleBookMainPanel;
    }

    private javax.swing.JPanel styleBookMainPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane styleBookScrollPane;

    public JPanel getMainPanel() {
        return mainPanel;
    }
    public JScrollPane getStyleBookScrollPane() {
        return styleBookScrollPane;
    }
}

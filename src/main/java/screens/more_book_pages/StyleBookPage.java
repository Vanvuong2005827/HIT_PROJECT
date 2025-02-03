package screens.more_book_pages;

import commons.ColorMain;
import models.book_information.Book;
import screens.MoreBookScreen;
import screens.StyleBookScreen;
import screens.WaitScreen;
import utils.GetAllBook;
import utils.Gradient;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.concurrent.*;

import static commons.ColorMain.*;
import static commons.ColorMain.colorMain3;

public class StyleBookPage extends javax.swing.JFrame {
    MoreBookScreen moreBookScreen;
    int totalBooks;

    public StyleBookPage(MoreBookScreen m) {
        moreBookScreen = m;
        initComponents();
    }

    private void initComponents() {

        styleBookMainPanel = new javax.swing.JPanel();
        styleBookScrollPane = new javax.swing.JScrollPane();
        mainPanel = new Gradient(colorMain1, colorMain2, colorMain3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        styleBookMainPanel.setBackground(colorMain);

        styleBookScrollPane.setBackground(colorMain);
        styleBookScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        styleBookScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mainPanel.setLayout(new java.awt.GridBagLayout());
        styleBookScrollPane.setViewportView(mainPanel);

        javax.swing.GroupLayout newBookMainPanelLayout = new javax.swing.GroupLayout(styleBookMainPanel);
        styleBookMainPanel.setLayout(newBookMainPanelLayout);
        newBookMainPanelLayout.setHorizontalGroup(
                newBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(styleBookScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        newBookMainPanelLayout.setVerticalGroup(
                newBookMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newBookMainPanelLayout.createSequentialGroup()
                                .addComponent(styleBookScrollPane)
                                .addContainerGap())
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

    public void processStyleBook(){
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
                        StyleBookScreen styleBookScreen = new StyleBookScreen(moreBookScreen, nameStyle, label1.getText(), ws);;
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
        mainPanel.addMouseListener(dragScrollListenerMainScroll);
        mainPanel.addMouseMotionListener(dragScrollListenerMainScroll);
    }

    public JPanel styleBookPanel(){
        return styleBookMainPanel;
    }

    MouseAdapter dragScrollListenerMainScroll = new MouseAdapter() {
        private Point origin;
        private final double SCROLL_FACTOR = 1.0;
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
            int maxScrollHeight = totalBooks / 2 * 170;

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
                int maxScrollHeight = totalBooks / 2 * 170;
                newY = Math.max(0, Math.min(newY, maxScrollHeight));

                int finalNewY = newY;
                SwingUtilities.invokeLater(() -> viewport.setViewPosition(new Point(viewPosition.x, finalNewY)));

                velocity *= 0.9;
            });
            inertiaTimer.start();
        }
    };

    private javax.swing.JPanel styleBookMainPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane styleBookScrollPane;
}

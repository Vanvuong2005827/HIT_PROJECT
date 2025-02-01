package utils;

import models.book_information.Book;
import models.book_information.BookCategory;
import models.chapter_information.Chapters;
import screens.OneBookScreen;
import screens.WaitScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class customBookGridPanel {
    public static JPanel customBookGrid3(JFrame previousScreen, int index, int panelWidth, int panelHeight, int imgWidth, int imgHeight, ArrayList<Book> books, Color cusColor, String baseUrl, Font customFont1, Font customFont2, JPanel panelMain) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(cusColor);
        panel.setPreferredSize(new Dimension(panelWidth, panelHeight));
        String baseUrlAllBook = baseUrl;
        String posterPathAllBook = books.get(index).getThumbnail();
        String fullUrlAllBook = baseUrlAllBook + posterPathAllBook;
        try {
            URL urlAllbook = new URL(fullUrlAllBook);
            Image imageAllBook = ImageIO.read(urlAllbook);

            Image resizedImageAllBook = imageAllBook.getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);

            JLabel jLabel1 = new JLabel(new ImageIcon(resizedImageAllBook));

            panel.add(jLabel1);
        } catch (IOException e) {
            e.printStackTrace();
            JLabel errorLabel = new JLabel("Không thể tải ảnh!");
            errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(errorLabel, BorderLayout.CENTER);
        }

        StringBuilder categories = new StringBuilder();
        for (BookCategory x : books.get(index).getCategory()) {
            if (categories.length() > 0) {
                categories.append(", ");
            }
            categories.append(x.getName());
        }

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(panel.getBackground());

        JLabel titleArea = new JLabel(books.get(index).getName());
        titleArea.setFont(customFont1);
        titleArea.setBackground(cusColor);
        textPanel.add(titleArea);

        JLabel categoriesArea = new JLabel(categories.toString());
        categoriesArea.setFont(customFont2);
        categoriesArea.setBackground(cusColor);
        categoriesArea.setForeground(Color.GRAY);
        textPanel.add(categoriesArea);

        panel.add(textPanel);
        panel.addMouseListener(new MouseAdapter() {
            GetAllBook getBook = new GetAllBook();
            GetChapters getChapters = new GetChapters();

            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(() -> {
                    SwingWorker<Void, Void> worker = new SwingWorker<>() {
                        Book curBook = new Book();
                        ArrayList<Chapters> chapters = new ArrayList<>();
                        WaitScreen ws = new WaitScreen();

                        @Override
                        protected Void doInBackground() {
                            ws.setVisible(true);
                            previousScreen.setVisible(false);
                            curBook = getBook.getBooksTheoTen(books.get(index).getSlug());
                            chapters = getChapters.getListChapters(curBook);
                            return null;
                        }

                        @Override
                        protected void done() {
                            OneBookScreen oneBookScreen = new OneBookScreen(previousScreen, curBook, chapters); // Truyền thông tin sách vào
                            oneBookScreen.setVisible(true);
                            ws.setVisible(false);
                        }
                    };

                    worker.execute();
                });
            }

            @Override
            public void mousePressed(MouseEvent e) {
                panelMain.dispatchEvent(SwingUtilities.convertMouseEvent(panel, e, panelMain));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panelMain.dispatchEvent(SwingUtilities.convertMouseEvent(panel, e, panelMain));
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                panelMain.dispatchEvent(SwingUtilities.convertMouseEvent(panel, e, panelMain));
            }
        });
        return panel;
    }

    public static JPanel customBookGrid1(JFrame previousScreen, int index, int panelWidth, int panelHeight, int imgWidth, int imgHeight, ArrayList<Book> books, Color cusColor, String baseUrl, Font customFont1, JPanel panelMain) {
        JPanel childPanel = new JPanel();

        JTextArea categoriesArea;
        JTextArea chapterLastestArea;
        JLabel imgLabel;
        JSeparator jSeparator1 = new JSeparator();
        JTextArea statusArea;
        JTextArea titleArea;
        JTextArea updateAtArea;

        childPanel.setBackground(cusColor);
        childPanel.setPreferredSize(new java.awt.Dimension(panelWidth, panelHeight));

        String baseUrlAllBook = baseUrl;
        String posterPathAllBook = books.get(index).getThumbnail();
        String fullUrlAllBook = baseUrlAllBook + posterPathAllBook;


        try {
            URL urlAllbook = new URL(fullUrlAllBook);
            Image imageAllBook = ImageIO.read(urlAllbook);
            Image resizedImageAllBook = imageAllBook.getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH);
            imgLabel = new JLabel(new ImageIcon(resizedImageAllBook));

        } catch (IOException e) {
            e.printStackTrace();
            imgLabel = new JLabel("Không thể tải ảnh!");
            imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        }

        imgLabel.setBackground(cusColor);
        imgLabel.setForeground(cusColor);

        String inputDateTime = books.get(index).getUpdatedAt();
        LocalDateTime dateTime = LocalDateTime.parse(inputDateTime.substring(0, 19));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        String updateAt = dateTime.format(formatter);

        StringBuilder categories = new StringBuilder();
        for (BookCategory x : books.get(index).getCategory()) {
            if (categories.length() > 0) {
                categories.append(", ");
            }
            categories.append(x.getName());
        }
        String chapterLatest = "";
        try {
            chapterLatest = books.get(index).getChapterLastests().get(0).getFilename();
        } catch (Exception e) {
            chapterLatest = "Chưa có chap mới";
        }

        titleArea = new JTextArea(books.get(index).getName());
        statusArea = new JTextArea("Status: " + books.get(index).getStatus());
        updateAtArea = new JTextArea("Last update: " + updateAt);
        chapterLastestArea = new JTextArea("Chapter newest: " + chapterLatest);
        categoriesArea = new JTextArea(categories.toString());

        titleArea.setFont(customFont1);
        titleArea.setBackground(cusColor);
        titleArea.setWrapStyleWord(true);
        titleArea.setLineWrap(true);
        titleArea.setFocusable(false);
        titleArea.setEditable(false);
        titleArea.setColumns(20);
        titleArea.setRows(5);

        updateAtArea.setFont(customFont1);
        updateAtArea.setBackground(cusColor);
        updateAtArea.setLineWrap(true);
        updateAtArea.setWrapStyleWord(true);
        updateAtArea.setFocusable(false);
        updateAtArea.setEditable(false);
        updateAtArea.setColumns(20);
        updateAtArea.setRows(5);

        statusArea.setFont(customFont1);
        statusArea.setBackground(cusColor);
        statusArea.setLineWrap(true);
        statusArea.setWrapStyleWord(true);
        statusArea.setFocusable(false);
        statusArea.setEditable(false);
        statusArea.setColumns(20);
        statusArea.setRows(5);

        categoriesArea.setFont(customFont1);
        categoriesArea.setBackground(cusColor);
        categoriesArea.setLineWrap(true);
        categoriesArea.setWrapStyleWord(true);
        categoriesArea.setFocusable(false);
        categoriesArea.setEditable(false);
        categoriesArea.setColumns(20);
        categoriesArea.setRows(5);

        chapterLastestArea.setFont(customFont1);
        chapterLastestArea.setBackground(cusColor);
        chapterLastestArea.setLineWrap(true);
        chapterLastestArea.setWrapStyleWord(true);
        chapterLastestArea.setFocusable(false);
        chapterLastestArea.setEditable(false);
        chapterLastestArea.setColumns(20);
        chapterLastestArea.setRows(5);

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout childPanelLayout = new javax.swing.GroupLayout(childPanel);
        childPanel.setLayout(childPanelLayout);
        childPanelLayout.setHorizontalGroup(
                childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(childPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1)
                                        .addGroup(childPanelLayout.createSequentialGroup()
                                                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, imgWidth, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(titleArea)
                                                        .addGroup(childPanelLayout.createSequentialGroup()
                                                                .addGroup(childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(statusArea, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(updateAtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(chapterLastestArea, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, childPanelLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(categoriesArea, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap())
        );
        childPanelLayout.setVerticalGroup(
                childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(childPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(childPanelLayout.createSequentialGroup()
                                                .addComponent(titleArea, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(statusArea, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(updateAtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(chapterLastestArea, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(categoriesArea, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 7, Short.MAX_VALUE))
                                        .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        childPanel.addMouseListener(new MouseAdapter() {
            GetAllBook getBook = new GetAllBook();
            GetChapters getChapters = new GetChapters();

            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(() -> {
                    SwingWorker<Void, Void> worker = new SwingWorker<>() {
                        Book curBook = new Book();
                        ArrayList<Chapters> chapters = new ArrayList<>();
                        WaitScreen ws = new WaitScreen();

                        @Override
                        protected Void doInBackground() {
                            ws.setVisible(true);
                            previousScreen.setVisible(false);
                            curBook = getBook.getBooksTheoTen(books.get(index).getSlug());
                            chapters = getChapters.getListChapters(curBook);
                            return null;
                        }

                        @Override
                        protected void done() {
                            OneBookScreen oneBookScreen = new OneBookScreen(previousScreen, curBook, chapters); // Truyền thông tin sách vào
                            oneBookScreen.setVisible(true);
                            ws.setVisible(false);
                        }
                    };

                    worker.execute();
                });
            }

            @Override
            public void mousePressed(MouseEvent e) {
                panelMain.dispatchEvent(SwingUtilities.convertMouseEvent(childPanel, e, panelMain));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panelMain.dispatchEvent(SwingUtilities.convertMouseEvent(childPanel, e, panelMain));
            }
        });
        childPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                panelMain.dispatchEvent(SwingUtilities.convertMouseEvent(childPanel, e, panelMain));
            }
        });
        return childPanel;
    }

    public static JPanel customChapterPanel(JFrame previousScreen, String title, String chapterNumber, Color cusColor, Font customFont1, JPanel panelMain){
        JPanel childPanel = new JPanel();

        childPanel.setBackground(cusColor);
        childPanel.setPreferredSize(new java.awt.Dimension(432, 60));

        JLabel titleArea = new JLabel(title);
        JLabel chapterNumberLabel = new JLabel(chapterNumber);

        JSeparator jSeparator1 = new javax.swing.JSeparator();
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout childPanelLayout = new javax.swing.GroupLayout(childPanel);
        childPanel.setLayout(childPanelLayout);
        childPanelLayout.setHorizontalGroup(
                childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(childPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(chapterNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(titleArea, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                                        .addComponent(jSeparator1))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        childPanelLayout.setVerticalGroup(
                childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(childPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chapterNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleArea, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        childPanel.addMouseListener(new MouseAdapter() {
            GetAllBook getBook = new GetAllBook();
            GetChapters getChapters = new GetChapters();

            @Override
            public void mouseClicked(MouseEvent e) {
//                SwingUtilities.invokeLater(() -> {
//                    SwingWorker<Void, Void> worker = new SwingWorker<>() {
//                        Book curBook = new Book();
//                        ArrayList<Chapters> chapters = new ArrayList<>();
//                        WaitScreen ws = new WaitScreen();
//
//                        @Override
//                        protected Void doInBackground() {
////                            ws.setVisible(true);
////                            previousScreen.setVisible(false);
////                            curBook = getBook.getBooksTheoTen(books.get(index).getSlug());
////                            chapters = getChapters.getListChapters(curBook);
//                            return null;
//                        }
//
//                        @Override
//                        protected void done() {
//                            OneBookScreen oneBookScreen = new OneBookScreen(previousScreen, curBook, chapters); // Truyền thông tin sách vào
//                            oneBookScreen.setVisible(true);
//                            ws.setVisible(false);
//                        }
//                    };
//
//                    worker.execute();
//                });
            }

            @Override
            public void mousePressed(MouseEvent e) {
                panelMain.dispatchEvent(SwingUtilities.convertMouseEvent(childPanel, e, panelMain));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                panelMain.dispatchEvent(SwingUtilities.convertMouseEvent(childPanel, e, panelMain));
            }
        });
        childPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                panelMain.dispatchEvent(SwingUtilities.convertMouseEvent(childPanel, e, panelMain));
            }
        });
        return childPanel;
    }
}

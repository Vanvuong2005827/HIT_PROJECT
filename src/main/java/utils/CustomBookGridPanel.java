package utils;

import models.book.Book;
import models.book.BookCategory;
import models.chapter.AllChapters;
import view.screens.ChapterScreen;
import view.pages.OneBookPage;
import view.screens.WaitScreen;
import services.BookService;
import data.GetAllBook;
import data.GetChapters;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static commons.CurrentUser.bookService;

public class CustomBookGridPanel {
    public static JPanel customBookGrid3(JFrame previousScreen, int index, int panelWidth, int panelHeight, int imgWidth, int imgHeight, ArrayList<Book> books, Color cusColor, String baseUrl, Font customFont1, Font customFont2, JPanel panelMain) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(cusColor);
        panel.setPreferredSize(new Dimension(panelWidth, panelHeight));
        String baseUrlAllBook = baseUrl;
        String posterPathAllBook = books.get(index).getThumbnail();
        String fullUrlAllBook = baseUrlAllBook + posterPathAllBook;
        ImageIO.setUseCache(false);
        JLabel imageLabel = new JLabel();
        try {
            URL url = new URL(fullUrlAllBook);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setConnectTimeout(4000);
            connection.setReadTimeout(4000);
            connection.connect();

            try (BufferedInputStream in = new BufferedInputStream(connection.getInputStream())) {
                BufferedImage originalImage = ImageIO.read(in);

                BufferedImage resizedImage = resizeImage(originalImage, imgWidth, imgHeight);
                imageLabel = new JLabel(new ImageIcon(resizedImage));
            }
            connection.disconnect();
        } catch (Exception e) {
            imageLabel = new JLabel("Không thể tải ảnh!");
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(imageLabel, BorderLayout.CENTER);
        }
        panel.add(imageLabel);

        StringBuilder categories = new StringBuilder();
        try {
            for (BookCategory x : books.get(index).getCategory()) {
                if (categories.length() > 0) {
                    categories.append(", ");
                }
                categories.append(x.getName());
            }
        } catch (Exception e) {
            categories.append("Đang cập nhật");
        }

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(panel.getBackground());

        String title;
        try {
            title = books.get(index).getName();
        } catch (Exception e) {
            title = "Đang cập nhật";
        }
        JLabel titleArea = new JLabel(title);
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
                        ArrayList<AllChapters> chapters = new ArrayList<>();
                        WaitScreen ws = new WaitScreen();
                        BookService bookService = new BookService();

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
                            OneBookPage oneBookScreen = null;
                            try {
                                oneBookScreen = new OneBookPage(previousScreen, curBook, chapters);
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
                            if (bookService.checkIfExitBookInUser(curBook.getId())) {
                                try {
                                    oneBookScreen.oneBookStartReadButton.setText("Tiếp tục đọc chapter " + chapters.get(bookService.getLastReadIndexChapter(curBook.getId())).getChapter_name());
                                } catch (Exception e) {
                                    oneBookScreen.oneBookStartReadButton.setText("Sách mới, vui lòng chờ");
                                }
                            }
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

    public static JPanel customBookGrid1(JFrame previousScreen, int index, int panelWidth, int panelHeight, int imgWidth, int imgHeight, ArrayList<Book> books, Color cusColor, String baseUrl, Font customFont, JPanel panelMain) {
        JPanel childPanel = new JPanel();

        JTextArea categoriesArea;
        JTextArea chapterLastestArea;
        JLabel imgLabel = null;
        JSeparator jSeparator1 = new JSeparator();
        JTextArea statusArea;
        JTextArea titleArea;
        JTextArea updateAtArea;

        childPanel.setBackground(cusColor);
        childPanel.setPreferredSize(new Dimension(panelWidth, panelHeight));

        String baseUrlAllBook = baseUrl;
        String posterPathAllBook = books.get(index).getThumbnail();
        String fullUrlAllBook = baseUrlAllBook + posterPathAllBook;

        ImageIO.setUseCache(false);
        try {
            URL url = new URL(fullUrlAllBook);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setConnectTimeout(4000);
            connection.setReadTimeout(4000);
            connection.connect();

            try (BufferedInputStream in = new BufferedInputStream(connection.getInputStream())) {
                BufferedImage originalImage = ImageIO.read(in);

                BufferedImage resizedImage = resizeImage(originalImage, imgWidth, imgHeight);
                imgLabel = new JLabel(new ImageIcon(resizedImage));
            }
            connection.disconnect();
        } catch (Exception e) {
            imgLabel = new JLabel("Không thể tải ảnh!");
            imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            childPanel.add(imgLabel, BorderLayout.CENTER);
        }

        String inputDateTime;
        try {
            inputDateTime = books.get(index).getUpdatedAt();
        } catch (Exception e) {
            inputDateTime = "Đang cập nhật";
        }
        LocalDateTime dateTime = LocalDateTime.parse(inputDateTime.substring(0, 19));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        String updateAt = dateTime.format(formatter);

        StringBuilder categories = new StringBuilder();
        try {
            for (BookCategory x : books.get(index).getCategory()) {
                if (categories.length() > 0) {
                    categories.append(", ");
                }
                categories.append(x.getName());
            }
        } catch (Exception e) {
            categories.append("Đang cập nhật");
        }
        String chapterLatest;
        try {
            chapterLatest = books.get(index).getChapterLastests().get(0).getFilename();
        } catch (Exception e) {
            chapterLatest = "Chưa có chap mới";
        }

        String title;
        String status;
        String update;
        String chapterNew;
        try {
            title = books.get(index).getName();
        } catch (Exception e) {
            title = "Đang cập nhật";
        }
        try {
            status = "Trạng thái: " + books.get(index).getStatus();
        } catch (Exception e) {
            status = "Trạng thái: Đang cập nhật";
        }
        try {
            update = "Cập nhật lần cuối: " + updateAt;
        } catch (Exception e) {
            update = "Cập nhật lần cuối: Đang cập nhật";
        }
        try {
            chapterNew = "Chapter mới: " + chapterLatest;
        } catch (Exception e) {
            chapterNew = "Chưa có chap mới";
        }
        titleArea = new JTextArea(title);
        statusArea = new JTextArea(status);
        updateAtArea = new JTextArea(update);
        chapterLastestArea = new JTextArea(chapterNew);
        categoriesArea = new JTextArea(categories.toString());

        JTextArea[] textAreas = {titleArea, updateAtArea, statusArea, chapterLastestArea, categoriesArea};
        for (JTextArea textArea : textAreas) {
            textArea.setFont(customFont);
            textArea.setBackground(cusColor);
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setFocusable(false);
            textArea.setHighlighter(null);
            textArea.setCursor(Cursor.getDefaultCursor());
            textArea.setEditable(false);
            textArea.setColumns(20);
            textArea.setRows(5);
            fixDragable(textArea, childPanel, previousScreen, books, index);
        }

        jSeparator1.setBackground(new Color(153, 153, 153));

        GroupLayout childPanelLayout = new GroupLayout(childPanel);
        childPanel.setLayout(childPanelLayout);
        childPanelLayout.setHorizontalGroup(childPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(childPanelLayout.createSequentialGroup().addContainerGap().addGroup(childPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jSeparator1).addGroup(childPanelLayout.createSequentialGroup().addComponent(imgLabel, GroupLayout.PREFERRED_SIZE, imgWidth, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(childPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(titleArea).addGroup(childPanelLayout.createSequentialGroup().addGroup(childPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(statusArea, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE).addComponent(updateAtArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(chapterLastestArea, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)).addGap(0, 0, Short.MAX_VALUE)).addGroup(GroupLayout.Alignment.TRAILING, childPanelLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(categoriesArea, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))))).addContainerGap()));
        childPanelLayout.setVerticalGroup(childPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(childPanelLayout.createSequentialGroup().addContainerGap().addGroup(childPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(childPanelLayout.createSequentialGroup().addComponent(titleArea, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(statusArea, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(updateAtArea, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(chapterLastestArea, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(categoriesArea, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE).addGap(0, 7, Short.MAX_VALUE)).addComponent(imgLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)));
        childPanel.addMouseListener(new MouseAdapter() {
            GetAllBook getBook = new GetAllBook();
            GetChapters getChapters = new GetChapters();

            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(() -> {
                    SwingWorker<Void, Void> worker = new SwingWorker<>() {
                        Book curBook = new Book();
                        ArrayList<AllChapters> chapters = new ArrayList<>();
                        WaitScreen ws = new WaitScreen();
                        BookService bookService = new BookService();

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
                            OneBookPage oneBookScreen = null;
                            try {
                                oneBookScreen = new OneBookPage(previousScreen, curBook, chapters);
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
                            if (bookService.checkIfExitBookInUser(curBook.getId())) {
                                try {
                                    oneBookScreen.oneBookStartReadButton.setText("Tiếp tục đọc chapter " + chapters.get(bookService.getLastReadIndexChapter(curBook.getId())).getChapter_name());
                                } catch (Exception e) {
                                    oneBookScreen.oneBookStartReadButton.setText("Sách mới, vui lòng chờ");
                                }
                            }
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

    public static JPanel customChapterPanel(JFrame previousScreen, int indexChapter, ArrayList<AllChapters> chapters, String title, String chapterNumber, Color cusColor, Font customFont1, JPanel panelMain, Book curBook, JButton oneBookStartReadButton) {
        JPanel childPanel = new JPanel();
        childPanel.setBackground(cusColor);
        childPanel.setPreferredSize(new Dimension(432, 70));

        JLabel titleArea = new JLabel(title);
        JLabel chapterNumberLabel = new JLabel(chapterNumber);

        JSeparator jSeparator1 = new JSeparator();
        jSeparator1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        GroupLayout childPanelLayout = new GroupLayout(childPanel);
        childPanel.setLayout(childPanelLayout);
        childPanelLayout.setHorizontalGroup(childPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(childPanelLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(childPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(chapterNumberLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(titleArea, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE).addComponent(jSeparator1)).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        childPanelLayout.setVerticalGroup(childPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(childPanelLayout.createSequentialGroup().addContainerGap().addComponent(chapterNumberLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(titleArea, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        childPanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(() -> {
                    SwingWorker<Void, Void> worker = new SwingWorker<>() {
                        WaitScreen ws = new WaitScreen();
                        ChapterScreen cs;

                        @Override
                        protected Void doInBackground() {
                            ws.setVisible(true);
                            previousScreen.setVisible(false);
                            cs = new ChapterScreen(previousScreen, curBook, oneBookStartReadButton, chapters, indexChapter);
                            bookService.insertBookToDB(curBook);
                            bookService.storageBookToUser(curBook.getId());
                            return null;
                        }

                        @Override
                        protected void done() {
                            bookService.saveLastReadChapter(curBook.getId(), indexChapter);
                            oneBookStartReadButton.setText("Tiếp tục đọc chapter " + chapters.get(bookService.getLastReadIndexChapter(curBook.getId())).getChapter_name());
                            cs.setVisible(true);
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

    public static void fixDragable(JTextArea textArea, JPanel childPanel, JFrame previousScreen, ArrayList<Book> books, int index) {
        textArea.addMouseListener(new MouseAdapter() {
            GetAllBook getBook = new GetAllBook();
            GetChapters getChapters = new GetChapters();

            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(() -> {
                    SwingWorker<Void, Void> worker = new SwingWorker<>() {
                        Book curBook = new Book();
                        ArrayList<AllChapters> chapters = new ArrayList<>();
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
                            OneBookPage oneBookScreen = null; // Truyền thông tin sách vào
                            try {
                                oneBookScreen = new OneBookPage(previousScreen, curBook, chapters);
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
                            oneBookScreen.setVisible(true);
                            ws.setVisible(false);
                        }
                    };

                    worker.execute();
                });
            }

            @Override
            public void mousePressed(MouseEvent e) {
                childPanel.dispatchEvent(SwingUtilities.convertMouseEvent(textArea, e, childPanel));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                childPanel.dispatchEvent(SwingUtilities.convertMouseEvent(textArea, e, childPanel));
            }
        });
        textArea.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                childPanel.dispatchEvent(SwingUtilities.convertMouseEvent(textArea, e, childPanel));
            }
        });
    }

    public static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();
        return resizedImage;
    }
}

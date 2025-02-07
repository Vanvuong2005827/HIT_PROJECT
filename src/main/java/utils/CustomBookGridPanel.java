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
import java.io.IOException;
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
        try {
            URL urlAllbook = new URL(fullUrlAllBook);
            BufferedImage originalImage = ImageIO.read(urlAllbook);

            BufferedImage resizedImage = resizeImage(originalImage, imgWidth, imgHeight);

            JLabel jLabel1 = new JLabel(new ImageIcon(resizedImage));

            panel.add(jLabel1);
        } catch (IOException e) {
            JLabel errorLabel = new JLabel("Không thể tải ảnh!");
            errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(errorLabel, BorderLayout.CENTER);
        }

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
                            OneBookPage oneBookScreen = new OneBookPage(previousScreen, curBook, chapters);
                            if (bookService.checkIfExitBookInUser(curBook.getId())) {
                                oneBookScreen.oneBookStartReadButton.setText("Tiếp tục đọc chapter " + chapters.get(bookService.getLastReadIndexChapter(curBook.getId())).getChapter_name());
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

        ImageIO.setUseCache(false);
        try {
            URL urlAllbook = new URL(fullUrlAllBook);
            BufferedImage originalImage = ImageIO.read(urlAllbook);

            BufferedImage resizedImage = resizeImage(originalImage, imgWidth, imgHeight);

            imgLabel = new JLabel(new ImageIcon(resizedImage));

        } catch (IOException e) {
            imgLabel = new JLabel("Không thể tải ảnh!");
            imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        }

        String inputDateTime;
        try{
            inputDateTime = books.get(index).getUpdatedAt();
        } catch (Exception e) {
            inputDateTime = "Đang cập nhật";
        }
        LocalDateTime dateTime = LocalDateTime.parse(inputDateTime.substring(0, 19));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        String updateAt = dateTime.format(formatter);

        StringBuilder categories = new StringBuilder();
        try{
            for (BookCategory x : books.get(index).getCategory()) {
                if (categories.length() > 0) {
                    categories.append(", ");
                }
                categories.append(x.getName());
            }
        } catch (Exception e){
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
        try{
            title = books.get(index).getName();
        } catch (Exception e){
            title = "Đang cập nhật";
        }
        try{
            status = "Trạng thái: " + books.get(index).getStatus();
        } catch (Exception e){
            status = "Trạng thái: Đang cập nhật";
        }
        try{
            update = "Cập nhật lần cuối: " + updateAt;
        } catch (Exception e){
            update = "Cập nhật lần cuối: Đang cập nhật";
        }
        try{
            chapterNew = "Chapter mới: " + chapterLatest;
        } catch (Exception e){
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

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout childPanelLayout = new javax.swing.GroupLayout(childPanel);
        childPanel.setLayout(childPanelLayout);
        childPanelLayout.setHorizontalGroup(childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(childPanelLayout.createSequentialGroup().addContainerGap().addGroup(childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jSeparator1).addGroup(childPanelLayout.createSequentialGroup().addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, imgWidth, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(titleArea).addGroup(childPanelLayout.createSequentialGroup().addGroup(childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(statusArea, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(updateAtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(chapterLastestArea, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(0, 0, Short.MAX_VALUE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, childPanelLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(categoriesArea, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))).addContainerGap()));
        childPanelLayout.setVerticalGroup(childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(childPanelLayout.createSequentialGroup().addContainerGap().addGroup(childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(childPanelLayout.createSequentialGroup().addComponent(titleArea, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(statusArea, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(updateAtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(chapterLastestArea, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(categoriesArea, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 7, Short.MAX_VALUE)).addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)));
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
                            OneBookPage oneBookScreen = new OneBookPage(previousScreen, curBook, chapters);
                            if (bookService.checkIfExitBookInUser(curBook.getId())) {

                                oneBookScreen.oneBookStartReadButton.setText("Tiếp tục đọc chapter " + chapters.get(bookService.getLastReadIndexChapter(curBook.getId())).getChapter_name());
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
        childPanel.setPreferredSize(new java.awt.Dimension(432, 70));

        JLabel titleArea = new JLabel(title);
        JLabel chapterNumberLabel = new JLabel(chapterNumber);

        JSeparator jSeparator1 = new javax.swing.JSeparator();
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout childPanelLayout = new javax.swing.GroupLayout(childPanel);
        childPanel.setLayout(childPanelLayout);
        childPanelLayout.setHorizontalGroup(childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(childPanelLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(chapterNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(titleArea, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE).addComponent(jSeparator1)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        childPanelLayout.setVerticalGroup(childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(childPanelLayout.createSequentialGroup().addContainerGap().addComponent(chapterNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(titleArea, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
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
                            OneBookPage oneBookScreen = new OneBookPage(previousScreen, curBook, chapters); // Truyền thông tin sách vào
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

package controllers;

import view.screens.main_screens.WaitScreen;
import view.screens.one_book_screens.ChapterScreen;
import view.screens.one_book_screens.OneBookScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static commons.CurrentUser.bookService;

public class OneBookController {
    private OneBookScreen oneBookScreen;
    private JFrame previousScreen;

    public OneBookController(OneBookScreen oneBookScreen, JFrame jf) {
        this.oneBookScreen = oneBookScreen;
        this.previousScreen = jf;
        fixedTab();
        backEvent();
        startReadEvent();
        loveEvent();
    }

    private void fixedTab() {
        int tabWidth = 201;
        for (int i = 0; i < oneBookScreen.getOneBookTabbed().getTabCount(); i++) {
            oneBookScreen.getOneBookTabbed().setTabComponentAt(i, new JLabel(oneBookScreen.getOneBookTabbed().getTitleAt(i)) {
                {
                    setPreferredSize(new Dimension(tabWidth, 30));
                    setHorizontalAlignment(SwingConstants.CENTER);
                }
            });
        }
    }

    private void backEvent() {
        oneBookScreen.getOneBookBackLabel().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                previousScreen.setVisible(true);
                oneBookScreen.setVisible(false);
            }
        });
    }

    private void startReadEvent() {
        oneBookScreen.getOneBookStartReadButton().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (oneBookScreen.getOneBookStartReadButton().getText().equals("Bắt đầu đọc")) {
                    SwingUtilities.invokeLater(() -> {
                        SwingWorker<Void, Void> worker = new SwingWorker<>() {
                            WaitScreen ws = new WaitScreen();
                            ChapterScreen cs;

                            @Override
                            protected Void doInBackground() {
                                ws.setVisible(true);
                                oneBookScreen.setVisible(false);
                                cs = new ChapterScreen(oneBookScreen, oneBookScreen.getCurBook(), oneBookScreen.getOneBookStartReadButton(), oneBookScreen.getChapters(), 0);
                                bookService.storageBookToUser(oneBookScreen.getCurBook().getId());
                                return null;
                            }

                            @Override
                            protected void done() {
                                bookService.saveLastReadChapter(oneBookScreen.getCurBook().getId(), 0);
                                oneBookScreen.getOneBookStartReadButton().setText("Tiếp tục đọc chapter " + oneBookScreen.getChapters().get(bookService.getLastReadIndexChapter(oneBookScreen.getCurBook().getId())).getChapter_name());
                                cs.setVisible(true);
                                ws.setVisible(false);
                            }
                        };

                        worker.execute();
                    });
                } else {
                    int x = bookService.getLastReadIndexChapter(oneBookScreen.getCurBook().getId());
                    SwingUtilities.invokeLater(() -> {
                        SwingWorker<Void, Void> worker = new SwingWorker<>() {
                            WaitScreen ws = new WaitScreen();
                            ChapterScreen cs;

                            @Override
                            protected Void doInBackground() {
                                ws.setVisible(true);
                                oneBookScreen.setVisible(false);
                                cs = new ChapterScreen(oneBookScreen, oneBookScreen.getCurBook(), oneBookScreen.getOneBookStartReadButton(), oneBookScreen.getChapters(), x);
                                bookService.storageBookToUser(oneBookScreen.getCurBook().getId());
                                return null;
                            }

                            @Override
                            protected void done() {
                                bookService.saveLastReadChapter(oneBookScreen.getCurBook().getId(), x);
                                oneBookScreen.getOneBookStartReadButton().setText("Tiếp tục đọc chapter " + oneBookScreen.getChapters().get(bookService.getLastReadIndexChapter(oneBookScreen.getCurBook().getId())).getChapter_name());
                                cs.setVisible(true);
                                ws.setVisible(false);
                            }
                        };

                        worker.execute();
                    });
                }
            }
        });
    }

    private void loveEvent() {
        oneBookScreen.getjLabel1().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (oneBookScreen.getOneBookFavou().getBackground() == Color.gray) {
                    oneBookScreen.getOneBookFavou().setBackground(Color.red);
                    oneBookScreen.getjLabel1().setForeground(Color.white);
                    bookService.toggleFavorite(oneBookScreen.getCurBook().getId(), Color.red);
                } else {
                    oneBookScreen.getOneBookFavou().setBackground(Color.gray);
                    oneBookScreen.getjLabel1().setForeground(Color.black);
                    bookService.toggleFavorite(oneBookScreen.getCurBook().getId(), Color.gray);
                }
            }
        });
    }
}

package controllers.book;

import view.screens.WaitScreen;
import view.screens.ChapterScreen;
import view.pages.OneBookPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static commons.CurrentUser.bookService;

public class OneBookController {
    private OneBookPage oneBookScreen;
    private JFrame previousScreen;

    public OneBookController(OneBookPage oneBookScreen, JFrame jf) {
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
                                try {
                                    bookService.storageBookToUser(oneBookScreen.getCurBook().getId());
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                }
                                return null;
                            }

                            @Override
                            protected void done() {
                                try {
                                    bookService.saveLastReadChapter(oneBookScreen.getCurBook().getId(), 0);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Lưu dữ liệu không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                }
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
                                try {
                                    bookService.storageBookToUser(oneBookScreen.getCurBook().getId());
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                }
                                return null;
                            }

                            @Override
                            protected void done() {
                                try {
                                    bookService.saveLastReadChapter(oneBookScreen.getCurBook().getId(), x);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                }
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
                    try {
                        bookService.toggleFavorite(oneBookScreen.getCurBook().getId(), Color.red);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    oneBookScreen.getOneBookFavou().setBackground(Color.gray);
                    oneBookScreen.getjLabel1().setForeground(Color.black);
                    try {
                        bookService.toggleFavorite(oneBookScreen.getCurBook().getId(), Color.gray);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}

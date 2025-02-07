package controllers.book;

import utils.MouseDragCommon;
import view.screens.WaitScreen;
import view.screens.ChapterScreen;
import view.pages.OneBookPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static commons.CurrentUser.bookService;

public class OneBookController {
    private OneBookPage oneBookPage;
    private JFrame previousScreen;

    public OneBookController(OneBookPage oneBookPage, JFrame jf) {
        this.oneBookPage = oneBookPage;
        this.previousScreen = jf;
        fixedTab();
        backEvent();
        startReadEvent();
        loveEvent();
        mouseDrag();
    }

    private void fixedTab() {
        int tabWidth = 201;
        for (int i = 0; i < oneBookPage.getOneBookTabbed().getTabCount(); i++) {
            oneBookPage.getOneBookTabbed().setTabComponentAt(i, new JLabel(oneBookPage.getOneBookTabbed().getTitleAt(i)) {
                {
                    setPreferredSize(new Dimension(tabWidth, 30));
                    setHorizontalAlignment(SwingConstants.CENTER);
                }
            });
        }
    }

    private void backEvent() {
        oneBookPage.getOneBookBackLabel().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                previousScreen.setVisible(true);
                oneBookPage.setVisible(false);
            }
        });
    }

    private void startReadEvent() {
        oneBookPage.getOneBookStartReadButton().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (oneBookPage.getOneBookStartReadButton().getText().equals("Bắt đầu đọc")) {
                    SwingUtilities.invokeLater(() -> {
                        SwingWorker<Void, Void> worker = new SwingWorker<>() {
                            WaitScreen ws = new WaitScreen();
                            ChapterScreen cs;

                            @Override
                            protected Void doInBackground() {
                                ws.setVisible(true);
                                oneBookPage.setVisible(false);
                                cs = new ChapterScreen(oneBookPage, oneBookPage.getCurBook(), oneBookPage.getOneBookStartReadButton(), oneBookPage.getChapters(), 0);
                                try {
                                    bookService.storageBookToUser(oneBookPage.getCurBook().getId());
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                }
                                return null;
                            }

                            @Override
                            protected void done() {
                                try {
                                    bookService.saveLastReadChapter(oneBookPage.getCurBook().getId(), 0);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Lưu dữ liệu không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                }
                                oneBookPage.getOneBookStartReadButton().setText("Tiếp tục đọc chapter " + oneBookPage.getChapters().get(bookService.getLastReadIndexChapter(oneBookPage.getCurBook().getId())).getChapter_name());
                                cs.setVisible(true);
                                ws.setVisible(false);
                            }
                        };

                        worker.execute();
                    });
                } else {
                    int x = bookService.getLastReadIndexChapter(oneBookPage.getCurBook().getId());
                    SwingUtilities.invokeLater(() -> {
                        SwingWorker<Void, Void> worker = new SwingWorker<>() {
                            WaitScreen ws = new WaitScreen();
                            ChapterScreen cs;

                            @Override
                            protected Void doInBackground() {
                                ws.setVisible(true);
                                oneBookPage.setVisible(false);
                                cs = new ChapterScreen(oneBookPage, oneBookPage.getCurBook(), oneBookPage.getOneBookStartReadButton(), oneBookPage.getChapters(), x);
                                try {
                                    bookService.storageBookToUser(oneBookPage.getCurBook().getId());
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                }
                                return null;
                            }

                            @Override
                            protected void done() {
                                try {
                                    bookService.saveLastReadChapter(oneBookPage.getCurBook().getId(), x);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                }
                                oneBookPage.getOneBookStartReadButton().setText("Tiếp tục đọc chapter " + oneBookPage.getChapters().get(bookService.getLastReadIndexChapter(oneBookPage.getCurBook().getId())).getChapter_name());
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
        oneBookPage.getjLabel1().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (oneBookPage.getOneBookFavou().getBackground() == Color.gray) {
                    oneBookPage.getOneBookFavou().setBackground(Color.red);
                    oneBookPage.getjLabel1().setForeground(Color.white);
                    try {
                        bookService.toggleFavorite(oneBookPage.getCurBook().getId(), Color.red);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    oneBookPage.getOneBookFavou().setBackground(Color.gray);
                    oneBookPage.getjLabel1().setForeground(Color.black);
                    try {
                        bookService.toggleFavorite(oneBookPage.getCurBook().getId(), Color.gray);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private void mouseDrag(){
        MouseDragCommon mouseDragCommon = new MouseDragCommon(oneBookPage.getOneBookChapterScroll(), 1.5, 80, false);
        oneBookPage.getOneBookChapterMainPanel().addMouseListener(mouseDragCommon);
        oneBookPage.getOneBookChapterMainPanel().addMouseMotionListener(mouseDragCommon);
    }
}

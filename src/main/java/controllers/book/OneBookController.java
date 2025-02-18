package controllers.book;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import utils.MouseDragCommon;
import view.WaitScreen;
import view.user_view.screens.ChapterScreen;
import view.user_view.pages.OneBookPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static commons.CurrentUser.bookService;
import static utils.NetworkChecker.isConnected;
import static view.user_view.pages.OneBookPage.currentColor;

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
                                bookService.updateDateToRead(oneBookPage.getCurBook().getId());
                                try {
                                    bookService.storageBookToUser(oneBookPage.getCurBook().getId());
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                }
                                return null;
                            }

                            @Override
                            protected void done() {
                                if (!isConnected) return;
                                try {
                                    bookService.saveLastReadChapter(oneBookPage.getCurBook().getId(), 0);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Lưu dữ liệu không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                }
                                try {
                                    oneBookPage.getOneBookStartReadButton().setText("Tiếp tục đọc chapter " + oneBookPage.getChapters().get(bookService.getLastReadIndexChapter(oneBookPage.getCurBook().getId())).getChapter_name());
                                    cs.setVisible(true);
                                } catch (Exception e) {
                                    oneBookPage.setVisible(true);
                                    JOptionPane.showMessageDialog(null, "Chưa có chapter");
                                }
                                ws.setVisible(false);
                            }
                        };

                        worker.execute();
                    });
                } else {
                    SwingUtilities.invokeLater(() -> {
                        SwingWorker<Void, Void> worker = new SwingWorker<>() {
                            WaitScreen ws = new WaitScreen();
                            ChapterScreen cs;
                            int x;

                            @Override
                            protected Void doInBackground() {
                                ws.setVisible(true);
                                oneBookPage.setVisible(false);
                                x = bookService.getLastReadIndexChapter(oneBookPage.getCurBook().getId());
                                cs = new ChapterScreen(oneBookPage, oneBookPage.getCurBook(), oneBookPage.getOneBookStartReadButton(), oneBookPage.getChapters(), x);
                                bookService.updateDateToRead(oneBookPage.getCurBook().getId());
                                try {
                                    bookService.storageBookToUser(oneBookPage.getCurBook().getId());
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                }
                                return null;
                            }

                            @Override
                            protected void done() {
                                if (!isConnected) return;
                                try {
                                    bookService.saveLastReadChapter(oneBookPage.getCurBook().getId(), x);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                                }
                                try {
                                    oneBookPage.getOneBookStartReadButton().setText("Tiếp tục đọc chapter " + oneBookPage.getChapters().get(bookService.getLastReadIndexChapter(oneBookPage.getCurBook().getId())).getChapter_name());
                                    cs.setVisible(true);
                                } catch (Exception e){
                                    JOptionPane.showMessageDialog(null, "Chưa có chapter");
                                    oneBookPage.setVisible(true);
                                }
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
                if (currentColor == Color.gray) {
                    oneBookPage.getjLabel1().setIcon(IconFontSwing.buildIcon(FontAwesome.HEART, 30, Color.RED));
                    currentColor = Color.RED;
                    try {
                        bookService.toggleFavorite(oneBookPage.getCurBook().getId(), Color.red);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    oneBookPage.getjLabel1().setIcon(IconFontSwing.buildIcon(FontAwesome.HEART, 30, Color.GRAY));
                    currentColor = Color.GRAY;
                    try {
                        bookService.toggleFavorite(oneBookPage.getCurBook().getId(), Color.gray);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private void mouseDrag() {
        MouseDragCommon mouseDragCommon = new MouseDragCommon(oneBookPage.getOneBookChapterScroll(), 1.5, 80, false);
        oneBookPage.getOneBookChapterMainPanel().addMouseListener(mouseDragCommon);
        oneBookPage.getOneBookChapterMainPanel().addMouseMotionListener(mouseDragCommon);
    }
}

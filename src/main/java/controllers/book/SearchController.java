package controllers.book;

import utils.MouseDrag;
import view.screens.home_screens.SearchScreen;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class SearchController {
    private SearchScreen searchScreen;
    private JFrame previousScreen;

    public SearchController(SearchScreen searchScreen, JFrame previousScreen) {
        this.searchScreen = searchScreen;
        this.previousScreen = previousScreen;
        backEvent();
        searchEvent();
        mouseDrag();
    }

    private void backEvent() {
        searchScreen.getSearchBackLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previousScreen.setVisible(true);
                searchScreen.setVisible(false);
            }
        });
    }

    private void searchEvent() {
        searchScreen.getSearchSearchLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                performSearch();
            }
        });
        searchScreen.getSearchSearchTextField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performSearch();
                }
            }
        });
    }

    private void performSearch(){
        String input = searchScreen.getSearchSearchTextField().getText();
        String keyword = null;
        try {
            keyword = URLEncoder.encode(input, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            JOptionPane.showMessageDialog(null, "Không lấy được dữ liệu. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        String finalKeyword = keyword;
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                searchScreen.getSearchKeywordLabel().setText("Loading...");
                searchScreen.processSeachBook(finalKeyword);
                return null;
            }

            @Override
            protected void done() {
                if (searchScreen.getTotalBooks() == 0) {
                    searchScreen.getSearchKeywordLabel().setText("Không tìm thấy kết quả");
                    searchScreen.getMainPanel().removeAll();
                    searchScreen.getMainPanel().revalidate();
                    searchScreen.getMainPanel().repaint();
                }
            }
        };

        worker.execute();
    }

    private void mouseDrag(){
        MouseDrag mouseDrag = new MouseDrag(searchScreen.getSearchScrollPane(), 1.5, 80, false);
        searchScreen.getMainPanel().addMouseListener(mouseDrag);
        searchScreen.getMainPanel().addMouseMotionListener(mouseDrag);
    }
}

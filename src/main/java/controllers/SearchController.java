package controllers;

import view.pages.home_screen_pages.SearchPage;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class SearchController {
    private SearchPage searchPage;
    private JFrame previousScreen;

    public SearchController(SearchPage searchPage, JFrame previousScreen) {
        this.searchPage = searchPage;
        this.previousScreen = previousScreen;
        backEvent();
        searchEvent();
    }

    private void backEvent() {
        searchPage.getSearchBackLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previousScreen.setVisible(true);
                searchPage.setVisible(false);
            }
        });
    }

    private void searchEvent() {
        searchPage.getSearchSearchLabel().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                performSearch();
            }
        });
        searchPage.getSearchSearchTextField().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performSearch();
                }
            }
        });
    }

    private void performSearch(){
        String input = searchPage.getSearchSearchTextField().getText();
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
                searchPage.getSearchKeywordLabel().setText("Loading...");
                searchPage.processSeachBook(finalKeyword);
                return null;
            }

            @Override
            protected void done() {
                if (searchPage.getTotalBooks() == 0) {
                    searchPage.getSearchKeywordLabel().setText("Không tìm thấy kết quả");
                    searchPage.getMainPanel().removeAll();
                    searchPage.getMainPanel().revalidate();
                    searchPage.getMainPanel().repaint();
                }
            }
        };

        worker.execute();
    }
}

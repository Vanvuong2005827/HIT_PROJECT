package controllers;

import view.screens.one_book_screens.ChapterScreen;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static commons.CurrentUser.bookService;

public class ChapterController {
    private ChapterScreen chapterScreen;

    public ChapterController(ChapterScreen chapterScreen) {
        this.chapterScreen = chapterScreen;
        backEvent();
        nextEvent();
        previousEvent();
    }

    private void backEvent() {
        chapterScreen.getChapterBackLabel().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                chapterScreen.getPreviousScreen().setVisible(true);
                chapterScreen.setVisible(false);
            }
        });
    }

    private void nextEvent() {
        chapterScreen.getChapterNext().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int chapterLastest = bookService.getLastReadIndexChapter(chapterScreen.getCurBook().getId());
                chapterScreen.getChapterPrevious().setForeground(Color.BLACK);
                chapterScreen.getChapterNext().setForeground((chapterLastest + 1 >= chapterScreen.getChapters().size() - 1) ? Color.gray : Color.BLACK);
                if (chapterLastest == chapterScreen.getChapters().size() - 1) return;
                chapterLastest++;
                bookService.saveLastReadChapter(chapterScreen.getCurBook().getId(), chapterLastest);
                chapterScreen.getOneBookStartReadButton().setText("Tiếp tục đọc chapter " + chapterScreen.getChapters().get(bookService.getLastReadIndexChapter(chapterScreen.getCurBook().getId())).getChapter_name());
                chapterScreen.setIndexChapter(chapterLastest);
                chapterScreen.processData();
            }
        });
    }

    private void previousEvent() {
        chapterScreen.getChapterPrevious().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int chapterLastest = bookService.getLastReadIndexChapter(chapterScreen.getCurBook().getId());
                chapterScreen.getChapterNext().setForeground(Color.BLACK);
                chapterScreen.getChapterPrevious().setForeground((chapterLastest - 1 <= 0) ? Color.gray : Color.BLACK);
                if (chapterLastest == 0) return;
                chapterLastest--;
                bookService.saveLastReadChapter(chapterScreen.getCurBook().getId(), chapterLastest);
                chapterScreen.getOneBookStartReadButton().setText("Tiếp tục đọc chapter " + chapterScreen.getChapters().get(bookService.getLastReadIndexChapter(chapterScreen.getCurBook().getId())).getChapter_name());
                chapterScreen.setIndexChapter(chapterLastest);
                chapterScreen.processData();
            }
        });
    }
}

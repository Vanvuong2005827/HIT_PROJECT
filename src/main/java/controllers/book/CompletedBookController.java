package controllers.book;

import utils.MouseDrag;
import view.screens.more_book_screens.CompletedBookScreen;

public class CompletedBookController {
    private CompletedBookScreen completedBookScreen;

    public CompletedBookController(CompletedBookScreen completedBookScreen) {
        this.completedBookScreen = completedBookScreen;
        mouseDrag();
    }

    private void mouseDrag(){
        MouseDrag mouseDrag = new MouseDrag(completedBookScreen.getCompletedBookScrollPane(), 1.5, 80, false);
        completedBookScreen.getMainPanel().addMouseListener(mouseDrag);
        completedBookScreen.getMainPanel().addMouseMotionListener(mouseDrag);
    }
}

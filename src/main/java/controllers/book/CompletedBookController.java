package controllers.book;

import utils.MouseDragAdvanced;
import utils.MouseDragCommon;
import view.screens.more_book_screens.CompletedBookScreen;

public class CompletedBookController {
    private CompletedBookScreen completedBookScreen;

    public CompletedBookController(CompletedBookScreen completedBookScreen) {
        this.completedBookScreen = completedBookScreen;
        mouseDrag();
    }

    private void mouseDrag() {
        MouseDragAdvanced mouseDragAdvanced = new MouseDragAdvanced(completedBookScreen.getCompletedBookScrollPane(), 1.5, 80, false, () -> completedBookScreen.processCompletedBook());
        completedBookScreen.getMainPanel().removeMouseListener(mouseDragAdvanced);
        completedBookScreen.getMainPanel().removeMouseMotionListener(mouseDragAdvanced);
        completedBookScreen.getMainPanel().addMouseListener(mouseDragAdvanced);
        completedBookScreen.getMainPanel().addMouseMotionListener(mouseDragAdvanced);
    }
}
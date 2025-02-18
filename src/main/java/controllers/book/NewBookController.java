package controllers.book;

import utils.MouseDragAdvanced;
import view.user_view.screens.more_book_screens.NewBookScreen;

public class NewBookController {
    private NewBookScreen newBookScreen;

    public NewBookController(NewBookScreen newBookScreen) {
        this.newBookScreen = newBookScreen;
        mouseDrag();
    }

    private void mouseDrag() {
        MouseDragAdvanced mouseDragAdvanced = new MouseDragAdvanced(newBookScreen.getNewBookScrollPane(), 1.5, 80, false, () -> newBookScreen.processNewBook());
        newBookScreen.getMainPanel().removeMouseListener(mouseDragAdvanced);
        newBookScreen.getMainPanel().removeMouseMotionListener(mouseDragAdvanced);
        newBookScreen.getMainPanel().addMouseListener(mouseDragAdvanced);
        newBookScreen.getMainPanel().addMouseMotionListener(mouseDragAdvanced);
    }
}
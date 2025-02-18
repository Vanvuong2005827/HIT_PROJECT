package controllers.book;

import utils.MouseDragAdvanced;
import view.user_view.screens.more_book_screens.OneStyleBookScreen;

public class OneStyleBookController {
    private OneStyleBookScreen oneStyleBookScreen;

    public OneStyleBookController(OneStyleBookScreen oneStyleBookScreen) {
        this.oneStyleBookScreen = oneStyleBookScreen;
        mouseDrag();
    }

    private void mouseDrag() {
        MouseDragAdvanced mouseDragAdvanced = new MouseDragAdvanced(oneStyleBookScreen.getStyleBookScrollPane(), 1.5, 80, false, () -> oneStyleBookScreen.processStyleBook());
        oneStyleBookScreen.getMainPanel().removeMouseListener(mouseDragAdvanced);
        oneStyleBookScreen.getMainPanel().removeMouseMotionListener(mouseDragAdvanced);
        oneStyleBookScreen.getMainPanel().addMouseListener(mouseDragAdvanced);
        oneStyleBookScreen.getMainPanel().addMouseMotionListener(mouseDragAdvanced);
    }
}
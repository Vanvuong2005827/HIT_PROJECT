package controllers.book;

import utils.MouseDrag;
import view.screens.more_book_screens.OneStyleBookScreen;

public class OneStyleBookController {
    private OneStyleBookScreen oneStyleBookScreen;

    public OneStyleBookController(OneStyleBookScreen oneStyleBookScreen) {
        this.oneStyleBookScreen = oneStyleBookScreen;
        mouseDrag();
    }

    private void mouseDrag() {
        MouseDrag mouseDrag = new MouseDrag(oneStyleBookScreen.getStyleBookScrollPane(), 1.5, 80, false);
        oneStyleBookScreen.getMainPanel().addMouseListener(mouseDrag);
        oneStyleBookScreen.getMainPanel().addMouseMotionListener(mouseDrag);
    }
}
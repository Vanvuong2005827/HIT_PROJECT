package controllers.book;

import utils.MouseDrag;
import view.screens.more_book_screens.StyleBookScreen;

public class StyleBookController {
    private StyleBookScreen styleBookScreen;

    public StyleBookController(StyleBookScreen styleBookScreen) {
        this.styleBookScreen = styleBookScreen;
        mouseDrag();
    }

    private void mouseDrag() {
        MouseDrag mouseDrag = new MouseDrag(styleBookScreen.getStyleBookScrollPane(), 1.5, 80, false);
        styleBookScreen.getMainPanel().addMouseListener(mouseDrag);
        styleBookScreen.getMainPanel().addMouseMotionListener(mouseDrag);
    }
}
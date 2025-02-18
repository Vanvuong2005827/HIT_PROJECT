package controllers.book;

import utils.MouseDragCommon;
import view.user_view.screens.more_book_screens.StyleBookScreen;

public class StyleBookController {
    private StyleBookScreen styleBookScreen;

    public StyleBookController(StyleBookScreen styleBookScreen) {
        this.styleBookScreen = styleBookScreen;
        mouseDrag();
    }

    private void mouseDrag() {
        MouseDragCommon mouseDragCommon = new MouseDragCommon(styleBookScreen.getStyleBookScrollPane(), 1.5, 80, false);
        styleBookScreen.getMainPanel().addMouseListener(mouseDragCommon);
        styleBookScreen.getMainPanel().addMouseMotionListener(mouseDragCommon);
    }
}
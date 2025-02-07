package controllers.book;

import utils.MouseDrag;
import view.screens.more_book_screens.NewBookScreen;

public class NewBookController {
    private NewBookScreen newBookScreen;

    public NewBookController(NewBookScreen newBookScreen) {
        this.newBookScreen = newBookScreen;
        mouseDrag();
    }

    private void mouseDrag() {
        MouseDrag mouseDrag = new MouseDrag(newBookScreen.getNewBookScrollPane(), 1.5, 80, false);
        newBookScreen.getMainPanel().addMouseListener(mouseDrag);
        newBookScreen.getMainPanel().addMouseMotionListener(mouseDrag);
    }
}
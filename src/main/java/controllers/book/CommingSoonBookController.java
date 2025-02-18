package controllers.book;

import utils.MouseDragAdvanced;
import view.user_view.screens.more_book_screens.CommingSoonBookScreen;

public class CommingSoonBookController {
    private CommingSoonBookScreen commingSoonBookScreen;

    public CommingSoonBookController(CommingSoonBookScreen commingSoonBookScreen) {
        this.commingSoonBookScreen = commingSoonBookScreen;
        mouseDrag();
    }

    private void mouseDrag() {
        MouseDragAdvanced mouseDragAdvanced = new MouseDragAdvanced(commingSoonBookScreen.getCommingSoonBookScrollPane(), 1.5, 80, false, () -> commingSoonBookScreen.processCommingSoonBook());
        commingSoonBookScreen.getMainPanel().removeMouseListener(mouseDragAdvanced);
        commingSoonBookScreen.getMainPanel().removeMouseMotionListener(mouseDragAdvanced);
        commingSoonBookScreen.getMainPanel().addMouseListener(mouseDragAdvanced);
        commingSoonBookScreen.getMainPanel().addMouseMotionListener(mouseDragAdvanced);
    }
}
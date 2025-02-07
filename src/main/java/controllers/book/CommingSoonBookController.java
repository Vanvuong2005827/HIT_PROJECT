package controllers.book;

import utils.MouseDrag;
import view.screens.more_book_screens.CommingSoonBookScreen;

public class CommingSoonBookController {
    private CommingSoonBookScreen commingSoonBookScreen;

    public CommingSoonBookController(CommingSoonBookScreen commingSoonBookScreen) {
        this.commingSoonBookScreen = commingSoonBookScreen;
        mouseDrag();
    }

    private void mouseDrag(){
        MouseDrag mouseDrag = new MouseDrag(commingSoonBookScreen.getCommingSoonBookScrollPane(), 1.5, 80, false);
        commingSoonBookScreen.getMainPanel().addMouseListener(mouseDrag);
        commingSoonBookScreen.getMainPanel().addMouseMotionListener(mouseDrag);
    }
}

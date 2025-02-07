package controllers.book;

import utils.MouseDrag;
import view.screens.home_screens.RecentScreen;

public class RecentController {
    private RecentScreen recentScreen;

    public RecentController(RecentScreen recentScreen) {
        this.recentScreen = recentScreen;
        mouseDrag();
    }

    private void mouseDrag(){
        MouseDrag mouseDrag = new MouseDrag(recentScreen.getRecentBookScrollPane(), 1.5, 80, false);
        recentScreen.getMainPanel().removeMouseListener(mouseDrag);
        recentScreen.getMainPanel().removeMouseMotionListener(mouseDrag);

        recentScreen.getMainPanel().addMouseListener(mouseDrag);
        recentScreen.getMainPanel().addMouseMotionListener(mouseDrag);
    }
}

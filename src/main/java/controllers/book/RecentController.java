package controllers.book;

import utils.MouseDragCommon;
import view.screens.home_screens.RecentScreen;

public class RecentController {
    private RecentScreen recentScreen;

    public RecentController(RecentScreen recentScreen) {
        this.recentScreen = recentScreen;
        mouseDrag();
    }

    private void mouseDrag() {
        MouseDragCommon mouseDragCommon = new MouseDragCommon(recentScreen.getRecentBookScrollPane(), 1.5, 80, false);
        recentScreen.getMainPanel().removeMouseListener(mouseDragCommon);
        recentScreen.getMainPanel().removeMouseMotionListener(mouseDragCommon);
        recentScreen.getMainPanel().addMouseListener(mouseDragCommon);
        recentScreen.getMainPanel().addMouseMotionListener(mouseDragCommon);
    }
}
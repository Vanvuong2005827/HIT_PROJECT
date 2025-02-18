package controllers.book;

import utils.MouseDragAdvanced;
import view.user_view.screens.home_screens.RecentScreen;

public class RecentController {
    private RecentScreen recentScreen;

    public RecentController(RecentScreen recentScreen) {
        this.recentScreen = recentScreen;
        mouseDrag();
    }

    private void mouseDrag() {
        MouseDragAdvanced mouseDragAdvanced = new MouseDragAdvanced(recentScreen.getRecentBookScrollPane(), 1.5, 80, false, () -> recentScreen.processRecentBook());
        recentScreen.getMainPanel().removeMouseListener(mouseDragAdvanced);
        recentScreen.getMainPanel().removeMouseMotionListener(mouseDragAdvanced);
        recentScreen.getMainPanel().addMouseListener(mouseDragAdvanced);
        recentScreen.getMainPanel().addMouseMotionListener(mouseDragAdvanced);
    }
}
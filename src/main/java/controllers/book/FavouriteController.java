package controllers.book;

import utils.MouseDragCommon;
import view.screens.home_screens.FavouriteScreen;

public class FavouriteController {
    private FavouriteScreen favouriteScreen;

    public FavouriteController(FavouriteScreen favouriteScreen) {
        this.favouriteScreen = favouriteScreen;
        mouseDrag();
    }

    private void mouseDrag() {
        MouseDragCommon mouseDragCommon = new MouseDragCommon(favouriteScreen.getFavouriteBookScrollPane(), 1.5, 80, false);
        favouriteScreen.getMainPanel().removeMouseListener(mouseDragCommon);
        favouriteScreen.getMainPanel().removeMouseMotionListener(mouseDragCommon);
        favouriteScreen.getMainPanel().addMouseListener(mouseDragCommon);
        favouriteScreen.getMainPanel().addMouseMotionListener(mouseDragCommon);
    }
}
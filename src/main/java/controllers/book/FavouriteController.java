package controllers.book;

import utils.MouseDragAdvanced;
import view.user_view.screens.home_screens.FavouriteScreen;

public class FavouriteController {
    private FavouriteScreen favouriteScreen;

    public FavouriteController(FavouriteScreen favouriteScreen) {
        this.favouriteScreen = favouriteScreen;
        mouseDrag();
    }

    private void mouseDrag() {
        MouseDragAdvanced mouseDragAdvanced = new MouseDragAdvanced(favouriteScreen.getFavouriteBookScrollPane(), 1.5, 80, false, () -> favouriteScreen.processFavouriteBook());
        favouriteScreen.getMainPanel().removeMouseListener(mouseDragAdvanced);
        favouriteScreen.getMainPanel().removeMouseMotionListener(mouseDragAdvanced);
        favouriteScreen.getMainPanel().addMouseListener(mouseDragAdvanced);
        favouriteScreen.getMainPanel().addMouseMotionListener(mouseDragAdvanced);
    }
}
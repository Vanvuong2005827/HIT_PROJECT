package controllers.book;

import utils.MouseDrag;
import view.screens.home_screens.FavouriteScreen;

public class FavouriteController {
    private FavouriteScreen favouriteScreen;

    public FavouriteController(FavouriteScreen favouriteScreen) {
        this.favouriteScreen = favouriteScreen;
        mouseDrag();
    }

    private void mouseDrag(){
        MouseDrag mouseDrag = new MouseDrag(favouriteScreen.getFavouriteBookScrollPane(), 1.5, 80, false);
        favouriteScreen.getMainPanel().removeMouseListener(mouseDrag);
        favouriteScreen.getMainPanel().removeMouseMotionListener(mouseDrag);

        favouriteScreen.getMainPanel().addMouseListener(mouseDrag);
        favouriteScreen.getMainPanel().addMouseMotionListener(mouseDrag);
    }
}

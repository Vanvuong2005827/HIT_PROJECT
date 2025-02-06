package controllers.book;

import view.screens.home_screens.HomeScreen;
import view.screens.home_screens.SearchScreen;
import view.pages.HomePage;
import view.pages.MoreBookPage;
import view.screens.WaitScreen;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeController {
    private HomeScreen homePage;
    private HomePage homeScreen;

    public HomeController(HomeScreen hp, HomePage hs) {
        homePage = hp;
        homeScreen = hs;
        more1();
        more2();
        more3();
        searchEvent();
    }

    private void more1() {
        homePage.getHomeNewBookShow().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                WaitScreen ws = new WaitScreen();
                ws.setVisible(true);
                homeScreen.setVisible(false);
                MoreBookPage mb = new MoreBookPage(homeScreen, 0, ws);
            }
        });
    }

    private void more2() {
        homePage.getHomeCommingSoonBookShow().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                WaitScreen ws = new WaitScreen();
                ws.setVisible(true);
                homeScreen.setVisible(false);
                MoreBookPage mb = new MoreBookPage(homeScreen, 1, ws);
            }
        });
    }

    private void more3() {
        homePage.getHomeStyleShow().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                WaitScreen ws = new WaitScreen();
                ws.setVisible(true);
                homeScreen.setVisible(false);
                MoreBookPage mb = new MoreBookPage(homeScreen, 3, ws);
            }
        });
    }

    private void searchEvent() {
        homePage.getHomeSearchLabel().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                SearchScreen sp = new SearchScreen(homeScreen);
                sp.setVisible(true);
                homeScreen.setVisible(false);
            }
        });
    }
}

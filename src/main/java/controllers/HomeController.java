package controllers;

import view.pages.home_screen_pages.HomePage;
import view.pages.home_screen_pages.SearchPage;
import view.screens.main_screens.HomeScreen;
import view.screens.main_screens.MoreBookScreen;
import view.screens.main_screens.WaitScreen;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeController {
    private HomePage homePage;
    private HomeScreen homeScreen;

    public HomeController(HomePage hp, HomeScreen hs) {
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
                MoreBookScreen mb = new MoreBookScreen(homeScreen, 0, ws);
            }
        });
    }

    private void more2() {
        homePage.getHomeCommingSoonBookShow().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                WaitScreen ws = new WaitScreen();
                ws.setVisible(true);
                homeScreen.setVisible(false);
                MoreBookScreen mb = new MoreBookScreen(homeScreen, 1, ws);
            }
        });
    }

    private void more3() {
        homePage.getHomeStyleShow().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                WaitScreen ws = new WaitScreen();
                ws.setVisible(true);
                homeScreen.setVisible(false);
                MoreBookScreen mb = new MoreBookScreen(homeScreen, 3, ws);
            }
        });
    }

    private void searchEvent() {
        homePage.getHomeSearchLabel().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                SearchPage sp = new SearchPage(homeScreen);
                sp.setVisible(true);
                homeScreen.setVisible(false);
            }
        });
    }
}

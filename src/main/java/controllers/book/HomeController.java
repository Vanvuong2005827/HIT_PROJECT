package controllers.book;

import utils.MouseDragCommon;
import view.screens.home_screens.HomeScreen;
import view.screens.home_screens.SearchScreen;
import view.pages.HomePage;
import view.pages.MoreBookPage;
import view.screens.WaitScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeController {
    private HomeScreen homeScreen;
    private HomePage homePage;

    public HomeController(HomeScreen hp, HomePage hs) {
        homeScreen = hp;
        homePage = hs;
        more1();
        more2();
        more3();
        searchEvent();
        mouseDrag();
    }

    private void more1() {
        homeScreen.getHomeNewBookShow().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                WaitScreen ws = new WaitScreen();
                ws.setVisible(true);
                homePage.setVisible(false);
                MoreBookPage mb = new MoreBookPage(homePage, 0, ws);
            }
        });
    }

    private void more2() {
        homeScreen.getHomeCommingSoonBookShow().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                WaitScreen ws = new WaitScreen();
                ws.setVisible(true);
                homePage.setVisible(false);
                MoreBookPage mb = new MoreBookPage(homePage, 1, ws);
            }
        });
    }

    private void more3() {
        homeScreen.getHomeStyleShow().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                WaitScreen ws = new WaitScreen();
                ws.setVisible(true);
                homePage.setVisible(false);
                MoreBookPage mb = new MoreBookPage(homePage, 3, ws);
            }
        });
    }

    private void searchEvent() {
        homeScreen.getHomeSearchLabel().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                SearchScreen sp = new SearchScreen(homePage);
                sp.setVisible(true);
                homePage.setVisible(false);
            }
        });
    }

    private void mouseDrag(){
        MouseDragCommon mouseDragCommon = new MouseDragCommon(homeScreen.getHomeMainScrollPane(),1.5, 80, true);
        homeScreen.getHomeMainPanel().addMouseListener(mouseDragCommon);
        homeScreen.getHomeMainPanel().addMouseMotionListener(mouseDragCommon);
        homeScreen.getHomeNewBookGridPanel().addMouseListener(mouseDragCommon);
        homeScreen.getHomeNewBookGridPanel().addMouseMotionListener(mouseDragCommon);
        homeScreen.getHomeCommingSoonBookGridPanel1().addMouseListener(mouseDragCommon);
        homeScreen.getHomeCommingSoonBookGridPanel1().addMouseMotionListener(mouseDragCommon);
        homeScreen.getHomeStyleMainPanel().addMouseListener(dragScrollListenerStyleScroll);
        homeScreen.getHomeStyleMainPanel().addMouseMotionListener(dragScrollListenerStyleScroll);
    }
    private MouseAdapter dragScrollListenerStyleScroll = new MouseAdapter() {
        private Point origin;
        @Override
        public void mousePressed(MouseEvent e) {
            origin = e.getPoint();
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            JViewport viewport = homeScreen.getHomeStyleScrollPane().getViewport();
            Point viewPosition = viewport.getViewPosition();
            int deltaX = origin.x - e.getX();
            int newX = viewPosition.x + deltaX;
            int totalWidth = 130 * 100;
            if (totalWidth < homeScreen.getHomeStyleScrollPane().getWidth()) totalWidth = homeScreen.getHomeStyleScrollPane().getWidth();
            int panelWidth = totalWidth;
            int viewportWidth = viewport.getWidth();
            if (newX < 0) {
                newX = 0;
            }
            if (newX > panelWidth - viewportWidth) {
                newX = panelWidth - viewportWidth;
            }
            viewport.setViewPosition(new Point(newX, 0));
        }
    };
}

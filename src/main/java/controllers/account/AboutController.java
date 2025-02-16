package controllers.account;

import view.screens.account_screens.AboutScreen;
import view.screens.auth_screens.PolicyScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class AboutController {
    private JFrame previousScreen;
    private AboutScreen aboutScreen;

    public AboutController(JFrame previousScreen, AboutScreen aboutScreen) {
        this.previousScreen = previousScreen;
        this.aboutScreen = aboutScreen;
        backEvent();
        linkEvent();
    }

    private void backEvent(){
        aboutScreen.getjLabel4().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                previousScreen.setVisible(true);
                aboutScreen.setVisible(false);
            }
        });
    }

    private void linkEvent(){
        aboutScreen.getFacebook1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.facebook.com/khuong.pham.359787"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        aboutScreen.getFacebook2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.facebook.com/dinhanvuong2k5"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        aboutScreen.getEmail1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://mail.google.com/mail/u/0/?view=cm&fs=1&to=boyzsno1@gmail.com&su=Xin+chào+Khương+&body="));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        aboutScreen.getEmail2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://mail.google.com/mail/u/0/?view=cm&fs=1&to=vanvuong2005827@gmail.com&su=Xin+chào+Vượng+&body="));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        aboutScreen.getGithub1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/khuong1742005"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        aboutScreen.getGithub2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/Vanvuong2005827"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        aboutScreen.getLinkGithub().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/Vanvuong2005827/HIT_PROJECT"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        aboutScreen.getPolicy().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PolicyScreen p = new PolicyScreen(aboutScreen);
                p.setVisible(true);
                aboutScreen.setVisible(false);
            }
        });
    }
}

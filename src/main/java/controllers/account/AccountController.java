package controllers.account;

import models.user.UserInfo;
import view.pages.HomePage;
import view.screens.account_screens.*;
import view.screens.home_screens.AccountScreen;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static commons.CurrentUser.*;

public class AccountController {
    private HomePage homePage;
    private AccountScreen accountScreen;

    public AccountController(HomePage homePage, AccountScreen accountScreen) {
        this.homePage = homePage;
        this.accountScreen = accountScreen;
        logOutEvent();
        changeNameEvent();
        changePassEvent();
        forgotPassEvent();
        changeThemeEvent();
        removeAccountEvent();
        authorInformationEvent();
    }

    private void logOutEvent(){
        accountScreen.getAccountLogoutButton().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                homePage.backToLogin();
                userAccount = null;
                userInfo = new UserInfo();
            }
        });
    }

    private void changeNameEvent(){
        accountScreen.getAccountChangeNameLabel().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ChangeNameScreen changeNameScreen = new ChangeNameScreen(accountScreen.getAccountNameLabel());
                changeNameScreen.setVisible(true);
            }
        });
    }

    private void changePassEvent(){
        accountScreen.getAccountChangePassLabel().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                ChangePassScreen cp = new ChangePassScreen(homePage);
                cp.setVisible(true);
                homePage.setVisible(false);
            }
        });
    }

    private void forgotPassEvent(){
        accountScreen.getAccountForgotPassLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ForgotPassScreen fg = new ForgotPassScreen(homePage);
                fg.setVisible(true);
                homePage.setVisible(false);
            }
        });
    }

    private void changeThemeEvent(){
        accountScreen.getAccountNightModeLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ChangeThemeScreen changeThemeScreen = new ChangeThemeScreen(homePage);
                changeThemeScreen.setVisible(true);
                homePage.setVisible(false);
            }
        });
    }

    private void removeAccountEvent(){
        accountScreen.getAccountRemoveLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int confirm = JOptionPane.showConfirmDialog(accountScreen, "Bạn muốn xóa tài khoản?", "Xóa tài khoản?", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    delAccountService.delAccount(userAccount.getId());
                    homePage.backToLogin();
                }
            }
        });
    }

    private void authorInformationEvent(){
        accountScreen.getAccountAuthorLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AboutScreen a = new AboutScreen(homePage);
                a.setVisible(true);
                homePage.setVisible(false);
            }
        });
    }
}

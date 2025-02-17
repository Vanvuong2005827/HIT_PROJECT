package commons;

import models.user.UserAccount;
import models.user.UserInfo;
import services.impl.*;

import java.util.prefs.Preferences;

public class CurrentUser {
    public static ILoginServiceImpl loginService = new ILoginServiceImpl();
    public static IRegisterServiceImpl registerService = new IRegisterServiceImpl();
    public static IUserServicesImpl userServices = new IUserServicesImpl();
    public static IBookServiceImpl bookService = new IBookServiceImpl();
    public static UserAccount userAccount;
    public static UserInfo userInfo = new UserInfo();
    public static IForgetPasswordServiceImpl forgetPasswordService = new IForgetPasswordServiceImpl();
    public static Preferences pref = Preferences.userRoot().node("rememberMe");
    public static IEncryptorServiceImpl encryptorService = new IEncryptorServiceImpl();
    public static IDelAccountServiceImpl delAccountService = new IDelAccountServiceImpl();
}

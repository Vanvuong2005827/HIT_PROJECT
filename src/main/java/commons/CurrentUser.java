package commons;

import models.user.UserAccount;
import models.user.UserInfo;
import services.*;
import services.account_services.*;

import java.util.prefs.Preferences;

public class CurrentUser {
    public static LoginService loginService = new LoginService();
    public static RegisterService registerService = new RegisterService();
    public static UserServices userServices = new UserServices();
    public static BookService bookService = new BookService();
    public static UserAccount userAccount;
    public static UserInfo userInfo = new UserInfo();
    public static ForgetPasswordService forgetPasswordService = new ForgetPasswordService();
    public static Preferences pref = Preferences.userRoot().node("rememberMe");
    public static EncryptorService encryptorService = new EncryptorService();
    public static DelAccountService delAccountService = new DelAccountService();
}

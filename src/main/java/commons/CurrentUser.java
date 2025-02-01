package commons;

import models.User.UserAccount;
import models.User.UserInfo;
import services.*;

import java.net.InetAddress;
import java.util.prefs.Preferences;

public class CurrentUser {
    public static LoginService loginService = new LoginService();
    public static RegisterService registerService = new RegisterService();
    public static UserServices userServices = new UserServices();
    public static UserAccount userAccount;
    public static UserInfo userInfo = new UserInfo();
    public static ForgetPasswordService forgetPasswordService = new ForgetPasswordService();
    public static Preferences pref = Preferences.userRoot().node("rememberMe");
    public static EncryptorService encryptorService = new EncryptorService();
}

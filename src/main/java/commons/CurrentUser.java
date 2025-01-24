package commons;

import models.User.UserAccount;
import models.User.UserInfo;
import services.ForgetPasswordService;
import services.LoginService;
import services.RegisterService;
import services.UserServices;

public class CurrentUser {
    public static LoginService loginService = new LoginService();
    public static RegisterService registerService = new RegisterService();
    public static UserServices userServices = new UserServices();
    public static UserAccount userAccount;
    public static UserInfo userInfo = new UserInfo();
    public static ForgetPasswordService forgetPasswordService = new ForgetPasswordService();
}

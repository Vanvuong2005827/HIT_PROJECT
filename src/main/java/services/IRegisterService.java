package services;

import models.user.UserAccount;

public interface IRegisterService {
    boolean register(UserAccount user) throws Exception;
}

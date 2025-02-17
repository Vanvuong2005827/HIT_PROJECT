package services;

import org.bson.types.ObjectId;

public interface IDelAccountService {
    void delAccount(ObjectId idUser);
}

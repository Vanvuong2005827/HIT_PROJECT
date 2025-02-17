package services;

public interface IEncryptorService {
    String hashing(String plainText);
    boolean checkPassword(String plainText, String hashedPassword);
}

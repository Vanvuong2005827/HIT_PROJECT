package models.User;

import org.bson.types.ObjectId;

import java.util.Date;

public class UserInfo {
    private ObjectId id;
    private String fullName;
    private int Birthday;
    private String Email;
    private String PhoneNumber;
    private String Sex;

    public UserInfo() {
        fullName = "";
        Birthday = 0;
        Email = null;
        PhoneNumber = null;
        Sex = null;
    }

    public UserInfo(String fullName ,int Birthday, String Email, String PhoneNumber, String sex, UserAccount userAccount) {
        this.id = userAccount.getId();
        this.Birthday = Birthday;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Sex = sex;
        this.fullName = fullName;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getBirthday() {
        return Birthday;
    }

    public void setBirthday(int birthday) {
        Birthday = birthday;
    }

    public String getEmail() { return Email; }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getSex(){
        return Sex;
    }

    public void setSex(String sex){
        Sex = sex;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}

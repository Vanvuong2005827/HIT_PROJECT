package models.User;

import java.util.Date;

public class UserInfo {
    private UserAccount account;
    private Date Birthday;
    private String Email;
    private String PhoneNumber;
    private Sex Sex;

    public UserInfo() {
        Birthday = null;
        Email = null;
        PhoneNumber = null;
        account = null;
        Sex = null;
    }

    public UserInfo(UserAccount account, Date Birthday, String Email, String PhoneNumber, Sex sex) {
        this.account = account;
        this.Birthday = Birthday;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Sex = sex;
    }

    public UserAccount getAccount() {
        return account;
    }

    public void setAccount(UserAccount account) {
        this.account = account;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Sex getSex(){
        return Sex;
    }

    public void setSex(Sex sex){
        Sex = sex;
    }


}

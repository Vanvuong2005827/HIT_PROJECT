package commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckRegex {
    public static boolean checkValidEmail(String email) {
        String EMAIL_PATTERN = Patterns.EMAIL_PATTERN;
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean checkValidPhoneNumber(String phoneNumber) {
        String PHONE_NUMBER_PATTERN = Patterns.PHONE_NUMBER_PATTERN;
        Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }


//    no _ or . at the end
//    allowed characters a-zA-Z0-9
//    no __ or _. or ._ or .. inside
//    no _ or . at the beginning
//    username is 8-20 characters long
    public static boolean checkValidUserName(String username) {
        String USERNAME_PATTERN = Patterns.USERNAME_PATTERN;
        Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

//    tối thiểu 8 ký tự, ít nhất 1 chữ cái in hoa, 1 chữ cái in thường, 1 chữ số và 1 ký tự đặc biệt.
    public static boolean checkValidPassword(String password) {
        String PASSWORD_PATTERN = Patterns.PASSWORD_PATTERN;
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}

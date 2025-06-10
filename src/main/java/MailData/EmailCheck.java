package MailData;

public class EmailCheck {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9][a-zA-Z0-9._-]*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";

    public static boolean checkEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }
}

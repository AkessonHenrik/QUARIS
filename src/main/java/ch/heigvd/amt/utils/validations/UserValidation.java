package ch.heigvd.amt.utils.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {
    
    // http://stackoverflow.com/a/8204716/1066915
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean email(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return email.length() <= 64 && matcher.find();
    }

    public static boolean username(String username) {
        return username.length() <= 32;
    }

    public static boolean password(String password) {
        return password.length() >= 3;
    }
}

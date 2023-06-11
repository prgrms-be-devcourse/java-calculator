package util;

import exception.NoSuchCommandException;

public class Validator {

    public static void checkIsDigit(String str) {
        if (str.length() != 1) {
            throw new NoSuchCommandException();
        }
        try {
            Character.isDigit(str.charAt(0));
        } catch (RuntimeException e) {
            throw new NoSuchCommandException();
        }
    }
}

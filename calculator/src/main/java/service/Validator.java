package service;

import java.util.ArrayList;

public class Validator {

    public void validateFormat(ArrayList<Object> postFix) {
        if (postFix.size() == 0 || postFix.size() % 2 == 0) {
            throw new IllegalArgumentException();
        }
    }

    public double validateDouble(String number) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}

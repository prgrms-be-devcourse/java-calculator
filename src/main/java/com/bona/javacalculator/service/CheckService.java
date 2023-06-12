package com.bona.javacalculator.service;

public class CheckService {
    static boolean isOperator(String s) {
        if (s.length() > 1) {
            return false;
        }
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return true;
        }
        return false;
    }

    public static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.length() == 1 && s.charAt(0) == '-') {
                return false;
            }
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
}

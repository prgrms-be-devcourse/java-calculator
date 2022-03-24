package com.programmers.java;
import java.util.StringTokenizer;

public class Calculator {

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public boolean invalidCheck(StringTokenizer s) {
        for (int i = 0; s.hasMoreElements(); i++) {
            String str = s.nextToken();
            if (i % 2 == 1) {
                if (str.length() > 1 || !isOperator(str.charAt(0)))
                    return false;
            }
            else {
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(0) == '-') {
                        if (str.length() <= 1)
                            return false;
                    }
                    else if (!isDigit(str.charAt(j)))
                        return false;
                }
            }
        }
        return true;
    }
}


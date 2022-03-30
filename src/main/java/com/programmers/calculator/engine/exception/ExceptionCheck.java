package com.programmers.calculator.engine.exception;

import com.programmers.calculator.engine.Regex;

import java.util.Stack;
import java.util.regex.Pattern;

public class ExceptionCheck {
    public boolean exceptionCheck(String[] numsNSymbols) {
        boolean ret = true;
        Stack<String> parentheses = new Stack<>();
        String lastString = "";

        for(String s : numsNSymbols) {
            // 정수의 경우
            if (Pattern.matches(Regex.getNumRegex(), s)) {
                if(!lastString.equals("") && !lastString.equals("(") &&
                        !lastString.equals("+") && !lastString.equals("-") &&
                        !lastString.equals("*") && !lastString.equals("/")) {
                    ret = false;
                    break;
                }
            } else if (s.equals("(")) {
                if(!lastString.equals("") &&
                        !lastString.equals("+") && !lastString.equals("-") &&
                        !lastString.equals("*") && !lastString.equals("/")) {
                    ret = false;
                    break;
                } else {
                    parentheses.push(s);
                }
            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                if (!Pattern.matches(Regex.getNumRegex(), lastString) && !lastString.equals(")")) {
                    ret = false;
                    break;
                }
            } else if (s.equals(")")) {
                if (!Pattern.matches(Regex.getNumRegex(), lastString)) {
                    ret = false;
                    break;
                } else {
                    if(parentheses.isEmpty() || !parentheses.pop().equals("(")) {
                        ret = false;
                        break;
                    }
                }
            } else {
                ret = false;
                break;
            }

            lastString = s;
        }

        if(!parentheses.isEmpty()) ret = false;

        return ret;
    }
}

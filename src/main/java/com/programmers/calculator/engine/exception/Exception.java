package com.programmers.calculator.engine.exception;

import com.programmers.calculator.engine.Regex;

import java.util.Stack;
import java.util.regex.Pattern;

public class Exception {
    public static boolean check(String[] numsNSymbols) {
        boolean ret = true;
        Stack<String> parentheses = new Stack<>();
        String lastString = "";

        for(String s : numsNSymbols) {
            // (정수) lastString이 초기상태인 경우, "("인 경우, 사칙연산인 경우 제외하면 error
            if (Pattern.matches(Regex.getNumRegex(), s)) {
                if(!lastString.equals("") && !lastString.equals("(") &&
                        !lastString.equals("+") && !lastString.equals("-") &&
                        !lastString.equals("*") && !lastString.equals("/")) {
                    ret = false;
                    break;
                }
            }
            // ("(") lastString이 초기상태인 경우, 사칙연산인 경우 제외하면 error
            else if (s.equals("(")) {
                if(!lastString.equals("") &&
                        !lastString.equals("+") && !lastString.equals("-") &&
                        !lastString.equals("*") && !lastString.equals("/")) {
                    ret = false;
                    break;
                } else {
                    parentheses.push(s);
                }
            }
            // (사칙연산) lastString이 정수인 경우, ")"인 경우 제외하면 error
            else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                if (!Pattern.matches(Regex.getNumRegex(), lastString) && !lastString.equals(")")) {
                    ret = false;
                    break;
                }
            }
            // (")") lastString이 정수인 경우 제외하면 error
            else if (s.equals(")")) {
                if (!Pattern.matches(Regex.getNumRegex(), lastString)) {
                    ret = false;
                    break;
                } else {
                    if(parentheses.isEmpty() || !parentheses.pop().equals("(")) {
                        ret = false;
                        break;
                    }
                }
            }
            // 정수, "(", ")", 사칙연산 제외 error
            else {
                ret = false;
                break;
            }

            lastString = s;
        }

        if(!parentheses.isEmpty()) ret = false;

        return ret;
    }
}

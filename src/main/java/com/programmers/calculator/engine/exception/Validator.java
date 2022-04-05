package com.programmers.calculator.engine.exception;

import com.programmers.calculator.engine.Operator;
import com.programmers.calculator.engine.Regex;

import java.util.Stack;
import java.util.regex.Pattern;

public class Validator {
    public static boolean exceptionCheck(String[] numsAndSymbols) {
        boolean ret = true;
        Stack<String> parentheses = new Stack<>();
        String lastString = "";

        for(String numAndSymbol : numsAndSymbols) {
            // (정수) lastString이 초기상태인 경우, "("인 경우, 사칙연산인 경우 제외하면 error
            if (Pattern.matches(Regex.NUM, numAndSymbol) && !numAndSymbol.equals("-")) {
                if(!lastString.equals("") &&
                        !lastString.equals("(") &&
                        !Operator.isOperator(lastString)) {
                    ret = false;
                    break;
                }
            }
            // ("(") lastString이 초기상태인 경우, 사칙연산인 경우, "("인 경우 제외하면 error
            else if (numAndSymbol.equals("(")) {
                if(!lastString.equals("") &&
                        !Operator.isOperator(lastString) &&
                        !lastString.equals("(")) {
                    ret = false;
                    break;
                } else {
                    parentheses.push(numAndSymbol);
                }
            }
            // (사칙연산) lastString이 정수인 경우, ")"인 경우 제외하면 error
            else if (Operator.isOperator(numAndSymbol)) {
                if (!Pattern.matches(Regex.NUM, lastString)
                        && !lastString.equals(")")) {
                    ret = false;
                    break;
                }
            }
            // (")") lastString이 정수인 경우, ")"인 경우 제외하면 error
            else if (numAndSymbol.equals(")")) {
                if (!Pattern.matches(Regex.NUM, lastString) &&
                        !lastString.equals(")")) {
                    ret = false;
                    break;
                } else {
                    if(parentheses.isEmpty()) {
                        ret = false;
                        break;
                    }
                    parentheses.pop();
                }
            }
            // 정수, "(", ")", 사칙연산 제외 error
            else {
                ret = false;
                break;
            }

            lastString = numAndSymbol;
        }

        if(!parentheses.isEmpty()) ret = false;

        return ret;
    }
}

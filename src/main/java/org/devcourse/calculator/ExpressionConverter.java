package org.devcourse.calculator;

import org.devcourse.util.DigitChecker;
import org.devcourse.util.RegexPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionConverter {


    // 입력된 수식 타입변환: 문자열 -> 리스트
    public static List<String> expressionStrToList(String exp) {

        List<String> expressionList = new ArrayList<>();

        Pattern pattern = RegexPattern.OPERATOR_PATTERN; // 연산자

        int li=0, ri=1;
        if(exp.charAt(0) == '(') {
            expressionList.add("(");
            li++;
        } else if (exp.charAt(0) == '-' && !Character.isDigit(exp.charAt(1))) {
            expressionList.add("-1");
            expressionList.add("*");
            li++;
        }

        while (ri < exp.length()) {

            Matcher matcher = pattern.matcher(String.valueOf(exp.charAt(ri)));

            if (matcher.find()) {

                // 피연산자(operand) 저장
                if (DigitChecker.isDigit(exp.substring(li, ri))) {

                    boolean isNegative = (li >= 2 && (exp.charAt(li - 1) == '-' && exp.charAt(li - 2) == '('));

                    if(isNegative) {
                        expressionList.add(exp.substring(li-1, ri)); // 음수 저장
                    } else {
                        expressionList.add(exp.substring(li, ri)); // 양수 저장
                    }
                }

                // 연산자(operation) 저장
                if( ri>= 1 && !(exp.charAt(ri) == '-' && exp.charAt(ri - 1) == '(' && exp.charAt(ri+1) != '(')) {

                    if(exp.charAt(ri) == '-' && exp.charAt(ri - 1) == '(') {
                        expressionList.add("-1");
                        expressionList.add("*");
                    } else {
                        expressionList.add(String.valueOf(exp.charAt(ri)));

                    }
                }


                li = ri+1;

            }

            ri++;

        }

        if(li < exp.length())
            expressionList.add(exp.substring(li, ri));


        return expressionList;

    }


    // 중위 표기식 -> 후위 표기식 변환
    public static List<String> infixToPostfix(List<String> infix) {

        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String term : infix) {

            switch (term) {

                case "*":
                case "/":
                    if (stack.isEmpty() || stack.peek().equals("(")) {

                        stack.push(term);

                    } else if (stack.peek().equals("+") || stack.peek().equals("-")) {

                        stack.push(term);

                    } else if (stack.peek().equals("*") || stack.peek().equals("/")) {

                        postfix.add(stack.pop());
                        stack.push(term);

                    }

                    break;


                case "+":
                case "-":

                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfix.add(stack.pop());
                    }

                    stack.push(term);
                    break;


                case "(":
                    stack.push("(");
                    break;


                case ")":

                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfix.add(stack.pop());
                    }

                    if (!stack.isEmpty()) {
                        stack.pop();
                    }

                    break;


                default:
                    postfix.add(term);

            }
        }


        while (!stack.isEmpty()) {
            String c = stack.pop();
            if(c.equals("(")) continue;
            else
                postfix.add(c);
        }


        return postfix;

    }


    // 연산결과 출력 양식으로 변환
    public static String convertToResult(String expression, String result) {

        return expression + " = " + result;
    }




}

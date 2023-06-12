package org.devcourse.validator;

import org.devcourse.exception.InputExpressionException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionValidator<T> implements Validator<T> {


    @Override
    public boolean validate(T expression) {

        try {

            if (expression instanceof String) {

                String exp = (String) expression;

                checkWrongOperator(exp); // 연산자,피연산자 외 문자여부 검증
                checkOperatorOrder(exp); // 연산자 순서 검증
                checkParentheses(exp);   // 괄호 쌍 검증

            }

            return true;

        } catch (InputExpressionException e) {
            System.out.println(e.getMessage());
            return false;
        }


    }


    // 수식 제외한 입력이 있는 지 판단
    private void checkWrongOperator(String exp) throws InputExpressionException {


        String expression = exp.replaceAll(" ", "");

        Pattern pattern = Pattern.compile("^[\\.+\\-*/\\(\\)\\d]*$"); // 연산자, 피연산자(\\d)
        Matcher matcher = pattern.matcher(expression);

        if (exp.equals("")) {
            throw new InputExpressionException("수식을 입력하세요.");
        }

        else if(!matcher.find()) {
            throw new InputExpressionException("잘못된 값이 포함되어 있습니다.");
        }

    }


    // 연산자 배치가 올바른 지 판단
    private void checkOperatorOrder(String exp) throws InputExpressionException {


        Pattern operandPattern = Pattern.compile("[0-9\\(\\)\\.]");
        Pattern notOperandPattern = Pattern.compile("[0-9]\\(|\\)[0-9]");

        char firstChar = exp.charAt(0);
        char lastChar = exp.charAt(exp.length()-1);

        if (firstChar == '*' || firstChar == '/') {
            throw new InputExpressionException("수식 가장 앞에 연산자가 올 수 없습니다.");
        }

        else if(!operandPattern.matcher(String.valueOf(lastChar)).find()) {
            throw new InputExpressionException("수식 가장 끝은 피연산자로 종료되어야 합니다.");
        }

        for (int i = 0; i < exp.length()-2; i++) {

            String subStr = exp.substring(i, i + 2);
            Matcher operandMatcher = operandPattern.matcher(subStr);
            Matcher notOperandMatcher = notOperandPattern.matcher(subStr);

            if(!operandMatcher.find() || notOperandMatcher.find()) {
                throw new InputExpressionException("올바르지 않은 연산자 형식이 들어있습니다. e.g.) --, +- , 1*-10, 2(1+1), (1+1)2 ");
            }
        }


    }


    // 괄호의 쌍이 맞는 지 확인
    private void checkParentheses(String exp) {

        Stack<Character> stack = new Stack<>();

        for (char c : exp.toCharArray()) {

            if (c == ')') {

                if (stack.isEmpty()) {
                    throw new InputExpressionException("괄호의 쌍이 올바르지 않습니다.");

                } else {
                    stack.pop();
                }
            }

            else if (c == '(') {
                stack.push('(');
            }

        }

        if(!stack.isEmpty()) throw new InputExpressionException("괄호의 쌍이 올바르지 않습니다.");
    }

}

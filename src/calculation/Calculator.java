package src.calculation;


import src.exception.ErrorMessage;

import java.util.Stack;
import java.util.regex.Pattern;


/**
 * 요구사항
 * 1. +, -, *, / 우선 순위 연산
 * 2. 실수와 정수 모두 피연산자로 들어올 수 있다.
 *    -> (+추가한 사항) 모든 연산은 소수점 아래 둘째자리 반올림
 *    -> (+필요한 부분) 음수 값 (-10) 처리x, 중괄호 포함 연산 처리x
 * 3. 예외 처리 사항
 *    1. 0으로 나누는 경우
 *    2. 수식에 숫자 연산자가 아닌 다른 문자가 포함 되는 경우
 *    3. 잘못된 수식인 경우 -> 1 ++ 2, 1 + 2 * 등등
 *    4. 수식이 null || "" || " " 인 경우
 */
public class Calculator {
    /*
        계산 로직
        1. 중위 표기법 -> 후위 표기법 변환
        2. 후위 표기법 계산
     */
    public static String calculate(String expression) {

        if(expression == null || expression.isBlank()){
            throw new RuntimeException(ErrorMessage.EMPTY_EXPRESSION.getMessage());
        }
        Double answer;
        try {
            String postfix = infixToPostfix(expression); // 중위 표기법 -> 후위 표기법 변환
            answer = calculatePostfix(postfix); // 후위 표기법 계산
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        //소수점 아래 둘째 자리 반올림
        double result = Math.round(answer * 100) / 100.0;

        //소수점 아래 0일경우 절삭
        //3.00 -> 3
        if(result - (int)result == 0){
            return String.valueOf((int)result);
        }
        return String.valueOf(result);
    }

    // 후위 표기법 계산
    private static double calculatePostfix(String postfix) {
        Stack<String> stack = new Stack<>();
        String element[] = postfix.split(" ");

        for (int i = 0; i < element.length; i++) {
            String s = element[i];
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                if(stack.size() < 2){ // 피연산자가 부족 -> 잘못된 수식, 예외 처리
                    throw new RuntimeException(ErrorMessage.NOT_FOUND_OPERAND.getMessage());
                }
                double op2 = Double.parseDouble(stack.pop());
                double op1 = Double.parseDouble(stack.pop());

                if(s.equals("+"))
                    stack.push(String.valueOf(op1 + op2));
                else if(s.equals("-"))
                    stack.push(String.valueOf(op1 - op2));
                else if(s.equals("*"))
                    stack.push(String.valueOf(op1 * op2));
                else if(s.equals("/")) {
                    if(op2 == 0){ // 0으로 나누는경우 예외 처리
                        throw new RuntimeException(ErrorMessage.DIVIDE_BY_ZERO.getMessage());
                    }
                    stack.push(String.valueOf(op1 / op2));
                }

            }else{
                stack.push(s);
            }
        }
        if(stack.size() != 1){ // 최종 값이 하나가 아니다. -> 잘못된 수식, 예외 처리
            throw new RuntimeException(ErrorMessage.NOT_FOUND_OPERATOR.getMessage());
        }
        return Double.parseDouble(stack.pop());
    }

    // 중위 표기법 -> 후위 표기법 변환
    private static String infixToPostfix(String expression) {
        String element[] = expression.split(" ");
        Stack<String> stack = new Stack<>();

        StringBuffer postfix = new StringBuffer();

        for (int i = 0; i < element.length; i++) {
            String s = element[i];

            if(!validateExpression(s)){
                throw new RuntimeException(ErrorMessage.INVALID_EXPRESSION.getMessage());
            }
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                while (!stack.isEmpty() && (prec(s) <= prec(stack.peek()))) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(s);
            } else {
                postfix.append(s).append(" ");
            }
        }
        while(!stack.isEmpty()){
            postfix.append(stack.pop()).append(" ");
        }
        return postfix.toString();
    }

    //입력 예외 처리
    private static boolean validateExpression(String s) {
        /**
         * 예외 처리
         * 1. 빈 값이거나 공백만 있는 경우
         * 2. 숫자, 연산자가 아닌 문자이거나 올바르지 않은 입력(-> "+++" 또는 "24234+")인 경우
         */
        if(s.isBlank()){
            return false;
        }
        if(s.length() == 1){
            return Pattern.matches("^[+\\-/*0-9]$", s);
        }
        return Pattern.matches("^[0-9.?]+$", s);
    }


    // 우선순위를 반환
    private static int prec(String s) {
        if (s.equals("+") || s.equals("-") )
            return 0;
        return 1;
    }
}

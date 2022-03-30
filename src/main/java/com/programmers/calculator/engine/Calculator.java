package com.programmers.calculator.engine;

import com.programmers.calculator.engine.exception.ExceptionCheck;
import com.programmers.calculator.engine.io.Input;
import com.programmers.calculator.engine.io.Output;
import com.programmers.calculator.engine.repository.ExpressionAndResult;

import java.util.*;
import java.util.regex.Pattern;

public class Calculator implements Runnable{
    private final Input input;
    private final Output output;
    private final ExpressionAndResult expressionAndResult; // 연산식, 결과 저장

    public Calculator(Input input, Output output) {
        this.input = input;
        this.output = output;
        expressionAndResult = new ExpressionAndResult(output);
    }

    @Override
    public void run() {
        while(true) {
            String s = input.input("1. 조회\n2. 계산\n3. 종료\n\n선택 : ");
            output.printEmpty();
            boolean close = false;
            switch(s) {
                case "1" :
                    expressionAndResult.print();
                    break;
                case "2" :
                    String expression = input.input("수식 입력 : ");
                    calc(expression);
                    break;
                case "3" :
                    close = true;
                    break;
                default :
                    output.inputError();
                    break;
            }

            if(close) break;
            output.printEmpty();
        }
    }

    // 연산식을 후위표기법으로 변환 -> Optional null체크 -> 후위표기법 계산하고 출력 -> map에 연산식, 결과 저장
    public void calc(String expression) {
        Optional<List<String>> postfix = infixToPostfix(expression);

        // 예외 출력
        if(!postfix.isPresent()) {
            output.inputError();
            return;
        }

        // 후위표기법 연산
        Stack<String> stack = new Stack<>();
        for(String s : postfix.get()) {
            if(Pattern.matches(Regex.getNumRegex(), s)) {
                stack.push(s);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                stack.push(s.equals("+") ? Integer.toString(num1 + num2) :
                           s.equals("-") ? Integer.toString(num1 - num2) :
                           s.equals("*") ? Integer.toString(num1 * num2) :
                                           Integer.toString(num1 / num2));
            }
        }

        int result = Integer.parseInt(stack.pop());
        output.printResult(result); // 결과 출력
        expressionAndResult.put(expression, result); // map에 저장
    }

    // 예외 체크 후 중위표기법 => 후위표기법 변환 (수식이 잘못 입력된 경우 Optional.empty() 리턴)
    public Optional<List<String>> infixToPostfix(String infix) {
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        String[] numsNSymbols = infix.split(" ");

        // 예외 체크
        ExceptionCheck ec = new ExceptionCheck();
        if(!ec.exceptionCheck(numsNSymbols)) {
            return Optional.empty();
        }

        // 중위 표기법 => 후위표기법 변환
        for(String s : numsNSymbols) {
            if (Pattern.matches(Regex.getNumRegex(), s)) {
                postfix.add(s);
            } else if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                if (!stack.isEmpty() && Priority.getPriority(stack.peek()) >= Priority.getPriority(s)) {
                    postfix.add(stack.pop());
                    stack.push(s);
                } else {
                    stack.push(s);
                }
            } else if (s.equals(")")) {
                while (true) {
                    String tmp = stack.pop();
                    if (tmp.equals("(")) break;
                    postfix.add(tmp);
                }
            }
        }

        while(!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return Optional.of(postfix);
    }
}

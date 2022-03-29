package com.programmers.calculator.engine;

import com.programmers.calculator.engine.io.Input;
import com.programmers.calculator.engine.io.Output;
import com.programmers.calculator.engine.repository.ExpressionAndResult;

import java.util.*;
import java.util.regex.Pattern;

public class Calculator implements Runnable{
    private Input input;
    private Output output;
    private ExpressionAndResult expressionAndResult;

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

    public void calc(String expression) {
        Optional<List<String>> postfix = infixToPostfix(expression);
        if(!postfix.isPresent()) {
            output.inputError();
            return;
        }

        Stack<String> stack = new Stack<>();
        for(String s : postfix.get()) {
            if(Pattern.matches(Regex.getNum(), s)) {
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
        expressionAndResult.put(expression, result);

        output.printResult(result);
    }

    public Optional<List<String>> infixToPostfix(String infix) {
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        String[] numsNSymbols = infix.split(" ");
        for(String s : numsNSymbols) {
            if (Pattern.matches(Regex.getNum(), s)) {
                postfix.add(s);
            } else if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                if (stack.isEmpty()) {
                    stack.push(s);
                } else {
                    if (Priority.getPriority(stack.peek()) >= Priority.getPriority(s)) {
                        postfix.add(stack.pop());
                        stack.push(s);
                    } else {
                        stack.push(s);
                    }
                }
            } else if (s.equals(")")) {
                while(true) {
                    String tmp = stack.pop();
                    if(tmp.equals("(")) break;
                    postfix.add(tmp);
                }
            } else {
                return Optional.empty();
            }
        }

        while(!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return Optional.of(postfix);
    }
}

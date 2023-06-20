package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.model.Operator;
import com.programmers.java.calculator.engine.model.Result;
import static com.programmers.java.calculator.engine.History.records;

import java.util.ArrayDeque;
import java.util.Deque;

// 계산
public class CalculatorEngine {
    public void start(String form) {
        double answer = calPostfix(infixTopostfic(form)); // 후위 연산식으로 변경 후 계산
        System.out.println(answer);
        records.add(new Result(form, answer));
        System.out.println();
    }


    // 중위 표기식 -> 후위 표기식 변환
    public String infixTopostfic(String s){
        StringBuilder postFix = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                postFix.append(c);
            }
            else if(c == '('){
                stack.push(c);
            }
            else if(c == ')'){
                while (stack.size() != 0 && stack.peek() != '('){
                    postFix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    throw new IllegalArgumentException("잘못된 괄호입니다.");
                }
                stack.pop(); // ( 제거
            }
            else{
                while(!stack.isEmpty() && Operator.getPriority(c) <= Operator.getPriority(stack.peek())){
                    postFix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while(!stack.isEmpty()){
            if(stack.peek() == '('){
                throw new IllegalArgumentException("잘못된 괄호입니다.");
            }
            postFix.append(stack.pop());
        }

        return postFix.toString();
    }

    // 후위 표기식으로 계산 결과 return
    public double calPostfix(String postFix){
        Deque<Double> stack = new ArrayDeque<>();

        for(char c : postFix.toCharArray()){
            if(Character.isDigit(c)){
                stack.push((double)c-48);
            }
            else{
                if(stack.size() < 2){
                    throw new IllegalArgumentException("잘못된 postFix");
                }
                double op1 = stack.pop();
                double op2 = stack.pop();

                switch (c){
                    case '+':
                        stack.push(op1 + op2);
                        break;
                    case '-':
                        stack.push(op2 - op1);
                        break;
                    case '*':
                        stack.push(op1 * op2);
                        break;
                    case '/':
                        stack.push(op2 / op1);
                        break;
                }
            }
        }

        if(stack.size() != 1)
            throw new IllegalArgumentException("잘못된 postFix, 사유:stack.size!=1");

        return stack.pop();
    }


}

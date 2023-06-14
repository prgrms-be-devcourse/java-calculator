package com.programmers.java.calculator.engine;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

// 계산
public class Calculation {
    public void start(String form) {
        System.out.println(calPostfix(infixTopostfic(form)));
        System.out.println();
    }

    // 연산자 우선순위 반환
    private int getPrecedence(char operator){
        if(operator == '+' || operator == '-'){
            return 1;
        }
        else if(operator == '*' || operator == '/'){
            return 2;
        }
        else if(operator == '('){
            return 3;
        }
        else {
            return -1;
        }
    }

    // 중위 표기식 -> 후위 표기식 변환
    private String infixTopostfic(String s){
        // StringTokenizer tokenizer = new StringTokenizer(s, "+-*/()");
        StringBuilder postFix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                postFix.append(c);
            }
            else if(c == '('){
                stack.push(c);
            }
            else if(c == ')'){
                while (!stack.empty() && stack.peek() != '('){
                    postFix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    throw new IllegalArgumentException("잘못된 괄호입니다.");
                }
                stack.pop(); // ( 제거
            }
            else{
                while(!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())){
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
    private int calPostfix(String postFix){
        Stack<Integer> stack = new Stack<>();
        System.out.println("postFix:"+postFix);

        for(char c : postFix.toCharArray()){
            if(Character.isDigit(c)){
                stack.push(Integer.valueOf(c-48));
            }
            else{
                if(stack.size() < 2){
                    throw new IllegalArgumentException("잘못된 postFix");
                }
                int op1 = stack.pop();
                int op2 = stack.pop();

                switch (c){
                    case '+':
                        stack.push(op1 + op2);
                        break;
                    case '-':
                        stack.push(op1 - op2);
                        break;
                    case '*':
                        stack.push(op1 * op2);
                        break;
                    case '/':
                        stack.push(op1 / op2);
                        break;
                }
            }
        }

        if(stack.size() != 1)
            throw new IllegalArgumentException("잘못된 postFix, 사유:stack.size!=1");

        return stack.pop();
    }


}

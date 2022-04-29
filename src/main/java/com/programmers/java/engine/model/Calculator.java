package com.programmers.java.engine.model;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Stack;

/*
 * Calculator : 계산 일을 담당하는 클래스
 * - 계산 과정 : 1. 호스트로부터 String 배열을 받고 이를 후위 연산으로 바꾼다.
 * - 2. 후위 연산 리스트를 계산한다.
 * */
public class Calculator {

    private final ArrayList<String> posixList = new ArrayList<>();
    /*
     * calculate : String[]을 받아 계산식을 계산 후 답을 String으로 반환하는 메소드
     * */
    public String calculate(String[] userStr) {
        //후위연산으로 전환
        changeToPosix(userStr);
        //posixList 계산
        Stack<Double> stack = new Stack<>();
        double ans = 0;
        for (String str : posixList) {
            Optional<Operator> operator = Operator.getOperator(str);
            if (operator.isEmpty()) {
                //피연산자
                stack.push(Double.parseDouble(str));
                continue;
            }
            //연산자
            if (stack.size() >= 2) {
                double num1 = stack.pop();
                double num2 = stack.pop();
                ans = Operator.calculate(operator.get(), num2, num1);
            }
            stack.push(ans);
        }

        if (ans == (int) ans) return Integer.toString((int) ans);
        return String.format("%.2f", stack.pop());
    }

    /*
     * changeToPosix : 주어진 String 배열을 후위 연산으로 바꾸어 posixList에 저장하는 메소드
     * */
    private void changeToPosix(String[] userStr) throws NumberFormatException {
        Stack<Operator> stack = new Stack<>();
        for (String str : userStr) {
            Optional<Operator> operator = Operator.getOperator(str);
            if (operator.isPresent()) {
                //연산자
                if (stack.isEmpty()) stack.push(operator.get());
                else {
                    int diff = stack.peek().getPriority() - operator.get().getPriority();
                    if (diff >= 0) posixList.add(stack.pop().toString());
                    stack.push(operator.get());
                }
                continue;
            }
            //피연산자
            posixList.add(str);
        }
        while (!stack.isEmpty()) {
            posixList.add(stack.pop().toString());
        }
    }


}

package com.programmers.java.calculator;

import com.programmers.java.data.Result;
import com.programmers.java.data.Store;
import com.programmers.java.io.Input;
import com.programmers.java.io.Output;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class Calculator implements Runnable {

    private Input input;
    private Output output;
    private Store store;

    @Override
    public void run() {
        while (true) {
            int in = input.select("1. 조회 \n2. 계산");
            // 1. 조회
            if (in == 1) {
                List<Result> history = store.getStore();
                history.forEach(i -> output.output(i));
            } else if (in == 2) {
                // 2. 계산
                String expression = input.input();
                expression = toString(expression);
                if (validate(expression)) {
                    // 이미 계산한 이력이 있다면 가져옴.
                    if (store.contain(expression)) {
                        output.outputAnswer(store.getResult(expression).get());
                    } else {
                        // 없으면 계산
                        output.outputAnswer(calculate(expression));
                    }
                } else output.error();
            } else output.error();
        }
    }

    public String toPostfix(String exp) {
        ArrayList<String> postFix = new ArrayList<>();
        String[] s = exp.replace(" ", "").split("");
        Stack<String> stack = new Stack<>();

        for (String t : s) {
            if (isNum(t)) postFix.add(t);
            else {
                if (t.equals("(")) {
                    continue;
                }
                if (t.equals(")")) { // 괄호 안에 있는 식부터 연산하도록 먼저 모두 후위식으로 보냄
                    while (!stack.isEmpty()) {
                        postFix.add(stack.pop());
                    }
                } else {
                    while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        postFix.add(stack.pop());
                    }
                    stack.push(t);
                }
            }
        }
        while (!stack.isEmpty()) postFix.add(stack.pop());
        return String.join("", postFix);
    }

    // 숫자인지 아닌지 판단
    public boolean isNum(String s){
        return s.matches("^[0-9]*$");
    }

    // 수식 예쁘게 만들기
    public String toString(String s){
        return Arrays.stream(s.replace(" ", "").split(""))
                .map(i -> i + " ")
                .collect(Collectors.joining(""));
    }

    public Result calculate(String s) {
        String exp = toPostfix(s);
        Stack<Integer> nums = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                nums.push(Character.getNumericValue(c));
            } else {
                int a = nums.pop();
                int b = nums.pop();
                switch (c) {
                    case '+' -> nums.push(b + a);
                    case '-' -> nums.push(b - a);
                    case '*' -> nums.push(b * a);
                    case '/' ->
                        // 0으로 나누는 예외 처리 해주기
//                        if(a == 0) {
//                            Result<String> res = new Result<>(toString(s), "오류");
//                            return res;
//                        }
                        nums.push(b / a);

                }
            }
        }

        Result res = new Result(toString(s), nums.pop());
        store.save(res);
        return res;
    }

    // 사용자 입력 유효 검사
    public boolean validate(String exp) {
        String[] s = exp.replace(" ", "").split("");
        List<String> operator = Arrays.asList("+", "-", "*", "/");
        boolean isOperator = false;
        boolean isDivide = false;
        Stack<Integer> bracket = new Stack<>();
        int countOperator = 0;
        int countNum = 0;

        if(operator.contains(s[0]) || operator.contains(s[s.length-1])) return false;

        for (String t : s) {
            if (t.matches("^[0-9]*$")) {
                if (t.equals("0") && isDivide) return false;
                isOperator = false;
                isDivide = false;
                countNum += 1;
            } else if (operator.contains(t)) {
                if (isOperator) {
                    return false;
                }
                isOperator = true;
                countOperator += 1;
                if (t.equals("/")) {
                    isDivide = true;
                }
            } else if (t.equals("(")) {
                bracket.add(1);
            } else if (t.equals(")")) {
                try {
                    bracket.pop();
                } catch (EmptyStackException e) {
                    return false;
                }
            }
        }
        if(countOperator >= countNum || countOperator == 0) return false;
        return bracket.isEmpty();
    }
}

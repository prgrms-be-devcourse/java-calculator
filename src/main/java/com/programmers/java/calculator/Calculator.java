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

            if (in == 1) {
                List<Result> history = store.getStore();
                history.stream()
                        .iterator()
                        .forEachRemaining(i -> output.output(i));
            } else if (in == 2) {
                String expression = input.input();
                if (validate(expression)) {
                    if (store.contain(expression)) {
                        output.output(store.getResult(expression));
                    } else {
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

        for (int i = 0; i < s.length; i++) {
            String t = s[i];
            if (t.matches("^[0-9]*$")) postFix.add(t);
            else {
                while(!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))){
                    postFix.add(stack.pop());
                }
                stack.push(t);
            }
        }
        while (!stack.isEmpty()) postFix.add(stack.pop());
        return String.join("", postFix);
    }

    public Result calculate(String s) {
        String exp = toPostfix(s);
        Stack<Integer> nums = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                nums.push(Character.getNumericValue(c));
            } else { // EmptyStackException ?????
                int a = nums.pop();
                int b = nums.pop();
                switch (c) {
                    case '+' -> nums.push(b + a);
                    case '-' -> nums.push(b - a);
                    case '*' -> nums.push(b * a);
                    case '/' ->
                        // 0으로 나누는 예외 처리 해주기
                            nums.push(b / a);
                }
            }
        }

        s = String.join("", Arrays.asList(s.replace(" ", "").split("")).stream()
                .map(i -> i + " ")
                .collect(Collectors.toList()));
        Result res = new Result(s, nums.pop());
        store.save(res);
        return res;
    }

    public boolean validate(String exp) {
        List<String> s = Arrays.asList(exp.replace(" ", "").split(""));
        List<String> operator = Arrays.asList("+", "-", "*", "/");
        boolean isOperator = false;
        boolean isDivide = false;
        Stack<Integer> bracket = new Stack<>();

        for (int i = 0; i < s.size(); i++) {
            String t = s.get(i);
            if (t.matches("^[0-9]*$")) {
                if (t.equals("0") && isDivide) return false;
                isOperator = false;
                isDivide = false;
            } else if (operator.contains(t)) {
                if (isOperator) {
                    return false;
                }
                isOperator = true;
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
        if (!bracket.isEmpty()) return false;
        return true;
    }
}

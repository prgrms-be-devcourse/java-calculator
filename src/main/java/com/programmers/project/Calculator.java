package com.programmers.project;

import com.programmers.project.io.Console;
import com.programmers.project.io.Input;

import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class Calculator {

    private Console console = new Console();

    public String menu() {
        return console.menu();
    }

    public String priority(String s) {
        HashMap<String, Integer> pr = new HashMap<>(); // 우선순위 저장
        pr.put("+", 1);
        pr.put("-", 1);
        pr.put("*", 2);
        pr.put("/", 2);

        Stack<String> stack = new Stack<>();
        int start = 0;
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                String num = s.substring(start, i);
                result.append(num);

                if (!stack.isEmpty() && pr.get(stack.peek()) >= pr.get(s.substring(i, i + 1))) { // 스택에 있는 수가 우선순위가 높거나 같을 때
                    result.append(stack.pop());
                }
                stack.push(s.substring(i, i + 1));
                start = i+1;
            }
        }

        stack.push(s.substring(start,s.length()));  // 마지막 숫자 넣어주기 

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }



}

package org.example.domain;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalculateExecuter {
    public Integer calculate(String[] str) {
        final Deque<Integer> stack = new ArrayDeque<>();

        for (String x : str) {

            if (!x.equals("+") && !x.equals("-") && !x.equals("*") && !x.equals("/")) {
                stack.push(Integer.parseInt(x));
            } else {

                int a = stack.pop();
                int b = stack.pop();

                switch (x) {
                    case "+":
                        stack.push(b + a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "*":
                        stack.push(b * a);
                        break;
                    case "/":
                        stack.push(b / a);
                        break;
                }
            }
        }
        return stack.pop();
    }
}

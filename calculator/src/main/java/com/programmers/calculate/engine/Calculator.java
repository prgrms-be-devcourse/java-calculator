package com.programmers.calculate.engine;

import com.programmers.calculate.engine.io.Input;
import com.programmers.calculate.engine.io.Output;
import com.programmers.calculate.engine.model.History;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@AllArgsConstructor
public class Calculator implements Runnable {
    Input input;
    Output output;
    History history;

    @Override
    public void run() {
        boolean flag = true;

        while (flag) {
            int num = input.selectNumber();

            switch (num) {
                case 1:
                    System.out.println();
                    history.findAll();
                    System.out.println();
                    break;
                case 2:
                    String inputString = input.inputExpression();
                    Queue<String> queue = parse(inputString);
                    int answer = calculate(queue);
                    System.out.println(answer + "\n");
                    saveExpression(inputString, answer);
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    output.valueError();
            }
        }
    }

    private void saveExpression(String inputString, int answer) {
        String expression = inputString + " = " + answer;
        history.save(expression);
    }

    private int calculate(Queue<String> queue) {
        Stack<String> stack = new Stack<>();

        while (!queue.isEmpty()) {
            String exp = queue.poll();

            if (exp.matches("-?\\d+")) {
                stack.add(exp);
            } else {
                int x = Integer.parseInt(stack.pop());
                int y = Integer.parseInt(stack.pop());

                switch (exp) {
                    case "+":
                        stack.add(Integer.toString(y + x));
                        break;
                    case "-":
                        stack.add(Integer.toString(y - x));
                        break;
                    case "*":
                        stack.add(Integer.toString(y * x));
                        break;
                    case "/":
                        stack.add(Integer.toString(y / x));
                        break;
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private Queue<String> parse(String inputString) {
        StringTokenizer st = new StringTokenizer(inputString, " ");
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            int priority = getPriority(str);

            if (str.matches("-?\\d+")) queue.add(str);
            else {
                while (!stack.isEmpty() && getPriority(stack.peek()) <= priority) queue.add(stack.pop());
                stack.push(str);
            }
        }

        while (!stack.isEmpty()) queue.add(stack.pop());

        return queue;
    }

    private int getPriority(String str) {
        switch (str) {
            case "*":
            case "/":
                return 1;
            case "+":
            case "-":
                return  2;
            default:
                return 3;
        }
    }
}

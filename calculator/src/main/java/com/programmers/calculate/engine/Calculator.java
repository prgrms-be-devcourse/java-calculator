package com.programmers.calculate.engine;

import com.programmers.calculate.engine.io.Input;
import com.programmers.calculate.engine.io.Output;
import com.programmers.calculate.engine.model.History;
import com.programmers.calculate.engine.model.Menu;

import java.util.*;

public class Calculator implements Runnable {
    private final Input input;
    private final Output output;
    private final History history;

    public Calculator(Input input, Output output, History history) {
        this.input = input;
        this.output = output;
        this.history = history;
    }

    @Override
    public void run() {
        while (true) {
            String selectNumber = input.selectNumber();

            if (selectNumber.equals(Menu.LOOK_UP.getValue())) {
                System.out.println();
                history.findAll(output);
                System.out.println();
            } else if (selectNumber.equals(Menu.CALCULATE.getValue())) {
                String inputString = input.inputExpression();
                Queue<String> queue = parse(inputString);
                int answer = calculate(queue);
                System.out.println(answer + "\n");
                saveExpression(inputString, answer);
            } else if (selectNumber.equals(Menu.EXIT.getValue())) break;
            else output.printErrorMessage();
        }
    }

    private void saveExpression(String inputString, int answer) {
        String expression = inputString + " = " + answer;
        history.save(expression);
    }

    protected int calculate(Queue<String> queue) {
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

    protected Queue<String> parse(String inputString) {
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

    protected int getPriority(String operator) {
        switch (operator) {
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

package com.programmers.calculate.engine;

import com.programmers.calculate.engine.model.io.Input;
import com.programmers.calculate.engine.model.io.Output;
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
        CalculatorManager calculatorManager = new CalculatorManager();

        while (calculatorManager.isRunnable()) {
            String selectNumber = input.selectNumber();
            Menu menu = Menu.matchNumber(selectNumber);

            switch (menu) {
                case LOOK_UP -> lookUp();
                case CALCULATE -> calculate();
                case EXIT -> calculatorManager.stopRunnable();
                default -> output.printErrorMessage();
            }
        }
    }

    private void calculate() {
        String inputString = input.inputExpression();
        Queue<String> queue = parse(inputString);
        int answer = calculatePostfix(queue);
        System.out.println(answer + "\n");
        saveExpression(inputString, answer);
    }

    private void lookUp() {
        System.out.println();
        history.findAll(output);
        System.out.println();
    }


    private void saveExpression(String inputString, int answer) {
        String expression = inputString + " = " + answer;
        history.save(expression);
    }

    protected int calculatePostfix(Queue<String> queue) {
        Stack<String> stack = new Stack<>();

        while (!queue.isEmpty()) {
            String exp = queue.poll();

            if (exp.matches("-?\\d+")) {
                stack.add(exp);
                continue;
            }

            int x = Integer.parseInt(stack.pop());
            int y = Integer.parseInt(stack.pop());

            switch (exp) {
                case "+" -> stack.add(Integer.toString(y + x));
                case "-" -> stack.add(Integer.toString(y - x));
                case "*" -> stack.add(Integer.toString(y * x));
                case "/" -> stack.add(Integer.toString(y / x));
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

package main.java.service;

import main.java.domain.Command;

import java.util.Stack;

public class Calculator {

    private Operator PM;
    private Operator MD;

    public Calculator() {}

    public int calculate(Command command) {
        PM = Operator.PLUS;
        MD = Operator.MULTIPLY;

        int result = 0;

        int[] numberArr = command.getNumberArr();
        Operator[] optArr = command.getOptArr();

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < command.getOptCount(); i++) {
            // nums
            calculateAndPush(numberArr[i], stack);

            // opts
            if(optArr[i].isPlusOrMinus()) {
                result = PM.calculateOpt(result, stack.peek());
                PM = optArr[i];
                stack.pop();
                continue;
            }
            MD = optArr[i];
        }

        calculateAndPush(numberArr[command.getOptCount()], stack);
        // 마지막 command의 숫자까지 처리.
        result = PM.calculateOpt(result, stack.peek());
        return result;
    }

    private void calculateAndPush(int number, Stack<Integer> stack) {
        if(stack.isEmpty()) {
            stack.push(number);
            return;
        }
        int top = stack.peek();
        stack.pop();
        stack.push(MD.calculateOpt(top, number));
    }
}

package com.caculator;

import com.caculator.io.Input;
import com.caculator.io.Output;
import com.caculator.repository.CalculatorRepository;
import com.caculator.dto.Result;

import java.util.List;
import java.util.Stack;

import static com.caculator.ErrorMessage.*;

public class Calculator {

    private final CalculatorRepository repository;
    private final Input input;
    private final Output output;
    private static final String COMMAND_HISTORY = "1", COMMAND_CALCULATE = "2", COMMAND_EXIT = "-1";

    public Calculator(CalculatorRepository repository, Input input, Output output) {
        this.repository = repository;
        this.input = input;
        this.output = output;
    }

    public void run() {
        while (true) {
            String cmd = input.inputCmd();

            switch (cmd) {
                case COMMAND_HISTORY:
                    List<Result> history = repository.findAll();
                    executeHistoryCommand(history);
                    break;
                case COMMAND_CALCULATE:
                    String exp = input.inputExp();
                    executeCalculationCommand(exp);
                    break;
                case COMMAND_EXIT:
                    return;
                default:
                    commandError();
            }
        }
    }

    private void commandError() {
        output.printError(INCORRECT_COMMAND_ERROR_MESSAGE);
    }

    private void executeCalculationCommand(String expression) {
        try {
            int result = executeCalculator(expression);
            repository.save(new Result(expression, result));
            output.printResult(result);
        } catch (IllegalArgumentException e) {
            output.printError(INCORRECT_EXPRESSION_ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            output.printError(DIVIDE_ZERO_ERROR_MESSAGE);
        }
    }

    private void executeHistoryCommand(List<Result> history) {
        if (isEmptyHistory(history)) {
            output.printError(EMPTY_HISTORY_MESSAGE);
            return;
        }
        output.printHistory(history);
    }

    private boolean isEmptyHistory(List<Result> history) {
        return history.size() == 0;
    }

    public int executeCalculator(String expression) throws IllegalArgumentException, ArithmeticException {
        List<String> postfix = PostfixConverter.convert(expression);
        return calculatePostfixExpression(postfix);
    }

    private int calculatePostfixExpression(List<String> expressions) throws IllegalArgumentException, ArithmeticException {
        Stack<Integer> stack = new Stack<>();

        for (String s : expressions) {
            if (StringUtils.isNumber(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                int n2 = stack.pop();
                int n1 = stack.pop();
                stack.push(calculate(n1, n2, s));
            }
        }

        return stack.pop();
    }

    private int calculate(int n1, int n2, String operator) throws ArithmeticException, IllegalArgumentException {
        switch (operator) {
            case "+":
                return Math.addExact(n1, n2);
            case "-":
                return Math.subtractExact(n1, n2);
            case "*":
                return Math.multiplyExact(n1, n2);
            case "/":
                return Math.floorDiv(n1, n2);
            default:
                throw new IllegalArgumentException();
        }
    }
}

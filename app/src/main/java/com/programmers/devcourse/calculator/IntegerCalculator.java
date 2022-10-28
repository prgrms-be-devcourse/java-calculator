package com.programmers.devcourse.calculator;

import com.programmers.devcourse.cache.AppMemoryCache;
import com.programmers.devcourse.cli.CommandLine;
import com.programmers.devcourse.cli.CommandOption;
import com.programmers.devcourse.converter.InFixToPostFixConverter;
import com.programmers.devcourse.validation.Validator;

import java.io.IOException;
import java.util.*;

public class IntegerCalculator implements Runnable {

    private Map<String, Operator> operators = new HashMap<>();
    private Validator validator;
    private CommandLine commandLine;
    private AppMemoryCache appMemoryCache;

    private InFixToPostFixConverter inFixToPostFixConverter;

    private List<String> expression = new ArrayList<>();
    private Deque<Integer> stack = new ArrayDeque<>();

    public IntegerCalculator() {
        for (Operator value : Operator.values()) {
            operators.put(value.operatorStr, value);
        }
        validator = Validator.getInstance();
        commandLine = CommandLine.getInstance();
        appMemoryCache = AppMemoryCache.getInstance();
        inFixToPostFixConverter = new InFixToPostFixConverter();
    }

    @Override
    public void run() {

        while (true) {

            commandLine.printOptionMessage();
            int option = -1;
            try {
                option = commandLine.readOption();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            if (option == CommandOption.INQUIRY.value) {
                commandLine.printList(appMemoryCache.getAll());
            } else if (option == CommandOption.CALCULATE.value) {

                String expressionStr ="";
                try {
                    expressionStr = commandLine.readExpression();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

                if(!validator.validate(expressionStr)) {
                    continue;
                }

                inFixToPostFixConverter.convert(expressionStr);
                expression = inFixToPostFixConverter.getPostfixList();
                inFixToPostFixConverter.printPostfixList();

                int result = calculate();
                System.out.println(calculate());

                appMemoryCache.save(expressionStr + "=" + result);
                inFixToPostFixConverter.clearPostfixList();
            }
            else if (option == CommandOption.EXIT.value) {
                try {
                    commandLine.stopCommandLine();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }

    }

    public int calculate() {
        for (String token : this.expression) {
            if (validator.isNumber(token)) {
                stack.addLast(Integer.parseInt(token));
            } else {
                int num1 = stack.removeLast();
                int num2 = stack.removeLast();
                int tempResult = operators.get(token).calculate(num2, num1);
                stack.addLast(tempResult);
            }
        }

        return stack.removeLast();

    }

    public int calculate(List<String> expression) {
        for (String token : expression) {
            if (validator.isNumber(token)) {
                stack.addLast(Integer.parseInt(token));
            } else {
                int num1 = stack.removeLast();
                int num2 = stack.removeLast();
                int tempResult = operators.get(token).calculate(num2, num1);
                stack.addLast(tempResult);
            }
        }
        return stack.removeLast();

    }
}

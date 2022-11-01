package com.programmers.devcourse.calculator;

import com.programmers.devcourse.cache.AppMemoryCache;
import com.programmers.devcourse.cli.CommandLine;
import com.programmers.devcourse.cli.CommandOption;
import com.programmers.devcourse.converter.ExpressionConverter;
import com.programmers.devcourse.converter.InFixToPostFixConverter;
import com.programmers.devcourse.validation.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Deque;
import java.util.ArrayDeque;

public class IntegerCalculator {

    private final Map<String, Operator> operators = new HashMap<>();
    private final Validator validator;
    private final CommandLine commandLine;
    private final AppMemoryCache appMemoryCache;

    private final ExpressionConverter expressionConverter;

    private List<String> expression = new ArrayList<>();
    private final Deque<Integer> stack = new ArrayDeque<>();

    public IntegerCalculator() {
        for (Operator value : Operator.values()) {
            operators.put(value.getOperatorStr(), value);
        }
        validator = Validator.getInstance();
        commandLine = CommandLine.getInstance();
        appMemoryCache = AppMemoryCache.getInstance();
        expressionConverter = new InFixToPostFixConverter();
    }

    public void run(boolean calculatorRunning) {

        while (calculatorRunning) {

            commandLine.printOptionMessage();
            int option = commandLine.readOption();

            if (option == CommandOption.INQUIRY.getValue()) {
                commandLine.printList(appMemoryCache.getAll());
            } else if (option == CommandOption.CALCULATE.getValue()) {

                String expressionStr = commandLine.readExpression();

                if (!validator.validate(expressionStr)) {
                    continue;
                }

                expressionConverter.convert(expressionStr);
                expression = expressionConverter.getConvertedList();

                int result = calculate();
                System.out.println(calculate());

                appMemoryCache.save(expressionStr + "=" + result);
                expressionConverter.clearConvertedList();
            } else if (option == CommandOption.EXIT.getValue()) {
                commandLine.stopCommandLine();
                break;
            }
        }

    }

    public int calculate() {
        return this.calculate(this.expression);
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

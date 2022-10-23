package com.programmers.java.engine;

import com.programmers.java.application.Console;
import com.programmers.java.application.Operator;
import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;
import com.programmers.java.engine.model.Expression;
import com.programmers.java.engine.operator.Divide;
import com.programmers.java.engine.operator.Minus;
import com.programmers.java.engine.operator.Multiply;
import com.programmers.java.engine.operator.Plus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class Calculator implements Runnable {
    private final String OPERATOR_REGEX = "[+\\-*/]";
    private final String NUMBER_REGEX = "\\d+(\\.\\d+)?";

    private Plus plus;
    private Minus minus;
    private Multiply multiply;
    private Divide divide;
    private Input input;
    private Output output;

    public Calculator(Operator operator, Console console) {
        this.plus = operator;
        this.minus = operator;
        this.multiply = operator;
        this.divide = operator;
        this.input = console;
        this.output = console;
    }

    @Override
    public void run() {

        // Loop
        while (true) {
            // input option
            String inputOption = this.input.input("1. 조회\n2. 계산\n\n선택 : ");

            // check validate
            Optional<Integer> option = parseOption(inputOption);
            // incorrect -> continue
            if (option.isEmpty()) {
                output.inputError();
                continue;
            }

            // Option 1. Show history
            if (option.get().equals(1)) {
                String inputHistory = input.readFile("\n");

                output.printHistory(inputHistory);
            }

            // Option 2. Use calculator
            if (option.get().equals(2)) {
                String inputExpression = this.input.input("\n");
                Optional<Expression> expression = parseExpression(inputExpression);

                if (expression.isEmpty()) {
                    output.inputError();
                    continue;
                }

                Double answer = calculate(expression.get());
                output.printAnswer(answer);
            }

        }
    }

    public Double calculate(Expression expression) {
        return null;
    }

    public Optional<Expression> parseExpression(String inputExpression) {

        // 숫자와 연산자 추출
        String[] tokens = inputExpression.split(" ");

        List<String> operators = new ArrayList<>();
        List<Double> numbers = new ArrayList<>();

        for (String token : tokens) {
            if (Pattern.matches(OPERATOR_REGEX, token)) {
                operators.add(token);
            } else if (Pattern.matches(NUMBER_REGEX, token)) {
                numbers.add(Double.parseDouble(token));
            }
        }

        return Optional.of(
                new Expression(
                        operators, numbers
                )
        );
    }

    public Optional<Integer> parseOption(String inputOption) {
        Integer result = 0;

        // validate: 숫자형인지 체크
        try {
            result = Integer.parseInt(inputOption);
        } catch (NumberFormatException exception) {
            return Optional.empty();
        }

        // validate: 1이나 2인지 체크
        if (result == 1 || result == 2) {
            return Optional.of(result);
        }
        return Optional.empty();
    }
}

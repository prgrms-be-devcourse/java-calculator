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

import java.util.Optional;

public class Calculator implements Runnable {

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
            Optional<Integer> option = parse(inputOption);
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
                Optional<Expression> expression = makeExpression(inputExpression);

                if (expression.isEmpty()) {
                    output.inputError();
                    continue;
                }

                Double answer = calculate(expression.get());
                output.printAnswer(answer);
            }

        }
    }

    private Double calculate(Expression expression) {
        return null;
    }

    private Optional<Expression> makeExpression(String inputExpression) {
        return null;
    }

    private Optional<Integer> parse(String inputOption) {
        return null;
    }
}

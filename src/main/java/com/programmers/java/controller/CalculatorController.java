package com.programmers.java.controller;

import com.programmers.java.calculator.Calculator;
import com.programmers.java.calculator.ConsoleCalculator;
import com.programmers.java.exception.CalculateException;
import com.programmers.java.calculator.parser.InfixToPostFixParser;
import com.programmers.java.calculator.validator.InfixValidator;
import com.programmers.java.data.MapRepository;
import com.programmers.java.exception.ValidateException;
import com.programmers.java.io.Input;
import com.programmers.java.io.Output;
import com.programmers.java.exception.SelectException;
import com.programmers.java.io.SelectType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CalculatorController implements Runnable {

    private Input input;
    private Output output;
    private MapRepository store;
    private InfixValidator validator;
    private InfixToPostFixParser parseInput;

    @Override
    public void run() {
        Calculator calculator = new ConsoleCalculator(store, parseInput);
        while (true) {
            try {
                String select = input.getOrder();
                SelectType s = SelectType.getSelectType(select);
                switch (s) {
                    case LOOKUP -> {
                        store.getAllResult(output);
                        break;
                    }
                    case CALCULATE -> {
                        execute(calculator);
                        break;
                    }
                    case EXIT -> {
                        output.putEnd();
                        return;
                    }
                }
            } catch (SelectException e) {
                output.putError(e.getMessage());
            }
        }
    }

    private void execute(Calculator c) {
        String exp = input.getExpression();
        try {
            validator.validate(exp);
            Double answer = c.calculate(exp);
            output.putAnswer(answer);
        } catch (CalculateException | ValidateException e) {
            output.putError(e.getMessage());
        }
    }
}

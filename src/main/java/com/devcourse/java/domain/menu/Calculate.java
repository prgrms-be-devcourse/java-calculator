package com.devcourse.java.domain.menu;

import com.devcourse.java.domain.calculator.Calculator;
import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.storage.CalculateResult;
import com.devcourse.java.domain.storage.Storage;
import com.devcourse.java.common.Validator;

import static com.devcourse.java.common.Messages.BAD_EXPRESSION;

public class Calculate implements Menu {
    private final Calculator calculator;
    private final Storage<CalculateResult> storage;

    public Calculate(Calculator calculator, Storage<CalculateResult> storage) {
        this.calculator = calculator;
        this.storage = storage;
    }

    @Override
    public boolean execute(Console console) {
        System.out.println();
        String expression = console.read();
        calculateExpression(console, expression);
        return true;
    }

    private void calculateExpression(Console console, String expression) {
        if (Validator.isValidExpression(expression)) {
            CalculateResult calculateResult = calculator.run(expression);
            console.print(calculateResult.getResult());
            storage.save(calculateResult);
        } else { // todo: change
            console.print(BAD_EXPRESSION.toMessage());
        }
    }
}

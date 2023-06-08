package com.devcourse.java.domain.menu;

import com.devcourse.java.domain.storage.Storage;
import com.devcourse.java.domain.storage.CalculateResult;
import com.devcourse.java.domain.calculator.Calculator;
import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.validator.Validator;

public class Calculate implements Menu {
    private final Calculator calculator;
    private final Storage<CalculateResult> storage;
    private final Validator validator;

    public Calculate(Calculator calculator, Storage<CalculateResult> storage, Validator validator) {
        this.calculator = calculator;
        this.storage = storage;
        this.validator = validator;
    }

    @Override
    public boolean execute(Console console) {
        String expression = console.read();
        calculateExpression(console, expression);
        return true;
    }

    private void calculateExpression(Console console, String expression) {
        if (validator.isValidExpression(expression, console)) {
            CalculateResult calculateResult = calculator.run(expression, validator);
            console.print(calculateResult.getResult());
            storage.save(calculateResult);
        }
    }
}

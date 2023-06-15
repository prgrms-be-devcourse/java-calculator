package com.devcourse.java.domain.menu;

import com.devcourse.java.common.Validator;
import com.devcourse.java.domain.calculator.Calculator;
import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.storage.CalculateResult;
import com.devcourse.java.domain.storage.Storage;

public class Calculate implements Menu {
    private static final String BAD_EXPRESSION = "올바른 계산식이 아닙니다. 다시 입력바랍니다.\n\n";
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
            console.write(calculateResult.getResult());
            storage.save(calculateResult);
        } else { // todo: change
            console.write(BAD_EXPRESSION);
        }
    }
}

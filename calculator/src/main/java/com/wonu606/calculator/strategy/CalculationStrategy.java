package com.wonu606.calculator.strategy;

import com.wonu606.calculator.calculator.Calculator;
import com.wonu606.calculator.converter.Converter;
import com.wonu606.calculator.model.CalculationResult;
import com.wonu606.calculator.storage.Persistence;
import com.wonu606.calculator.util.CalculatorMessage;
import com.wonu606.calculator.validator.Validator;
import com.wonu606.io.Input;
import com.wonu606.io.Print;
import java.util.List;

public class CalculationStrategy implements CalculatorStrategy {

    Validator validator;
    Converter<String, List<String>> converter;
    Calculator calculator;

    public CalculationStrategy(Validator validator, Converter<String, List<String>> converter,
            Calculator calculator) {
        this.validator = validator;
        this.converter = converter;
        this.calculator = calculator;
    }

    @Override
    public void execute(Input input, Print printer, Persistence store) {
        String inputExpression = input.getInput();
        if (isNotValidExpression(inputExpression)) {
            printer.print(CalculatorMessage.INVALID_INPUT.message);
            return;
        }

        List<String> convertedExpression = converter.convert(inputExpression);
        try {
            double result = calculator.calculate(convertedExpression);

            store.saveResult(new CalculationResult(inputExpression, result));
            printCalculationResult(printer, result);
        } catch (ArithmeticException exception) {
            printer.print(exception.getMessage());
        }
    }

    private static void printCalculationResult(Print printer, double result) {
        String message = String.valueOf(roundResultToInt(result));
        if (isResultOverflow(result)) {
            message = CalculatorMessage.OVERFLOW_OCCURS.message;
        }
        printer.print(message);
    }

    private static int roundResultToInt(double result) {
        return (int) Math.round(result);
    }

    private static boolean isResultOverflow(double result) {
        return Double.isInfinite(result) || (isIntegerOverflow(result));
    }

    private static boolean isIntegerOverflow(double result) {
        return result > Integer.MAX_VALUE;
    }

    private boolean isNotValidExpression(String inputExpression) {
        return !validator.isValid(inputExpression);
    }
}

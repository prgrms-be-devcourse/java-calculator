package calculator;

import calculator.model.CalculationResult;
import calculator.util.ExpressionConverter;
import calculator.io.Input;
import calculator.io.Output;
import calculator.model.BasicCalculator;
import calculator.repository.CalculationRepository;
import calculator.util.validator.CalculatorValidator;

import java.util.List;

import static calculator.global.ErrorResponse.*;
import static calculator.global.InputConstants.*;

public class Calculator implements Runnable {
    private final BasicCalculator calculator;
    private final ExpressionConverter expressionConverter;
    private final Input input;
    private final Output output;
    private final CalculationRepository calculationRepository;

    public Calculator(BasicCalculator calculator, ExpressionConverter expressionConverter, Input input, Output output, CalculationRepository calculationRepository) {
        this.calculator = calculator;
        this.expressionConverter = expressionConverter;
        this.input = input;
        this.output = output;
        this.calculationRepository = calculationRepository;
    }


    @Override
    public void run() {
        boolean isProgramRunnable = true;
        while (isProgramRunnable) {
            output.putMenu();
            String inputString = input.getChoice(CHOICE_PROMPT);
            if (!CalculatorValidator.isValidChoice(inputString)) {
                output.inputError(MENU_INPUT_ERROR);
                continue;
            }

            switch (inputString.charAt(FIRST_INDEX)) {
                case REQUEST_EXIT -> isProgramRunnable = false;
                case REQUEST_VIEW_CALCULATION_RESULT -> output.showCalculationResult(calculationRepository.findAll());
                case REQUEST_CALCULATION -> {
                    String expression = input.getExpression();
                    if (!CalculatorValidator.isValidExpression(expression)) {
                        output.inputError(INVALID_INPUT_EXPRESSION);
                        continue;
                    }
                    List<String> convertedExpression = expressionConverter.convert(expression);
                    Object result = calculator.calculate(convertedExpression);
                    output.showResult(result.toString());
                    calculationRepository.save(new CalculationResult(expression, result.toString()));
                }
            }
        }
    }
}

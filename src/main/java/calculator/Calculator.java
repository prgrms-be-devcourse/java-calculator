package calculator;

import calculator.io.ExpressionConverter;
import calculator.io.Input;
import calculator.io.Output;
import calculator.repository.CalculationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static calculator.global.ErrorResponse.*;
import static calculator.global.InputConstants.*;

public class Calculator implements Runnable {
    private final ExpressionConverter infixConverter;
    private final Input input;
    private final Output output;
    private final CalculationRepository calculationRepository;

    public Calculator(ExpressionConverter infixConverter, Input input, Output output, CalculationRepository calculationRepository) {
        this.infixConverter = infixConverter;
        this.input = input;
        this.output = output;
        this.calculationRepository = calculationRepository;
    }


    @Override
    public void run() {
        while(true) {
            output.putMenu();
            String inputString = input.getChoice(CHOICE_PROMPT);
            if (!validateChoiceInput(inputString)) output.inputError(MENU_INPUT_ERROR);

            switch (inputString.charAt(FIRST_INDEX)) {
                case REQUEST_VIEW_CALCULATION_RESULT:
                    output.showCalculationResult(calculationRepository.findAll());

                case REQUEST_CALCULATION:
                    String expression = input.getExpression();
                    if (validateExpression(expression)) {
                        ArrayList<String> postfixList = infixConverter.convert(expression);
                        int result = calculate(postfixList);
                        calculationRepository.save(expression + " = " + result);
                    }
            }
        }
    }

    private int calculate(ArrayList<String> postfixExpression){
        return 0;
    }

    private boolean validateChoiceInput(String input){
        char firstChar = input.charAt(FIRST_INDEX);
        return input.length() == MENU_INPUT_LENGTH
                && firstChar == REQUEST_VIEW_CALCULATION_RESULT
                || firstChar == REQUEST_CALCULATION;
    }
    private boolean validateExpression(String expression){
        AtomicInteger index = new AtomicInteger(0);
        long countOfValidOps = Arrays.stream(expression.split(" "))
                .filter(e -> index.getAndIncrement() % 2 == 0 ? e.matches(OPERAND_REGEX) : e.matches(OPERATOR_REGEX))
                .count();
        return countOfValidOps >= MINIMUM_OPS && Arrays.stream(expression.split(" ")).count() == countOfValidOps;
    }
}

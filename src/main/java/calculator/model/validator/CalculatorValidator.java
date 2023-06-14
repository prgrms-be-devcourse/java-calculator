package calculator.model.validator;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;


public class CalculatorValidator {
    private static final String OPERATOR_REGEX = "[-*/+]";
    private static final String OPERAND_REGEX = "^(0|[-]?[1-9]\\d*)$";

    private static final int MINIMUM_OPS = 3;
    private static final int FIRST_INDEX = 0;

    private static final String EXPRESSION_DELIMITER = " ";


    public static boolean isValidExpression(String expression){
        AtomicInteger index = new AtomicInteger(FIRST_INDEX);
        long countOfValidOps = Arrays.stream(expression.split(EXPRESSION_DELIMITER))
                .filter(e -> isEvenNumber(index) ? e.matches(OPERAND_REGEX) : e.matches(OPERATOR_REGEX))
                .count();
        return countOfValidOps >= MINIMUM_OPS && Arrays.stream(expression.split(" ")).count() == countOfValidOps;
    }

    private static boolean isEvenNumber(AtomicInteger index) {
        return index.getAndIncrement() % 2 == 0;
    }
}

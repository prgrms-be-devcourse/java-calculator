package calculator.util.validator;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;


public class CalculatorValidator {
    public static final String OPERATOR_REGEX = "[-*/+]";
    public static final String OPERAND_REGEX = "^\\d+$";

    public static final int MINIMUM_OPS = 3;

    public static boolean isValidExpression(String expression){
        AtomicInteger index = new AtomicInteger(0);
        long countOfValidOps = Arrays.stream(expression.split(" "))
                .filter(e -> isEvenNumber(index) ? e.matches(OPERAND_REGEX) : e.matches(OPERATOR_REGEX))
                .count();
        return countOfValidOps >= MINIMUM_OPS && Arrays.stream(expression.split(" ")).count() == countOfValidOps;
    }

    private static boolean isEvenNumber(AtomicInteger index) {
        return index.getAndIncrement() % 2 == 0;
    }
}

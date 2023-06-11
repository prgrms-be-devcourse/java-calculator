package calculator.util.validator;

import calculator.global.Menu;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static calculator.global.InputConstants.*;

public class CalculatorValidator {
    public static boolean isValidChoice(String input){
        if (input.length() != MENU_INPUT_LENGTH) return false;
        Character firstChar = input.charAt(FIRST_INDEX);
        return Arrays.stream(Menu.values()).filter(m -> m.getCommand()
                .equals(firstChar)).count() == 1;
    }
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

package calculator.domain.enums;

import calculator.exception.ApplicationException;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static calculator.exception.ErrorMessage.WRONG_EXPRESSION_EXCEPTION;
import static calculator.exception.ErrorMessage.ZERO_DIVISION_OPTION;

public enum Operator {
    ADDITION("+", (number1, number2) -> number1 + number2),
    SUBTRACTION("-", (number1, number2) -> number1 - number2),
    MULTIPLICATION("*", (number1, number2) -> number1 * number2),
    DIVISION("/", (number1, number2) -> number1 / number2)
    ;

    private final String operator;
    private final BinaryOperator<Integer> expression;

    Operator(String operator, BinaryOperator<Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    private static final Map<String, Operator> OPERATOR_MAP =
            Collections.unmodifiableMap(Arrays.stream(values())
                    .collect(Collectors.toMap(Operator::getOperator, Function.identity())));

    public static Operator from(String operator) {
        return Optional.ofNullable(OPERATOR_MAP.get(operator))
                .orElseThrow(() -> new ApplicationException(WRONG_EXPRESSION_EXCEPTION));
    }

    public static boolean checkOperator(String operator) {
        return OPERATOR_MAP.containsKey(operator);
    }

    public static boolean isHigherPriority(Operator operator) {
        switch (operator) {
            case MULTIPLICATION:
            case DIVISION:
                return true;
        }

        return false;
    }

    public String getOperator() {
        return this.operator;
    }

    public int apply(int n1, int n2) {
        checkZeroDivision(n2);
        return expression.apply(n1, n2);
    }

    private void checkZeroDivision(int n2) {
        if (DIVISION.equals(this) && n2 == 0) {
            throw new ApplicationException(ZERO_DIVISION_OPTION);
        }
    }
}

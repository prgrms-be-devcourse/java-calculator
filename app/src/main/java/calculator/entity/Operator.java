package calculator.entity;

import calculator.exception.ExpressionInputException;
import java.util.Arrays;

public enum Operator {
    ADD("+") {
        @Override
        public int evaluate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACT("-") {
        @Override
        public int evaluate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLY("*") {
        @Override
        public int evaluate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },
    DIVIDE("/") {
        private static final int ZERO = 0;
        private static final String DIVISION_BY_ZERO_MESSAGE = "0으로 나눌 수 없습니다.";

        @Override
        public int evaluate(int operand1, int operand2) {
            validateIsDivisorNotZero(operand2);
            return operand1 / operand2;
        }

        private void validateIsDivisorNotZero(int divisor) {
            if (divisor == ZERO) {
                throw new ArithmeticException(DIVISION_BY_ZERO_MESSAGE);
            }
        }
    };

    private static final String NOT_MATCHING_ANY_SYMBOL_MESSAGE = "일치하는 연산자가 없습니다.";

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator getOperatorWithSameSymbol(String elementSymbol) {
        return Arrays.stream(Operator.values())
            .filter(operator -> elementSymbol.equals(operator.getSymbol()))
            .findFirst()
            .orElseThrow(() -> new ExpressionInputException(NOT_MATCHING_ANY_SYMBOL_MESSAGE));
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract int evaluate(int operand1, int operand2);
}

package calculator.entity;

import calculator.exception.ExpressionInputException;
import java.util.Arrays;

public enum Operator {
    ADD("+", 1) {
        @Override
        public int evaluate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACT("-", 1) {
        @Override
        public int evaluate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLY("*", 2) {
        @Override
        public int evaluate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },
    DIVIDE("/", 2) {
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
    private final int priority;

    Operator(String symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public static Operator getOperatorWithSameSymbol(String elementSymbol) {
        return Arrays.stream(Operator.values())
            .filter(operator -> elementSymbol.equals(operator.getSymbol()))
            .findFirst()
            .orElseThrow(() -> new ExpressionInputException(NOT_MATCHING_ANY_SYMBOL_MESSAGE));
    }

    public boolean isLowerOrSamePriorityThan(Operator otherOperator) {
        return priority <= otherOperator.getPriority();
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPriority() {
        return priority;
    }

    public abstract int evaluate(int operand1, int operand2);
}

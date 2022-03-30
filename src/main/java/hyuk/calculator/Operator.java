package hyuk.calculator;

import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        @Override
        public Integer apply(int firstOperand, int secondOperand) {
            return firstOperand + secondOperand;
        }
    },
    MINUS("-") {
        @Override
        public Integer apply(int firstOperand, int secondOperand) {
            return firstOperand - secondOperand;
        }
    },
    DIVIDE("/") {
        @Override
        public Integer apply(int firstOperand, int secondOperand) {
            if (secondOperand == 0) {
                throw new IllegalStateException("0으로 나눌 수 없습니다.");
            }
            return firstOperand / secondOperand;
        }
    },
    MULTIPLY("*") {
        @Override
        public Integer apply(int firstOperand, int secondOperand) {
            return firstOperand * secondOperand;
        }
    };

    private final String textOperator;

    Operator(final String textOperator) {
        this.textOperator = textOperator;
    }

    public static Operator of(final String symbol) {
        return Arrays.stream(values())
            .filter(operator -> operator.isTextOperator(symbol))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("해당 연산자를 찾을 수 없습니다."));
    }

    private boolean isTextOperator(String symbol) {
        return textOperator.equals(symbol);
    }

    public abstract Integer apply(int firstOperand, int secondOperand);

}

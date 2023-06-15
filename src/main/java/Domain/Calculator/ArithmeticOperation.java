package Domain.Calculator;

import Common.Exception.DivideByZeroException;
import Common.Exception.WrongValueException;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum ArithmeticOperation {
    ADD("+", (a, b) -> a + b),
    SUB("-", (a, b) -> a - b),
    MUL("*", (a, b) -> a * b),
    DIV("/", (a, b) -> a / b),
    EMPTY(null, (a, b) -> null);

    private final String operation;
    private final BinaryOperator<Double> function;

    ArithmeticOperation(String operation, BinaryOperator<Double> function) {
        this.operation = operation;
        this.function = function;
    }

    public static ArithmeticOperation from(String operation) {
        return Arrays.stream(values())
                .filter(o -> operation.equals(o.operation))
                .findAny()
                .orElseThrow(WrongValueException::new);
    }

    public Double calculate(Double operand1, Double operand2) throws DivideByZeroException {
        if (this.operation.equals("/") && operand2 == 0) {
            throw new DivideByZeroException();
        }
        return function.apply(operand1, operand2);
    }
}

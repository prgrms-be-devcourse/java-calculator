package calculator.calculate;

public interface Calculator {
    Integer calculate(String expr);

    Boolean isValidExpression(String expr);
}

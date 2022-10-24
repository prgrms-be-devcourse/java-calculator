package engine;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (n1, n2) -> n1 + n2),
    MINUS("-", (n1, n2) -> n1 - n2),
    MULTIPLY("*", (n1, n2) -> n1 * n2),
    DIVIDE("/", (n1, n2) -> n1 / n2),;

    private String operator;
    private BiFunction<Double, Double, Double> expression;

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public double calculate(double n1, double n2) {
        return expression.apply(n1, n2);
    }

    public boolean isOperator(String exp) {
        if(exp.equals("+") || exp.equals("-") || exp.equals("*") || exp.equals("/")){
            return true;
        }

        return false;
    }
}

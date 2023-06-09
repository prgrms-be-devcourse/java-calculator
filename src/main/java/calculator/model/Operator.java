package calculator.model;
import java.util.Arrays;
import java.util.function.BiFunction;

import static calculator.global.Priority.HIGH;
import static calculator.global.Priority.LOW;

public enum Operator {

    PLUS("+", (num1, num2) -> num1 + num2, LOW),
    MINUS("-", (num1, num2) -> num1 - num2, LOW),
    MULTIPLY("*", (num1, num2) -> num1 * num2, HIGH),
    DIVIDE("/", (num1, num2) -> num1 / num2, HIGH);


    private final String operator;
    private final BiFunction<Double, Double, Double> expression;
    private final Integer priority;

    Operator(String operator, BiFunction<Double, Double, Double> expression, Integer priority) {
        this.operator = operator;
        this.expression = expression;
        this.priority = priority;
    }


    public boolean isSameOrGrater(Operator operator){
        System.out.println(priority + " ? " + operator.priority);
        return priority >= operator.priority;
    }

    public double mapCalculate(String operator, double num1, double num2){
        return getOperator(operator).expression.apply(num1, num2);
    }

    public static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }
}

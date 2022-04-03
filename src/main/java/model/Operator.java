package model;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (firstNum, secondNum) -> firstNum + secondNum ),
    MINUS("-", (firstNum, secondNum) -> firstNum - secondNum),
    MULTIPLY("*", (firstNum, secondNum) -> firstNum * secondNum),
    DIVIDE("/", (firstNum, secondNum) -> {
        if(secondNum == 0 || Double.isInfinite(secondNum)){
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return firstNum / secondNum;
    });

    private final String operator;
    private final BiFunction<Double, Double, Double> expression;

    Operator(String operator, BiFunction<Double, Double, Double> expression){
        this.operator = operator;
        this.expression = expression;
    }

    public double operate(double firstNum, double secondNum) {
        return expression.apply(firstNum, secondNum);
    }

    public static Operator findOperator(String operator) {
        return Arrays
                .stream(values())
                .filter(op -> op.operator.equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자가 입력되었습니다"));
    }

    public static boolean isMultiPlyOrDivide(String operator){
        return operator.equals("*") || operator.equals("/");
    }
}

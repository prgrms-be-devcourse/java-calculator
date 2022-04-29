package fakeModel;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum FakeOperator {
    PLUS("+", (a,b)->a+b, 0),
    MINUS("-",(a,b)->a-b,0),
    MULTIPLY("*",(a,b)->a*b, 1),
    DIVIDE("/", (a,b)->a/b, 1);

    private String operator;
    private BiFunction<Double, Double, Double> expression;
    private int priority;

    FakeOperator(String operator, BiFunction<Double, Double, Double> expression, int priority){
        this.operator=operator;
        this.expression=expression;
        this.priority=priority;
    }
    public static double calculate(String operator, double a, double b){
        Optional<FakeOperator> inputOperator=getOperator(operator);
        if(inputOperator.isPresent()) return inputOperator.get().expression.apply(a,b);
        throw new IllegalArgumentException("올바른 연산자가 아닙니다.");
    }

    public static Optional<FakeOperator> getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst();
    }

    public int getPriority(){
        return priority;
    }

    @Override
    public String toString(){
        return operator;
    }
}

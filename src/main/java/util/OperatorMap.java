package util;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorMap {
    MINUS("-", 2, (num1, num2)->num1-num2),
    PLUS("+", 2, (num1, num2)->num1+num2),
    MUL("*",1, (num1, num2)-> num1*num2),
    DIV("/",1, (num1, num2)-> num1/num2);

    private final String operator;
    private final int priority;
    private final BiFunction<Double, Double, Double> bifunction;

    OperatorMap(String operator, int priority, BiFunction<Double, Double, Double> bifunction) {
        this.operator = operator;
        this.priority = priority;
        this.bifunction = bifunction;
    }

    public static boolean contains(String operator) {
        for (OperatorMap oper : OperatorMap.values()) {
            if (operator.equals(oper.operator)) {
                return true;
            }
        }
        return false;
    }

    public static int priority(String operator) {
        for (OperatorMap oper : OperatorMap.values()) {
            if (operator.equals(oper.operator)) {
                return oper.priority;
            }
        }
        return 0;
    }

    public static OperatorMap getOperator(String operator) {
        return Arrays.stream(OperatorMap.values())
                .filter(operatorMap -> operatorMap.operator.equals(operator))
                .findAny()
                .orElseThrow(()->new IllegalException(ExceptionMsg.NotSolveEquationException));
    }

    private void validate(String operator, double num2) {
        if (!DIV.operator.equals(operator)) {
            return;
        }

        if (num2 == 0) {
            throw new IllegalException(ExceptionMsg.NotSolveEquationException);
        }
    }

    public double calculate(double num1, double num2) {
        validate(this.operator, num2);
        return this.bifunction.apply(num1, num2);
    }

    public String getOperator() {
        return this.operator;
    }




}

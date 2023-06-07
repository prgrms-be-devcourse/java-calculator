package util;

import calculator.exception.NotSolveEquationException;

import java.util.function.BiFunction;

public enum OperatorMap {
    MINUS("-", (num1, num2)->num1-num2),
    PLUS("+", (num1, num2)->num1+num2),
    MUL("*",(num1, num2)-> num1*num2),
    DIV("/",(num1, num2)-> num1/num2);

    private final String operator;
    private final BiFunction<Double, Double, Double> bifunction;

    OperatorMap(String operator, BiFunction<Double, Double, Double> bifunction) {
        this.operator = operator;
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

    public static boolean firstOrder(String operator) {
        if (operator.equals(MUL.operator) || operator.equals(DIV.operator)) {
            return true;
        }
        return false;
    }

    public static double apply(String operator, double num1, double num2) {
        for (OperatorMap oper : OperatorMap.values()) {
            if (operator.equals(oper.operator)) {
                return oper.bifunction.apply(num1, num2);
            }
        }
        throw new NotSolveEquationException();
    }

    public String getOperator() {
        return this.operator;
    }

}

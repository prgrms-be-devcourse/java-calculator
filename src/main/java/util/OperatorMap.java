package util;

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

    public static double calculate(String operator, double num1, double num2) {
        for (OperatorMap oper : OperatorMap.values()) {
            if (operator.equals(oper.operator)) {
                return oper.bifunction.apply(num1, num2);
            }
        }
        throw new IllegalException(ExceptionMsg.NotSolveEquationException);
    }

    public String getOperator() {
        return this.operator;
    }

    public static int priority(String operator) {
        for (OperatorMap oper : OperatorMap.values()) {
            if (operator.equals(oper.operator)) {
                return oper.priority;
            }
        }
        return 0;
    }


}

package calculator.module.arithmetic.model;

import java.util.List;

public abstract class Operator {
    private static final List<String> operatorList = List.of("+","-","/","*");
    private final OperatorType type;

    protected Operator(OperatorType type){
        this.type = type;
    }

    public static boolean isOperator(String target){
        return operatorList.contains(target);
    }

    abstract Double calculate(Double num, Double num2);

    public OperatorType getType() {
        return type;
    }

}

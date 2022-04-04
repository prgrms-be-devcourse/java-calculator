package calculator.model.operator;

import calculator.model.expression.ExpressionableToken;

public abstract class Operator extends ExpressionableToken {
    private final OperatorType operatorType;
    protected Operator(OperatorType operatorType) {
        super(operatorType.getSymbol());
        this.operatorType =  operatorType;
    }

    public boolean hasLowerPriority(Operator other){
        return operatorType.hasLowerPriority(other.getOperatorType());
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }
}

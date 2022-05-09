package calculator.model.operator;

import calculator.model.expression.ExpressionableToken;
import calculator.model.operand.OperandPool;

public abstract class Operator extends ExpressionableToken {
    private final OperatorType operatorType;
    protected Operator(OperatorType operatorType) {
        super(operatorType.getSymbol());
        this.operatorType =  operatorType;
    }

    public abstract Double calculate(OperandPool operandPool);

    public boolean hasLowerPriority(Operator other){
        return operatorType.hasLowerPriority(other.getOperatorType());
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }
}

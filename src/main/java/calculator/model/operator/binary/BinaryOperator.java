package calculator.model.operator.binary;

import calculator.model.expression.ExpressionableToken;
import calculator.model.operand.Operand;
import calculator.model.operator.Operator;
import calculator.model.operator.OperatorType;
import calculator.model.operator.bracket.OpenBracketOperator;

public abstract class BinaryOperator extends Operator{
    protected BinaryOperator(OperatorType operatorType) {
        super(operatorType);
    }

    public abstract Double calculate(Double firstOperand, Double secondOperand);

    @Override
    public boolean couldOtherTokenComeNext(ExpressionableToken other) {
        return other instanceof Operand || other instanceof OpenBracketOperator;
    }

}

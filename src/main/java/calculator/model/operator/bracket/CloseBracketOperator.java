package calculator.model.operator.bracket;

import calculator.model.expression.ExpressionableToken;
import calculator.model.operator.Operator;
import calculator.model.operator.OperatorType;
import calculator.model.operator.binary.BinaryOperator;

public class CloseBracketOperator extends Operator {
    public CloseBracketOperator() {
        super(OperatorType.CLOSED_BRACKET);
    }

    @Override
    public boolean couldOtherTokenComeNext(ExpressionableToken other) {
        return other instanceof BinaryOperator || other instanceof CloseBracketOperator;
    }

}

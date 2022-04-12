package calculator.model.operator.bracket;

import calculator.model.expression.ExpressionableToken;
import calculator.model.operator.binary.BinaryOperator;

public class CloseBracketOperator extends ExpressionableToken {
    public CloseBracketOperator() {
        super("(");
    }

    @Override
    public boolean couldOtherTokenComeNext(ExpressionableToken other) {
        return other instanceof BinaryOperator || other instanceof CloseBracketOperator;
    }

}

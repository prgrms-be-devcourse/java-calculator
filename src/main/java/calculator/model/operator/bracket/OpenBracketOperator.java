package calculator.model.operator.bracket;

import calculator.model.expression.ExpressionableToken;
import calculator.model.operand.Operand;

public class OpenBracketOperator extends ExpressionableToken {
    public OpenBracketOperator() {
        super(")");
    }

    @Override
    public boolean couldOtherTokenComeNext(ExpressionableToken other) {
        return other instanceof Operand || other instanceof OpenBracketOperator;
    }
}

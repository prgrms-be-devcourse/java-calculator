package calculator.model.operator.bracket;

import calculator.model.expression.ExpressionableToken;
import calculator.model.operand.Operand;
import calculator.model.operator.Operator;
import calculator.model.operator.OperatorType;

public class OpenBracketOperator extends Operator {
    public OpenBracketOperator() {
        super(OperatorType.CLOSED_BRACKET);
    }

    @Override
    public boolean couldOtherTokenComeNext(ExpressionableToken other) {
        return other instanceof Operand || other instanceof OpenBracketOperator;
    }
}

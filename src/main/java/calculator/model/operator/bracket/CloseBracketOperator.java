package calculator.model.operator.bracket;

import calculator.model.expression.ExpressionableToken;
import calculator.model.operator.Operator;
import calculator.model.operator.OperatorType;
import calculator.model.operator.binary.BinaryOperator;

public class CloseBracketOperator implements Operator {
    private final OperatorType type;
    public CloseBracketOperator() {
        type = OperatorType.CLOSED_BRACKET;
    }

    @Override
    public boolean couldOtherTokenComeNext(ExpressionableToken other) {
        return other instanceof BinaryOperator || other instanceof CloseBracketOperator;
    }

    @Override
    public String getValue() {
        return type.getSymbol();
    }
}

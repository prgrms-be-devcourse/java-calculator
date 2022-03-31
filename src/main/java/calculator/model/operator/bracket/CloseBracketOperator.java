package calculator.model.operator.bracket;

import calculator.model.operator.BinaryOperator;
import calculator.model.operator.Operator;
import calculator.model.operator.OperatorType;
import calculator.model.token.Tokenizationable;

public class CloseBracketOperator implements Operator {
    private final OperatorType type;
    public CloseBracketOperator() {
        type = OperatorType.CLOSED_BRACKET;
    }

    @Override
    public boolean couldOtherTokenComeNext(Tokenizationable other) {
        return other instanceof BinaryOperator || other instanceof CloseBracketOperator;
    }

    @Override
    public String getValue(String value) {
        return type.getSymbol();
    }
}

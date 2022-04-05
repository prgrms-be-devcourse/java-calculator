package calculator.model.operand;

import calculator.model.expression.ExpressionableToken;
import calculator.model.operator.binary.BinaryOperator;
import calculator.model.operator.bracket.CloseBracketOperator;

public class Operand extends ExpressionableToken {
    public Operand(String value) {
        super(value);
    }

    public static boolean isOperand(String target) {
        try {
            double numeric;
            numeric = Double.parseDouble(target);
            return !Double.isNaN(numeric);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Double getDoubleValue(){
        return Double.parseDouble(super.getValue());
    }

    @Override
    public boolean couldOtherTokenComeNext(ExpressionableToken other) {
        return other instanceof BinaryOperator || other instanceof CloseBracketOperator;
    }
}

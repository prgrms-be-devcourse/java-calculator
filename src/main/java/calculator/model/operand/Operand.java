package calculator.model.operand;

import calculator.model.expression.ExpressionableToken;
import calculator.model.operator.binary.BinaryOperator;
import calculator.model.operator.bracket.CloseBracketOperator;

public class Operand implements ExpressionableToken {
    private final String value;

    public static boolean isOperand(String target){
        double numeric;
        try{
            numeric = Double.parseDouble(target);
            return !Double.isNaN(numeric);
        }catch (NumberFormatException e){
            return false;
        }
    }
    public Operand(String value){
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean couldOtherTokenComeNext(ExpressionableToken other) {
        return other instanceof BinaryOperator || other instanceof CloseBracketOperator;
    }
}

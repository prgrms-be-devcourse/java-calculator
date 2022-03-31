package calculator.model.operand;

import calculator.model.operator.BinaryOperator;
import calculator.model.operator.bracket.CloseBracketOperator;
import calculator.model.token.Tokenizationable;

public class Operand implements Tokenizationable {
    private String value;

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

    public String getValue() {
        return value;
    }

    public boolean couldOtherTokenComeNext(Tokenizationable other) {
        return other instanceof BinaryOperator || other instanceof CloseBracketOperator;
    }

    @Override
    public String getValue(String value) {
        return null;
    }
}

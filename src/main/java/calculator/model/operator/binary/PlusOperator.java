package calculator.model.operator.binary;

import calculator.model.operand.Operand;
import calculator.model.operator.BinaryOperator;
import calculator.model.operator.OperatorType;
import calculator.model.operator.bracket.OpenBracketOperator;
import calculator.model.token.Tokenizationable;

public class PlusOperator implements BinaryOperator {
    private final OperatorType type;
    public PlusOperator() {
        type = OperatorType.PLUS;
    }

    @Override
    public double doBinaryCalculate(Double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    @Override
    public boolean couldOtherTokenComeNext(Tokenizationable other) {
        return other instanceof Operand || other instanceof OpenBracketOperator;
    }

    @Override
    public String getValue(String value) {
        return type.getSymbol();
    }
}

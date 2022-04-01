package calculator.model.operator.binary;

import calculator.model.expression.ExpressionableToken;
import calculator.model.operand.Operand;
import calculator.model.operator.OperatorType;
import calculator.model.operator.bracket.OpenBracketOperator;

public class DivideOperator implements BinaryOperator {
    private final OperatorType type;

    public DivideOperator() {
        type = OperatorType.DIVIDER;
    }

    @Override
    public boolean hasLowerPriority(BinaryOperator other) {
        return type.hasLowerPriority(other.getOperatorType());
    }

    @Override
    public OperatorType getOperatorType() {
        return type;
    }

    @Override
    public double doBinaryCalculate(Double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }

    @Override
    public boolean couldOtherTokenComeNext(ExpressionableToken other) {
        return other instanceof Operand || other instanceof OpenBracketOperator;
    }

    @Override
    public String getValue() {
        return type.getSymbol();
    }

}

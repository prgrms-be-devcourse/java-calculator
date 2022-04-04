package calculator.model.operator.binary;

import calculator.model.operator.OperatorType;

public class PlusOperator extends BinaryOperator {
    public PlusOperator() {
        super(OperatorType.PLUS);
    }

    @Override
    public Double calculate(Double firstOperand, Double secondOperand) {
        return firstOperand + secondOperand;
    }
}

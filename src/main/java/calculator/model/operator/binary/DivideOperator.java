package calculator.model.operator.binary;

import calculator.model.operator.OperatorType;

public class DivideOperator extends BinaryOperator {

    public DivideOperator() {
        super(OperatorType.DIVIDER);
    }

    @Override
    public Double calculate(Double firstOperand, Double secondOperand) {
        return firstOperand / secondOperand;
    }
}

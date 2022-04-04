package calculator.model.operator.binary;

import calculator.model.operator.OperatorType;

public class MinusOperator extends BinaryOperator {
    public MinusOperator() {
        super(OperatorType.MINUS);
    }


    @Override
    public Double calculate(Double firstOperand, Double secondOperand) {
        return firstOperand - secondOperand;
    }
}

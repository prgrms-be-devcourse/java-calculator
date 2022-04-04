package calculator.model.operator.binary;

import calculator.model.operator.OperatorType;


public class TimesOperator extends BinaryOperator {

    public TimesOperator() {
        super(OperatorType.TIMES);
    }

    @Override
    public Double calculate(Double firstOperand, Double secondOperand) {
        return firstOperand * secondOperand;
    }
}

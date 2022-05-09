package calculator.model.operator.binary;

import calculator.model.operand.OperandPool;
import calculator.model.operator.OperatorType;


public class TimesOperator extends BinaryOperator {

    public TimesOperator() {
        super(OperatorType.TIMES);
    }

    @Override
    public Double calculate(OperandPool operandPool) {
        Double[] operands = operandPool.getTwoOperand();
        return  operands[0] * operands[1];
    }
}

package calculator.model.operator.binary;

import calculator.model.operand.OperandPool;
import calculator.model.operator.OperatorType;

public class PlusOperator extends BinaryOperator {
    public PlusOperator() {
        super(OperatorType.PLUS);
    }

    @Override
    public Double calculate(OperandPool operandPool) {
        Double[] operands = operandPool.getTwoOperand();
        return  operands[0] + operands[1];
    }
}

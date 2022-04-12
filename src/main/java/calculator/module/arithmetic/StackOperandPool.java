package calculator.module.arithmetic;

import calculator.model.operand.Operand;
import calculator.model.operand.OperandPool;

import java.util.Stack;

public class StackOperandPool implements OperandPool {
    private final Stack<Operand> pool = new Stack<>();

    @Override
    public Double getOneOperand() {
        return pool.pop().getDoubleValue();
    }

    @Override
    public Double[] getTwoOperand() {
        Double secondOperand = getOneOperand();
        Double firstOperand = getOneOperand();
        return new Double[] {firstOperand,secondOperand};
    }

    @Override
    public void addOperand(Operand operand) {
        pool.push(operand);
    }
}

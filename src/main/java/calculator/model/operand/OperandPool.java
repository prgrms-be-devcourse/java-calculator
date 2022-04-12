package calculator.model.operand;

public interface OperandPool {
    Double getOneOperand();
    Double[] getTwoOperand();
    void addOperand(Operand operand);
}

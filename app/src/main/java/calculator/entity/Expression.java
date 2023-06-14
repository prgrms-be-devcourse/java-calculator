package calculator.entity;

public class Expression {

    private final Operator operator;
    private final int operand1;
    private final int operand2;

    public Expression(Operator operator, int operand1, int operand2) {
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public int evaluate() {
        return operator.evaluate(operand1, operand2);
    }
}

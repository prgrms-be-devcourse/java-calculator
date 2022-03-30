package org.programmers.calculator.configuration;

public class Config {

    private Operand operandType = Operand.RATIONAL_NUMBER;

    public void set(Operand operandType) {
        this.operandType = operandType;
        apply();
    }

    private void apply() {
        ObjectContainer.create(operandType);
    }
}

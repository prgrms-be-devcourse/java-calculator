package org.programmers.calculator.configuration;

public class Config {

    private static Operand operandType = Operand.RATIONAL_NUMBER;

    public static void set(Operand operandType) {
        apply();
    }

    private static void apply() {
        ObjectContainer.create(operandType);
    }
}

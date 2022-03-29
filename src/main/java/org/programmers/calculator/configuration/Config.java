package org.programmers.calculator.configuration;

public class Config {

    private static Operand operandType = Operand.RATIONAL_NUMBER;
    private static Operator operatorType;

    public static void read() {

    }

    private static void apply() {
        ObjectContainer.create(operandType);
    }
}

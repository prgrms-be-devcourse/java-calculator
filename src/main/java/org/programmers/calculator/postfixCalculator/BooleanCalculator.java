package org.programmers.calculator.postfixCalculator;

public class BooleanCalculator {

    String negation(String operand) {
        return (operand.equals("T")) ? "F" : "T";
    }

    String conjunction(String operandA, String operandB) {
        boolean operandAToBoolean = operandA.equals("T") ? true : false;
        boolean operandBToBoolean = operandB.equals("T") ? true : false;

        return (operandAToBoolean && operandBToBoolean) ? "T" : "F";
    }

    String disjunction(String operandA, String operandB) {
        boolean operandAToBoolean = operandA.equals("T") ? true : false;
        boolean operandBToBoolean = operandB.equals("T") ? true : false;

        return (operandAToBoolean || operandBToBoolean) ? "T" : "F";
    }

    String materialImplication(String operandA, String operandB) {
        boolean operandAToBoolean = operandA.equals("T") ? true : false;
        boolean operandBToBoolean = operandB.equals("T") ? true : false;

        return (operandBToBoolean || !operandAToBoolean) ? "T" : "F";
    }
}

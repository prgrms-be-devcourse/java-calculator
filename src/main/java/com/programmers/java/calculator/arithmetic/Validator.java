package com.programmers.java.calculator.arithmetic;

public class Validator {

    public Integer getPriority(String op) {
        return OperationCode.getPriority(op);
    }

    public boolean isOperator(String op) {
        return OperationCode.isOperator(op);
    }

    public boolean isDecimal(String num) {
        String[] res = splitIntegerAndRealNumbers(num);
        if (isInteger(res)) return false;
        return !isZeroBelowDecimalPoint(res);
    }

    private String[] splitIntegerAndRealNumbers(String num){
        return num.split("\\.");
    }

    private boolean isInteger(String[] num) {
        return num.length == 1;
    }

    private boolean isZeroBelowDecimalPoint(String[] num) {
        return num[1].equals("0");
    }
}

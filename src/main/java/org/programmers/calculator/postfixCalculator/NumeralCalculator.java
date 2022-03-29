package org.programmers.calculator.postfixCalculator;

import org.programmers.calculator.TypeChecker.NumeralTypeChecker;
import org.programmers.calculator.TypeChecker.TypeChecker;

import java.math.BigDecimal;

public class NumeralCalculator {

    NumeralTypeChecker typeChecker;

    public NumeralCalculator(TypeChecker typeChecker) {
        this.typeChecker = (NumeralTypeChecker) typeChecker;
    }

    String plus(String a, String b) {

        if (typeChecker.isFractional(a) || typeChecker.isFractional(b)) {
            return Double.toString(Double.parseDouble(a) + Double.parseDouble(b));
        } else {
            return Integer.toString(Integer.parseInt(a) + Integer.parseInt(b));
        }
    }

    String minus(String a, String b) {

        if (typeChecker.isFractional(a) || typeChecker.isFractional(b)) {
            BigDecimal result = new BigDecimal(a);
            return (result.subtract(new BigDecimal(b))).toString();
        } else {
            return Integer.toString(Integer.parseInt(a) - Integer.parseInt(b));
        }
    }

    String multiply(String a, String b) {

        if (typeChecker.isFractional(a) || typeChecker.isFractional(b)) {
            BigDecimal result = new BigDecimal(a);
            return (result.multiply(new BigDecimal(b))).toString();
        } else {
            return Integer.toString(Integer.parseInt(a) * Integer.parseInt(b));
        }
    }

    String division(String a, String b) {

        if (typeChecker.isFractional(a) || typeChecker.isFractional(b)) {
            BigDecimal result = new BigDecimal(a);
            return (result.divide(new BigDecimal(b))).toString();
        } else {
            double result = Double.parseDouble(a) / Double.parseDouble(b);
            return decimalPlacesAreZero(result);
        }
    }

    // 나누기 이후 소수점 아래자리가 0일 경우 사용하는 메서드, 의미 없는 .0 형태 표기를 없앤다.
    private String decimalPlacesAreZero(double value) {

        if ((value - (int) value) == 0) {
            return String.valueOf((int) value);
        }
        return Double.toString(value);
    }

}

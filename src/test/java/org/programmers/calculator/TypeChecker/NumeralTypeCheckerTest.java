package org.programmers.calculator.TypeChecker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("연산자/피연산자 체크")
class NumeralTypeCheckerTest {

    @Test
    @DisplayName("피연산자 일반 사례")
    void isOperandNormal() {
        NumeralTypeChecker typeChecker = new NumeralTypeChecker();
        boolean result = typeChecker.isOperand("1");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("피연산자 음수 사례")
    void isOperandNegative() {
        NumeralTypeChecker typeChecker = new NumeralTypeChecker();
        boolean result = typeChecker.isOperand("-1");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("피연산자 0 사례")
    void isOperandZero() {
        NumeralTypeChecker typeChecker = new NumeralTypeChecker();
        boolean result = typeChecker.isOperand("0");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("피연산자 유리수 사례")
    void isOperandFractional() {
        NumeralTypeChecker typeChecker = new NumeralTypeChecker();
        boolean result = typeChecker.isOperand("1.5");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("소수 검사 기본")
    void isFractional() {
        NumeralTypeChecker typeChecker = new NumeralTypeChecker();
        boolean result = typeChecker.isFractional("0.5");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("연산자 체크 +")
    void isOperatorPlus() {
        NumeralTypeChecker typeChecker = new NumeralTypeChecker();
        boolean result = typeChecker.isOperator("+");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("연산자 체크 -")
    void isOperatorMinus() {
        NumeralTypeChecker typeChecker = new NumeralTypeChecker();
        boolean result = typeChecker.isOperator("-");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("연산자 체크 *")
    void isOperatorMultiply() {
        NumeralTypeChecker typeChecker = new NumeralTypeChecker();
        boolean result = typeChecker.isOperator("*");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("연산자 체크 /")
    void isOperatorDivide() {
        NumeralTypeChecker typeChecker = new NumeralTypeChecker();
        boolean result = typeChecker.isOperator("/");
        assertEquals(true, result);
    }
}
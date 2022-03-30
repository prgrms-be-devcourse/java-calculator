package org.programmers.calculator.TypeChecker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("연산자/피연산자 체크")
class BooleanTypeCheckerTest {

    @Test
    @DisplayName("피연산자 T 사례")
    void isOperandNormal() {
        BooleanTypeChecker typeChecker = new BooleanTypeChecker();
        boolean result = typeChecker.isOperand("T");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("피연산자 F 사례")
    void isOperandNegative() {
        BooleanTypeChecker typeChecker = new BooleanTypeChecker();
        boolean result = typeChecker.isOperand("F");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("연산자 체크 !")
    void isOperatorPlus() {
        BooleanTypeChecker typeChecker = new BooleanTypeChecker();
        boolean result = typeChecker.isOperator("!");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("연산자 체크 &")
    void isOperatorMinus() {
        BooleanTypeChecker typeChecker = new BooleanTypeChecker();
        boolean result = typeChecker.isOperator("&");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("연산자 체크 |")
    void isOperatorMultiply() {
        BooleanTypeChecker typeChecker = new BooleanTypeChecker();
        boolean result = typeChecker.isOperator("|");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("연산자 체크 ->")
    void isOperatorDivide() {
        BooleanTypeChecker typeChecker = new BooleanTypeChecker();
        boolean result = typeChecker.isOperator("->");
        assertEquals(true, result);
    }
}
package org.example.Calculate;

import org.junit.jupiter.api.*;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class CalOrderImplTest {
    PreProcess preProcess = new PreProcessImpl();
    CalOrder calOrder = new CalOrderImpl();
    Stack<String> expressionStack;
    String expression = "3 * 6 + 8 / 2";

    @BeforeEach
    void beforeEach(){
        expressionStack = preProcess.expressionToStack(expression);
        calOrder.setStack(expressionStack);
    }

    @Test
    @DisplayName("곱하기 나누기 우선순위 연산 확인")
    void calculateMultiplyDivideTest() {
        String calculatedMultiplyDivideResult = calOrder.calculateMultiplyDivide();
        assertEquals(calculatedMultiplyDivideResult,"[18, +, 4]");
    }

    @Test
    @DisplayName("더하기 빼기 연산 확인")
    void calculatePlusMinusTest(){
        calOrder.calculateMultiplyDivide();
        int result = calOrder.calculatePlusMinus();
        assertEquals(result, 22);
    }
}
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

}
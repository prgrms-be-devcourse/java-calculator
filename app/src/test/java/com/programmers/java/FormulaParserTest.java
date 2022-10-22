package com.programmers.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FormulaParserTest {
    @Test
    void changeInfixToPostfix() {
        FormulaParser parser = new FormulaParser();
        String infixFormula1 = "1+2*3";
        String infixFormula2 = "(1+2)/3";

        String[] postfixFormula1 = parser.changeInfixToPostfix(infixFormula1);
        String[] postfixFormula2 = parser.changeInfixToPostfix(infixFormula2);

        Assertions.assertEquals(postfixFormula1.length, 5);
        Assertions.assertEquals(postfixFormula2.length, 5);
    }
}
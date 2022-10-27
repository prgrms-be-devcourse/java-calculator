package com.programmers.calculator.engine.conversion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConversionFormulaTest {
    Conversion conversion = new ConversionFormula();

    @Test
    public void 후위표기법_변환_확인() {
        String formula = "1 * ( 2 + 3 )";
        List<String> postfix = conversion.formulaToPostfixTokens(formula);

        Assertions.assertEquals(postfix.get(0),"1");
        Assertions.assertEquals(postfix.get(1),"2");
        Assertions.assertEquals(postfix.get(2),"3");
        Assertions.assertEquals(postfix.get(3),"+");
        Assertions.assertEquals(postfix.get(4),"*");
    }

}
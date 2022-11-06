package com.programmers.calculator.engine.calculation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SymbolTest {


    @Test
    public void 계산_확인(){
        Double add = Symbol.calculate("+", 1,2);
        Double sub = Symbol.calculate("-", 3,2);
        Double mul = Symbol.calculate("*", 5,2);
        Double div = Symbol.calculate("/", 7,2);

        Assertions.assertEquals(add, 3.0);
        Assertions.assertEquals(sub, 1.0);
        Assertions.assertEquals(mul, 10.0);
        Assertions.assertEquals(div, 3.5);


    }
}
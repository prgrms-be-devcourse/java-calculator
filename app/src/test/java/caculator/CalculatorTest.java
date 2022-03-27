package caculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void checkCalculate() {
        Calculator calTest = new Calculator();
        assertTrue(calTest.calculate(new StringBuilder("1"))==1);
        assertTrue(calTest.calculate(new StringBuilder("1+2"))==3);
        assertTrue(calTest.calculate(new StringBuilder("-12+3"))==-9);
        assertTrue(calTest.calculate(new StringBuilder("4-5"))==-1);
        assertTrue(calTest.calculate(new StringBuilder("4*5*10"))==200);
        assertTrue(calTest.calculate(new StringBuilder("-4+5/5*3-23"))==-24);
        assertTrue(calTest.calculate(new StringBuilder("120/2/4/3"))==5);
        assertTrue(calTest.calculate(new StringBuilder("4+5/5-3"))==2);
    }

    @Test
    void checkIsFormula() {
        Calculator calTest = new Calculator();
        assertTrue(calTest.isFormula(new StringBuilder("1+2")));
        assertTrue(calTest.isFormula(new StringBuilder("120/4/5/6")));
        assertTrue(calTest.isFormula(new StringBuilder("-4+5/5*3-23")));
        assertFalse(calTest.isFormula(new StringBuilder("1+*2")));
        assertFalse(calTest.isFormula(new StringBuilder("++1+2")));
        assertFalse(calTest.isFormula(new StringBuilder("*1+2**")));
    }
}

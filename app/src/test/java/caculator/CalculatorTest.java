package caculator;

import caculator.engine.Calculator;
import caculator.exception.CanNotDivideWithZeroException;
import caculator.exception.WrongFormulaException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setCalculator() {
        calculator = new Calculator();
    }

    @Test
    void testCalculate() throws Exception {
        assertTrue(calculator.calculate(new StringBuilder("1"))==1);
        assertTrue(calculator.calculate(new StringBuilder("1+2"))==3);
        assertTrue(calculator.calculate(new StringBuilder("-12+3"))==-9);
        assertTrue(calculator.calculate(new StringBuilder("4-5"))==-1);
        assertTrue(calculator.calculate(new StringBuilder("4*5*10"))==200);
        assertTrue(calculator.calculate(new StringBuilder("-4+5/5*3-23"))==-24);
        assertTrue(calculator.calculate(new StringBuilder("120/2/4/3"))==5);
        assertTrue(calculator.calculate(new StringBuilder("4+5/5-3"))==2);
        assertThrows(CanNotDivideWithZeroException.class, () -> calculator.calculate(new StringBuilder("1/0")));
        assertThrows(CanNotDivideWithZeroException.class, () -> calculator.calculate(new StringBuilder("1+2/0")));
        assertThrows(CanNotDivideWithZeroException.class, () -> calculator.calculate(new StringBuilder("12/12/12/0")));
    }

    @Test
    void testIsFormula() throws Exception {
        assertTrue(calculator.isFormula(new StringBuilder("1+2")));
        assertTrue(calculator.isFormula(new StringBuilder("120/4/5/6")));
        assertTrue(calculator.isFormula(new StringBuilder("-4+5/5*3-23")));
        assertThrows(WrongFormulaException.class, () -> calculator.isFormula(new StringBuilder("+1+2")));
        assertThrows(WrongFormulaException.class, () -> calculator.isFormula(new StringBuilder("1++2")));
        assertThrows(WrongFormulaException.class, () -> calculator.isFormula(new StringBuilder("1+2++")));
    }
}

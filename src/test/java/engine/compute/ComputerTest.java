package engine.compute;

import engine.compute.validator.ExpressionValidator;
import engine.compute.validator.SimpleExpressionValidator;
import engine.compute.converter.ExpressionConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {

    private ExpressionConverter converter;
    private ExpressionValidator validator;
    private Computer computer;

    @BeforeEach
    void setting() {
        validator = new SimpleExpressionValidator();
        converter = new ExpressionConverter(validator);
        computer = new Computer(new ComputeServiceImpl(validator, converter));
    }

    @Test
    void 연산과정종합테스트1() {
        String result = computer.compute("1+2+3+4+5");
        Assertions.assertEquals("15.00", result);
    }
    @Test
    void 연산과정종합테스트2() {
        String result1 = computer.compute("1*2*3*4*5");
        Assertions.assertEquals("120.00", result1);
    }
    @Test
    void 연산과정종합테스트3() {
        String result2 = computer.compute("1/2+3+4*5");
        Assertions.assertEquals("23.50", result2);
    }

    @Test
    void 연산과정종합테스트4() {
        String result3 = computer.compute("1-23-4-5");
        Assertions.assertEquals("-31.00", result3);
    }
}
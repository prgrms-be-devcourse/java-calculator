package engine.compute;

import engine.compute.validator.ExpressionValidator;
import engine.compute.validator.SimpleExpressionValidator;
import engine.operate.ExpressionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {

    ExpressionFactory factory;
    ExpressionValidator validator;
    Computer computer;

    @BeforeEach
    void setting() {
        validator = new SimpleExpressionValidator();
        factory = new ExpressionFactory(validator);
        computer = new Computer(validator, factory);
    }

    @Test
    void 연산과정종합테스트() {
        String result = computer.compute("1+2+3+4+5");
        Assertions.assertEquals("15.00", result);

        String result1 = computer.compute("1*2*3*4*5");
        Assertions.assertEquals("120.00", result1);

        String result2 = computer.compute("1/2+3+4*5");
        Assertions.assertEquals("23.50", result2);

        String result3 = computer.compute("1-23-4-5");
        Assertions.assertEquals("-31.00", result3);
    }
}
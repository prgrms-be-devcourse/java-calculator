package engine.computer;

import com.devcourse.engine.model.computer.Computer;
import com.devcourse.engine.model.computer.SimpleComputer;
import com.devcourse.engine.model.converter.PostfixConverter;
import com.devcourse.engine.model.exception.InvalidInputException;
import com.devcourse.engine.model.validator.SimpleValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
    void computeTest1() {
        Computer computer = new SimpleComputer();
        String expression = "1+1";
        Assertions.assertEquals(
                2.0,
                computer.compute(
                        new PostfixConverter()
                                .convert(
                                        new SimpleValidator().
                                                validate(expression)
                                )
                )
        );
    }

    @Test
    void computeTest2() {
        Computer computer = new SimpleComputer();
        String expression = "1 +2 * 5- 8/4";
        Assertions.assertEquals(
                9.0,
                computer.compute(
                        new PostfixConverter()
                                .convert(
                                        new SimpleValidator().
                                                validate(expression)
                                )
                )
        );
    }

    @Test
    void computeTest3() {
        Computer computer = new SimpleComputer();
        String expression = "1 +";
        Assertions.assertThrows(
                InvalidInputException.class,
                () -> computer.compute(
                        new PostfixConverter()
                                .convert(
                                        new SimpleValidator().
                                                validate(expression)
                                )
                )
        );
    }

    @Test
    void computeTest4() {
        Computer computer = new SimpleComputer();
        String expression = "\n";
        Assertions.assertThrows(
                InvalidInputException.class,
                () -> computer.compute(
                        new PostfixConverter()
                                .convert(
                                        new SimpleValidator().
                                                validate(expression)
                                )
                )
        );
    }

    @Test
    void computeTest5() {
        Computer computer = new SimpleComputer();
        String expression = "(1+2*(10-8))/4";
        Assertions.assertEquals(
                1.25,
                computer.compute(
                        new PostfixConverter()
                                .convert(
                                        new SimpleValidator().
                                                validate(expression)
                                )
                )
        );
    }

    @Test
    void computeTest6() {
        Computer computer = new SimpleComputer();
        String expression = "1+2*(10-8)/4";
        Assertions.assertEquals(
                2.0,
                computer.compute(
                        new PostfixConverter()
                                .convert(
                                        new SimpleValidator().
                                                validate(expression)
                                )
                )
        );
    }

}

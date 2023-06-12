package engine.computer;

import com.devcourse.engine.computer.SimpleComputer;
import com.devcourse.engine.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleComputerComputeTest {

    @Test
    void computeTest1() {
        SimpleComputer simpleComputer = new SimpleComputer();
        String expression = "1+1";
        Assertions.assertEquals(2.0, simpleComputer.compute(simpleComputer.convert(simpleComputer.validate(expression))));
    }

    @Test
    void computeTest2() {
        SimpleComputer simpleComputer = new SimpleComputer();
        String expression = "1 +2 * 5- 8/4";
        Assertions.assertEquals(9.0, simpleComputer.compute(simpleComputer.convert(simpleComputer.validate(expression))));
    }

    @Test
    void computeTest3() {
        SimpleComputer simpleComputer = new SimpleComputer();
        String expression = "1 +";
        Assertions.assertThrows(InvalidInputException.class, () -> simpleComputer.compute(simpleComputer.convert(simpleComputer.validate(expression))));
    }

    @Test
    void computeTest4() {
        SimpleComputer simpleComputer = new SimpleComputer();
        String expression = "\n";
        Assertions.assertThrows(InvalidInputException.class, () -> simpleComputer.compute(simpleComputer.convert(simpleComputer.validate(expression))));
    }

    @Test
    void computeTest5() {
        SimpleComputer simpleComputer = new SimpleComputer();
        String expression = "(1+2*(10-8))/4";
        Assertions.assertEquals(1.25, simpleComputer.compute(simpleComputer.convert(simpleComputer.validate(expression))));
    }

    @Test
    void computeTest6() {
        SimpleComputer simpleComputer = new SimpleComputer();
        String expression = "1+2*(10-8)/4";
        Assertions.assertEquals(2.0, simpleComputer.compute(simpleComputer.convert(simpleComputer.validate(expression))));
    }

}

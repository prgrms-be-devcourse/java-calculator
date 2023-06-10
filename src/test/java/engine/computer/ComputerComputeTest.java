package engine.computer;

import com.devcourse.engine.computer.Computer;
import com.devcourse.engine.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerComputeTest {

    @Test
    void computeTest1() {
        Computer computer = new Computer();
        String expression = "1+1";
        Assertions.assertEquals(2.0, computer.compute(computer.convert(computer.validate(expression))));
    }

    @Test
    void computeTest2() {
        Computer computer = new Computer();
        String expression = "1 +2 * 5- 8/4";
        Assertions.assertEquals(9.0, computer.compute(computer.convert(computer.validate(expression))));
    }

    @Test
    void computeTest3() {
        Computer computer = new Computer();
        String expression = "1 +";
        Assertions.assertThrows(InvalidInputException.class, () -> computer.compute(computer.convert(computer.validate(expression))));
    }

    @Test
    void computeTest4() {
        Computer computer = new Computer();
        String expression = "\n";
        Assertions.assertThrows(InvalidInputException.class, () -> computer.compute(computer.convert(computer.validate(expression))));
    }

    @Test
    void computeTest5() {
        Computer computer = new Computer();
        String expression = "(1+2*(10-8))/4";
        Assertions.assertEquals(1.25, computer.compute(computer.convert(computer.validate(expression))));
    }

    @Test
    void computeTest6() {
        Computer computer = new Computer();
        String expression = "1+2*(10-8)/4";
        Assertions.assertEquals(2.0, computer.compute(computer.convert(computer.validate(expression))));
    }

}

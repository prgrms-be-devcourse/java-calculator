package engine.computer;

import com.devcourse.engine.computer.Computer;
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

}

package engine.computer;

import com.devcourse.engine.computer.Computer;
import com.devcourse.engine.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComputerValidateTest {

    @Test
    void validateTest1() {
        Computer computer = new Computer();
        List<String> expressionResult = computer.validate("1+1");
        Assertions.assertEquals(3, expressionResult.size());
    }

    @Test
    void validateTest2() {
        Computer computer = new Computer();
        List<String> expressionResult = computer.validate("1 + 2 * 5 -8/4");
        Assertions.assertEquals(9, expressionResult.size());
    }

    @Test
    void validateExceptionTest1() {
        Computer computer = new Computer();
        Assertions.assertThrows(InvalidInputException.class, () -> computer.validate("+ 1"));
    }

    @Test
    void validateExceptionTest2() {
        Computer computer = new Computer();
        Assertions.assertThrows(InvalidInputException.class, () -> computer.validate("+"));
    }

    @Test
    void validateExceptionTest3() {
        Computer computer = new Computer();
        Assertions.assertThrows(InvalidInputException.class, () -> computer.validate("1 ++"));
    }

    @Test
    void validateExceptionTest4() {
        Computer computer = new Computer();
        Assertions.assertThrows(InvalidInputException.class, () -> computer.validate("1 2 3"));
    }

    @Test
    void validateExceptionTest5() {
        Computer computer = new Computer();
        Assertions.assertThrows(InvalidInputException.class, () -> computer.validate(""));
    }

}

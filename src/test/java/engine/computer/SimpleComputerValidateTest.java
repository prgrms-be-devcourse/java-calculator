package engine.computer;

import com.devcourse.engine.computer.SimpleComputer;
import com.devcourse.engine.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SimpleComputerValidateTest {

    @Test
    void validateTest1() {
        SimpleComputer simpleComputer = new SimpleComputer();
        List<String> expressionResult = simpleComputer.validate("1+1");
        Assertions.assertEquals(3, expressionResult.size());
    }

    @Test
    void validateTest2() {
        SimpleComputer simpleComputer = new SimpleComputer();
        List<String> expressionResult = simpleComputer.validate("1 + 2 * 5 -8/4");
        Assertions.assertEquals(9, expressionResult.size());
    }

    @Test
    void validateTest3() {
        SimpleComputer simpleComputer = new SimpleComputer();
        List<String> expressionResult = simpleComputer.validate(" 1");
        Assertions.assertEquals(1, expressionResult.size());
    }

    @Test
    void validateTest4() {
        SimpleComputer simpleComputer = new SimpleComputer();
        Assertions.assertEquals(3, simpleComputer.validate("2. * 3").size());
    }

    @Test
    void validateTest5() {
        SimpleComputer simpleComputer = new SimpleComputer();
        Assertions.assertEquals(3, simpleComputer.validate("2.*3").size());
    }

    @Test
    void validateTest6() {
        SimpleComputer simpleComputer = new SimpleComputer();
        Assertions.assertEquals(11, simpleComputer.validate("1+2*(10-8)/4").size());
    }

    @Test
    void validateExceptionTest6() {
        SimpleComputer simpleComputer = new SimpleComputer();
        Assertions.assertEquals(3, simpleComputer.validate("1.2*2").size());
    }

    @Test
    void validateExceptionTest1() {
        SimpleComputer simpleComputer = new SimpleComputer();
        Assertions.assertThrows(InvalidInputException.class, () -> simpleComputer.validate("+ 1"));
    }

    @Test
    void validateExceptionTest2() {
        SimpleComputer simpleComputer = new SimpleComputer();
        Assertions.assertThrows(InvalidInputException.class, () -> simpleComputer.validate("+"));
    }

    @Test
    void validateExceptionTest3() {
        SimpleComputer simpleComputer = new SimpleComputer();
        Assertions.assertThrows(InvalidInputException.class, () -> simpleComputer.validate("1 ++"));
    }

    @Test
    void validateExceptionTest4() {
        SimpleComputer simpleComputer = new SimpleComputer();
        Assertions.assertThrows(InvalidInputException.class, () -> simpleComputer.validate("1 2 3"));
    }

    @Test
    void validateExceptionTest5() {
        SimpleComputer simpleComputer = new SimpleComputer();
        Assertions.assertThrows(InvalidInputException.class, () -> simpleComputer.validate(""));
    }


    @Test
    void validateExceptionTest7() {
        SimpleComputer simpleComputer = new SimpleComputer();
        Assertions.assertThrows(InvalidInputException.class, () -> simpleComputer.validate(".14 + 2"));
    }

    @Test
    void validateExceptionTest8() {
        SimpleComputer simpleComputer = new SimpleComputer();
        Assertions.assertThrows(InvalidInputException.class, () -> simpleComputer.validate("1+)7*9-(8+9"));
    }

    @Test
    void validateExceptionTest9() {
        SimpleComputer simpleComputer = new SimpleComputer();
        Assertions.assertThrows(InvalidInputException.class, () -> simpleComputer.validate("())"));
    }

    @Test
    void validateExceptionTest10() {
        SimpleComputer simpleComputer = new SimpleComputer();
        Assertions.assertThrows(InvalidInputException.class, () -> simpleComputer.validate("(())"));
    }

}

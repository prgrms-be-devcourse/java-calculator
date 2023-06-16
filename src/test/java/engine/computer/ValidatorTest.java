package engine.computer;

import com.devcourse.engine.model.exception.InvalidInputException;
import com.devcourse.engine.model.validator.ExpressionValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ValidatorTest {

    @Test
    void validateTest1() {
        Validator validator = new ExpressionValidator();
        List<String> expressionResult = validator.validate("1+1");
        Assertions.assertEquals(3, expressionResult.size());
    }

    @Test
    void validateTest2() {
        Validator validator = new ExpressionValidator();
        List<String> expressionResult = validator.validate("1 + 2 * 5 -8/4");
        Assertions.assertEquals(9, expressionResult.size());
    }

    @Test
    void validateTest3() {
        Validator validator = new ExpressionValidator();
        List<String> expressionResult = validator.validate(" 1");
        Assertions.assertEquals(1, expressionResult.size());
    }

    @Test
    void validateTest4() {
        Validator validator = new ExpressionValidator();
        Assertions.assertEquals(3, validator.validate("2. * 3").size());
    }

    @Test
    void validateTest5() {
        Validator validator = new ExpressionValidator();
        Assertions.assertEquals(3, validator.validate("2.*3").size());
    }

    @Test
    void validateTest6() {
        Validator validator = new ExpressionValidator();
        Assertions.assertEquals(11, validator.validate("1+2*(10-8)/4").size());
    }

    @Test
    void validateExceptionTest6() {
        Validator validator = new ExpressionValidator();
        Assertions.assertEquals(3, validator.validate("1.2*2").size());
    }

    @Test
    void validateExceptionTest1() {
        Validator validator = new ExpressionValidator();
        Assertions.assertThrows(InvalidInputException.class, () -> validator.validate("+ 1"));
    }

    @Test
    void validateExceptionTest2() {
        Validator validator = new ExpressionValidator();
        Assertions.assertThrows(InvalidInputException.class, () -> validator.validate("+"));
    }

    @Test
    void validateExceptionTest3() {
        Validator validator = new ExpressionValidator();
        Assertions.assertThrows(InvalidInputException.class, () -> validator.validate("1 ++"));
    }

    @Test
    void validateExceptionTest4() {
        Validator validator = new ExpressionValidator();
        Assertions.assertThrows(InvalidInputException.class, () -> validator.validate("1 2 3"));
    }

    @Test
    void validateExceptionTest5() {
        Validator validator = new ExpressionValidator();
        Assertions.assertThrows(InvalidInputException.class, () -> validator.validate(""));
    }


    @Test
    void validateExceptionTest7() {
        Validator validator = new ExpressionValidator();
        Assertions.assertThrows(InvalidInputException.class, () -> validator.validate(".14 + 2"));
    }

    @Test
    void validateExceptionTest8() {
        Validator validator = new ExpressionValidator();
        Assertions.assertThrows(InvalidInputException.class, () -> validator.validate("1+)7*9-(8+9"));
    }

    @Test
    void validateExceptionTest9() {
        Validator validator = new ExpressionValidator();
        Assertions.assertThrows(InvalidInputException.class, () -> validator.validate("())"));
    }

    @Test
    void validateExceptionTest10() {
        Validator validator = new ExpressionValidator();
        Assertions.assertThrows(InvalidInputException.class, () -> validator.validate("(())"));
    }

}

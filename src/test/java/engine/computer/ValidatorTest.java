package engine.computer;

import com.devcourse.engine.model.exception.InvalidInputException;
import com.devcourse.engine.model.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "1+1", "1 + 2 * 5 -8/4", " 1",
            "2. * 3", "2.*3", "1+2*(10-8)/4",
            "1.2*2"
    })
    void validateTest(String input) {
        Validator validator =  new Validator();
        boolean result = validator.validate(input);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "+ 1", "1 ++", "1 2 3",
            "", ".14 + 2", "1+)7*9-(8+9",
            "())", "(())", "adsfk", "1 k 3", "", " "
    })
    void ValidateExceptionTest(String input) {
        Validator validator =  new Validator();
        Assertions.assertThrows(InvalidInputException.class, () -> validator.validate(input));
    }

}

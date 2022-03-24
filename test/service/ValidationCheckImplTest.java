package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidationCheckImplTest {

    ValidationCheck validationCheck = new ValidationCheckImpl();

    @ParameterizedTest
    @CsvSource({ // given
            "10 + 2 -", "*1 + 2 * 3", "3 - z200 * 29", "111 222", "100",
            "-100", "0", "100 ++ 200", "--100 + 200"
    })
    public void 올바르지않은_수식_검사(String command) {
        // when
        boolean validate = validationCheck.validate(command);
        // then
        Assertions.assertEquals(false, validate);
    }

    @ParameterizedTest
    @CsvSource({ // given
            "1 + 2", "1 + 2 * 3", "3 - 2 * 2", "-3 + 2 * 2 / 2 - 1",
    })
    public void 올바른_수식_검사(String command) {
        // when
        boolean validate = validationCheck.validate(command);
        // then
        Assertions.assertEquals(true, validate);
    }

    @ParameterizedTest
    @CsvSource({ // given
            "1 +     2",
            "        1 + 2          * 3",
            "3 -         2 *    2",
            "300-    200"
    })
    public void 공백이포함된_올바_수식_검사(String command) {
        // when
        boolean validate = validationCheck.validate(command);
        // then
        Assertions.assertEquals(true, validate);
    }

    @ParameterizedTest
    @CsvSource({ // given
            "*1 +     2",
            "        1 + 2          ** 3",
            "3 -         2 *    2  ㅋ",
            "300-    200-"
    })
    public void 공백이포함된_올바르지않은_수식_검사(String command) {
        // when
        boolean validate = validationCheck.validate(command);
        // then
        Assertions.assertEquals(false, validate);
    }

}
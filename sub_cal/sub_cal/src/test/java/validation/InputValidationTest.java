package validation;

import option.Option;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {
    @ParameterizedTest
    @CsvSource(value = {"1,","2"})
    void isValidMenuNumberFalse(String inputNumber) {
        Optional<Option> userOption = Option.getMenu(inputNumber);
        Assertions.assertFalse(InputValidation.isValidMenuNumber(userOption));
    }

    @ParameterizedTest
    @CsvSource(value = {"4,","5"})
    void isValidMenuNumberTrue(String inputNumber) {
        Optional<Option> userOption = Option.getMenu(inputNumber);
        Assertions.assertTrue(InputValidation.isValidMenuNumber(userOption));
    }
}

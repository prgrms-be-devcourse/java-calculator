package app.validator;

import app.calculator.Select;
import app.exception.SelectInputValidateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("번호 선택 입력값 검증 확인 - 정상 입력값")
    @Test
    void validateCorrectSelectInputTest() {
        // given
        Select lookUpInput = Select.LOOK_UP;
        Select calculateInput = Select.CALCULATE;
        Select exitInput = Select.EXIT;

        // when, then
        Assertions.assertDoesNotThrow(() -> inputValidator.validateSelectInput(lookUpInput));
        Assertions.assertDoesNotThrow(() -> inputValidator.validateSelectInput(calculateInput));
        Assertions.assertDoesNotThrow(() -> inputValidator.validateSelectInput(exitInput));
    }

    @DisplayName("번호 선택 입력값 검증 확인 - 비정상 입력값")
    @Test
    void validateAbnormalSelectInputTest() {
        // given
        Select abnormalInput = null;

        // when, then
        assertThrows(SelectInputValidateException.class, () -> inputValidator.validateSelectInput(abnormalInput));

    }
}
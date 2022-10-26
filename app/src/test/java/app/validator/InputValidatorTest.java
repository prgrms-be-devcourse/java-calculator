package app.validator;

import app.calculator.Select;
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

        // when
        boolean lookUpResult = inputValidator.validateSelectInput(lookUpInput);
        boolean calculateResult = inputValidator.validateSelectInput(calculateInput);
        boolean exitResult = inputValidator.validateSelectInput(exitInput);

        // then
        Assertions.assertTrue(lookUpResult);
        Assertions.assertTrue(calculateResult);
        Assertions.assertTrue(exitResult);
    }

    @DisplayName("번호 선택 입력값 검증 확인 - 비정상 입력값")
    @Test
    void validateAbnormalSelectInputTest() {
        // given
        Select abnormalInput = null;

        // when
        boolean result = inputValidator.validateSelectInput(abnormalInput);

        //then
        Assertions.assertFalse(result);
    }

    @DisplayName("게신시 연산식 입력값 검증 확인 - 정상 입력값")
    void validateCorrectCalculateInputValueTest() {
        // given
        String correctInput = "1 + 2 * 3 / 4 - 5";

        // when
        boolean result = inputValidator.validateCalculateInputValue(correctInput);

        // then
        Assertions.assertTrue(result);
    }

    @DisplayName("계산시 연산식 입력값 검증 확인 - 비정상 입력값 1 : 숫자, 사칙연산을 제외한 문자가 입력되었을 경우")
    @Test
    void validateAbnormalCalculateInputValueTest() {
        // given
        String abnormalInput = "1 + 2 ^ 3";

        // when
        boolean result = inputValidator.validateCalculateInputValue(abnormalInput);

        // then
        Assertions.assertFalse(result);
    }

    @DisplayName("계산시 연산식 입력값 검증 확인 - 비정상 입력값 2 : 연산식이 연속으로 배치됐을 경우")
    @Test
    void validateInCorrectExpressionInputValueTest() {
        // given
        String abnormalInput = "1 ++ 2 -- 3";

        // when
        boolean result = inputValidator.validateCalculateInputValue(abnormalInput);

        // then
        Assertions.assertFalse(result);
    }

}
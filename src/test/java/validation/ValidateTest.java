package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ValidateTest {
    ValidateService validate = new ValidateService();

    @ParameterizedTest
    @DisplayName("옳바른 선택 값인지")
    @ValueSource(strings = {
            "1", "2", "3"
    })
    void isCorrectCommandTrueTest(String inputCommand) {
        assertThat(validate.isCorrectCommand(inputCommand)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("잘못된 선택 값인지")
    @ValueSource(strings = {
            "4", " ", "!@#!", "마", "a"
    })
    void isCorrectCommandFalseTest(String inputCommand) {
        assertThat(validate.isCorrectCommand(inputCommand)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("조건에 맞는 계산식인지")
    @ValueSource(strings = {
            "3 * 5", "3 - 3 * 3 / 3 + 3"
    })
    void isCorrectFormulaTrueTest(String formula) {
        assertThat(validate.isCorrectFormula(formula)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("조건에 틀린 계산식인지")
    @ValueSource(strings = {
            "1", " ", "3 ! 4", "3 + ", "3+1"
    })
    void isCorrectFormulaFalseTest(String formula) {
        assertThat(validate.isCorrectFormula(formula)).isFalse();
    }
}
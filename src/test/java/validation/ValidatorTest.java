package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    @ParameterizedTest
    @DisplayName("올바르지 않은 괄호의 쌍 검증 테스트")
    @ValueSource(strings = {"((3+4)*2", "(3+4)*2)", "3+2*(2+6", "3)+4*2"})
    void bracketsPairWrongTest(String expression) {
        assertThat(Validator.checkBrackets(expression)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("올바른 괄호의 쌍 검증 테스트")
    @ValueSource(strings = {"(3+4)*2", "3+(4*2)", "(3+2*2+6)", "((3+4)*2)"})
    void bracketsPairTest(String expression) {
        assertThat(Validator.checkBrackets(expression)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("올바르지 않은 계산식 테스트")
    @ValueSource(strings = {"1+", "+1", "1++", "*", "((3+4)", "(3+4))", "3/45+-"})
    void wrongExpressionWrongTest(String expression) {
        assertThat(Validator.isRightExpression(expression)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("올바른 계산식 테스트")
    @ValueSource(strings = {"1+7", "11+1", "121+23", "87*17", "(31+4)", "(3*4)+4", "3+(4*3)"})
    void wrongExpressionTest(String expression) {
        assertThat(Validator.isRightExpression(expression)).isTrue();
    }


}
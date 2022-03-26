package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTypeTest {

    @DisplayName("from은 연산자를 주면 OperatorType을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "/", "*"})
    void from_operator_returnType(String operator) {
        assertThat(OperatorType.from(operator))
            .isInstanceOf(OperatorType.class);
    }

    @DisplayName("from은 연산자가 아닐 때 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"5", "", " ", "//", "s", "++"})
    void from_notOperand_throwException(String notOperator) {
        assertThatThrownBy(() -> OperatorType.from(notOperator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 연산자가 아닙니다. 다시 입력해주세요.");
    }
}

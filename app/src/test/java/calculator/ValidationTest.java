package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.Validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static validator.Validator.checkValidOperator;

class ValidationTest {
    @DisplayName("0, 1, 2를 제외한 숫자를 입력하면 예외가 발생한다.")
    @Test
    void checkChoiceNum() {
        final int num = 4;

        assertThatThrownBy(() -> Validator.checkChoiceNum(num))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("(, ), +, -, *, /를 제외한 부호는 예외가 발생한다")
    @Test
    void checkOperator() {
        final char rightOp = '+';
        final char wrongOp = '&';

        assertThat(checkValidOperator(rightOp)).isEqualTo('+');
        assertThatThrownBy(() -> checkValidOperator(wrongOp))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
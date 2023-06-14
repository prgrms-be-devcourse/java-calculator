package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.Validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static validator.Validator.checkPositiveNum;
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

    @DisplayName("계산기에 음수는 입력할 수 없다.")
    @Test
    void checkInputNum() {
        final String positive = "123";
        final String negative = "-123";

        assertThat(checkPositiveNum(positive)).isEqualTo(true);
        assertThatThrownBy(() -> checkPositiveNum(negative))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
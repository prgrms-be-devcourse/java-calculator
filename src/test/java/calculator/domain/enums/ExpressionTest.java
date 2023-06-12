package calculator.domain;

import calculator.exception.ApplicationException;
import calculator.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Expression 테스트")
public class ExpressionTest {
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 + 3",
            "1 * 2 + 3",
            "1 / 3 + 4",
            "1 - 4"})
    void 연산식입력이_정상이라면_성공(String input) {
        // when
        Expression expression = new Expression(input);

        // then
        assertEquals(input, expression.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + +",
            "1 +",
            "* + 1",
            "/ 1",
            "1 + + + + +",
            "+"
    })
    void 연산신입력에서_연산자순서가잘못됐다면_예외발생(String input) {
        // when && then
        assertThatThrownBy(() -> new Expression(input))
                .isInstanceOf(ApplicationException.class)
                .hasMessageContaining(ErrorMessage.WRONG_EXPRESSION_EXCEPTION.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 +",
            "1 1 1",
            "+ 1 1",
            "1 + ",
    })
    void 연산식입력값에서_피연산자순서가잘못됐다면_에러발생(String input) {
        // when && then
        assertThatThrownBy(() -> new Expression(input))
                .isInstanceOf(ApplicationException.class)
                .hasMessageContaining(ErrorMessage.WRONG_EXPRESSION_EXCEPTION.getMessage());
    }
}

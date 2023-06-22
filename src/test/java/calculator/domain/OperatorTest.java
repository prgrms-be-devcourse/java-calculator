package calculator.domain;

import calculator.domain.enums.Operator;
import calculator.exception.ApplicationException;
import calculator.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Enum Operator 테스트")
public class OperatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "/", "*"})
    void 입력값이_연산자가맞다면_리턴true(String input) {
        // when && then
        assertThat(Operator.checkOperator(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"?", "=", "2", "f", "ㄹ"})
    void 입력값이_연산자가아니라면_리턴false(String input) {
        // when && then
        assertThat(Operator.checkOperator(input)).isFalse();
    }

    @Test
    void 연산자가곱셈나눗셈_우선순위가높다면_리턴true() {
        Operator op1 = Operator.DIVISION;
        Operator op2 = Operator.MULTIPLICATION;

        // when && then
        assertThat(Operator.isHigherPriority(op1)).isTrue();
        assertThat(Operator.isHigherPriority(op2)).isTrue();
    }

    @Test
    void 연산자가덧셈뺄셈셈_우선순위가낮다면_리턴false() {
        Operator op1 = Operator.ADDITION;
        Operator op2 = Operator.SUBTRACTION;

        // when && then
        assertThat(Operator.isHigherPriority(op1)).isFalse();
        assertThat(Operator.isHigherPriority(op2)).isFalse();
    }

    @Test
    void 연산자로_더하기가들어온다면_두수의합리턴() {
        // given
        Operator op = Operator.ADDITION;
        int n1 = 1;
        int n2 = 2;

        // when
        int result = op.apply(n1, n2);

        // then
        assertEquals(3, result);
    }

    @Test
    void 연산자로_빼기가들어온다면_두수의합리턴() {
        // given
        Operator op = Operator.SUBTRACTION;
        int n1 = 1;
        int n2 = 2;

        // when
        int result = op.apply(n1, n2);

        // then
        assertEquals(-1, result);
    }

    @Test
    void 연산자로_곱하기가들어온다면_두수의합리턴() {
        // given
        Operator op = Operator.MULTIPLICATION;
        int n1 = 1;
        int n2 = 2;

        // when
        int result = op.apply(n1, n2);

        // then
        assertEquals(2, result);
    }

    @Test
    void 연산자로_나누기가들어온다면_두수의합리턴() {
        // given
        Operator op = Operator.DIVISION;
        int n1 = 1;
        int n2 = 2;

        // when
        int result = op.apply(n1, n2);

        // then
        assertEquals(0, result);
    }

    @Test
    void 연산식이_0으로나누려고할때_예외처리() {
        // given
        Operator op = Operator.DIVISION;
        int n1 = 10;
        int n2 = 0;

        // when && then
        assertThatThrownBy(() -> op.apply(n1, n2))
                .isInstanceOf(ApplicationException.class)
                .hasMessageContaining(ErrorMessage.ZERO_DIVISION_OPTION.getMessage());
    }
}
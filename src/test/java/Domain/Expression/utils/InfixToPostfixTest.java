package Domain.Expression.utils;

import Common.Exception.WrongExpressionException;
import Common.Exception.WrongValueException;
import Domain.Expression.Expression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InfixToPostfixTest {

    @Test
    @DisplayName("후위표기식 동작 테스트")
    void convert_correctExp() {
        // given
        String exp = "12 + 3 * 4 + 5 * 6 * 7";
        List<String> expected = List.of("12", "3", "4", "*", "+", "5", "6", "*", "7", "*", "+");
        // when
        List<String> postfix = new InfixToPostfix().convert(exp);
        // then
        assertThat(expected.toString()).isEqualTo(postfix.toString());
    }

    @Test
    @DisplayName("후위표기식 에러 테스트(뚱딴지 같은 값 e.g. 영어, 특수문자)")
    void convert_WrongValue() {
        // given
        String exp = "12 + 3 + fdf ";
        // when
        // then
        assertThrows(WrongValueException.class, () -> new InfixToPostfix().convert(exp));
    }

    @Test
    @DisplayName("후위표기식 에러 테스트(입력 가능한 값인데 이상한 식)")
    void convert_WrongExpCase1() {
        // given
        String exp = "1 ++++++ 2";
        // when
        // then
        assertThrows(WrongValueException.class, () -> new InfixToPostfix().convert(exp));
    }

    @Test
    @DisplayName("후위표기식 에러 테스트(입력 가능한 값만 들어오지만 식이 이상한 경우)")
    void convert_WrongExpCase2() {
        // given
        String exp = "1 + 2 + 3 +";
        // when
        // then
        assertThrows(WrongExpressionException.class, () -> new Expression(exp));
    }
}
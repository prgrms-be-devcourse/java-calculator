package com.programmers.calculator.constant;

import com.programmers.calculator.domain.vo.Expression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RegexEnumTest {

    @DisplayName("정규식에 맞게 토큰이 잘 쪼개지는지 확인")
    @Test
    void expression_regex_parsing () {

        // given
        Expression expression1 = new Expression("1 + 2 * 4 / 6");
        Expression expression2 = new Expression("1+2*4/6");

        // when
        List<String> result1 = RegexEnum.parseToTokens(expression1);
        List<String> result2 = RegexEnum.parseToTokens(expression2);
        List<String> expectedTokens = List.of("1", "+", "2", "*", "4", "/", "6");

        // then
        assertThat(result1).isEqualTo(expectedTokens);
        assertThat(result2).isEqualTo(expectedTokens);
    }

    @DisplayName("숫자가 숫자 정규식에 체크 되는지 확인")
    @Test
    void numeric_regex() {
        assertThat(RegexEnum.isNumeric("1")).isTrue();
    }

    @DisplayName("숫자 아닌 것이 숫자 정규식에 체크가 안되는지 확인")
    @Test
    void not_numeric_regex() {
        assertThat(RegexEnum.isNumeric("a")).isFalse();
    }

}
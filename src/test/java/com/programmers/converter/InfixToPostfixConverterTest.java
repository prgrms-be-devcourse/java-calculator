package com.programmers.converter;

import com.programmers.util.ConstantRegex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InfixToPostfixConverterTest {

    ExpressionConverter converter;

    @BeforeEach
    void setUp() {
        converter = new InfixToPostfixConverter();
    }

    @ParameterizedTest
    @CsvSource(value = {"3  * 4     + 2:5", "4 + 3 * 2 / 5 :7", "10 * 20    + 3 / 4     + 5:9", "(3 + 4) * 2    + 5     * ( 2 + 3):15"}, delimiter = ':')
    @DisplayName("수식 입력 값 개별 토큰 변환")
    void 수식_개별토큰변환(String input, String output) {
        Matcher matcher = ConstantRegex.EXPRESSION_FILTER_REGEX_COMPILE.matcher(input);
        List<String> filterExpression = new ArrayList<>();

        while (matcher.find()) {
            filterExpression.add(matcher.group());
        }
        assertThat(filterExpression.size()).isEqualTo(Integer.parseInt(output));
    }

    @ParameterizedTest
    @CsvSource(value = {"4 + 3 * 2 / 5:True", "(3 + 4) * 2    + 5     * ( 2 + 3) : True"}, delimiter = ':')
    @DisplayName("수식 입력 옳은 값 검증")
    void 수식_적절한입력토큰검증(String input, String output) {
        input = input.replaceAll(ConstantRegex.WHITESPACE_REGEX, "");
        assertThat(ConstantRegex.EXPRESSION_VALIDATION_REGEX_COMPILE
                .matcher(input)
                .matches()).isEqualTo(Boolean.valueOf(output));

    }

    @ParameterizedTest
    @CsvSource(value = {"a * 5 + 2 : False", "7 ^ 2 + 5 : False", "7 ^     2 + 5 : False"}, delimiter = ':')
    @DisplayName("수식 입력 잘못된 값 검증")
    void 수식_잘못된입력토큰검증(String input, String output) {
        input = input.replaceAll(ConstantRegex.WHITESPACE_REGEX, "");
        assertThat(ConstantRegex.EXPRESSION_VALIDATION_REGEX_COMPILE
                .matcher(input)
                .matches()).isEqualTo(Boolean.valueOf(output));
    }

    @ParameterizedTest
    @CsvSource(value = {"3*8/4:3 8 * 4 /", "( 3 / ( 8 - 4 + 9 ) ) * ( 20 - 8 ) * 17: 3 8 4 - 9 + / 20 8 - * 17 *", "10/7-15+10*20-5*8:10 7 / 15 - 10 20 * + 5 8 * -"}, delimiter = ':')
    @DisplayName("수식 중위표기 -> 수식 후위표기")
    void 수식_변환(String input, String output) {
        assertThat(converter.convert(input))
                .containsExactly(output.split(" "));
    }

    @ParameterizedTest
    @ValueSource(strings = {") (3 * 5)"})
    @DisplayName("괄호가 일치하지 않은 경우 예외 검증")
    void 괄호_검증(String input) {
        assertThatThrownBy(() -> converter.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("괄호의 순서가 잘못되었습니다.");
    }
}
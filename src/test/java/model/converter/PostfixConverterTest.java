package model.converter;

import model.vo.Expression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PostfixConverterTest {
    private final PostfixConverter converter = new PostfixConverter();

    @Test
    @DisplayName("후위식변환 테스트")
    void covert1() {
        //given
        final Expression expression = new Expression("3 + 2 * 4 - 9 / 3");
        final List<String> expected = List.of("3", "2", "4", "*", "+", "9", "3", "/", "-");

        //when
        List<String> result = converter.convert(expression);

        //then
        assertThat(result).hasSameHashCodeAs(expected);
    }

    @Test
    @DisplayName("후위식변환 테스트")
    void covert2() {
        //given
        final Expression expression = new Expression("2 + 3 * 4 - 5");
        final List<String> expected = List.of("2", "3", "4", "*", "+", "5", "-");

        //when
        List<String> result = converter.convert(expression);

        //then
        assertThat(result).hasSameHashCodeAs(expected);
    }

    @Test
    @DisplayName("후위식변환 테스트")
    void covert3() {
        //given
        final Expression expression = new Expression("2 - 3 + 4");
        final List<String> expected = List.of("2", "3", "-", "4", "+");

        //when
        List<String> result = converter.convert(expression);

        //then
        assertThat(result).hasSameHashCodeAs(expected);
    }
}

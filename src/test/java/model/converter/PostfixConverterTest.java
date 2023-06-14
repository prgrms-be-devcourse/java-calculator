package model.converter;

import model.vo.Expression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PostfixConverterTest {

    @Test
    @DisplayName("후위식변환 테스트")
    void covert() {
        //given
        final Converter converter = new PostfixConverter();
        final Expression expression = new Expression("3 + 2 * 4 - 9 / 3");
        final List<String> result = List.of("3", "2", "4", "*", "+", "9", "3", "/", "-");

        //when
        List<String> covert = converter.convert(expression);

        //then
        assertThat(covert).hasSameHashCodeAs(result);
    }
}

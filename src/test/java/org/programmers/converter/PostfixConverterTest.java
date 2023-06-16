package org.programmers.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.expression.ExpressionParam;
import org.programmers.expression.ExpressionValidator;

import static org.assertj.core.api.Assertions.assertThat;

class PostfixConverterTest {

    @Test
    @DisplayName("후위표기식 변환 테스트")
    void toPostfixTest() {
        Converter converter = new PostfixConverter(new ExpressionValidator());

        String expression = "3+4*2";
        String expression2 = "15-5*2";

        ExpressionParam param = converter.convert(expression);
        assertThat(param.getPostfix().get(1)).isEqualTo("4");
        assertThat(param.getPostfix().get(3)).isEqualTo("*");

        ExpressionParam param2 = converter.convert(expression2);
        assertThat(param2.getPostfix().get(0)).isEqualTo("15");
    }
}
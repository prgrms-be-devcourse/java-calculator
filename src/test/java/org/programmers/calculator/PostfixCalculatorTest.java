package org.programmers.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.converter.Converter;
import org.programmers.converter.PostfixConverter;
import org.programmers.expression.ExpressionParam;
import org.programmers.expression.ExpressionResult;
import org.programmers.expression.ExpressionValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PostfixCalculatorTest {

    @Test
    @DisplayName("계산 성공 테스트")
    void calculateSuccess() {
        ExpressionValidator validator = new ExpressionValidator();
        Calculator calculator = new PostfixCalculator(validator);
        Converter converter = new PostfixConverter(validator);

        ExpressionParam param = converter.convert("3+4*5");
        ExpressionResult expressionResult = calculator.calculate(param);
        double result = expressionResult.getAnswer();

        assertThat(result).isEqualTo(23);
    }

    @Test
    @DisplayName("잘못된 식을 넣으면 예외가 발생한다.")
    void calculateException() {
        ExpressionValidator validator = new ExpressionValidator();
        Calculator calculator = new PostfixCalculator(validator);
        Converter converter = new PostfixConverter(validator);

        ExpressionParam param = converter.convert("3+4**5");
        assertThatThrownBy(() -> calculator.calculate(param))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
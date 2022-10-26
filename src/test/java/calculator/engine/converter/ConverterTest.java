package calculator.engine.converter;

import calculator.application.io.Parser;
import calculator.engine.model.Expression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterTest {
    private final Converter converter = new PostfixConverter();

    @DisplayName("후위식 변환 테스트")
    @Test
    void test1() {
        Expression infix = new Expression(Parser.toList("A + B / C * D - E"));
        Expression answer = new Expression(Parser.toList("A B C / D * + E -"));

        Expression postfix = converter.toPostfix(infix);

        assertThat(postfix.getExpression()).isEqualTo(answer.getExpression());
    }
}
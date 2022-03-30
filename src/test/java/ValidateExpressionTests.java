import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidateExpressionTests {

    private final Prefix2PostfixConverter converter = new Prefix2PostfixConverter();

    @Test
    @DisplayName("괄호의 짝이 맞으면 true, 안 맞으면 false 반환한다.")
    void validateExpressionWithParentheses() {

        // given
        List<String> exp1 = converter.expressionToList("1 + ( 3 * ( 4 - 2 )");
        List<String> exp2 = converter.expressionToList("(()");
        List<String> exp3 = converter.expressionToList("(3))");

        // when

        // then
        assertThat(converter.validate(exp1)).isEqualTo(false);
        assertThat(converter.validate(exp2)).isEqualTo(false);
        assertThat(converter.validate(exp3)).isEqualTo(false);
    }

    @Test
    @DisplayName("+-/*이외의 연산자를 사용한 경우 예외를 발생시킨다.")
    void validateExpressionWithOpcode() {
        // given
        List<String> exp1 = converter.expressionToList("1 = 3");
        List<String> exp2 = converter.expressionToList("1 + [ 2 + 3 ]");
        List<String> exp3 = converter.expressionToList("1 % 3");

        // when

        // then
        assertThat(converter.validate(exp1)).isEqualTo(false);
        assertThat(converter.validate(exp2)).isEqualTo(false);
        assertThat(converter.validate(exp3)).isEqualTo(false);
    }

    @Test
    @DisplayName("'('를 제외한 연산자로 시작하는 경우 예외를 발생시킨다.")
    void validateExpressionWithFirstLetter() {
        // given
        List<String> exp1 = converter.expressionToList("+1 + 1");
        List<String> exp2 = converter.expressionToList("-1 * (2 + 3)");
        List<String> exp3 = converter.expressionToList("* 1 - 1");

        // when

        // then
        assertThat(converter.validate(exp1)).isEqualTo(false);
        assertThat(converter.validate(exp2)).isEqualTo(false);
        assertThat(converter.validate(exp3)).isEqualTo(false);
    }

    @Test
    @DisplayName("')'를 제외한 연산자로 끝나는 경우 예외를 발생시킨다.")
    void validateExpressionWithEndLetter() {
        // given
        List<String> exp1 = converter.expressionToList("1 + +");
        List<String> exp2 = converter.expressionToList("1 + 2 - (");
        List<String> exp3 = converter.expressionToList("1 * 2 *");

        // when

        // then
        assertThat(converter.validate(exp1)).isEqualTo(false);
        assertThat(converter.validate(exp2)).isEqualTo(false);
        assertThat(converter.validate(exp3)).isEqualTo(false);
    }

    @Test
    @DisplayName("공백이거나 연산항의 개수가 2개 이하인 경우 예외를 발생시킨다.")
    void validateExpressionWithNumberOfOperatorsAndOperands() {
        // given
        List<String> exp1 = converter.expressionToList("");
        List<String> exp2 = converter.expressionToList("1 1");
        List<String> exp3 = converter.expressionToList("  ");

        // when

        // then
        assertThat(converter.validate(exp1)).isEqualTo(false);
        assertThat(converter.validate(exp2)).isEqualTo(false);
        assertThat(converter.validate(exp3)).isEqualTo(false);
    }
}
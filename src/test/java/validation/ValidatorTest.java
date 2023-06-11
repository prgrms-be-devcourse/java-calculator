package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    @Test
    @DisplayName("괄호의 쌍 테스트")
    void bracketsPairTest() {
        String expr = "(3+4)*2";
        boolean result = Validator.checkBrackets(expr);
        assertThat(result).isTrue();

        expr = "(3+4)*2)";
        result = Validator.isRightExpr(expr);
        assertThat(result).isFalse();

        expr = "3+2*(2+6";
        result = Validator.isRightExpr(expr);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("올바르지 않은 계산식 테스트")
    void wrongExprTest() {
        String expr = "1+";
        boolean result = Validator.isRightExpr(expr);
        assertThat(result).isFalse();

        expr = "+1";
        result = Validator.isRightExpr(expr);
        assertThat(result).isFalse();

        expr = "1++";
        result = Validator.isRightExpr(expr);
        assertThat(result).isFalse();

        expr = "*";
        result = Validator.isRightExpr(expr);
        assertThat(result).isFalse();

        expr = "((3+4)";
        result = Validator.isRightExpr(expr);
        assertThat(result).isFalse();

        expr = "(3+4))";
        result = Validator.isRightExpr(expr);
        assertThat(result).isFalse();

        expr = "3/45+-";
        result = Validator.isRightExpr(expr);
        assertThat(result).isFalse();
    }
}
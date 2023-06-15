package computation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostfixComputerTest {

    private final Converter converter = new PostfixConverter();
    private final PostfixComputer postfixComputer = new PostfixComputer();

    @Test
    @DisplayName("기본 사칙 연산 테스트")
    void basicCalculationTest() {
        String infixExpr = "3 + 4";
        int result = postfixComputer.calculate(converter.convert(infixExpr));
        assertThat(result).isEqualTo(7);

        infixExpr = "3 - 4";
        result = postfixComputer.calculate(converter.convert(infixExpr));
        assertThat(result).isEqualTo(-1);

        infixExpr = "3 * 4";
        result = postfixComputer.calculate(converter.convert(infixExpr));
        assertThat(result).isEqualTo(12);

        infixExpr = "6 / 3";
        result = postfixComputer.calculate(converter.convert(infixExpr));
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("괄호를 반영한 계산 테스트")
    void bracketsTest() {
        String infixExpr = "(3 + (4 * 7)) - (6 / 3)";
        int result = postfixComputer.calculate(converter.convert(infixExpr));
        assertThat(result).isEqualTo(29);

        infixExpr = "3 + (6 / 3)";
        result = postfixComputer.calculate(converter.convert(infixExpr));
        assertThat(result).isEqualTo(5);

        infixExpr = "9 * (11 + 23)";
        result = postfixComputer.calculate(converter.convert(infixExpr));
        assertThat(result).isEqualTo(306);

        infixExpr = "(6 + 3) * 4";
        result = postfixComputer.calculate(converter.convert(infixExpr));
        assertThat(result).isEqualTo(36);
    }

}
package calculator;

import calculator.engine.Postfix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PostfixTest {
    private Postfix postfix = new Postfix();

    @Test
    @DisplayName("우선순위 테스트 & 입력값 이상 있을 경우 예외가 터져야 한다.")
    void test_01() throws Exception {
        int two1 = postfix.priority("/");
        int two2 = postfix.priority("*");
        int one1 = postfix.priority("+");
        int one2 = postfix.priority("-");
        int zero1 = postfix.priority("(");
        int zero2 = postfix.priority(")");

        assertThat(two1).isEqualTo(2);
        assertThat(two2).isEqualTo(2);
        assertThat(one1).isEqualTo(1);
        assertThat(one2).isEqualTo(1);
        assertThat(zero1).isEqualTo(0);
        assertThat(zero2).isEqualTo(0);

        assertThrows(IllegalArgumentException.class, () -> {
            postfix.priority("abc");
        });
    }

    @Test
    @DisplayName("계산식 & 후위식 변환 테스트")
    void test_02() throws Exception {
        String formula = "abc";
        assertThrows(IllegalArgumentException.class, () -> {
            postfix.makeToPostfix(formula);
        });

        String formula1 = "30 + 30";
        List<String> strings = postfix.makeToPostfix(formula1);
        String result = String.join(" ", strings);
        assertThat(result).isEqualTo("30 30 +");

        String formula2 = "(30 + 30) * 40 / 10";
        List<String> strings2 = postfix.makeToPostfix(formula2);
        String result2 = String.join(" ", strings2);
        assertThat(result2).isEqualTo("30 30 + 40 * 10 /");
    }
}
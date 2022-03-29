import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConvertExpressionTests {
    private final ExpressionConverter converter = new Prefix2PostfixConverter();

    @Test
    @DisplayName("전위표기법을 후위표기법으로 변환한다.")
    void prefixToPostfixTest() {

        // given
        String exp1 = "1 + 2 * 3";
        String exp2 = "1 * ( 2 / (3 - 4) )";
        String exp3 = "2 + 1/0";

        // when
        final StringBuilder sb = new StringBuilder();
        converter.convert(exp1).forEach(sb::append);
        String res1 = sb.toString();

        sb.setLength(0);
        converter.convert(exp2).forEach(sb::append);
        String res2 = sb.toString();

        sb.setLength(0);
        converter.convert(exp3).forEach(sb::append);
        String res3 = sb.toString();

        // then
        Assertions.assertThat(res1).isEqualTo("123*+");
        Assertions.assertThat(res2).isEqualTo("1234-/*");
        Assertions.assertThat(res3).isEqualTo("210/+");

    }
}

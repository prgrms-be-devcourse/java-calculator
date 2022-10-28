package app.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BasicPostfixMakerTest {

    private final BasicPostfixMaker basicPostfixMaker = new BasicPostfixMaker();

    @DisplayName("중위표기법 연산식을 후위표기법 연산식으로 변환")
    @Test
    void infixToPostfixTest() {
        // given
        String infix = "1 + 2 * 3 + 4 / 5";
        List<String> answer = List.of("1", "2", "3", "*", "+", "4", "5", "/", "+");

        // when
        List<String> result = basicPostfixMaker.makePostfix(infix);

        // then
        Assertions.assertThat(answer).isEqualTo(result);
    }
}

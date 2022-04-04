package hyuk.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PostOrderFormulaTest {

    @DisplayName("후위표기식 테스트")
    @Test
    void changeToPostOrder() {
        //given
        String formula = "1 + 2 * 3 + 4";

        //when
        PostOrderFormula postOrderFormula = new PostOrderFormula(formula);

        //then
        Assertions.assertThat(postOrderFormula.getPostOrderFormula())
            .containsExactly("1", "2", "3", "*", "+", "4", "+");
    }
}
package hyuk;

import hyuk.entity.Operators;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorsTest {

    @DisplayName("문자열 수식 -> 연산자 리스트로 변환")
    @Test
    void createOperators() {
        //given
        String exp = "1 + 2 * 3 + 4";

        //when
        Operators operators = new Operators(exp);

        //then
        Assertions.assertThat(operators.getOperators())
            .containsExactly('+', '*', '+');
    }

}

package hyuk;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperandsTest {

    @DisplayName("문자열 수식 -> 정수 피연산자 리스트")
    @Test
    void createOperands() {
        //given
        String exp = "1 + 2 * 3 + 4";

        //when
        Operands operands = new Operands(exp);

        //then
        Assertions.assertThat(operands.getOperands())
            .containsExactly(1, 2, 3, 4);
    }

}

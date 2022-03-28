package hyuk.entity;

import static org.assertj.core.api.Assertions.assertThat;

import hyuk.model.Operands;
import hyuk.model.Operators;
import hyuk.model.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LogTest {

    @DisplayName("log 변환 테스트")
    @Test
    void translate() {
        //given
        String formula = "1 + 2 * 3 + 4";
        Operands operands = new Operands(formula);
        Operators operators = new Operators(formula);
        Result result = new Result(11);

        //when
        Log log = Log.createLog(operands, operators, result);

        //then
        assertThat(log.getId()).isEqualTo(1);
        assertThat(log.getFormula()).isEqualTo(formula);
        assertThat(log.getResult()).isEqualTo(11);
    }
}

package hyuk.entity;

import static org.assertj.core.api.Assertions.assertThat;

import hyuk.calculator.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LogTest {

    @DisplayName("log 변환 테스트")
    @Test
    void translate() {
        //given
        String formula = "1 + 2 * 3 + 4";
        Result result = new Result(11);

        //when
        Log log = Log.createLog(formula, result);

        //then
        assertThat(log.getId()).isEqualTo(1);
        assertThat(log.getFormula()).isEqualTo(formula);
        assertThat(log.getResult()).isEqualTo(11);
    }
}

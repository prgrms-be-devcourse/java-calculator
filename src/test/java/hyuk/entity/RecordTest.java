package hyuk.entity;

import static org.assertj.core.api.Assertions.assertThat;

import hyuk.calculator.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RecordTest {

    @DisplayName("record 변환 테스트")
    @Test
    void translate() {
        //given
        String formula = "1 + 2 * 3 + 4";
        Result result = new Result(11);

        //when
        Record record = Record.createRecord(formula, result);

        //then
        assertThat(record.getId()).isNull();
        assertThat(record.getFormula()).isEqualTo(formula);
        assertThat(record.getResult()).isEqualTo(11);
    }
}

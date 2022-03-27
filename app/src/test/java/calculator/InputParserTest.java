package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputParserTest {
    @Test
    @DisplayName("입력 변환기 테스트")
    void parse(){
        assertThatThrownBy(()->InputParser.parse(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->InputParser.parse("")).isInstanceOf(IllegalArgumentException.class);
        assertThat(InputParser.parse("1 + 2")).isEqualTo(new String[] {"1", "2","+"});
        assertThat(InputParser.parse("1 + 2 * 3")).isEqualTo(new String[] {"1", "2", "3", "*", "+"});
        assertThat(InputParser.parse("1 * 2 + 3 / 0")).isEqualTo(new String[] {"1", "2", "*", "3", "0", "/", "+"});
    }
}

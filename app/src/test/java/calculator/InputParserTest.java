package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputParserTest {
    static InputParser inputParser;

    @BeforeAll
    static void setUp() {
        inputParser = new InputParser();
    }

    @Test
    @DisplayName("입력 변환기 테스트")
    void parse() {
        assertThatThrownBy(() -> inputParser.parse(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputParser.parse("")).isInstanceOf(IllegalArgumentException.class);
        assertThat(inputParser.parse("1 + 2")).isEqualTo(new String[]{"1", "2", "+"});
        assertThat(inputParser.parse("1 + 2 * 3")).isEqualTo(new String[]{"1", "2", "3", "*", "+"});
        assertThat(inputParser.parse("1 * 2 + 3 / 0")).isEqualTo(new String[]{"1", "2", "*", "3", "0", "/", "+"});
    }
}

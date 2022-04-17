package javacalculator.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class InputParserTest {
    static InputParser inputParser;

    @BeforeAll
    static void setUp() {
        inputParser = new InputParser();
    }

    @ParameterizedTest
    @DisplayName("입력 변환기 일반 입력 테스트")
    @CsvSource({"1 + 2,1 2 +", "1 + 2 * 3,1 2 3 * +", "1 * 2 + 3 / 0,1 2 * 3 0 / +"})
    void parse(String inputFormula, String expect) {
        String[] splitedExpect = expect.split(" ");
        assertThat(inputParser.parse(inputFormula)).isEqualTo(splitedExpect);
    }

    @Test
    @DisplayName("입력 변환기 null / 빈값 테스트")
    void parseWithNullOrEmpty() {
        assertThatThrownBy(() -> inputParser.parse(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputParser.parse("")).isInstanceOf(IllegalArgumentException.class);
    }
}

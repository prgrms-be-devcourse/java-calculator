package calculator;

import calculator.calculate.Calculate;
import calculator.calculate.PostfixCalculate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class CalculatorTest {

    Calculate calculator;

    @BeforeEach
    void beforeEach() {
        calculator = new PostfixCalculate();
    }

    @DisplayName("파싱한 값을 전달했을 때 원하는 값이 나오는지 확인")
    @Test
    void validCalculateTest() {
        ArrayList<String> mock = new ArrayList<>(Arrays.asList("3", "2", "4", "*", "+", "9", "3", "/", "-"));
        int want = 8;

        int got = calculator.execute(mock);

        Assertions.assertThat(got).isEqualTo(want);
    }
}
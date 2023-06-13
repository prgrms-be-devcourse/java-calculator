package org.calculator.engine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculateEngineTest {

    CalculateEngine calculateEngine = new CalculateEngine();

    @ParameterizedTest
    @CsvSource(
            {"1 + 1,2.0", "0 + 0,0.0", "-1 + 2,1.0", "-1 + 0, -1.0",
            "2 - 1,1.0", "1 - 2,-1.0", "-1 - 1, -2.0",
            "1 / 2,0.5", "2 / 1,2.0","-2 / 1, -2.0",
            "4 * 2 + 10,18.0", " 1 * 3 + 4 / 2,5.0"})
    void tesEngine(String equation, Double result) {
        Assertions.assertThat(calculateEngine.calculate(equation)).isEqualTo(result);
    }

}

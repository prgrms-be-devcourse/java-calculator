package org.example.calculation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArithmeticCalculationTest {

    @Test
    public void 사칙연산() throws Exception{
        ArithmeticCalculation arithmeticCalculation = new ArithmeticCalculation();
        int result = arithmeticCalculation.run("5 + 3 * 2");
        Assertions.assertThat(result).isEqualTo(11);
    }

}

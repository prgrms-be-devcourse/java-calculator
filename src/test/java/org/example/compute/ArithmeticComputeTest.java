package org.example.compute;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArithmeticComputeTest {

    @Test
    public void 사칙연산() throws Exception{
        ArithmeticCompute arithmeticCalculation = new ArithmeticCompute();
        double result = arithmeticCalculation.operate("5 + 3 * 2");
        Assertions.assertThat(result).isEqualTo(11);
    }

    @Test
    public void 잘못된_수식입력_테스트() throws Exception{
        ArithmeticCompute arithmeticCalculation = new ArithmeticCompute();
        double result = arithmeticCalculation.operate("5 + 3 * 2");
        Assertions.assertThat(result).isEqualTo(11);
    }

}

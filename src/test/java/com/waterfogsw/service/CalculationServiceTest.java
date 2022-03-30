package com.waterfogsw.service;

import com.waterfogsw.AppConfig;
import com.waterfogsw.exception.DoubleOverflow;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculationServiceTest {
    private CalculationService calculationService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        calculationService = appConfig.calculationService();
    }

    @Test
    public void 계산서비스_테스트_덧셈() throws Exception {
        // given
        String expr = "2 + 2 + 2";

        // when
        String result = calculationService.getResult(expr);

        // then
        Assertions.assertThat(result).isEqualTo("6");
    }

    @Test
    public void 계산서비스_테스트_뺄셈() throws Exception {
        // given
        String expr = "2 - 2 - 2 - 2";

        // when
        String result = calculationService.getResult(expr);

        // then
        Assertions.assertThat(result).isEqualTo("-4");
    }

    @Test
    public void 계산서비스_테스트_곱셈() throws Exception {
        // given
        String expr = "2 - 2 * 2";

        // when
        String result = calculationService.getResult(expr);

        // then
        Assertions.assertThat(result).isEqualTo("-2");
    }

    @Test
    public void 계산서비스_테스트_나눗셈() throws Exception {
        // given
        String expr = "2 - 2 / 2";

        // when
        String result = calculationService.getResult(expr);

        // then
        Assertions.assertThat(result).isEqualTo("1");
    }

    @Test
    public void 계산서비스_테스트_0으로나누기() throws Exception {
        // given
        String expr = "1 / 0";

        // when
        try {
            String result = calculationService.getResult(expr);
        } catch (ArithmeticException ignored) {

        }
    }

    @Test
    public void 계산서비스_테스트_괄호1() throws Exception {
        // given
        String expr = "2 / ( 4 + 3 )";

        // when
        String result = calculationService.getResult(expr);

        // then
        Assertions.assertThat(result).isEqualTo("0.286");
    }

    @Test
    public void 계산서비스_테스트_괄호2() throws Exception {
        // given
        String expr = "( 4 - 2 ) * 2";

        // when
        String result = calculationService.getResult(expr);

        // then
        Assertions.assertThat(result).isEqualTo("4");
    }

    @Test
    public void 계산서비스_테스트_음수시작1() throws Exception {
        // given
        String expr = "-100";

        // when
        String result = calculationService.getResult(expr);

        // then
        Assertions.assertThat(result).isEqualTo("-100");
    }

    @Test
    public void 계산서비스_테스트_음수시작2() throws Exception {
        // given
        String expr = "-10 + 45";

        // when
        String result = calculationService.getResult(expr);

        // then
        Assertions.assertThat(result).isEqualTo("35");
    }

    @Test
    public void 계산서비스_테스트_소수점() throws Exception {
        // given
        String expr = "-3.3 + 4";

        // when
        String result = calculationService.getResult(expr);

        // then
        Assertions.assertThat(result).isEqualTo("0.7");
    }

    @Test
    public void 계산서비스_테스트_범위초과() throws Exception {
        // given
        String expr = "2500000000000000000000 + 2000";

        // when
        try {
            String result = calculationService.getResult(expr);
        } catch (DoubleOverflow ignored) {

        }
    }
}
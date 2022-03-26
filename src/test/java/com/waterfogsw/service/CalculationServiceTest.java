package com.waterfogsw.service;

import com.waterfogsw.AppConfig;
import com.waterfogsw.service.CalculationService;
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
        String expr = "2 - 2 - 2";

        // when
        String result = calculationService.getResult(expr);

        // then
        Assertions.assertThat(result).isEqualTo("-2");
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
        String result = calculationService.getResult(expr);

        // then
    }

    @Test
    public void 계산서비스_테스트_괄호() throws Exception {
        // given
        String expr = "2 / ( 4 + 3 )";

        // when
        String result = calculationService.getResult(expr);

        // then
        Assertions.assertThat(result).isEqualTo("0");
    }

}
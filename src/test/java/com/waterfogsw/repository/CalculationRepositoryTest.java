package com.waterfogsw.repository;

import com.waterfogsw.AppConfig;
import com.waterfogsw.domain.Calculation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CalculationRepositoryTest {

    private CalculationRepository repository;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        this.repository = appConfig.calculationRepository();
    }

    @Test
    void 저장소_저장_테스트() {
        // given
        String expression = "2 + 2 + 2";
        String result = "6";

        // when
        repository.save(expression, result);
        Calculation findCal = repository.findById(0L);

        //then
        Assertions.assertThat(findCal.getFormula()).isEqualTo(expression);
    }

    @Test
    void 저장소_전체조회_테스트() {
        // given
        String expression1 = "2 + 2 + 2";
        String result1 = "6";

        String expression2 = "( 2 + 2 ) * 4";
        String result2 = "16";

        String expression3 = " ( 2 + 2 ) / 4";
        String result3 = "1";


        // when
        repository.save(expression1, result1);
        repository.save(expression2, result2);
        repository.save(expression3, result3);

        //then
        List<Calculation> findCals = repository.findAll();
        Assertions.assertThat(findCals.size()).isEqualTo(3);
    }
}
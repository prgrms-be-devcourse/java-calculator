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
        Calculation cal = new Calculation(0L, "2 + 2 + 2", "6");

        // when
        repository.save(cal);
        Calculation findCal = repository.findById(0L);

        //then
        Assertions.assertThat(findCal).isEqualTo(cal);
    }

    @Test
    void 저장소_전체조회_테스트() {
        // given
        Calculation cal1 = new Calculation(0L, "2 + 2 + 2", "6");
        Calculation cal2 = new Calculation(1L, "( 2 + 2 ) * 4", "16");
        Calculation cal3 = new Calculation(2L, "( 2 + 2 ) / 4", "1");

        // when
        repository.save(cal1);
        repository.save(cal2);
        repository.save(cal3);

        //then
        List<Calculation> findCals = repository.findAll();
        Assertions.assertThat(findCals.size()).isEqualTo(3);
    }
}
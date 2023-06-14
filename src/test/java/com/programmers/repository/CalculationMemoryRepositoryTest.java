package com.programmers.repository;

import com.programmers.domain.model.Calculation;
import com.programmers.util.CalculatiorTestUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.programmers.util.CalculatiorTestUtil.createCalculation;
import static org.assertj.core.api.Assertions.assertThat;

class CalculationMemoryRepositoryTest {
    CalculationRepository calculationRepository = new CalculationMemoryRepository();

    @Test
    void save() {
        //given
        Calculation calculation = createCalculation("1 + 2 + 3", 6);

        //when
        calculationRepository.save(calculation);

        //then
        List<Calculation> result = calculationRepository.findAll();

        assertThat(result).containsExactly(calculation);
    }

    @Test
    void findAll() {
        //given
        Calculation calculationA = createCalculation("1 + 2 + 3", 6);
        Calculation calculationB = createCalculation("1 + 3 + 5", 9);

        //when
        calculationRepository.save(calculationA);
        calculationRepository.save(calculationB);

        //then
        List<Calculation> result = calculationRepository.findAll();

        assertThat(result).containsExactly(calculationA, calculationB);
    }
}
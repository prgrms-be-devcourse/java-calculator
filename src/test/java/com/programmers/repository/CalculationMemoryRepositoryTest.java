package com.programmers.repository;

import com.programmers.domain.Calculator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.programmers.util.CalculatorTestUtil.createCalculation;
import static org.assertj.core.api.Assertions.assertThat;

class CalculationMemoryRepositoryTest {
    CalculatorMemoryRepository calculatorRepository = new CalculatorMemoryRepository();

    @Test
    void save() {
        //given
        Calculator calculation = createCalculation("1 + 2 + 3");

        //when
        calculatorRepository.save(calculation);

        //then
        List<Calculator> result = calculatorRepository.findAll();

        assertThat(result).containsExactly(calculation);
    }

    @Test
    void findAll() {
        //given
        Calculator calculationA = createCalculation("1 + 2 + 3");
        Calculator calculationB = createCalculation("1 + 3 + 5");

        //when
        calculatorRepository.save(calculationA);
        calculatorRepository.save(calculationB);

        //then
        List<Calculator> result = calculatorRepository.findAll();

        assertThat(result).containsExactly(calculationA, calculationB);
    }
}
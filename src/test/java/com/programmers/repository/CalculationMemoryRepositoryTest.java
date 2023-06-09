package com.programmers.repository;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculationMemoryRepositoryTest {
    CalculationRepository calculationRepository = new CalculationMemoryRepository();

    @Test
    void save() {
        //given
        String input = "1 + 2 + 3 = 6";

        //when
        calculationRepository.save(input);

        //then
        List<String> result = calculationRepository.findAll();

        assertThat(result).containsExactly(input);
    }

    @Test
    void findAll() {
        //given
        String inputA = "1 + 2 + 3 = 6";
        String inputB = "1 + 3 + 5 = 9";

        //when
        calculationRepository.save(inputA);
        calculationRepository.save(inputB);

        //then
        List<String> result = calculationRepository.findAll();

        assertThat(result).containsExactly(inputA, inputB);
    }
}
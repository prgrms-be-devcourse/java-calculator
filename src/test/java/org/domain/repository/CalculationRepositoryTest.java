package org.domain.repository;

import org.domain.model.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationRepositoryTest {

    private CalculationRepository calculationRepository;

    @BeforeEach
    void setUp() {
        calculationRepository = new CalculationRepository();
    }

    @Test
    void SUCCESS_계산기_저장소에_값_저장_및_조회() {

        //then
        final Calculator calculator1 = new Calculator(
                "1+2",
                "3"
        );
        final Calculator calculator2 = new Calculator(
                "21/3",
                "7"
        );
        calculationRepository.save(calculator1);
        calculationRepository.save(calculator2);

        //when
        List<Calculator> calculators = calculationRepository.findAll();

        //then
        assertEquals(calculators.size(), 2);
        assertEquals(calculators.get(0), calculator1);
        assertEquals(calculators.get(1), calculator2);
    }
}

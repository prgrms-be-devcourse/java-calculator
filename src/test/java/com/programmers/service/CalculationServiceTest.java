package com.programmers.service;

import com.programmers.io.Console;
import com.programmers.repository.CalculationMemoryRepository;
import com.programmers.repository.CalculationRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculationServiceTest {
    private final CalculationService calculatorService;
    private final CalculationRepository calculationRepository;

    public CalculationServiceTest() {
        calculationRepository = new CalculationMemoryRepository();
        Console console = new Console();

        calculatorService = new CalculationService(calculationRepository, console, console);
    }

    @Test
    void inputData() {
        //given
        String inputA = "1   +   2 +  3";
        String inputB = "5 * 2 + 3  +  4 - 5 * 6";
        String inputC = "5 * 2 * 3 - 4 / 2 * 4";
        String inputD = "3 * 3 3";

        //when
        int resultA = calculatorService.calculate(inputA);
        int resultB = calculatorService.calculate(inputB);
        int resultC = calculatorService.calculate(inputC);
        int resultD = calculatorService.calculate(inputD);

        //then
        assertThat(resultA).isEqualTo(6);
        assertThat(resultB).isEqualTo(5 * 2 + 3 + 4 - 5 * 6);
        assertThat(resultC).isEqualTo(5 * 2 * 3 - 4 / 2 * 4);
        assertThat(resultD).isEqualTo(3 * 33);
    }

    @Test
    void inputDataButInvalidOrder_Then_Exception() {
        //given
        String inputA = "1 + 2 - - 2";

        //when

        //then
        assertThatThrownBy(() -> calculatorService.calculate(inputA))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void inputData_Then_Save() {
        //given
        String inputA = "1 + 2 + 3";

        //when
        calculatorService.calculate(inputA);

        //then
        List<String> resultA = calculationRepository.findAll();

        assertThat(resultA).containsExactly("1 + 2 + 3 = 6");
    }

    @Test
    void findCalculations() {
        //given
        String calculationA = "1 + 2 + 3 = 6";
        String calculationB = "1 * 2 - 3 = -1";

        calculationRepository.save(calculationA);
        calculationRepository.save(calculationB);

        //when
        List<String> resultA = calculatorService.findCalculations();

        //then
        assertThat(resultA).containsExactly(calculationA, calculationB);

    }

}

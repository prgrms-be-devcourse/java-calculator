package org.programmers.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.programmers.repository.CalculatorRepository;
import org.programmers.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {
    CalculateService calculateService = new CalculateService();
    Repository repository = new CalculatorRepository();

    @Test
    void calculateSaveTest() {
        String input = "5 - 30";

        double result = calculateService.calculateSave(input);
        Assertions.assertThat(result).isEqualTo(-5);
    }

    @Test
    void find() {
        calculateService.calculateSave("3 * 2");
        calculateService.calculateSave("3 * 3");
        calculateService.calculateSave("2 * 2");
        calculateService.calculateSave("3 * 1");

        calculateService.find();
    }
}
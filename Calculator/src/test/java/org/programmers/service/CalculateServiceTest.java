package org.programmers.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.programmers.repository.CalculatorRepository;
import org.programmers.repository.Repository;

class CalculateServiceTest {
    CalculateService calculateService = new CalculateService();
    Repository repository = new CalculatorRepository();

    @Test
    void calculateSaveTest() {
        String input = "5555555 * 30";

        double result = calculateService.calculateSave(input);
        double result2 = 5555555 * 30;
        System.out.println(result);
        System.out.println(5555555 * 30);
        String a = "0000777";
        System.out.println(Integer.parseInt(a));
        Assertions.assertThat(result).isEqualTo(result2);
    }

    @Test
    void find() {
        calculateService.calculateSave("4 * 2");
        calculateService.calculateSave("3 * 3");
        calculateService.calculateSave("2 * 2");
        calculateService.calculateSave("3 * 1");

        calculateService.historyCheck();
    }
}
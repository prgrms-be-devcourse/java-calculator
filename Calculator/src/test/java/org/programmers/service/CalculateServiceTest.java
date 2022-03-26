package org.programmers.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.programmers.entity.ResultModel;
import org.programmers.repository.CalculatorRepository;
import org.programmers.repository.Repository;

import java.util.*;

class CalculateServiceTest {
    CalculateService calculateService = new CalculateService();
    CalculatorRepository repository = new CalculatorRepository();


    @Test
    void calculateSaveTest() {
        Map<Double, Double> map = new HashMap<>();

        map.put((double)(2 + 3 * 3 * 2), calculateService.calculateSave("2 + 3 * 3 * 2"));

        long result2 = map.entrySet()
                        .stream()
                                .filter(i -> i.getKey().equals(i.getValue()))
                                        .count();

        Assertions.assertThat(result2).isEqualTo(1);
    }

    @Test
    void find() {
        List<ResultModel> list = new ArrayList<>();

        calculateService.calculateSave("4 * 2");
        calculateService.calculateSave("3 * 3");
        calculateService.calculateSave("2 * 2");
        calculateService.calculateSave("3 * 1");

        list = calculateService.findHistory();

        Assertions.assertThat(list.size()).isEqualTo(4);

    }
}
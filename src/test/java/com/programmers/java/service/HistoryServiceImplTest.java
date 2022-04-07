package com.programmers.java.service;

import com.programmers.java.entity.Calculation;
import com.programmers.java.repository.MemoryRepository;
import com.programmers.java.repository.Repository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class HistoryServiceImplTest {

    Repository repository;
    HistoryService historyService;

    @BeforeEach
    void beforeEach() {
        repository = new MemoryRepository();
        historyService = new HistoryServiceImpl(repository);
    }

    @Test
    void 메모리_저장_로직_테스트() {
        //given
        String formula = "1 + 2 * 3";
        int result = 7;

        //when
        historyService.save(formula, result);

        //then
        Assertions.assertThat(repository.findAll().get(0)).isNotEqualTo(null);
        Assertions.assertThat(repository.findAll().get(0).getFormula()).isEqualTo(formula);
        Assertions.assertThat(repository.findAll().get(0).getResult()).isEqualTo(result);
    }

    @Test
    void 계산이력_조회_로직_테스트() {
        //given
        String formula1 = "1 + 2 * 3";
        int result1 = 7;
        String formula2 = "1 + 2 * 3";
        int result2 = 7;

        historyService.save(formula1, result1);
        historyService.save(formula2, result2);

        //when
        List<Calculation> resultList = historyService.findHistory();

        //then
        Assertions.assertThat(false).isEqualTo(resultList.isEmpty());
        Assertions.assertThat(resultList.get(0)).isNotEqualTo(null);

        Assertions.assertThat(resultList.get(0).getFormula()).isEqualTo(formula1);
        Assertions.assertThat(resultList.get(0).getResult()).isEqualTo(result1);
        Assertions.assertThat(resultList.get(0).getFormula()).isEqualTo(formula2);
        Assertions.assertThat(resultList.get(0).getResult()).isEqualTo(result2);
    }
}
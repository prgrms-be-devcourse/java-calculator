package com.programmers.java.repository;

import com.programmers.java.entity.Calculation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryRepositoryTest {

    Repository repository;

    @BeforeEach
    void beforeEach() {
        repository = new MemoryRepository();
    }

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void 메모리_저장_테스트() {
        //given
        Calculation calculation = new Calculation("1 + 2 * 3", 7);

        //when
        repository.save(calculation);

        //then
        Assertions.assertThat(repository.findAll().get(0)).isEqualTo(calculation);

    }

    @Test
    void 계산이력_조회_테스트() {
        //given
        Calculation calculation1 = new Calculation("1 + 2 * 3", 7);
        Calculation calculation2 = new Calculation("4 - 7 * 1", -3);
        List<Calculation> expectedStore = Arrays.asList(calculation1, calculation2);
        repository.save(calculation1);
        repository.save(calculation2);

        //when
        List<Calculation> resultRepositoryStore = repository.findAll();

        //then
        Assertions.assertThat(resultRepositoryStore).isEqualTo(expectedStore);
    }
}
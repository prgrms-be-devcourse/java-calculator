package com.caculator.repository;

import com.caculator.dto.Result;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryCalculatorRepositoryTest {
    CalculatorRepository repository = new MemoryCalculatorRepository();

    @Test
    void test() {
        //given
        Result result1 = new Result("1 + 2 + 3", 6);
        Result result2 = new Result("1 * 2 * 3", 6);
        Result result3 = new Result("1 - 2 - 3", -6);

        //when
        repository.save(result1);
        repository.save(result2);
        repository.save(result3);

        //then
        List<Result> resultList = repository.findAll();

        assertThat(resultList).contains(result1, result2, result3);
        assertThat(resultList.size()).isEqualTo(3);
    }
}
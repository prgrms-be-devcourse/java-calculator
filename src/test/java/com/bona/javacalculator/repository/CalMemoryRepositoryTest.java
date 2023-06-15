package com.bona.javacalculator.repository;

import com.bona.javacalculator.model.ExpressionResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalMemoryRepositoryTest {
    MemoryRepository memoryRepository = new CalMemoryRepository();

    @DisplayName("저장 테스트")
    @Test
    void save() {
        //given
        ExpressionResult expressionResult = new ExpressionResult("1+2",3.0);

        //when
        ExpressionResult savedExpressionResult = memoryRepository.save(expressionResult);

        //then
        ExpressionResult findExpressionResult = memoryRepository.findById(expressionResult.getId());
        assertThat(findExpressionResult).isEqualTo(savedExpressionResult);
    }

}
package com.programmers.kwonjoosung.java.calculator.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepositoryTest {
    static Repository repository;

    @Test
    @DisplayName("데이터베이스 동작 테스트")
        // 데이터 저장 후 내역 받아오기
    void repositoryTest() {
        //given
        repository = new MemoryCalculationRepository();
        String expression = "12 + 12";
        String result = "24";
        String answer = "12 + 12 = 24";
        //when
        repository.save(expression, result);
        //then
        assertEquals(answer, repository.findAll().get(0));
    }
}

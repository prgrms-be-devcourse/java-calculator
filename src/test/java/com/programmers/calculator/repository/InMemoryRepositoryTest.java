package com.programmers.calculator.repository;

import com.programmers.calculator.controller.io.Response;
import com.programmers.calculator.core.Expression;
import com.programmers.calculator.domain.CalculateHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("InMemoryRepository 테스트")
class InMemoryRepositoryTest {

    private InMemoryRepository inMemoryRepository;

    @BeforeEach
    void setUp() {
        inMemoryRepository = new InMemoryRepository();
    }

    @DisplayName("저장 테스트 - 정상 저장되면 id값이 null이 아니다")
    @Test
    void saveTestIdNotNull() {
        //given
        String expression = "1 + 1";
        Number result = 2;
        CalculateHistory calculateHistory = new CalculateHistory(IdGenerator.getInstance().generateId(), expression, result);
        //when
        CalculateHistory savedCalculateHistory = inMemoryRepository.save(calculateHistory);

        //then
        List<CalculateHistory> calculateHistories = inMemoryRepository.findAll();
        assertNotNull(calculateHistories);
        assertNotEquals(0, calculateHistories.size());
        assertNotNull(savedCalculateHistory.getId());
        assertNotNull(savedCalculateHistory.getResult());
        assertNotNull(savedCalculateHistory.getHistory());
        assertEquals(result, savedCalculateHistory.getResult());
    }

    @DisplayName("저장 테스트 - 정상 저장되면 history값이 null이 아니다")
    @Test
    void saveTestHistoryNotNull() {
        //given
        String expression = "1 + 1";
        Number result = 2;
        CalculateHistory calculateHistory = new CalculateHistory(IdGenerator.getInstance().generateId(), expression, result);

        //when
        CalculateHistory savedCalculateHistory = inMemoryRepository.save(calculateHistory);

        //then
        List<CalculateHistory> calculateHistories = inMemoryRepository.findAll();
        assertNotNull(calculateHistories);
        assertNotEquals(0, calculateHistories.size());
        assertNotNull(savedCalculateHistory.getHistory());
        assertEquals(result, savedCalculateHistory.getResult());
    }

    @DisplayName("저장 테스트 - 정상 저장되면 result값이 null이 아니다")
    @Test
    void saveTestResultNotNull() {
        //given
        String expression = "1 + 1";
        Number result = 2;
        CalculateHistory calculateHistory = new CalculateHistory(IdGenerator.getInstance().generateId(), expression, result);

        //when
        CalculateHistory savedCalculateHistory = inMemoryRepository.save(calculateHistory);

        //then
        List<CalculateHistory> calculateHistories = inMemoryRepository.findAll();
        assertNotNull(calculateHistories);
        assertNotEquals(0, calculateHistories.size());
        assertNotNull(savedCalculateHistory.getHistory());
        assertEquals(result, savedCalculateHistory.getResult());
    }


    @DisplayName("조회 테스트 - 저장된 모든 객체가 조회된다.")
    @Test
    void findAllTestSuccess() {
        //given
        String expressionStr1 = "1 + 1 + 1";
        Number result1 = 3;

        String expressionStr2 = "2 * 2 * 2";
        Number result2 = 8;

        String expressionStr3 = "3 * 3 / 3";
        Number result3 = 3;

        inMemoryRepository.save(new CalculateHistory(IdGenerator.getInstance().generateId(), expressionStr1, result1));
        inMemoryRepository.save(new CalculateHistory(IdGenerator.getInstance().generateId(), expressionStr2, result2));
        inMemoryRepository.save(new CalculateHistory(IdGenerator.getInstance().generateId(), expressionStr3, result3));

        //when
        List<CalculateHistory> calculateHistories = inMemoryRepository.findAll();

        //then
        assertNotNull(calculateHistories);
        assertEquals(3, calculateHistories.size());
    }

    @DisplayName("조회 테스트 - 저장된 객체가 없다면 빈 리스트가 반환된다.")
    @Test
    void findAllTestReturnEmptyList() {
        //given & when
        List<CalculateHistory> calculateHistories = inMemoryRepository.findAll();

        //then
        assertNotNull(calculateHistories);
        assertEquals(0, calculateHistories.size());
    }


}
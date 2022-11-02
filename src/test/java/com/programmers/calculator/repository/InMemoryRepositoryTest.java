package com.programmers.calculator.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.programmers.calculator.domain.CalculateHistory;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("InMemoryRepository 테스트")
class InMemoryRepositoryTest {

    private final InMemoryRepository inMemoryRepository = new InMemoryRepository();

    @AfterEach
    void clean() {
        inMemoryRepository.deleteAll();
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

    @DisplayName("삭제 테스트 - deleteAll() 메서드를 호출하면 조회했을 때 빈 리스트가 반횐된다.")
    @Test
    void deleteTestReturnEmptyList() {
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
        inMemoryRepository.deleteAll();

        //then
        List<CalculateHistory> calculateHistories = inMemoryRepository.findAll();

        assertTrue(calculateHistories.isEmpty());
    }

}
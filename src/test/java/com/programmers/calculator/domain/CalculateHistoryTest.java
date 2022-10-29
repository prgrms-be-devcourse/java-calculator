package com.programmers.calculator.domain;

import com.programmers.calculator.repository.IdGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CalculateHistory 엔티티 테스트")
class CalculateHistoryTest {

    @DisplayName("생성 테스트 - 문자열 식과 Number 결과값으로 history 필드가 '식 = 결과값' 으로 생성된다.  ")
    @Test
    void historyFieldTest() {
        //given
        String expressionStr = "1 + 1";
        Number result = 2;
        String history = expressionStr + " = " + result;

        //when
        CalculateHistory calculateHistory = new CalculateHistory(IdGenerator.getInstance()
            .generateId(), expressionStr, 2);

        //then
        assertEquals(history, calculateHistory.getHistory());
        assertNotNull(calculateHistory.getId());
    }

}
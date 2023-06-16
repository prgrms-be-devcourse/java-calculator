package org.programmers.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.expression.ExpressionResult;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionRepositoryTest {

    @Test
    @DisplayName("저장 테스트")
    void saveTest() {
        ExpressionResult result = new ExpressionResult("1+1", 2.0);
        Repository repository = new ExpressionRepository();

        repository.save(result);

        assertEquals(repository.getAll().get(0L).getAnswer(), 2.0);
    }

}
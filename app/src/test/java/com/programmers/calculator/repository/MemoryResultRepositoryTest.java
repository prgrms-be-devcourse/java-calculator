package com.programmers.calculator.repository;

import com.programmers.calculator.domain.OperationResult;
import jdk.dynalink.Operation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemoryResultRepositoryTest {

    ResultRepository repository;

    @BeforeEach
    void beforeEach() {
        repository = new MemoryResultRepository();
    }

    @Test
    @DisplayName("연산결과를 저장한다.")
    void save() {
        // given
        OperationResult operationResult = new OperationResult();
        operationResult.setFormula("1 + 1");
        operationResult.setResult("2");

        // when
        repository.save(operationResult);

        // then
        assertEquals(repository.findById(operationResult.getId()).get(), operationResult);
    }

    @Test
    @DisplayName("id를 이용하여 결과를 조회한다.")
    void findById() {
        // given
        OperationResult operationResultA = new OperationResult();
        operationResultA.setFormula("2 + 4");
        operationResultA.setResult("6");
        OperationResult operationResultB = new OperationResult();
        operationResultB.setFormula("5 + 4");
        operationResultB.setResult("9");

        // when
        repository.save(operationResultA);
        repository.save(operationResultB);

        // then
        assertEquals(repository.findById(operationResultA.getId()).get(), operationResultA);
    }

    @Test
    @DisplayName("잘못된 id를 이용해 결과 조회시 Optional.empty() 반환한다.")
    void findByWrongId() {
        // given
        OperationResult operationResultA = new OperationResult();
        operationResultA.setFormula("2 + 4");
        operationResultA.setResult("6");

        // when
        repository.save(operationResultA); // 내부에서 id 0으로 세팅됨.

        // then
        assertEquals(Optional.empty(), repository.findById(1000));
    }

    @Test
    @DisplayName("저장소가 비어있는지를 확인한다.")
    void isEmpty() {
        assertEquals(true, repository.isEmpty());
    }
}
package com.bona.javacalculator.repository;

import com.bona.javacalculator.model.InputAndAnswer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalMemoryRepositoryTest {
    MemoryRepository memoryRepository = new CalMemoryRepository();

    @AfterEach
    void afterEach() {
        memoryRepository.clearStore();
    }

    @DisplayName("저장 테스트")
    @Test
    void save() {
        //given
        InputAndAnswer inputAndAnswer = new InputAndAnswer("1+2",3.0);

        //when
        InputAndAnswer savedInputAndAnswer = memoryRepository.save(inputAndAnswer);

        //then
        InputAndAnswer findInputAndAnswer = memoryRepository.findById(inputAndAnswer.getId());
        assertThat(findInputAndAnswer).isEqualTo(savedInputAndAnswer);
    }

}
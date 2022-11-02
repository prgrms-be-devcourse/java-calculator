package org.programmers.java.calculator.memory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemoryTest {

    Memory memory = new Memory();

    @Test
    @DisplayName("전체 값의 출력이 제대로 이루어지는 검증하라")
    void findAll() {
        //given
        String input = "1 + 1";
        String answer = "2.0";

        memory.save(input, answer);
        memory.save(input, answer);
        memory.save(input, answer);

        //when
        List<String> findAll = memory.findAll();


        //then
        for (int i = 0; i < findAll.size(); i++) {
            assertEquals(i + ". 1 + 1 = 2", findAll.get(i));
        }
    }

    @Test
    @DisplayName("입력 값이 정상적으로 저장되는지 검증하라")
    void save() {
        //given
        String input = "1 + 1";
        String answer = "2.0";

        //when
        Long id = memory.save(input, answer);

        //then
        assertEquals(0L, id);
    }

    @Test
    @DisplayName("이미 저장되어있는 값이있다면 잘 찾아지는지 검증하라")
    void find() {
        //given
        String input = "1 + 1";
        String answer = "2.0";

        memory.save(input, answer);
        //when
        Optional<String> find = memory.findCache(input);

        //then
        assertEquals("2.0", find.get());
    }
}
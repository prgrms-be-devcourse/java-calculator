package com.programmers.calculator.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdGeneratorTest {

    @DisplayName("싱글톤 테스트 - getInstance를 호출하면 같은 인스턴스가 반환된다")
    @Test
    void singleTonGetInstanceTest() {
        //given & when
        IdGenerator idGenerator1 = IdGenerator.getInstance();
        IdGenerator idGenerator2 = IdGenerator.getInstance();

        //then
        assertEquals(idGenerator1, idGenerator2);
    }

    @DisplayName("아이디 생성 테스트 - 다음 generatedId()를 호출하면 다은 id값은 1씩 증가한다.")
    @Test
    void idGenerateTestStart0() {
        //given
        IdGenerator idGenerator = IdGenerator.getInstance();

        //when
        Long id = idGenerator.generateId();
        Long nextId = idGenerator.generateId();

        //then
        assertEquals(id + 1, nextId);
    }

}
package org.domain.repository;

import org.domain.repository.IdGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdGeneratorTest {

    @Test
    void SUCCESS_싱글톤_객체_1씩_증가() {

        //then
        IdGenerator id = IdGenerator.getInstance();

        //when
        final long id1 = id.generateId();
        final long id2 = id.generateId();

        //then
        assertEquals(id1, 0);
        assertEquals(id2, 1);
    }
}

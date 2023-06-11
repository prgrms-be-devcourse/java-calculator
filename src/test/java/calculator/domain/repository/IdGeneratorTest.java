package calculator.domain.repository;

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
        final long id3 = id.generateId();
        final long id4 = id.generateId();
        final long id5 = id.generateId();

        //then
        assertEquals(id1, 1);
        assertEquals(id2, 2);
        assertEquals(id3, 3);
        assertEquals(id4, 4);
        assertEquals(id5, 5);
    }
}

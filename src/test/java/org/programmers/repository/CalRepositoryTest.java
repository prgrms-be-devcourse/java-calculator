package org.programmers.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CalRepositoryTest {

    CalRepository calRepository = new CalRepositoryImpl();



    @Test
    public void testSaveAndGetQueryList() {

        //given
        String formula1 = "2 + 2";
        String result1 = "4";

        String formula2 = "3 * 5";
        String result2 = "15";

        String formula3 = "10 - 7";
        String result3 = "3";

        //when
        calRepository.save(formula1, result1);
        calRepository.save(formula2, result2);
        calRepository.save(formula3, result3);

        Map<Long, String> queryList = calRepository.getQueryList();

        //then
        Assertions.assertEquals(3, queryList.size());

        Assertions.assertEquals(formula1 + " = " + result1, queryList.get(0L));
        Assertions.assertEquals(formula2 + " = " + result2, queryList.get(1L));
        Assertions.assertEquals(formula3 + " = " + result3, queryList.get(2L));
    }
}


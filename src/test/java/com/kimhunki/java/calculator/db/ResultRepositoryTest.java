package com.kimhunki.java.calculator.db;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ResultRepositoryTest
{

    @Test
    @DisplayName("리포지토리 값 더하기")
    void getResultList()
    {
        //given
        ResultRepository resultRepository1 = new ResultRepository(new ArrayList<>());
        ResultRepository resultRepository2 = new ResultRepository(new ArrayList<>());
        //when

        resultRepository1.getResultList().add("1 + 3 / 2 * 2 = 3");
        resultRepository1.getResultList().add("1 + 3 = 4");
        ArrayList arrayList = new ArrayList<>();
        arrayList.add("1 + 3 / 2 * 2 = 3");
        arrayList.add("1 + 3 = 4");
        //then
        assertEquals(arrayList,resultRepository1.getResultList());
    }


}
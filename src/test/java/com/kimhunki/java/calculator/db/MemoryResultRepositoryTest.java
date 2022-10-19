package com.kimhunki.java.calculator.db;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemoryResultRepositoryTest {

    @Test
    @DisplayName("리포지토리 값 더하기")
    void getResultList( ) {
        //given
        ResultRepository resultRepository1 = new MemoryResultRepository(new ArrayList<>());
        ResultRepository resultRepository2 = new MemoryResultRepository(new ArrayList<>());
        //when

        resultRepository1.getRepository().add("1 + 3 = 4");
        resultRepository1.getRepository().add("1 + 3 / 2 * 2 = 3");
        ArrayList arrayList = new ArrayList<>();
        arrayList.add("1 + 3 = 4");
        arrayList.add("1 + 3 / 2 * 2 = 3");

        //then
        assertEquals(arrayList, resultRepository1.getRepository());
    }


}
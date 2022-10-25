package com.programmers.engine.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryRepositoryTest {
    Repository myRepository = new MemoryRepository();

    @Test void 파일출력테스트(){
        myRepository.addData("10 + 2 = 12");
        myRepository.addData("12 / 3 = 4");
        myRepository.addData("4 - 2 = 2");

        assertEquals("10 + 2 = 12\n" +
                "12 / 3 = 4\n" +
                "4 - 2 = 2\n",myRepository.printData());
    }

}
package com.programmers.java.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RepositoryImplTest {

    Repository repository = new RepositoryImpl();

    @Test
    void findAllHistory() {
        String formula1 = "1+2+3";
        String formula2 = "4+5+6";
        int result1 = 6;
        int result2 = 15;

        repository.save(formula1, result1);
        repository.save(formula2, result2);
        List<String> history = repository.findAllHistory();


        Assertions.assertEquals(history.size(),2);
        Assertions.assertEquals(history.get(0),"1+2+3=6");
    }


}
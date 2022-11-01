package com.programmers.engine.stack;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static com.programmers.engine.stack.Bracket.*;

class BracketTest {
    List<String> testFormula;
    void generateFormula(){
        testFormula = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            testFormula.add(i % 2 == 0 ? "(" : ")");
    }

    @DisplayName("find test")
    @Test
    void find() {
        AtomicInteger openCnt = new AtomicInteger();
        AtomicInteger closeCnt = new AtomicInteger();

        generateFormula();

        testFormula.forEach((bracket) -> {
            if(Bracket.find(bracket).equals(Optional.of(OPEN)))
                openCnt.getAndIncrement();
            else if(Bracket.find(bracket).equals(Optional.of(CLOSE)))
                closeCnt.getAndIncrement();
        });

        assertEquals(openCnt.get(), 5);
        assertEquals(closeCnt.get(), 5);
    }
}
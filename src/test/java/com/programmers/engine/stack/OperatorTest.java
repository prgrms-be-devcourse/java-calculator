package com.programmers.engine.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static com.programmers.engine.stack.Operator.*;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {
    List<String> testFormula;
    void generateFormula(){
        testFormula = new ArrayList<>();
        String formula = "5 + 6 - 10 / 10";

        testFormula.addAll(Arrays.asList(formula.split(" ")));
    }


    @DisplayName("find test")
    @Test
    void testFind(){
        AtomicInteger plusCnt = new AtomicInteger();
        AtomicInteger minusCnt = new AtomicInteger();
        AtomicInteger divideCnt = new AtomicInteger();

        generateFormula();

        testFormula.forEach((element) -> {
            if (Operator.find(element).equals(Optional.of(PLUS)))
                plusCnt.getAndIncrement();
            else if (Operator.find(element).equals(Optional.of(DIV)))
                minusCnt.getAndIncrement();
            else if (Operator.find(element).equals(Optional.of(MINUS)))
                divideCnt.getAndIncrement();
        });

        testFormula.forEach(System.out::println);

        assertEquals(plusCnt.get(), 1);
        assertEquals(minusCnt.get(), 1);
        assertEquals(divideCnt.get(), 1);
    }
}
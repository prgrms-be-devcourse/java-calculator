package com.programmers.engine.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

public class StackAndDequeTest {
    Deque<BigDecimal> dq1 = new ArrayDeque<>();
    Deque<BigDecimal> dq2 = new ArrayDeque<>();

    @BeforeEach
    public void addToDq(){
//        dq1.addLast(BigDecimal.valueOf(1));
//        dq1.addLast(BigDecimal.valueOf(2));
//        dq1.addLast(BigDecimal.valueOf(3));
//
//        dq2.addLast(BigDecimal.valueOf(9));
//        dq2.addLast(BigDecimal.valueOf(8));
//        dq2.addLast(BigDecimal.valueOf(7));
        dq1.addFirst(BigDecimal.valueOf(1));
        dq1.addFirst(BigDecimal.valueOf(2));
        dq1.addFirst(BigDecimal.valueOf(3));

        dq2.addFirst(BigDecimal.valueOf(9));
        dq2.addFirst(BigDecimal.valueOf(8));
        dq2.addFirst(BigDecimal.valueOf(7));
    }

    public void printDqs(){
        System.out.println("Dq1 : " + Arrays.toString(dq1.toArray()));
        System.out.println("Dq2 : " + Arrays.toString(dq2.toArray()));
    }
    public void popDqs(Deque<BigDecimal> dq1, Deque<BigDecimal> dq2){
        if(!dq1.isEmpty())
            dq1.pop();
        if(!dq2.isEmpty())
            dq2.pop();
    }

    @Test
    public void dqPopTest(){
        printDqs();
        popDqs(dq1, dq2);
        printDqs();
        assertThat(dq1.size()).isEqualTo(2);
        assertThat(dq2.size()).isEqualTo(2);
        assertThat(dq1.pollFirst()).isEqualTo(BigDecimal.valueOf(2));
        assertThat(dq2.pollFirst()).isEqualTo(BigDecimal.valueOf(8));
    }
}

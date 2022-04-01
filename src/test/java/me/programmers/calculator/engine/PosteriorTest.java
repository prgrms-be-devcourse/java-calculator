package me.programmers.calculator.engine;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PosteriorTest {

    @Test
    void convertToPosteriorTest() {
        assertEquals(Posterior.convertToPosterior("11+222"), Arrays.asList("11", "222", "+"));
        assertEquals(Posterior.convertToPosterior("1+2*3"), Arrays.asList("1", "2", "3", "*", "+"));
        assertEquals(Posterior.convertToPosterior("3-6/3"), Arrays.asList("3", "6", "3", "/", "-" ));
        assertEquals(Posterior.convertToPosterior("1+2*3/4"), Arrays.asList("1", "2", "3", "*", "4", "/", "+" ));
    }

}
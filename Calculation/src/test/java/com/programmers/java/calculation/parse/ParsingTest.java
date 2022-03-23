package com.programmers.java.calculation.parse;

import org.junit.jupiter.api.Test;

import java.util.List;

class ParsingTest {

    ParsingImpl parsing = new ParsingImpl();

    @Test
    public void makeArray() throws Exception {

        String input = "1+2+3*4/5-69";

        List<String> list = parsing.makeArray(input);

        System.out.println("list = " + list);

    }

}
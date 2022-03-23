package com.programmers.java.calculation.parse;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParsingTest {

    Parsing parsing = new Parsing();

    @Test
    public void makeArray() throws Exception {

        String input = "1+2+3*4/5-69";

        List<String> list = parsing.makeArray(input);

        System.out.println("list = " + list);

    }

}
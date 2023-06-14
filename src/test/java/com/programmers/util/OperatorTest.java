package com.programmers.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {
              "1"
            , "3"
            , "*"
            , "+"
            , "-"
    })
    void 연산자포함(String cur) {
        System.out.println(Operator.contains(cur));
    }
}
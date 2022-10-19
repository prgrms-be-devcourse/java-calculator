package com.programmers.java.enums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @Test
    void 덧셈_사칙연산_성공_테스트() {
        //given, when
        int result = Operator.calculate("+", 1, 2);

        //then
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void 뺄셈_사칙연산_성공_테스트() {
        //given, when
        int result = Operator.calculate("-", 2, 4);

        //then
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    void 곱셈_사칙연산_성공_테스트() {
        //given, when
        int result = Operator.calculate("*", 1, 2);

        //then
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    void 나눗셈_사칙연산_성공_테스트() {
        //given, when
        int result = Operator.calculate("/", 2, 4);

        //then
        Assertions.assertThat(result).isEqualTo(2);
    }

}
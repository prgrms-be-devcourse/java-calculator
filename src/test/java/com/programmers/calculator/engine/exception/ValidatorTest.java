package com.programmers.calculator.engine.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    // 연산자 중복
    @Test
    void check1() {
        boolean expected = false;
        boolean actual = Validator.exceptionCheck("1 + + 2".split(" "));

        assertEquals(expected, actual);
    }

    // 괄호 안맞음 1
    @Test
    void check2() {
        boolean expected = false;
        boolean actual = Validator.exceptionCheck("( ( 1 + 2 )".split(" "));

        assertEquals(expected, actual);
    }

    // 괄호 안맞음 2
    @Test
    void check3() {
        boolean expected = false;
        boolean actual = Validator.exceptionCheck("( 1 + 2 ) )".split(" "));

        assertEquals(expected, actual);
    }

    // 규격 외 문자
    @Test
    void check4() {
        boolean expected = false;
        boolean actual = Validator.exceptionCheck("1 + 2 + Q".split(" "));

        assertEquals(expected, actual);
    }

    // 정수 중복
    @Test
    void check5() {
        boolean expected = false;
        boolean actual = Validator.exceptionCheck("1 1 + 2".split(" "));

        assertEquals(expected, actual);
    }

    // 음수 인식하는지 테스트
    @Test
    void check6() {
        boolean expected = true;
        boolean actual = Validator.exceptionCheck("-1 + 2".split(" "));

        assertEquals(expected, actual);
    }

    // 잘못된 연산식
    @Test
    void check7() {
        boolean expected = false;
        boolean actual = Validator.exceptionCheck("( ) 1 + 2".split(" "));

        assertEquals(expected, actual);
    }

    // 연산식1
    @Test
    void check8() {
        boolean expected = true;
        boolean actual = Validator.exceptionCheck("( ( 1 - ( 2 * 3 ) ) + 4 ) - 10 / 2".split(" "));

        assertEquals(expected, actual);
    }

    // 연산식2
    @Test
    void check9() {
        boolean expected = true;
        boolean actual = Validator.exceptionCheck("1 * ( 2 + 3 )".split(" "));

        assertEquals(expected, actual);
    }
}
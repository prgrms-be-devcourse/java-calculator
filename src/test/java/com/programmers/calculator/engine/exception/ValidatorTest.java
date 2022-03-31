package com.programmers.calculator.engine.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    // 연산자 중복
    @Test
    void check1() {
        String[] numsNSymbols = {"1", "+", "+", "2"};
        assertEquals(false, Validator.check(numsNSymbols));
    }

    // 괄호 안맞음 1
    @Test
    void check2() {
        String[] numsNSymbols = {"(", "(", "1", "+", "2", ")"};
        assertEquals(false, Validator.check(numsNSymbols));
    }

    // 괄호 안맞음 2
    @Test
    void check3() {
        String[] numsNSymbols = {"(", "1", "+", "2", ")", ")"};
        assertEquals(false, Validator.check(numsNSymbols));
    }

    // 규격 외 문자
    @Test
    void check4() {
        String[] numsNSymbols = {"1", "+", "2", "Q"};
        assertEquals(false, Validator.check(numsNSymbols));
    }

    // 정수 중복
    @Test
    void check5() {
        String[] numsNSymbols = {"1", "1", "+", "2"};
        assertEquals(false, Validator.check(numsNSymbols));
    }

    // 음수 인식하는지 테스트
    @Test
    void check6() {
        String[] numsNSymbols = {"-1", "+", "2"};
        assertEquals(true, Validator.check(numsNSymbols));
    }

    // 잘못된 연산식
    @Test
    void check7() {
        String[] numsNSymbols = {"(", ")", "1", "+", "2"};
        assertEquals(false, Validator.check(numsNSymbols));
    }

    // 연산식1
    @Test
    void check8() {
        String[] numsNSymbols = "( ( 1 - ( 2 * 3 ) ) + 4 ) - 10 / 2".split(" ");
        assertEquals(true, Validator.check(numsNSymbols));
    }

    // 연산식2
    @Test
    void check9() {
        String[] numsNSymbols = "1 * ( 2 + 3 )".split(" ");
        assertEquals(true, Validator.check(numsNSymbols));
    }
}
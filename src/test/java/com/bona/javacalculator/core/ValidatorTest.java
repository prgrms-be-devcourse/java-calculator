package com.bona.javacalculator.core;

import com.bona.javacalculator.util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ValidatorTest {

    Validator validator = new Validator();

    @Test
    @DisplayName("0으로 나눌때 runtime exception 반환 테스트")
    public void divisionByZero() {
        //given
        String input = "1/0";
        //when
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            validator.validateFormula(input);
        });
        //then
        assertEquals("0으로 나눌 수 없습니다.", exception.getMessage());

    }

    @Test
    @DisplayName("공백이 있는 연산식 테스트")
    public void whiteSpaceInput() {
        //given
        String input = "";
        //when
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            validator.validateFormula(input);
        });
        //then
        assertEquals("입력 값이 비어있습니다.", exception.getMessage());

    }

    @Test
    @DisplayName("올바른 format이 아닌 연산식 테스트")
    public void invalidFormatInput() {
        //given
        String input = "1+3-";
        //when
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            validator.validateFormula(input);
        });
        //then
        assertEquals("입력식이 포맷에 맞지 않습니다.", exception.getMessage());

    }

    @Test
    @DisplayName("연산자 자리에 다른 문자가 있는 연산식 테스트")
    public void notOperatorInput() {
        //given
        String input = "1+3=1";
        //when
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            validator.validateFormula(input);
        });
        //then
        assertEquals("입력식이 포맷에 맞지 않습니다.", exception.getMessage());
    }

}
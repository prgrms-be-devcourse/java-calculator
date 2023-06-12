package com.bona.javacalculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;


class ValidateServiceTest {

    ValidateService validateService = new ValidateService();

    @Test
    @DisplayName("0으로 나눌때 Optional 반환 테스트")
    public void divisionByZero() {
        //given
        String input = "1/0";
        //when
        Optional<String> validateInput = validateService.validate(input);
        //then
        Assertions.assertTrue(validateInput.isEmpty());

    }

    @Test
    @DisplayName("공백이 있는 연산식 테스트")
    public void whiteSpaceInput() {
        //given
        String input = "1+     3";
        //when
        Optional<String> validateInput = validateService.validate(input);
        //then
        Assertions.assertTrue(validateInput.isEmpty());

    }

    @Test
    @DisplayName("문자가 있는 연산식 테스트")
    public void otherStringInput() {
        //given
        String input = "1+a+3";
        //when
        Optional<String> validateInput = validateService.validate(input);
        //then
        Assertions.assertTrue(validateInput.isEmpty());

    }

    @Test
    @DisplayName("올바른 format이 아닌 연산식 테스트")
    public void invalidFormatInput() {
        //given
        String input = "1+3-";
        //when
        Optional<String> validateInput = validateService.validate(input);
        //then
        Assertions.assertTrue(validateInput.isEmpty());

    }

    @Test
    @DisplayName("연산자 자리에 다른 문자가 있는 연산식 테스트")
    public void notOperatorInput() {
        //given
        String input = "1+3=1";
        //when
        Optional<String> validateInput = validateService.validate(input);
        //then
        Assertions.assertTrue(validateInput.isEmpty());

    }

}
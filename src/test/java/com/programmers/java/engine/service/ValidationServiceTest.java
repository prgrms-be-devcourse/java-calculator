package com.programmers.java.engine.service;

import com.programmers.java.engine.model.Formula;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class ValidationServiceTest {

    ValidationService validationService = new ValidationService();

    @Test
    public void 연속된_공백이_들어올경우_Optional_empty를_반환해야함(){
        //given
        String errorFormula = "5 +         1";
        //when
        Optional<Formula> testResult = validationService.Validation(errorFormula);
        //then
        Assertions.assertFalse(testResult.isPresent());
    }

    @Test
    public void 나누기연산에서_제수가_0인경우_Opitonal_empty를_반환해야함(){
        //given
        String errorFormula = "3 + 2 / 0";
        //when
        Optional<Formula> testResult = validationService.Validation(errorFormula);
        //then
        Assertions.assertTrue(testResult.isEmpty());
    }

    @Test
    public void 입력식에_숫자말고_문자가_들어올경우_Optional_empty_반환해야함(){
        //given
        String errorFormula = "3 + a / 0";
        //when
        Optional<Formula> testResult = validationService.Validation(errorFormula);
        //then
        Assertions.assertTrue(testResult.isEmpty());
    }

    @Test
    public void 입력식에_연산자말고_다른문자가_들어올경우_Opitonal_empty를_반환해야함(){
        //given
        String errorFormula = "3 + 2 = 1";
        //when
        Optional<Formula> testResult = validationService.Validation(errorFormula);
        //then
        Assertions.assertTrue(testResult.isEmpty());
    }

    @Test
    public void 입력식이_공백으로만_들어온경우_Opitonal_empty를_반환해야함(){
        //given
        String errorFormula = " ";
        //when
        Optional<Formula> testResult = validationService.Validation(errorFormula);
        //then
        Assertions.assertTrue(testResult.isEmpty());
    }

    @Test
    public void 입력식의_식의_포맷이_아닌경우1_Optional_empty를_반환해야함() {
        //given
        String errorFormula = "1 + 2 -3";
        //when
        Optional<Formula> testResult = validationService.Validation(errorFormula);
        //then
        Assertions.assertTrue(testResult.isEmpty());
    }

    @Test
    public void 입력식의_식의_포맷이_아닌경우2_Optional_empty를_반환해야함() {
        //given
        String errorFormula = "1 + 2 -";
        //when
        Optional<Formula> testResult = validationService.Validation(errorFormula);
        //then
        Assertions.assertTrue(testResult.isEmpty());
    }

    @Test
    public void 입력형식이_공백으로_나누어진게_아닌경우_Optional_empty를_반환해야함() {
        //given
        String errorFormula = "1+2+3";
        //when
        Optional<Formula> testResult = validationService.Validation(errorFormula);
        //then
        Assertions.assertTrue(testResult.isEmpty());
    }

}

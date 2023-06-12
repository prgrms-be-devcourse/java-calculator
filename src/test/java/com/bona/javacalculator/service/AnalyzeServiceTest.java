package com.bona.javacalculator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalyzeServiceTest {

    AnalyzeService analyzeService = new AnalyzeService();
    MakePostfixService makePostfixService = new MakePostfixService();

    @Test
    @DisplayName("결과값 반환 테스트")
    public void resultTest() {
        //given
        String input = "1+2*3";

        //when
        String postfix = makePostfixService.convPostfix(input);
        Double result = analyzeService.analyzeStr(postfix);

        //then
        Assertions.assertThat(result).isEqualTo(7);
    }

}
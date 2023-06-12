package com.bona.javacalculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakePostfixServiceTest {

    MakePostfixService makePostfixService = new MakePostfixService();

    @Test
    @DisplayName("후위표기식 출력 테스트")
    public void makePostfixTest() {
        //given
        String input = "1+2*3";
        String wantInput = "123*+";
        //when
        String postfixInput = makePostfixService.convPostfix(input);
        //then
        assertThat(postfixInput).isEqualTo(wantInput);
    }

}
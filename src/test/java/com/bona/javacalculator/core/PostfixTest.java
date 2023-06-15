package com.bona.javacalculator.core;

import static org.assertj.core.api.Assertions.assertThat;

import com.bona.javacalculator.core.converter.PostfixConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PostfixTest {

    PostfixConverter makePostfix = new PostfixConverter();

    @Test
    @DisplayName("후위표기식 출력 테스트")
    public void makePostfixTest() {
        //given
        String input = "1+2*3";
        String wantInput = "123*+";
        //when
        List<String> convert = makePostfix.convert(input);
        //then
        assertThat(convert).isEqualTo(wantInput);
    }

}
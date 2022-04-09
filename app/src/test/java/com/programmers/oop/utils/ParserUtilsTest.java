package com.programmers.oop.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserUtilsTest {

    private final static String expression = "(1 + 2) * 3";
    private final static String realAnswer = "12+3*";

    @Test
    @DisplayName("후위 표기식 변환")
    void toPostFix() {
        //given

        //when
        List<String> postFix = ParserUtils.toPostFix(expression);

        //then
        StringBuilder answer=new StringBuilder();
        postFix.stream().forEach(answer::append);
        Assertions.assertEquals(realAnswer,answer.toString());
    }
}
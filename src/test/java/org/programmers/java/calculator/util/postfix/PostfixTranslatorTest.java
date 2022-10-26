package org.programmers.java.calculator.util.postfix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PostfixTranslatorTest {

    PostfixTranslator postfixTranslator = new PostfixTranslator();

    @Test
    @DisplayName("정상 입력 값에 따라서 후위표기법을 검증하라")
    void infixToPostfix() {
        //given
        String input = "1 + 1";

        //then
        final String postfixExpression = postfixTranslator.infixToPostfix(input);

        //when
        assertEquals("11+", postfixExpression);
    }
}
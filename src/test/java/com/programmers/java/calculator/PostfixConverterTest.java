package com.programmers.java.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostfixConverterTest {

    private PostfixConverter postfixConverter;

    @BeforeEach
    public void setUp() {
        postfixConverter = new PostfixConverter();
    }

    @Test
    void postfixConvertPlus() {
        List<String> tokenList = Arrays.asList(new String[]{"3", "+", "5"});
        String postfixExpression = postfixConverter.postfixConvert(tokenList);
        Assertions.assertEquals("3 5 PLUS ", postfixExpression);
    }

    @Test
    void postfixConvertMultiple() {
        List<String> tokenList = Arrays.asList(new String[]{"3", "-", "5"});
        String postfixExpression = postfixConverter.postfixConvert(tokenList);
        Assertions.assertEquals("3 5 MINUS ", postfixExpression);
    }

    @Test
    void postfixConvertMix() {
        List<String> tokenList = Arrays.asList(new String[]{"3", "+", "5", "*", "4"});
        String postfixExpression = postfixConverter.postfixConvert(tokenList);
        Assertions.assertEquals("3 5 4 MULTIPLE PLUS ", postfixExpression);
    }

    @Test
    void postfixConvertException() {
        List<String> tokenList = Arrays.asList("3", "!", "5", "*", "4");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            postfixConverter.postfixConvert(tokenList);
        });
    }
}
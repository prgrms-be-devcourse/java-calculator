package com.programmers.devcourse.converter;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InFixToPostFixConverterTest {

    static InFixToPostFixConverter inFixToPostFixConverter;

    @BeforeAll
    static void setUp() {
        inFixToPostFixConverter = new InFixToPostFixConverter();
    }

    @AfterEach
    void clear() {
        inFixToPostFixConverter.clearConvertedList();
    }

    @Test
    @DisplayName("중위표기식 후위표기로 변환")
    void convert() {
        inFixToPostFixConverter.convert("(1-2)");
        assertTrue(inFixToPostFixConverter.getConvertedList().equals(Arrays.asList("1", "2", "-")));
    }
}
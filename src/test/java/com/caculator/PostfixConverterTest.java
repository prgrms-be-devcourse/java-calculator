package com.caculator;

import com.caculator.util.PostfixConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PostfixConverterTest {

    @Test
    void passTest() {
        //given
        String expression1 = "1 + 2 * 3 + 4 / 2";
        String expression2 = "3 * 5 + 10 / 2";
        String expression3 = "123 * 3 / 10";

        //when
        List<String> postfix1 = PostfixConverter.convert(expression1);
        List<String> postfix2 = PostfixConverter.convert(expression2);
        List<String> postfix3 = PostfixConverter.convert(expression3);

        //then
        assertThat(postfix1).containsExactly("1", "2", "3", "*", "+", "4", "2", "/", "+");
        assertThat(postfix2).containsExactly("3", "5", "*", "10", "2", "/", "+");
        assertThat(postfix3).containsExactly("123", "3", "*", "10", "/");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 * 3 + 4 ! 2", "1 a 2 * 3 + 4 ! 2", "a b c d e f g", " "})
    @DisplayName("잘못된 형식의 수식이 들어오면 IllegalArgumentException 발생")
    void failTest(String expression) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> PostfixConverter.convert(expression));
    }
}
package com.caculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PostfixConverterTest {

    @Test
    void passTest() {
        //given
        String exp1 = "1 + 2 * 3 + 4 / 2";
        String exp2 = "3 * 5 + 10 / 2";
        String exp3 = "123 * 3 / 10";

        //when
        List<String> postfix1 = PostfixConverter.convert(exp1);
        List<String> postfix2 = PostfixConverter.convert(exp2);
        List<String> postfix3 = PostfixConverter.convert(exp3);

        //then
        assertThat(postfix1).containsExactly("1", "2", "3", "*", "+", "4", "2", "/", "+");
        assertThat(postfix2).containsExactly("3", "5", "*", "10", "2", "/", "+");
        assertThat(postfix3).containsExactly("123", "3", "*", "10", "/");
    }

    @Test
    @DisplayName("잘못된 형식의 수식이 들어오면 IllegalArgumentException 발생")
    void failTest() {
        String exp1 = "1 + 2 * 3 + 4 ! 2";
        String exp2 = "1 a 2 * 3 + 4 ! 2";
        String exp3 =  "a b c d e f g";
        String exp4 = " ";

        Assertions.assertThrows(IllegalArgumentException.class, () -> PostfixConverter.convert(exp1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PostfixConverter.convert(exp2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PostfixConverter.convert(exp3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> PostfixConverter.convert(exp4));
    }

}
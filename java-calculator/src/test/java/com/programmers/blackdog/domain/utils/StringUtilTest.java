package com.programmers.blackdog.domain.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilTest {
    @DisplayName("입력값이 숫자가 아니면 예외를 발생한다.")
    @Test
    void when_InputIsNotNumber_Expects_ThrowsException() {
        String input = "a";
        
        assertThatThrownBy(() -> StringUtil.convertStringToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 숫자이면 예외를 발생하지 않는다.")
    @Test
    void when_InputIsNumber_Expects_DoesNotThrowsException() {
        String input = "111";

        assertThatNoException()
                .isThrownBy(() -> StringUtil.convertStringToInt(input));
    }
}
package com.programmers.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuTypeTest {

    @ParameterizedTest
    @DisplayName("적절한 메뉴 입력")
    @ValueSource(strings = {"1", "2", "3"})
    void rightInputMenuNumber(String inputMenuNumber) {
        assertThatCode(
                () -> MenuType.findMenuType(inputMenuNumber)
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("잘못된 메뉴 입력")
    @ValueSource(strings = {"a", "z", "4", "0", "!", ")"})
    void wrongInputMenuNumber(String inputMenuNumber) {
        assertThatThrownBy(() -> MenuType.findMenuType(inputMenuNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
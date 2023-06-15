package com.programmers.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

class MenuTypeTest {

    @ParameterizedTest
    @DisplayName("적절한 메뉴 입력")
    @ValueSource(strings = {"1", "2", "3"})
    void 적절한_메뉴_입력(String inputMenuNumber) {
        assertThatCode(
                () -> MenuType.findMenuType(inputMenuNumber)
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("잘못된 메뉴 입력")
    @ValueSource(strings = {"a", "z", "4", "0", "!", ")"})
    void 잘못된_메뉴_입력(String inputMenuNumber) {
        Assertions.assertThat(MenuType.findMenuType(inputMenuNumber)).isEqualTo(MenuType.NULL);
    }
}
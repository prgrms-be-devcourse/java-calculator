package com.programmers.calculator.domain;

import com.programmers.calculator.exception.InvalidMenuException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MenuTest {
    @ParameterizedTest
    @DisplayName("올바른 메뉴 번호인 경우 성공한다.")
    @ValueSource(strings = {"1", "2", "3"})
    void 올바른_메뉴_번호_입력(String menuNumber) {
        assertThatCode(() -> Menu.findByNumber(menuNumber))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("잘못된 메뉴 번호인 경우 예외가 발생한다.")
    @ValueSource(strings = {"4", "a", ""})
    void 잘못된_메뉴_번호_입력(String menuNumber) {
        assertThatThrownBy(() -> Menu.findByNumber(menuNumber))
                .isInstanceOf(InvalidMenuException.class);
    }
}

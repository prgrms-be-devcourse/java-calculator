package com.programmers.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class MenuTest {

    @Test
    void 입력에_맞는_메뉴를_찾는다() {
        //given
        String input = "2";

        //when
        Menu result = Menu.findMenu(input);

        //then
        Assertions.assertThat(result).isEqualTo(Menu.CALCULATE);
    }

    @EmptySource
    @ParameterizedTest
    void 메뉴_번호가_입력되지_않으면_예외처리한다(String input) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> Menu.findMenu(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ValueSource(strings = { "5", " ", "&", "B"})
    @ParameterizedTest
    void 입력된_메뉴_번호가_형식에_맞지_않으면_예외처리한다(String input) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> Menu.findMenu(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
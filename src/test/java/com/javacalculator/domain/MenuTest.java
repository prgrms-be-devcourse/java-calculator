package com.javacalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuTest {

    @Test
    void 등록된_메뉴번호가_아닌_번호가_입력되면_예외가_발생한다() {
        // given
        int menuNumber = 3;

        // when & then
        assertThatThrownBy(() -> Menu.from(menuNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("메뉴에 존재하지 않는 번호입니다. : " + menuNumber);
    }
}

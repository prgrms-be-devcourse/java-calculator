package com.programmers.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class SelectionValidatorTest {
    SelectionValidator selectionValidator = new SelectionValidator();

    @ValueSource(strings = { "5", " ", "&", "B"})
    @ParameterizedTest
    void 입력된_메뉴_번호가_조건을_만족하지_않으면_예외처리한다(String input) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> selectionValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @EmptySource
    @ParameterizedTest
    void 메뉴_번호가_입력되지_않으면_예외처리한다(String input) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> selectionValidator.isEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ValueSource(strings = { "7", "%", "&", "B"})
    @ParameterizedTest
    void 메뉴_번호_외의_숫자_또는_문자가_입력되면_예외처리한다(String input) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> selectionValidator.isNotMenuNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
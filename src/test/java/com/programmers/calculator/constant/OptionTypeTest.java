package com.programmers.calculator.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OptionTypeTest {

    @DisplayName("메뉴 번호를 파라미터로 넘겨주면, 올바른 Option 반환된다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2"})
    void right_option_menu(String inputOption) {

        // given
        OptionType optionType = OptionType.of(inputOption);

        // then
        assertThat(optionType.getInputOption()).isEqualTo(inputOption);

    }

    @DisplayName("잘못된 메뉴 번호를 파라미터로 넘겨주면, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "a", "+"})
    void wrong_option_menu(String notInputOption) {

        // then
        assertThatThrownBy(() -> OptionType.of(notInputOption))
                        .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("유효하지 않은 메뉴입니다.");

    }
}
package com.programmers.calculator.constant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OptionTypeTest {

    @DisplayName("메뉴 번호를 파라미터로 넘겨주면, 올바른 Option 반환된다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2"})
    void rightOptionMenu(String inputOption) {
        // given
        OptionType optionType = OptionType.of(inputOption);

        // then
        Assertions.assertThat(optionType.getInputOption()).isEqualTo(inputOption);
    }

    @DisplayName("잘못된 메뉴 번호를 파라미터로 넘겨주면, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "a", "+"})
    void wrongOptionMenu(String notInputOption) {
        // then
        Assertions.assertThatThrownBy(() -> OptionType.of(notInputOption))
                        .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("유효하지 않은 메뉴입니다.");
    }
}
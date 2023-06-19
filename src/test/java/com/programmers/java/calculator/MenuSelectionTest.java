package com.programmers.java.calculator;

import com.programmers.java.calculator.domain.MenuType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuSelectionTest {

    @ParameterizedTest
    @CsvSource({"1, 조회", "2, 계산", "3, 종료"})
    @DisplayName("메뉴 선택 성공 테스트")
    void correctMenuSelection(String inputMenuType, String expectedName) {
        MenuType selectedtMenuType = MenuType.of(inputMenuType);
        assertThat(selectedtMenuType.getName()).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4", "~", "A", " "})
    @DisplayName("메뉴 선택 예외 테스트")
    void wrongMenuSelection(String inputMenuType) {
        assertThatThrownBy(() -> MenuType.of(inputMenuType))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("메뉴를 찾을 수 없습니다.");
    }
}

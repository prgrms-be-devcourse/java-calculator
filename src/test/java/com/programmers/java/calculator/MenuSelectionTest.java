package com.programmers.java.calculator;

import com.programmers.java.calculator.model.MenuType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuSelectionTest {

    @Test
    @DisplayName("메뉴 선택 정상 케이스")
    void correctMenuSelection() {
        MenuType selecedtMenuType1 = MenuType.of("1");
        MenuType selecedtMenuType2 = MenuType.of("2");
        MenuType selecedtMenuType3 = MenuType.of("3");

        assertThat(selecedtMenuType1).isEqualTo(MenuType.HISTORY);
        assertThat(selecedtMenuType2).isEqualTo(MenuType.CALCULATE);
        assertThat(selecedtMenuType3).isEqualTo(MenuType.END);
    }

    @Test
    @DisplayName("메뉴 선택 예외 케이스")
    void wrongMenuSelection() {
        assertThatThrownBy(() -> MenuType.of("4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("메뉴를 찾을 수 없습니다.");
    }
}

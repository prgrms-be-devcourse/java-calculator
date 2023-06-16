package com.devcourse.java.domain.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTypeTest {

    @Nested
    @DisplayName("Menus 테스트")
    class createMenuTypeTest {
        @ParameterizedTest
        @DisplayName("조회, 계산 생성 테스트")
        @ValueSource(strings = {"1", "2"})
        void menuCreateTest(String type) {
            // given

            // when
            MenuType menuType = MenuType.from(type);

            // then
            assertThat(menuType.isNotOnMenu()).isFalse();
        }

        @Test
        @DisplayName("없는 메뉴 생성 테스트")
        void noneMenuCreateTest() {
            // given
            final String notOnMenu = "3";

            // when
            MenuType menuType = MenuType.from(notOnMenu);

            // then
            assertThat(menuType).isEqualTo(MenuType.NONE);
            assertThat(menuType.isNotOnMenu()).isTrue();
        }
    }
}

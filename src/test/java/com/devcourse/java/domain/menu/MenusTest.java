package com.devcourse.java.domain.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenusTest {

    @Nested
    @DisplayName("Menus 테스트")
    class createMenusTest {
        @ParameterizedTest
        @DisplayName("조회, 계산 생성 테스트")
        @ValueSource(strings = {"1", "2"})
        void menuCreateTest(String type) {
            // given

            // when
            Menus menus = Menus.from(type);

            // then
            assertThat(menus.isNotOnMenu()).isFalse();
        }

        @Test
        @DisplayName("없는 메뉴 생성 테스트")
        void noneMenuCreateTest() {
            // given
            final String notOnMenu = "3";

            // when
            Menus menus = Menus.from(notOnMenu);

            // then
            assertThat(menus).isEqualTo(Menus.NONE);
            assertThat(menus.isNotOnMenu()).isTrue();
        }
    }
}

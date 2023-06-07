package com.devcourse.java.domain.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {

    @Nested
    @DisplayName("Menus 테스트")
    class MenusTest {
        @ParameterizedTest
        @DisplayName("조회, 계산 생성 테스트")
        @ValueSource(ints = {1, 2})
        void menuCreateTest(int type) {
            // given

            // when
            Menus menus = Menus.of(type);

            // then
            assertThat(menus.isNotOnMenu()).isFalse();
        }

        @Test
        @DisplayName("없는 메뉴 생성 테스트")
        void noneMenuCreateTest() {
            // given
            int notOnMenu = 3;

            // when
            Menus menus = Menus.of(notOnMenu);

            // then
            assertThat(menus).isEqualTo(Menus.NONE);
            assertThat(menus.isNotOnMenu()).isTrue();
        }
    }

//    @Nested
//    @DisplayName("팩토리 테스트")
//    class FactoryTest {
//        private final Factory<Menu, Menus> factory = new MenuFactory();
//        private final Console console = new Console(new CustomInput(), new CustomOutput());
//
//        @ParameterizedTest
//        @DisplayName("조회, 계산 생성 테스트")
//        @EnumSource(value = Menus.class, names = {"QUERY", "CALCULATE"})
//        void menuCreateTest(Menus menus) {
//            // given
//
//            // when
//            Menu menu = factory.create(menus);
//
//            // then
//            assertThat(menu).isNotInstanceOf(Exit.class);
//            assertThat(menu.execute(console)).isTrue();
//        }
//
//        @Test
//        @DisplayName("종료 생성 테스트")
//        void exitCreateTest() {
//            // given
//            Menus none = Menus.NONE;
//
//            // when
//            Menu menu = factory.create(none);
//
//            // then
//            assertThat(menu).isInstanceOf(Exit.class);
//            assertThat(menu.execute(console)).isFalse();
//        }
//    }
//
//    static class CustomInput implements Input {
//        @Override
//        public String read() {
//            return null;
//        }
//
//        @Override
//        public int readAsInt() {
//            return 0;
//        }
//    }
//
//    static class CustomOutput implements Output {
//        @Override
//        public void print(String message) {
//
//        }
//    }
}

package com.devcourse.java.domain.menu;

import com.devcourse.java.common.Factory;
import com.devcourse.java.domain.operator.Operator;
import com.devcourse.java.domain.operator.OperatorFactory;
import com.devcourse.java.domain.storage.MemoryStorage;
import com.devcourse.java.domain.calculator.Calculator;
import com.devcourse.java.domain.parser.ExpressionParser;
import com.devcourse.java.domain.parser.PrefixParser;
import com.devcourse.java.domain.validator.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {
    private Query query;
    private Calculate calculate;

    @Nested
    @DisplayName("Menus 테스트")
    class MenusTest {
        @ParameterizedTest
        @DisplayName("조회, 계산 생성 테스트")
        @ValueSource(ints = {1, 2})
        void menuCreateTest(int type) {
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
            int notOnMenu = 3;

            // when
            Menus menus = Menus.from(notOnMenu);

            // then
            assertThat(menus).isEqualTo(Menus.NONE);
            assertThat(menus.isNotOnMenu()).isTrue();
        }
    }

    @Nested
    @DisplayName("팩토리 테스트")
    class FactoryTest {
        private Factory<Menu, Menus> factory;

        @BeforeEach
        void setupFactory() {
            initMenu();
            factory = new MenuFactory(query, calculate);
        }

        @ParameterizedTest
        @DisplayName("조회, 계산 생성 테스트")
        @EnumSource(value = Menus.class, names = {"QUERY", "CALCULATE"})
        void menuCreateTest(Menus menus) {
            // given

            // when
            Menu menu = factory.create(menus);

            // then
            assertThat(menu).isNotInstanceOf(Exit.class);
        }

        @Test
        @DisplayName("종료 생성 테스트")
        void exitCreateTest() {
            // given
            Menus none = Menus.NONE;

            // when
            Menu menu = factory.create(none);

            // then
            assertThat(menu).isInstanceOf(Exit.class);
        }
    }

    private void initMenu() {
        Validator validator = new Validator();
        MemoryStorage memoryStorage = new MemoryStorage();
        ExpressionParser prefixParser = new PrefixParser();
        Factory<Operator, String> factory = new OperatorFactory();
        Calculator calculator = new Calculator(prefixParser, factory);
        query = new Query(memoryStorage, validator);
        calculate = new Calculate(calculator, memoryStorage, validator);
    }
}

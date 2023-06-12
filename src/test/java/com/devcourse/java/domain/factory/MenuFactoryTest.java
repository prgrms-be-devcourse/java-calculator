package com.devcourse.java.domain.factory;

import com.devcourse.java.domain.calculator.PrefixCalculator;
import com.devcourse.java.domain.menu.Calculate;
import com.devcourse.java.domain.menu.Exit;
import com.devcourse.java.domain.menu.Menu;
import com.devcourse.java.domain.menu.Menus;
import com.devcourse.java.domain.menu.Query;
import com.devcourse.java.domain.operator.Operator;
import com.devcourse.java.domain.parser.ExpressionParser;
import com.devcourse.java.domain.parser.PrefixParser;
import com.devcourse.java.domain.storage.MemoryStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenuFactoryTest {
    private Query query;
    private Calculate calculate;

    @Nested
    @DisplayName("팩토리 테스트")
    class FactoryTest {
        private Factory<Menu, Menus> factory;

        @BeforeEach
        void setupFactory() {
            initializeQueryAndCalculateMenu();
            factory = new MenuFactory(query, calculate);
        }

        @ParameterizedTest
        @DisplayName("입력에 맞게 메뉴가 생성되어야 한다. (Exit가 아니어야함)")
        @EnumSource(value = Menus.class, names = {"QUERY", "CALCULATE"})
        void queryAndCalculateMenuCreateTest(Menus menus) {
            // given

            // when
            Menu menu = factory.create(menus);

            // then
            assertThat(menu).isNotInstanceOf(Exit.class);
        }

        @Test
        @DisplayName("종료 메뉴가 생성되어야 한다.")
        void exitCreateTest() {
            // given
            Menus none = Menus.NONE;

            // when
            Menu menu = factory.create(none);

            // then
            assertThat(menu).isInstanceOf(Exit.class);
        }
    }

    private void initializeQueryAndCalculateMenu() {
        MemoryStorage memoryStorage = new MemoryStorage();
        ExpressionParser prefixParser = new PrefixParser();
        Factory<Operator, String> factory = new OperatorFactory();
        PrefixCalculator prefixCalculator = new PrefixCalculator(prefixParser, factory);
        query = new Query(memoryStorage);
        calculate = new Calculate(prefixCalculator, memoryStorage);
    }
}

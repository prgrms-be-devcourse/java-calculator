package com.devcourse.java.domain.mapper;

import com.devcourse.java.domain.calculator.PrefixCalculator;
import com.devcourse.java.domain.menu.Calculate;
import com.devcourse.java.domain.menu.Exit;
import com.devcourse.java.domain.menu.Menu;
import com.devcourse.java.domain.menu.MenuMapper;
import com.devcourse.java.domain.menu.MenuType;
import com.devcourse.java.domain.menu.Query;
import com.devcourse.java.domain.calculator.parser.PrefixParser;
import com.devcourse.java.domain.operator.OperatorMapper;
import com.devcourse.java.domain.storage.MemoryStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenuMapperTest {
    private Query query;
    private Calculate calculate;

    @Nested
    @DisplayName("팩토리 테스트")
    class FactoryTest {
        private MenuMapper mapper;

        @BeforeEach
        void setupFactory() {
            initializeQueryAndCalculateMenu();
            mapper = new MenuMapper(query, calculate);
        }

        @ParameterizedTest
        @DisplayName("입력에 맞게 메뉴가 생성되어야 한다. (Exit가 아니어야함)")
        @EnumSource(value = MenuType.class, names = {"QUERY", "CALCULATE"})
        void queryAndCalculateMenuCreateTest(MenuType menuType) {
            // given

            // when
            Menu menu = mapper.toMenu(menuType);

            // then
            assertThat(menu).isNotInstanceOf(Exit.class);
        }

        @Test
        @DisplayName("종료 메뉴가 생성되어야 한다.")
        void exitCreateTest() {
            // given
            MenuType none = MenuType.NONE;

            // when
            Menu menu = mapper.toMenu(none);

            // then
            assertThat(menu).isInstanceOf(Exit.class);
        }
    }

    private void initializeQueryAndCalculateMenu() {
        MemoryStorage memoryStorage = new MemoryStorage();
        PrefixParser prefixParser = new PrefixParser();
        OperatorMapper factory = new OperatorMapper();
        PrefixCalculator prefixCalculator = new PrefixCalculator(prefixParser, factory);
        query = new Query(memoryStorage);
        calculate = new Calculate(prefixCalculator, memoryStorage);
    }
}

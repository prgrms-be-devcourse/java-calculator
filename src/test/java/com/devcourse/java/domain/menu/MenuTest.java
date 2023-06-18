package com.devcourse.java.domain.menu;

import com.devcourse.java.domain.calculator.Calculator;
import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.console.io.Reader;
import com.devcourse.java.domain.console.io.Writer;
import com.devcourse.java.domain.console.io.ConsoleReader;
import com.devcourse.java.domain.console.io.ConsoleWriter;
import com.devcourse.java.domain.storage.CalculateResult;
import com.devcourse.java.domain.storage.MemoryStorage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MenuTest {
    private final Console console = new Console(new ConsoleReader(), new ConsoleWriter());
    private final MemoryStorage memoryStorage = new MemoryStorage();

    @Test
    @DisplayName("종료 메뉴 테스트")
    void exitMenuTest() {
        // given
        Exit exit = new Exit();

        // when
        boolean power = exit.execute(console);

        // then
        assertThat(power).isFalse();
    }

    @Nested
    @DisplayName("조회 메뉴 테스트")
    class queryMenuTest {
        private final Query query = new Query(memoryStorage);

        @ParameterizedTest
        @MethodSource("queryData")
        void querySuccessTest(String expression, double expected) {
            // given
            CalculateResult calculateResult = new CalculateResult(expression, expected);
            memoryStorage.save(calculateResult);

            // when
            boolean power = query.execute(console);

            // then
            List<CalculateResult> calculateResults = memoryStorage.fetchAll();
            assertThat(calculateResults.size()).isEqualTo(memoryStorage.getId() - 1);
            assertThat(power).isTrue();
        }

        static Stream<Arguments> queryData() {
            return Stream.of(
                    arguments("3 + 4 * 2", 11),
                    arguments("8 - 6 / 2", 5),
                    arguments("5 * 2 + 7 - 1", 16)
            );
        }
    }

    @Nested
    @DisplayName("계산 메뉴 테스트")
    class calculateMenuTest {
        private final Writer writer = new ConsoleWriter();

        @ParameterizedTest
        @MethodSource("calculateData")
        void calculateSuccessTest(String expression, double expected) {
           // given
            final Console console = new Console(new CustomReader(expression), writer);
            final Calculate calculate = new Calculate(new CustomCalculator(expected), memoryStorage);

            // when
            boolean power = calculate.execute(console);

            // then
            List<CalculateResult> calculateResults = memoryStorage.fetchAll();
            assertThat(calculateResults.size()).isEqualTo(memoryStorage.getId() - 1);
            assertThat(power).isTrue();
        }

        static class CustomCalculator implements Calculator {
            private final double result;

            public CustomCalculator(double result) {
                this.result = result;
            }

            @Override
            public CalculateResult run(String expression) {
                return new CalculateResult(expression, this.result);
            }
        }

        static class CustomReader implements Reader {
            private final String input;

            public CustomReader(String input) {
                this.input = input;
            }

            @Override
            public String read() {
                return input;
            }
        }

        static Stream<Arguments> calculateData() {
            return Stream.of(
                    arguments("3 + 4 * 2", 11),
                    arguments("8 - 6 / 2", 5),
                    arguments("5 * 2 + 7 - 1", 16)
            );
        }
    }
}

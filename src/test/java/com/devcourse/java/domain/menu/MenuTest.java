package com.devcourse.java.domain.menu;

import com.devcourse.java.domain.calculator.Calculator;
import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.console.Input;
import com.devcourse.java.domain.console.Output;
import com.devcourse.java.domain.console.Reader;
import com.devcourse.java.domain.console.Writer;
import com.devcourse.java.domain.storage.CalculateResult;
import com.devcourse.java.domain.storage.MemoryStorage;
import com.devcourse.java.domain.validator.Validator;
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
    private final Console console = new Console(new Reader(), new Writer());
    private final Validator validator = new Validator();
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
        private final Query query = new Query(memoryStorage, validator);

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
        private final Output output = new Writer();

        @ParameterizedTest
        @MethodSource("calculateData")
        void calculateSuccessTest(String expression, double expected) {
           // given
            final Console console = new Console(new CustomInput(expression), output);
            final Calculate calculate = new Calculate(new CustomCalculator(expected), memoryStorage, validator);

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
            public CalculateResult run(String expression, Validator validator) {
                return new CalculateResult(expression, this.result);
            }
        }

        static class CustomInput implements Input {
            private final String input;

            public CustomInput(String input) {
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

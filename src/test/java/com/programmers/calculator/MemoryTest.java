package com.programmers.calculator;

import com.programmers.converter.InfixToPostfixConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class MemoryTest {

    Accumulator accumulator;
    Memory memory;

    @BeforeEach
    void setUp() {
        accumulator = new Accumulator(new InfixToPostfixConverter());
        memory = new Memory();
    }

    @Test
    @DisplayName("연산 기록 저장 테스트")
    void 연산_기록_저장() {
        // given
        String expression1 = "3 * 8 / 4";
        String expression2 = "( 3 / ( 8 - 4 + 9 ) ) * ( 20 - 8 ) * 17";
        // when
        memory.save(new CalcResult(expression1, accumulator.calculate(expression1).get()));
        memory.save(new CalcResult(expression2, accumulator.calculate(expression2).get()));

        // then
        assertThat(memory.getSize()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"3 * 8 / 4 : 6", "( 3 / ( 8 - 4 + 9 ) ) * ( 20 - 8 ) * 17 : 47.0769230769"}, delimiter = ':')
    @DisplayName("연산 기록 출력 테스트")
    void 연산_기록_출력(String input, String output) {
        memory.save(new CalcResult(input, accumulator.calculate(input).get()));

        assertThat(memory.findAll().get(0)).isEqualTo(input + " = " + output);
    }
}
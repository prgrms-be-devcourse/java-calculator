package com.calculator.java.engine.comand;

import com.calculator.java.database.Database;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculationTest {
    @ParameterizedTest(name = "{2}: {0} = {1}")
    @MethodSource("calculationTestParameter")
    void 연산_테스트(String exp, String result) {
        Command calculation = new Calculation(exp, Database.getInstance());

        String calculationResult = calculation.doCommand();

        assertThat(calculationResult).isEqualTo(result);
    }

    private static Stream<Arguments> calculationTestParameter() {
        return Stream.of(
                Arguments.of("11 + 22", "33", "더하기"),
                Arguments.of("11 + 22 + 33 + -22 + 44 + 55", "143", "더하기"),
                Arguments.of("11 - 22", "-11", "빼기"),
                Arguments.of("11 - 22 - 33 - -22 - 44 - 55", "-121", "빼기"),
                Arguments.of("11 + 22 + 33 - -22 - 44 - 55", "-11", "더하기_빼기"),
                Arguments.of("11 * 22 * 33", "7986", "곱하기"),
                Arguments.of("11 * 22 + 33 * -22 - 44 + 55", "-473", "곱하기_혼합"),
                Arguments.of("22 / 11", "2", "나누기"),
                Arguments.of("11 + 22 / 2 * 3", "44", "나누기_혼합_테스트"),
                Arguments.of("11 / 0", "계산할 수 없습니다.", "틀린_나누기"),
                Arguments.of("1.1 + 2.2", "3.3", "소수 계산"),
                Arguments.of("1.1 - 2.1", "-1", "소수 계산")
        );
    }
}
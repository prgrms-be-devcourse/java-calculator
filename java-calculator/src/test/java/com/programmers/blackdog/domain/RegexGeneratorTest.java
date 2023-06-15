package com.programmers.blackdog.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class RegexGeneratorTest {

    private static final String REGEX_PREFIX = "^\\d+\\s([";
    private static final String REGEX_SUFFIX = "]\\s\\d+\\s)+$";
    public static final String OPERATOR_PREFIX = "\\";

    private RegexGenerator regexGenerator;

    @BeforeEach
    void setUp() {
        regexGenerator = new RegexGenerator();
    }

    @DisplayName("연산자 설정에 따른 정규식을 만들어 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"ADDITION/SUBTRACTION", "SUBTRACTION/ADDITION", "SUBTRACTION/DIVISION"}, delimiter = '/')
    void when_ConfineSpecificOperator_Expects_GenerateRegexWithInputOperator(ArithmeticOperators firstOperator, ArithmeticOperators secondOperator) {
        String regex = regexGenerator.generateWithOperator(firstOperator, secondOperator);

        assertThat(regex).isEqualTo(REGEX_PREFIX + OPERATOR_PREFIX + firstOperator.getOperator()+ OPERATOR_PREFIX + secondOperator.getOperator() + REGEX_SUFFIX);
    }

    @DisplayName("모든 연산자를 포함한 정규식을 반환한다.")
    @Test
    void when_GenerateWithAllOperator_Expects_GenerateRegexWithAllOperator() {
        String regex = regexGenerator.generateWithAllOperator();

        String expected = "^\\d+\\s([\\+\\-\\*\\/]\\s\\d+\\s)+$";

        assertThat(regex).isEqualTo(expected);
    }
}
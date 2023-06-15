package org.programmers.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidaionTest {
    FormulaSplitValidator formulaSplitValidator = new FormulaSplitValidator();
    FormulaCountValidator formulaCountValidator = new FormulaCountValidator();

    @ParameterizedTest
    @DisplayName("연산식 검증: 연산식 분해 검증")
    @MethodSource("makeFormulaAndList")
    void formulaSplitValidation(String input, List<String> formula){
        // when
        List<String> formulaList = formulaSplitValidator.validate(input);

        // then
        assertEquals(formula, formulaList);
    }

    static Stream<Arguments> makeFormulaAndList(){
        return Stream.of(
                Arguments.of("10 + 4 / 20 * 3 - 2", Arrays.asList("10", "+", "4", "/", "20", "*", "3", "-", "2")),
                Arguments.of("5 - 2 * 20 + 3 / 2", Arrays.asList("5","-","2","*","20","+","3","/","2")),
                Arguments.of("7 * 2 - 3 / 3 + 2", Arrays.asList("7","*","2","-","3","/","3","+","2"))
        );
    }

    @ParameterizedTest
    @DisplayName("연산식 검증: 연산자와 피연산자의 전체 개수 검증 및 위치 검증")
    @MethodSource("makeFormulaList")
    void checkFormulaValidation(List<String> formulaList){
        // when
        Boolean checkedFormulaValidation = formulaCountValidator.validate(formulaList);

        // then
        assertEquals(checkedFormulaValidation, true);
    }

    static Stream<Arguments> makeFormulaList(){
        return Stream.of(
                Arguments.of(Arrays.asList("10", "+", "4", "/", "20", "*", "3", "-", "2")),
                Arguments.of(Arrays.asList("5","-","2","*","20","+","3","/","2")),
                Arguments.of(Arrays.asList("7","*","2","-","3","/","3","+","2"))
        );
    }
}

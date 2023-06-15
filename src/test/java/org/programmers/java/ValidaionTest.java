package org.programmers.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.programmers.java.validator.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidaionTest {

    @ParameterizedTest
    @DisplayName("연산자 혹은 피연산자가 아닌 것이 들어오면 예외가 발생한다.")
    @ValueSource(strings = {"10 + 4 / 20 * 3 - ㄱ", "# + 3 - 11", "****"})
    void formulaSplitValidation(String input){
        assertThrows(IllegalArgumentException.class, () -> Validator.formulaSplitValidate(input));
    }

    @ParameterizedTest
    @DisplayName("연산자와 피연산자 수, 리스트 전체 개수, 위치가 맞지 않으면 예외가 발상핸다.")
    @MethodSource("makeFormulaList")
    void checkFormulaValidation(List<String> formulaList){
        assertThrows(IllegalArgumentException.class, () -> Validator.formulaCountValidate(formulaList));
    }

    static Stream<Arguments> makeFormulaList(){
        return Stream.of(
                Arguments.of(Arrays.asList("10", "+", "4", "/", "20", "*", "3", "-")),
                Arguments.of(Arrays.asList("5","2","*","20","+","3","/","2")),
                Arguments.of(Arrays.asList("7","*","2","-","3","/","3","+"))
        );
    }
}

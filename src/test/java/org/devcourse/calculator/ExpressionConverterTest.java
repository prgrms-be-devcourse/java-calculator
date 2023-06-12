package org.devcourse.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class ExpressionConverterTest {


    @ParameterizedTest
    @DisplayName("입력된 수식 타입변환: 문자열 -> 리스트")
    @MethodSource("getData")
    void expressionStrToList(String expression, List<String> list) {

        List<String> expList = ExpressionConverter.expressionStrToList(expression);
        Assertions.assertThat(expList.equals(list)).isEqualTo(true);

    }


    @ParameterizedTest
    @DisplayName("중위표기식 -> 후위표기식")
    @MethodSource("getData2")
    void infixToPostfix(List<String> infix, List<String> expected) {

        List<String> postfix = ExpressionConverter.infixToPostfix(infix);
        Assertions.assertThat(postfix.equals(expected)).isEqualTo(true);
    }


    static Stream<Arguments> getData() {

        return Stream.of(
                Arguments.of("((-10+5)*50)", Arrays.asList("(", "(", "-10", "+", "5", ")", "*", "50", ")")),
                Arguments.of("-10+5*50", Arrays.asList( "-10", "+", "5", "*", "50" )),
                Arguments.of("5*3/5+1", Arrays.asList("5", "*", "3", "/", "5", "+", "1")),
                Arguments.of("(5*3)/5+1-50", Arrays.asList("(", "5", "*", "3", ")", "/", "5", "+", "1", "-", "50"))
        );
    }


    static Stream<Arguments> getData2() {

        return Stream.of(
                Arguments.of(Arrays.asList("(", "(", "-10", "+", "5", ")", "*", "50", ")"),
                            Arrays.asList("-10", "5", "+", "50", "*")),

                Arguments.of(Arrays.asList( "-10", "+", "5", "*", "50" ),
                            Arrays.asList( "-10", "5", "50", "*",  "+" )),

                Arguments.of(Arrays.asList("5", "*", "3", "/", "5", "+", "1"),
                            Arrays.asList("5", "3", "*", "5", "/", "1", "+")),

                Arguments.of(Arrays.asList("(", "5", "*", "3", ")", "/", "5", "+", "1", "-", "50"),
                            Arrays.asList( "5", "3", "*", "5", "/", "1", "+", "50", "-"))
        );
    }

}
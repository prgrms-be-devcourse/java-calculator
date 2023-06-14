package calculator.model.calculator;

import calculator.model.calculator.Operation;
import calculator.model.converter.InfixToPostfixConverter;
import calculator.model.ExpressionConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


class InfixToPostfixConverterTest {

    private static ExpressionConverter converter;
    private static final Operation operation = Operation.getInstance();

    @BeforeEach
    void beforeEach(){
        converter = new InfixToPostfixConverter();
    }

    @ParameterizedTest
    @MethodSource("testExpressionData")
     void convert(String infix, List<String> expectedPostfix) {
        List<String> convertedToPostfix = converter.convert(infix);
        Assertions.assertEquals(expectedPostfix, convertedToPostfix);
    }

    private static Stream<Arguments> testExpressionData(){
        return Stream.of(
                Arguments.of("3 + 5", Arrays.asList("3", "5", "+")),
                Arguments.of("3 - 5 * -2", Arrays.asList("3", "5", "*", "-2", "-")), // Failed
                Arguments.of("3 + 5 - 2 * 1", Arrays.asList("3", "5", "+", "2", "1", "*", "-")),
                Arguments.of("1 + 5 * 2", Arrays.asList("1", "5", "2", "*", "+")),
                Arguments.of("3 + 6 * 2 / 3", Arrays.asList("3", "6", "2",  "*", "3", "/", "+"))
        );
    }
}
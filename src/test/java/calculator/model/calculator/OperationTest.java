package calculator.model.calculator;

import calculator.model.calculator.Operation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class OperationTest {

    private static final Operation operation = Operation.getInstance();


    @ParameterizedTest
    @DisplayName("Operator 사칙 연산을 검증 하는 테스트")
    @CsvSource({
            "1, +, 5, 6",
            "2, -,1, 1",
            "3, *, -5, -15",
            "12, /, 4, 3"
    })
    void calculate(Integer a, String operator, Integer b, Integer result) {
        Integer calculated = operation.calculate(a, operator, b);
        Assertions.assertEquals(result, calculated);
    }

    @ParameterizedTest
    @DisplayName("잘못된 표현 수식에 대한 연산을 검증 하는 테스트")
    @CsvSource({
            "2, /, 0",
            "3, /, 0"
    })
    void calculateInvalidExpression(Integer a, String operator, Integer b) {
        try {
            Integer calculated = operation.calculate(a, operator, b);
        } catch (RuntimeException e){
            Assertions.assertEquals("올바른 피연산자가 아닙니다.", e.getMessage());
        }
    }


    @ParameterizedTest
    @DisplayName("Operator 사칙 연산을 검증 하는 테스트 - 잘못된 결과 값에 대한 테스트")
    @CsvSource({
            "1, +, 5, 5",
            "2, -, 1, 4",
            "3, *, -5, 15",
            "12, /, 4, 1"
    })
    void validateWrongCalculation(Integer a, String operator, Integer b, Integer result) {
        Integer calculated = operation.calculate(a, operator, b);
        Assertions.assertNotEquals(result, calculated);

    }

    @ParameterizedTest
    @DisplayName("String 형태의 연산자를 Operator 객체로 가져오는 것을 검증하는 테스트")
    @MethodSource("testData")
    void getOperator(Operation.Operator operator, String value) {
        Assertions.assertEquals(operator, Operation.getOperator(value));

    }

    private static Stream<Arguments> testData(){
        return Stream.of(
                Arguments.of(Operation.Operator.PLUS, "+"),
                Arguments.of(Operation.Operator.MINUS, "-"),
                Arguments.of(Operation.Operator.DIVIDE, "/"),
                Arguments.of(Operation.Operator.MULTIPLY, "*")
        );
    }

    @Test
    @DisplayName("Operation이 싱글톤으로 객체가 생성되는지 확인하는 테스트")
    void getInstance() {
        Operation operation = Operation.getInstance();
        Operation operation2 = Operation.getInstance();

        Assertions.assertEquals(operation, operation2);
    }
}
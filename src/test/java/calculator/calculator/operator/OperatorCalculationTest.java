package calculator.calculator.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static calculator.calculator.operator.OperatorCalculation.*;
import static calculator.exception.OperatorException.OPERATOR_CALCULATION_EXCEPTION_DIVIDE_ZERO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OperatorCalculationTest {

    @ParameterizedTest(name = "[{index}] formula = ({0}) + ({1}), expect = {2}")
    @MethodSource("whenPlusIntegerCalculationThenSuccessDummy")
    @DisplayName("정수형 더하기 연산 성공 테스트")
    void whenPlusIntegerCalculationThenSuccessTest(int leftOperand, int rightOperand, int expect) {
        double result = PLUS_CALCULATOR.doCalculation(
                        BigDecimal.valueOf(leftOperand),
                        BigDecimal.valueOf(rightOperand))
                .doubleValue();
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "[{index}] formula = ({0}) - ({1}), expect = {2}")
    @MethodSource("whenMinusIntegerCalculationThenSuccessDummy")
    @DisplayName("정수형 빼기 연산 성공 테스트")
    void whenMinusIntegerCalculationThenSuccessTest(int leftOperand, int rightOperand, int expect) {
        double result = MINUS_CALCULATOR.doCalculation(
                        BigDecimal.valueOf(leftOperand),
                        BigDecimal.valueOf(rightOperand))
                .doubleValue();
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "[{index}] formula = ({0}) * ({1}), expect = {2}")
    @MethodSource("whenMultiplyIntegerCalculationThenSuccessDummy")
    @DisplayName("정수형 곱하기 연산 성공 테스트")
    void whenMultiplyIntegerCalculationThenSuccessTest(int leftOperand, int rightOperand, int expect) {
        double result = MULTIPLY_CALCULATOR.doCalculation(
                        BigDecimal.valueOf(leftOperand),
                        BigDecimal.valueOf(rightOperand))
                .doubleValue();
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "[{index}] formula = ({0}) / ({1}), expect = {2}")
    @MethodSource("whenDivideIntegerCalculationThenSuccessDummy")
    @DisplayName("정수형 나누기 연산 성공 테스트")
    void whenDivideIntegerCalculationThenSuccessTest(int leftOperand, int rightOperand, int expect) {
        double result = DIVIDE_CALCULATOR.doCalculation(
                        BigDecimal.valueOf(leftOperand),
                        BigDecimal.valueOf(rightOperand))
                .doubleValue();
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "[{index}] formula = ({0}) + ({1}), expect = {2}")
    @MethodSource("whenPlusDoubleCalculationThenSuccessDummy")
    @DisplayName("소수형 더하기 연산 성공 테스트")
    void whenPlusDoubleCalculationThenSuccessTest(double leftOperand, double rightOperand, double expect) {
        double result = PLUS_CALCULATOR.doCalculation(
                        BigDecimal.valueOf(leftOperand),
                        BigDecimal.valueOf(rightOperand))
                .doubleValue();
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "[{index}] formula = ({0}) - ({1}), expect = {2}")
    @MethodSource("whenMinusDoubleCalculationThenSuccessDummy")
    @DisplayName("소수형 빼기 연산 성공 테스트")
    void whenMinusDoubleCalculationThenSuccessTest(double leftOperand, double rightOperand, double expect) {
        double result = MINUS_CALCULATOR.doCalculation(
                        BigDecimal.valueOf(leftOperand),
                        BigDecimal.valueOf(rightOperand))
                .doubleValue();
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "[{index}] formula = ({0}) * ({1}), expect = {2}")
    @MethodSource("whenMultiplyDoubleCalculationThenSuccessDummy")
    @DisplayName("소수형 곱하기 연산 성공 테스트")
    void whenMultiplyDoubleCalculationThenSuccessTest(double leftOperand, double rightOperand, double expect) {
        double result = MULTIPLY_CALCULATOR.doCalculation(
                        BigDecimal.valueOf(leftOperand),
                        BigDecimal.valueOf(rightOperand))
                .doubleValue();
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "[{index}] formula = ({0}) / ({1}), expect = {2}")
    @MethodSource("whenDivideDoubleCalculationThenSuccessDummy")
    @DisplayName("소수형 나누기 연산 성공 테스트")
    void whenDivideDoubleCalculationThenSuccessTest(double leftOperand, double rightOperand, double expect) {
        double result = DIVIDE_CALCULATOR.doCalculation(
                        BigDecimal.valueOf(leftOperand),
                        BigDecimal.valueOf(rightOperand))
                .doubleValue();
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "[{index}] formula = ({0}) / ({1})")
    @MethodSource("whenDivideZeroCalculationThenExceptionDummy")
    @DisplayName("0 나누기 연산 실패 예외처리 테스트")
    void whenDivideZeroCalculationThenExceptionTest(double leftOperand, double rightOperand) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        DIVIDE_CALCULATOR.doCalculation(
                                BigDecimal.valueOf(leftOperand),
                                BigDecimal.valueOf(rightOperand)))
                .withMessageMatching(OPERATOR_CALCULATION_EXCEPTION_DIVIDE_ZERO.message);

    }

    static Stream<Arguments> whenPlusIntegerCalculationThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(0, 0, 0),
                Arguments.arguments(1, 2, 3),
                Arguments.arguments(1, 3, 4),
                Arguments.arguments(1, 4, 5),
                Arguments.arguments(1, 10, 11),
                Arguments.arguments(1, 100, 101),
                Arguments.arguments(1, 1000, 1001),
                Arguments.arguments(10, 1, 11),
                Arguments.arguments(10, 10, 20),
                Arguments.arguments(10, 100, 110),
                Arguments.arguments(10, 1000, 1010),
                Arguments.arguments(2_000_000_000, 2_000_000, 2_002_000_000),
                Arguments.arguments(-1, -2, -3),
                Arguments.arguments(-1, -3, -4),
                Arguments.arguments(-1, -4, -5),
                Arguments.arguments(-1, -10, -11),
                Arguments.arguments(-1, -100, -101),
                Arguments.arguments(-1, -1000, -1001),
                Arguments.arguments(-10, -1, -11),
                Arguments.arguments(-10, -10, -20),
                Arguments.arguments(-10, -100, -110),
                Arguments.arguments(-10, -1000, -1010),
                Arguments.arguments(-2_000_000_000, -2_000_000, -2_002_000_000)
        );
    }

    static Stream<Arguments> whenMinusIntegerCalculationThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(0, 0, 0),
                Arguments.arguments(1, 2, -1),
                Arguments.arguments(1, 3, -2),
                Arguments.arguments(1, 4, -3),
                Arguments.arguments(1, 10, -9),
                Arguments.arguments(1, 100, -99),
                Arguments.arguments(1, 1000, -999),
                Arguments.arguments(10, 1, 9),
                Arguments.arguments(10, 10, 0),
                Arguments.arguments(10, 100, -90),
                Arguments.arguments(10, 1000, -990),
                Arguments.arguments(2_000_000_000, 2_000_000, 1_998_000_000),
                Arguments.arguments(-1, -2, 1),
                Arguments.arguments(-1, -3, 2),
                Arguments.arguments(-1, -4, 3),
                Arguments.arguments(-1, -10, 9),
                Arguments.arguments(-1, -100, 99),
                Arguments.arguments(-1, -1000, 999),
                Arguments.arguments(-10, -1, -9),
                Arguments.arguments(-10, -10, 0),
                Arguments.arguments(-10, -100, 90),
                Arguments.arguments(-10, -1000, 990),
                Arguments.arguments(-2_000_000_000, -2_000_000, -1_998_000_000)
        );
    }

    static Stream<Arguments> whenMultiplyIntegerCalculationThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(0, 0, 0),
                Arguments.arguments(1, 2, 2),
                Arguments.arguments(1, 3, 3),
                Arguments.arguments(1, 4, 4),
                Arguments.arguments(1, 10, 10),
                Arguments.arguments(1, 100, 100),
                Arguments.arguments(1, 1000, 1000),
                Arguments.arguments(10, 1, 10),
                Arguments.arguments(10, 10, 100),
                Arguments.arguments(10, 100, 1000),
                Arguments.arguments(10, 1000, 10000),
                Arguments.arguments(-1, -2, 2),
                Arguments.arguments(-1, -3, 3),
                Arguments.arguments(-1, -4, 4),
                Arguments.arguments(-1, -10, 10),
                Arguments.arguments(-1, -100, 100),
                Arguments.arguments(-1, -1000, 1000),
                Arguments.arguments(-10, -1, 10),
                Arguments.arguments(-10, -10, 100),
                Arguments.arguments(-10, -100, 1000),
                Arguments.arguments(-10, -1000, 10000),
                Arguments.arguments(-1, 2, -2),
                Arguments.arguments(-1, 3, -3),
                Arguments.arguments(-1, 4, -4),
                Arguments.arguments(-1, 10, -10),
                Arguments.arguments(-1, 100, -100),
                Arguments.arguments(-1, 1000, -1000),
                Arguments.arguments(-10, 1, -10),
                Arguments.arguments(-10, 10, -100),
                Arguments.arguments(-10, 100, -1000),
                Arguments.arguments(-10, 1000, -10000),
                Arguments.arguments(1, -2, -2),
                Arguments.arguments(1, -3, -3),
                Arguments.arguments(1, -4, -4),
                Arguments.arguments(1, -10, -10),
                Arguments.arguments(1, -100, -100),
                Arguments.arguments(1, -1000, -1000),
                Arguments.arguments(10, -1, -10),
                Arguments.arguments(10, -10, -100),
                Arguments.arguments(10, -100, -1000),
                Arguments.arguments(10, -1000, -10000)
        );
    }

    static Stream<Arguments> whenDivideIntegerCalculationThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(2, 1, 2),
                Arguments.arguments(3, 1, 3),
                Arguments.arguments(4, 1, 4),
                Arguments.arguments(10, 1, 10),
                Arguments.arguments(10, 10, 1),
                Arguments.arguments(100, 10, 10),
                Arguments.arguments(1000, 10, 100),
                Arguments.arguments(2_000_000_000, 2_000_000, 1_000),
                Arguments.arguments(-2, -1, 2),
                Arguments.arguments(-3, -1, 3),
                Arguments.arguments(-4, -1, 4),
                Arguments.arguments(-10, -1, 10),
                Arguments.arguments(-10, -10, 1),
                Arguments.arguments(-100, -10, 10),
                Arguments.arguments(-1000, -10, 100),
                Arguments.arguments(-2_000_000_000, -2_000_000, 1_000),
                Arguments.arguments(2, -1, -2),
                Arguments.arguments(3, -1, -3),
                Arguments.arguments(4, -1, -4),
                Arguments.arguments(10, -1, -10),
                Arguments.arguments(10, -10, -1),
                Arguments.arguments(100, -10, -10),
                Arguments.arguments(1000, -10, -100),
                Arguments.arguments(2_000_000_000, -2_000_000, -1_000),
                Arguments.arguments(-2, 1, -2),
                Arguments.arguments(-3, 1, -3),
                Arguments.arguments(-4, 1, -4),
                Arguments.arguments(-10, 1, -10),
                Arguments.arguments(-10, 10, -1),
                Arguments.arguments(-100, 10, -10),
                Arguments.arguments(-1000, 10, -100),
                Arguments.arguments(-2_000_000_000, 2_000_000, -1_000)
        );
    }

    static Stream<Arguments> whenPlusDoubleCalculationThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(0.3, 0.2, 0.5),
                Arguments.arguments(1.3, 2.2, 3.5),
                Arguments.arguments(1.3, 3.2, 4.5),
                Arguments.arguments(1.3, 4.2, 5.5),
                Arguments.arguments(1.3, 10.2, 11.5),
                Arguments.arguments(1.3, 100.2, 101.5),
                Arguments.arguments(1.3, 1000.2, 1001.5),
                Arguments.arguments(10.1, 1.2, 11.3),
                Arguments.arguments(10.1, 10.2, 20.3),
                Arguments.arguments(10.1, 100.2, 110.3),
                Arguments.arguments(10.1, 1000.2, 1010.3),
                Arguments.arguments(2_000_000_000.998, 2_000_000.002, 2_002_000_001.0),

                Arguments.arguments(-1.0, -2.1, -3.1),
                Arguments.arguments(-1.0, -3.1, -4.1),
                Arguments.arguments(-1.0, -4.1, -5.1),
                Arguments.arguments(-1.0, -10.1, -11.1),
                Arguments.arguments(-1.0, -100.1, -101.1),
                Arguments.arguments(-1.0, -1000.1, -1001.1),
                Arguments.arguments(-10, -1, -11),
                Arguments.arguments(-10, -10, -20),
                Arguments.arguments(-10, -100, -110),
                Arguments.arguments(-10, -1000, -1010),
                Arguments.arguments(-2_000_000_000, -2_000_000, -2_002_000_000)
        );
    }

    static Stream<Arguments> whenMinusDoubleCalculationThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(0.0, 0.2, -0.2),
                Arguments.arguments(1.0, 2.2, -1.2),
                Arguments.arguments(1.0, 3.2, -2.2),
                Arguments.arguments(1.0, 4.2, -3.2),
                Arguments.arguments(1.0, 10.2, -9.2),
                Arguments.arguments(1.0, 100.2, -99.2),
                Arguments.arguments(1.0, 1000.2, -999.2),
                Arguments.arguments(10.0, 1.2, 8.8),
                Arguments.arguments(10.0, 10.2, -0.2),
                Arguments.arguments(10.0, 100.2, -90.2),
                Arguments.arguments(10.0, 1000.2, -990.2),
                Arguments.arguments(2_000_000_000.1, 2_000_000.1, 1_998_000_000.0),

                Arguments.arguments(-1, -2, 1),
                Arguments.arguments(-1, -3, 2),
                Arguments.arguments(-1, -4, 3),
                Arguments.arguments(-1, -10, 9),
                Arguments.arguments(-1, -100, 99),
                Arguments.arguments(-1, -1000, 999),
                Arguments.arguments(-10, -1, -9),
                Arguments.arguments(-10, -10, 0),
                Arguments.arguments(-10, -100, 90),
                Arguments.arguments(-10, -1000, 990),
                Arguments.arguments(-2_000_000_000, -2_000_000, -1_998_000_000)
        );
    }

    static Stream<Arguments> whenMultiplyDoubleCalculationThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(0.3, 0.3, 0.09),
                Arguments.arguments(1.3, 2.3, 2.99),
                Arguments.arguments(1.3, 3.3, 4.29),
                Arguments.arguments(1.3, 4.3, 5.59),
                Arguments.arguments(1.3, 10.3, 13.39),
                Arguments.arguments(1.3, 100.3, 130.39),
                Arguments.arguments(1.3, 1000.3, 1300.39),
                Arguments.arguments(10.3, 1.3, 13.39),
                Arguments.arguments(10.3, 10.3, 106.09),
                Arguments.arguments(10.3, 100.3, 1033.09),
                Arguments.arguments(10.3, 1000.3, 10303.09),

                Arguments.arguments(-1.3, -2.3, 2.99),
                Arguments.arguments(-1.3, -3.3, 4.29),
                Arguments.arguments(-1.3, -4.3, 5.59),
                Arguments.arguments(-1.3, -10.3, 13.39),
                Arguments.arguments(-1.3, -100.3, 130.39),
                Arguments.arguments(-1.3, -1000.3, 1300.39),
                Arguments.arguments(-10.3, -1.3, 13.39),
                Arguments.arguments(-10.3, -10.3, 106.09),
                Arguments.arguments(-10.3, -100.3, 1033.09),
                Arguments.arguments(-10.3, -1000.3, 10303.09),

                Arguments.arguments(-1.3, 2.3, -2.99),
                Arguments.arguments(-1.3, 3.3, -4.29),
                Arguments.arguments(-1.3, 4.3, -5.59),
                Arguments.arguments(-1.3, 10.3, -13.39),
                Arguments.arguments(-1.3, 100.3, -130.39),
                Arguments.arguments(-1.3, 1000.3, -1300.39),
                Arguments.arguments(-10.3, 1.3, -13.39),
                Arguments.arguments(-10.3, 10.3, -106.09),
                Arguments.arguments(-10.3, 100.3, -1033.09),
                Arguments.arguments(-10.3, 1000.3, -10303.09),

                Arguments.arguments(1.3, -2.3, -2.99),
                Arguments.arguments(1.3, -3.3, -4.29),
                Arguments.arguments(1.3, -4.3, -5.59),
                Arguments.arguments(1.3, -10.3, -13.39),
                Arguments.arguments(1.3, -100.3, -130.39),
                Arguments.arguments(1.3, -1000.3, -1300.39),
                Arguments.arguments(10.3, -1.3, -13.39),
                Arguments.arguments(10.3, -10.3, -106.09),
                Arguments.arguments(10.3, -100.3, -1033.09),
                Arguments.arguments(10.3, -1000.3, -10303.09)
        );
    }

    static Stream<Arguments> whenDivideDoubleCalculationThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(2.4, 1.2, 2),
                Arguments.arguments(3.4, 1.2, 2.833333333333333),
                Arguments.arguments(4.4, 1.2, 3.666666666666667),
                Arguments.arguments(10.4, 1.2, 8.666666666666668),
                Arguments.arguments(10.4, 10.2, 1.019607843137255),
                Arguments.arguments(100.4, 10.2, 9.843137254901961),
                Arguments.arguments(1000.4, 10.2, 98.07843137254902),
                Arguments.arguments(2_000_000_000.4, 2_000_000.2, 999.99990020001),

                Arguments.arguments(-2.4, -1.2, 2.0),
                Arguments.arguments(-3.4, -1.2, 2.833333333333333),
                Arguments.arguments(-4.4, -1.2, 3.666666666666667),
                Arguments.arguments(-10.4, -1.2, 8.666666666666668),
                Arguments.arguments(-10.4, -10.2, 1.019607843137255),
                Arguments.arguments(-100.4, -10.2, 9.843137254901961),
                Arguments.arguments(-1000.4, -10.2, 98.07843137254902),
                Arguments.arguments(-2_000_000_000.4, -2_000_000.2, 999.99990020001),

                Arguments.arguments(2.4, -1.2, -2.0),
                Arguments.arguments(3.4, -1.2, -2.833333333333333),
                Arguments.arguments(4.4, -1.2, -3.666666666666667),
                Arguments.arguments(10.4, -1.2, -8.666666666666668),
                Arguments.arguments(10.4, -10.2, -1.019607843137255),
                Arguments.arguments(100.4, -10.2, -9.843137254901961),
                Arguments.arguments(1000.4, -10.2, -98.07843137254902),
                Arguments.arguments(2_000_000_000.4, -2_000_000.2, -999.99990020001),

                Arguments.arguments(-2.4, 1.2, -2.0),
                Arguments.arguments(-3.4, 1.2, -2.833333333333333),
                Arguments.arguments(-4.4, 1.2, -3.666666666666667),
                Arguments.arguments(-10.4, 1.2, -8.666666666666668),
                Arguments.arguments(-10.4, 10.2, -1.019607843137255),
                Arguments.arguments(-100.4, 10.2, -9.843137254901961),
                Arguments.arguments(-1000.4, 10.2, -98.07843137254902),
                Arguments.arguments(-2_000_000_000.4, 2_000_000.2, -999.99990020001)
        );
    }

    static Stream<Arguments> whenDivideZeroCalculationThenExceptionDummy() {
        return Stream.of(
                Arguments.arguments(0, 0),
                Arguments.arguments(1, 0),
                Arguments.arguments(10, 0),
                Arguments.arguments(100, 0),
                Arguments.arguments(1000, 0),
                Arguments.arguments(-1, 0),
                Arguments.arguments(-10, 0),
                Arguments.arguments(-100, 0),
                Arguments.arguments(-1000, 0),

                Arguments.arguments(0.123, 0),
                Arguments.arguments(1.123, 0),
                Arguments.arguments(10.123, 0),
                Arguments.arguments(100.123, 0),
                Arguments.arguments(1000.123, 0),
                Arguments.arguments(-1.123, 0),
                Arguments.arguments(-10.123, 0),
                Arguments.arguments(-100.123, 0),
                Arguments.arguments(-1000.123, 0)
        );
    }
}
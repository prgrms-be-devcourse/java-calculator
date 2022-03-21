package com.prgrms.ndy.domain.operation;

import com.prgrms.ndy.domain.Op;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OpTest {

    Offset<Double> OFFSET = Offset.offset(0.000_000_1);

    @Nested
    class Op_ADD_의_BiFunction_은 {

        @ParameterizedTest
        @CsvSource(value = {
                "1, -3.0, -2.0",
                "-14, 20, 6.0",
                "1.4, 3.0, 4.4",
                "100, 77, 177"
        })
        void 정상로직을_잘처리한다(double operandA, double operandB, double expectedResult) {
            double actualResult = Op.ADD.apply(operandA, operandB);
            assertThat(actualResult).isCloseTo(expectedResult, OFFSET);
        }
    }

    @Nested
    class Op_SUB_의_BiFunction_은 {

        @ParameterizedTest
        @CsvSource(value = {
                "1.4, 3.0, -1.6",
                "100, 77, 23"
        })
        void 양수를_잘뺀다(double operandA, double operandB, double expectedResult) {
            double actualResult = Op.SUB.apply(operandA, operandB);
            assertThat(actualResult).isCloseTo(expectedResult, OFFSET);
        }

        @ParameterizedTest
        @CsvSource(value = {
                "1.4, -3.0, 4.4",
                "100, -77, 177"
        })
        void 음수를_잘뺸다(double operandA, double operandB, double expectedResult) {
            double actualResult = Op.SUB.apply(operandA, operandB);
            assertThat(actualResult).isCloseTo(expectedResult, OFFSET);
        }
    }

    @Nested
    class Op_MUL_의_BiFunction_은 {

        @ParameterizedTest
        @CsvSource(value = {
                "1, -3.0, -3.0",
                "-14, 20, -280",
                "1.4, 3.0, 4.2",
                "100, 77, 7700"
        })
        void 정상로직을_잘처리한다(double operandA, double operandB, double expectedResult) {
            double actualResult = Op.MUL.apply(operandA, operandB);
            assertThat(actualResult).isCloseTo(expectedResult, OFFSET);
        }
    }

    @Nested
    class Op_DIV_의_BiFunction_은 {

        @ParameterizedTest
        @CsvSource(value = {
                "-14, 20,   -0.7",
                "1, -3.0,   -0.33333333333333",
                "1.4, 3.0,   0.4666666666666666",
                "100, 77,   1.2987012987012987"
        })
        void 정상로직을_잘처리한다(double operandA, double operandB, double expectedResult) {
            double actualResult = Op.DIV.apply(operandA, operandB);
            assertThat(actualResult).isCloseTo(expectedResult, OFFSET);
        }

        @Test
        void 영으로_나누면_무한대값을_준다() {
            double posInf = Op.DIV.apply(1.4, 0.0);
            double negInf = Op.DIV.apply(-1.4, 0.0);

            assertThat(posInf).isEqualTo(Double.POSITIVE_INFINITY);
            assertThat(negInf).isEqualTo(Double.NEGATIVE_INFINITY);
        }
    }
}

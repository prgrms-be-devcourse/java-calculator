package calculator.engine.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticOperatorTest {

    @DisplayName("연산자 우선순위 테스트")
    @Test
    void test1() {
        ArithmeticOperator multiplication = ArithmeticOperator.toOperator("*");
        ArithmeticOperator division = ArithmeticOperator.toOperator("/");
        ArithmeticOperator addition = ArithmeticOperator.toOperator("+");
        ArithmeticOperator subtraction = ArithmeticOperator.toOperator("-");

        boolean actual1 = multiplication.hasSamePriorityOrPrecede(subtraction);
        boolean actual2 = addition.hasSamePriorityOrPrecede(multiplication);

        Assertions.assertAll(
                () -> assertThat(actual1).isTrue(),
                () -> assertThat(actual2).isFalse()
        );
    }
}
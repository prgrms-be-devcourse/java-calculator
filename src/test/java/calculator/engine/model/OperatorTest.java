package calculator.engine.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @Test
    @DisplayName("사칙연산(+, -, *, /) 계산 테스트")
    void testCalculate() {
        assertThat(Operator.PLUS.calculate(3.5, 9.9)).isEqualTo(13.4);
        assertThat(Operator.MINUS.calculate(3.5, 9.9)).isEqualTo(-6.4);
        assertThat(Operator.MULTIPLY.calculate(3.5, 9.9)).isEqualTo(34.65);
        assertThat(Operator.DIVIDE.calculate(5, 4)).isEqualTo(1.25);
    }

    @Test
    @DisplayName("사칙연산 기호에 따라 enum Operator 객체 반환 테스트")
    void testGetOperator() {
        assertThat(Operator.getOperator("+").get()).isEqualTo(Operator.PLUS);
        assertThat(Operator.getOperator("-").get()).isEqualTo(Operator.MINUS);
        assertThat(Operator.getOperator("*").get()).isEqualTo(Operator.MULTIPLY);
        assertThat(Operator.getOperator("/").get()).isEqualTo(Operator.DIVIDE);
    }

    @Test
    @DisplayName("Operator(+, -, *, /) 인지 체크")
    void testIsOperator() {
        assertThat(Operator.isOperator("@")).isEqualTo(false);
        assertThat(Operator.isOperator("+")).isEqualTo(true);
        assertThat(Operator.isOperator("-")).isEqualTo(true);
        assertThat(Operator.isOperator("*")).isEqualTo(true);
        assertThat(Operator.isOperator("/")).isEqualTo(true);
    }

    @Test
    @DisplayName("우선순위 비교 테스트")
    void testComparePriority() {
        Operator operator = Operator.PLUS;
        assertThat(operator.comparePriority(Operator.PLUS)).isEqualTo(0);
        assertThat(operator.comparePriority(Operator.MINUS)).isEqualTo(0);
        assertThat(operator.comparePriority(Operator.MULTIPLY)).isEqualTo(-1);
        assertThat(operator.comparePriority(Operator.DIVIDE)).isEqualTo(-1);
    }

    @Test
    @DisplayName("우선순위 반환 테스트")
    void testGetPriority() {
        Operator op1 = Operator.PLUS;
        Operator op2 = Operator.MINUS;
        Operator op3 = Operator.MULTIPLY;
        Operator op4 = Operator.DIVIDE;
        assertThat(op1.getPriority()).isEqualTo(1);
        assertThat(op2.getPriority()).isEqualTo(1);
        assertThat(op3.getPriority()).isEqualTo(2);
        assertThat(op4.getPriority()).isEqualTo(2);
    }
}

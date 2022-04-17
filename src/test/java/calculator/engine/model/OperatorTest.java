package calculator.engine.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

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

    @DisplayName("Operator(+, -, *, /) 인지 체크")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void testIsOperator(String  token) {
        assertThat(Operator.isOperator(token)).isEqualTo(true);
    }

    @Test
    @DisplayName("우선순위 비교 테스트")
    void testComparePriority() {
        Operator operator = Operator.PLUS;
        assertThat(operator.comparePriority(Optional.of(Operator.PLUS))).isEqualTo(0);
        assertThat(operator.comparePriority(Optional.of(Operator.MINUS))).isEqualTo(0);
        assertThat(operator.comparePriority(Optional.of(Operator.MULTIPLY))).isEqualTo(-1);
        assertThat(operator.comparePriority(Optional.of(Operator.DIVIDE))).isEqualTo(-1);
    }

}

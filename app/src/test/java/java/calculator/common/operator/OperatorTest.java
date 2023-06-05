package java.calculator.common.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperatorTest {

    @Test
    @DisplayName("연산자에 맞는 계산기를 반환하는지 확인하는 테스트: 덧셈")
    public void 덧셈_계산기_반환_테스트() {
        // given
        String addSymbol = "+";

        // when
        Operator addOperator = Operator.of(addSymbol);

        // then
        assertEquals(Operator.ADD, addOperator);
    }

    @Test
    @DisplayName("연산자에 맞는 계산기를 반환하는지 확인하는 테스트: 뺄셈")
    public void 뺄셈_계산기_반환_테스트() {
        // given
        String subtractSymbol = "-";

        // when
        Operator subtractOperator = Operator.of(subtractSymbol);

        // then
        assertEquals(Operator.SUBTRACT, subtractOperator);
    }

    @Test
    @DisplayName("연산자에 맞는 계산기를 반환하는지 확인하는 테스트: 곱셈")
    public void 곱셈_계산기_반환_테스트() {
        // given
        String multiplySymbol = "*";

        // when
        Operator multiplyOperator = Operator.of(multiplySymbol);

        // then
        assertEquals(Operator.MULTIPLY, multiplyOperator);
    }

    @Test
    @DisplayName("연산자에 맞는 계산기를 반환하는지 확인하는 테스트: 나눗셈")
    public void 나눗셈_맞는_계산기_반환_테스트() {
        // given
        String divideSymbol = "/";

        // when
        Operator divideOperator = Operator.of(divideSymbol);

        // then
        assertEquals(Operator.DIVIDE, divideOperator);
    }

    @Test
    @DisplayName("없는 계산기를 입력했을 때 예외를 반환하는지 확인하는 테스트")
    public void 없는_계산기_예외_반환_테스트() {
        // given
        String invalidSymbol = "%";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> Operator.of(invalidSymbol));
    }

    @Test
    @DisplayName("계산기의 기능이 잘 작동하는지 확인하는 테스트: 덧셈")
    public void 덧셈_기능_테스트() {
        // given
        int a = 10;
        int b = 2;

        // when
        int addResult = Operator.ADD.calculate(a, b);

        // then
        assertEquals(12, addResult);
    }

    @Test
    @DisplayName("계산기의 기능이 잘 작동하는지 확인하는 테스트: 뺄셈")
    public void 뺄셈_기능_테스트() {
        // given
        int a = 10;
        int b = 2;

        // when
        int subtractResult = Operator.SUBTRACT.calculate(a, b);

        // then
        assertEquals(8, subtractResult);
    }

    @Test
    @DisplayName("계산기의 기능이 잘 작동하는지 확인하는 테스트: 곱셈")
    public void 곱셈_기능_테스트() {
        // given
        int a = 10;
        int b = 2;

        // when
        int multiplyResult = Operator.MULTIPLY.calculate(a, b);

        // then
        assertEquals(20, multiplyResult);
    }

    @Test
    @DisplayName("계산기의 기능이 잘 작동하는지 확인하는 테스트: 나눗셈")
    public void 나눗셈_기능_테스트() {
        // given
        int a = 10;
        int b = 2;

        // when
        int divideResult = Operator.DIVIDE.calculate(a, b);

        // then
        assertEquals(5, divideResult);
    }

    @Test
    @DisplayName("0으로 나누었을 때 예외를 반환하는지 확인하는 테스트")
    public void zero_나누기_예외_테스트() {
        // given
        int a = 10;
        int b = 0;

        // when & then
        assertThrows(ArithmeticException.class, () -> Operator.DIVIDE.calculate(a, b));
    }
}


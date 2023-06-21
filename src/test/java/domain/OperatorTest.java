package domain;

import com.programmers.domain.Operator;
import com.programmers.error.CalculatorException;
import com.programmers.view.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.programmers.error.ErrorMessage.DIVIDE_ZERO_EXCEPTION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorTest {
    @DisplayName("Operator에서 덧셈 연산 테스트 ")
    @CsvSource(value = {"3:5:8", "30:210:240"}, delimiter = ':')
    @ParameterizedTest
    void 덧셈_테스트(String input1, String input2, String output) {
        int num1 = Integer.parseInt(input1);
        int num2 = Integer.parseInt(input2);
        int result = Operator.PLUS.applyOperation(num1, num2);

        assertEquals(String.valueOf(result), output);
    }

    @DisplayName("Operator에서 뺄셈 연산 테스트 ")
    @CsvSource(value = {"3:5:-2", "210:30:180"}, delimiter = ':')
    @ParameterizedTest
    void 뺄셈_테스트(String input1, String input2, String output) {
        int num1 = Integer.parseInt(input1);
        int num2 = Integer.parseInt(input2);
        int result = Operator.MINUS.applyOperation(num1, num2);

        assertEquals(String.valueOf(result), output);
    }

    @DisplayName("Operator에서 곱셈 연산 테스트 ")
    @CsvSource(value = {"3:5:15", "210:30:6300"}, delimiter = ':')
    @ParameterizedTest
    void 곱셈_테스트(String input1, String input2, String output) {
        int num1 = Integer.parseInt(input1);
        int num2 = Integer.parseInt(input2);
        int result = Operator.MULTIPLY.applyOperation(num1, num2);

        assertEquals(String.valueOf(result), output);
    }

    @DisplayName("Operator에서 나눗셈 연산 테스트 ")
    @CsvSource(value = {"15:5:3", "210:30:7"}, delimiter = ':')
    @ParameterizedTest
    void 나눗셈_테스트(String input1, String input2, String output) {
        int num1 = Integer.parseInt(input1);
        int num2 = Integer.parseInt(input2);
        int result = Operator.DIVIDE.applyOperation(num1, num2);

        assertEquals(String.valueOf(result), output);
    }

    @DisplayName("[실패] 나눗셈 연산 실패 테스트 - 0으로 나눌 때 ")
    @CsvSource(value = {"15:0", "210:0"}, delimiter = ':')
    @ParameterizedTest
    void 나눗셈_실패_테스트(String input1, String input2) {
        int num1 = Integer.parseInt(input1);
        int num2 = Integer.parseInt(input2);

        assertThatThrownBy(() -> Operator.DIVIDE.applyOperation(num1, num2))
                .isInstanceOf(CalculatorException.class)
                .hasMessageContaining(DIVIDE_ZERO_EXCEPTION.getMessage());
    }
}

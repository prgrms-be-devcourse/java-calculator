import exception.CalculatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.InMemoryRepository;

import java.io.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PostfixCalculatorTests {

    private PostfixCalculator calculator;

    @BeforeEach
    void beforeEach() {
        calculator = new PostfixCalculator(
                new BufferedReader(new InputStreamReader(System.in)),
                new InMemoryRepository(),
                new Prefix2PostfixConverter());
    }


    @Test
    @DisplayName("사칙연산의 우선순위에 따른 계산을 한다.")
    void calculateWithPriority() {
        // given
        String exp1 = "1 + 2 * 3";
        String exp2 = "1 * ( 2 / (3 - 4) )";
        String exp3 = "2 + 1 / 0";
        String exp4 = "1 - 2 / 0";

        // when
        String result1 = calculator.operate(exp1);
        String result2 = calculator.operate(exp2);
        String result3 = calculator.operate(exp3);
        String result4 = calculator.operate(exp4);

        // then
        assertThat(result1).isEqualTo("7");
        assertThat(result2).isEqualTo("-2");
        assertThat(result3).isEqualTo("Infinity");
        assertThat(result4).isEqualTo("-Infinity");

    }

    @Test
    @DisplayName("계산이력을 저장하고 출력한다.")
    void saveHistory() {
        // given
        String exp1 = "1 + 2 * 3";
        String exp2 = "1 * ( 2 / (3 - 4) )";
        String exp3 = "2 + 1 / 0";
        String exp4 = "1 - 2 / 0";

        // when
        calculator.operate(exp1);
        calculator.operate(exp2);
        calculator.operate(exp3);
        calculator.operate(exp4);

        // then
        calculator.printHistory();

    }

    @Test
    @DisplayName("괄호 속 단항연산자가 있는 경우 예외를 발생시킨다.")
    void validateExpressionWithUnary() {

        // given
        String exp1 = "(+1)";
        String exp2 = "1 + 2 +(-3)";
        String exp3 = "1 *(-3)";
        // when

        // then
        Exception exception = assertThrows(CalculatorException.class, () -> calculator.operate(exp1));
        assertEquals("올바르지 않은 연산식입니다.", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> calculator.operate(exp2));
        assertEquals("올바르지 않은 연산식입니다.", exception.getMessage());

        exception = assertThrows(CalculatorException.class, () -> calculator.operate(exp3));
        assertEquals("올바르지 않은 연산식입니다.", exception.getMessage());

    }

}

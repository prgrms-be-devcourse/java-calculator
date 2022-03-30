import entity.CustomLog;
import exception.CalculatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.InMemoryLogRepository;

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
                new InMemoryLogRepository<CustomLog>(),
                new Prefix2PostfixConverter());
    }


    @Test
    @DisplayName("괄호 및 사칙연산의 우선순위에 따른 계산을 한다.")
    void calculateWithPriority() {
        // given
        String exp1 = "1 + 2 * 3";
        String exp2 = "1 * ( 2 / (3 - 4) )";

        // when
        String result1 = calculator.getResult(exp1);
        String result2 = calculator.getResult(exp2);

        // then
        assertThat(result1).isEqualTo("7");
        assertThat(result2).isEqualTo("-2");

    }

    @Test
    @DisplayName("0으로 나누는 경우, Infinity, -Infinity")
    void calculateWithZero() {
        // given
        String exp1 = "2 + 1 / 0";
        String exp2 = "1 - 2 / 0";

        // when
        String result3 = calculator.getResult(exp1);
        String result4 = calculator.getResult(exp2);

        // then
        assertThat(result3).isEqualTo("Infinity");
        assertThat(result4).isEqualTo("-Infinity");
    }

    @Test
    @DisplayName("괄호 속 단항연산자가 있는 경우 예외를 발생시킨다.")
    void validateExpressionWithUnary() {

        // given
        String exp1 = "(+1)";

        // when

        // then
        Exception exception = assertThrows(CalculatorException.class, () -> calculator.getResult(exp1));
        assertEquals("올바르지 않은 연산식입니다.", exception.getMessage());
    }

}

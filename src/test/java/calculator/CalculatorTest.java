package calculator;

import calculator.engine.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("계산과 조회 기능 테스트")
    void test_01() throws Exception {
        //example1
        StringBuilder sb = new StringBuilder();
        String formula1 = "1 + 2", answer1 = "3";
        sb.append(formula1).append("\n").append(answer1).append("\n");
        String result1 = calculator.calculate(formula1);
        assertThat(result1).isEqualTo(sb.toString());
        sb.delete(0, sb.length());

        //example2
        String formula2 = "1 + 2 * 3", answer2 = "7";
        sb.append(formula2).append("\n").append(answer2).append("\n");
        String result2 = calculator.calculate(formula2);
        assertThat(result2).isEqualTo(sb.toString());
        sb.delete(0, sb.length());

        //example3
        String formula3 = "3 - 2 * 2", answer3 = "-1";
        sb.append(formula3).append("\n").append(answer3).append("\n");
        String result3 = calculator.calculate(formula3);
        assertThat(result3).isEqualTo(sb.toString());

        //search
        String search = calculator.search();
        assertThat(search).isNotEmpty();
        assertThat(search).contains(formula1, formula2, formula3);
    }

    @Test
    @DisplayName("0으로 나눌 경우 에러 발생")
    void test_02() throws Exception {
        String formula = "3 / 0";
        assertThrows(Exception.class, () -> {
            calculator.calculate(formula);
        }).getMessage().equals("0으로 값을 나눌 수 없습니다.");
    }
}

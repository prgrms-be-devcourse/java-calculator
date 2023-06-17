package calculator;

import calculator.handler.ICalculateHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateHandlerTest {

    ICalculateHandler calculateHandler = new CalculateHandler();

    @Test
    @DisplayName("사칙 연산이 정상적으로 동작한다.")
    void 사칙_연산_정상_동작1() {
        String problem = "100 - 10 * 8 + 50 / 2";

        int result = calculateHandler.calculate(problem);

        assertThat(result).isEqualTo(45);
    }

    @Test
    @DisplayName("사칙 연산이 정상적으로 동작한다.")
    void 사칙_연산_정상_동작2() {

        String problem = "5 + 3 * 7 - 5 * 6 + 3";

        int result = calculateHandler.calculate(problem);

        assertThat(result).isEqualTo(-1);
    }
}
package calculator.handler;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateHandlerTest {
    CalculatorHandler calculatorHandler = new CalculateHandler();
    Map<String, String> param = new HashMap<>();
    Map<String, Object> model = new HashMap<>();

    @AfterEach
    void afterEach() {
        param.clear();
        model.clear();
    }

    @Test
    @DisplayName("사칙 연산이 정상적으로 동작한다.")
    void 사칙_연산_정상_동작1() {

        param.put("problem", "100 - 10 * 8 + 50 / 2");

        calculatorHandler.process(param, model);
        int result = (int) model.get("answer");

        assertThat(result).isEqualTo(45);
    }

    @Test
    @DisplayName("사칙 연산이 정상적으로 동작한다.")
    void 사칙_연산_정상_동작2() {

        param.put("problem", "5 + 3 * 7 - 5 * 6 + 3");

        calculatorHandler.process(param, model);
        int result = (int) model.get("answer");

        assertThat(result).isEqualTo(-1);
    }
}
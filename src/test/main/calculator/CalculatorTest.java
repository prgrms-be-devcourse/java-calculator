package main.calculator;

import main.calculator.engine.io.Input;
import main.calculator.engine.io.Output;
import main.calculator.engine.model.CalculationRepository;
import main.calculator.engine.model.MemoryCalculationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    Input input = new Console();
    Output output = new Console();
    CalculationRepository calculationRepository = new MemoryCalculationRepository();
    Operator operator = new Operator();
    Calculator calculator = new Calculator(input, output, calculationRepository, operator);

    @Test
    @DisplayName("선택지에서 1~3이 아닌 숫자 입력")
    void inputNotMenuNumber() {
        String input = "4";

        assertThatThrownBy(() -> calculator.parse(input)).isInstanceOf(SelectException.class);
    }

    @Test
    @DisplayName("선택지에서 문자열 입력")
    void inputString() {
        String input = "안녕친구";

        assertThatThrownBy(() -> calculator.parse(input)).isInstanceOf(NumberFormatException.class);
    }
}

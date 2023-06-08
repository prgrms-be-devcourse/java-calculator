import main.java.domain.Command;
import main.java.service.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    String command;
    Calculator calculator = new Calculator();
    @DisplayName("calculate함수는 띄어쓰기로 파싱된 commandArr를 계산하는 함수.")
    @ParameterizedTest
    @ValueSource(strings =  {"5 * 2 + 64 / 32 - 7",
            "15 / 5 * 2 + 8 / 2",
            "2 + 12 / 6 - 3 * 7",
            "7 - 25 * 3 + 20 / 10"})

    void calculateTest(String command) {
        // 1. * + / -
        assertEquals(5, input(command));

        // 2. / * + /
//        assertEquals(10, input(command));

        // 3. + / - * 
//        assertEquals(-17, input(command));

        // 4. - * + /
//        assertEquals(-66, input(command));
    }

    int input(String command) {
        String[] commandArr = command.split(" ");
        Command command1 = new Command(commandArr);
        command1.parseComamand();
        return calculator.calculate(command1);
    }
}

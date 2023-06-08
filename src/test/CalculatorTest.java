import main.java.domain.Command;
import main.java.service.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    String command;
    Calculator calculator = new Calculator();
    @DisplayName("calculate함수는 띄어쓰기로 파싱된 commandArr를 계산하는 함수.")
    @Test
    void calculateTest() {
        // 1. * + / -
        command = "5 * 2 + 64 / 32 - 7";
        assertEquals(5, input(command));

        // 2. / * + /
        command = "15 / 5 * 2 + 8 / 2";
        assertEquals(10, input(command));

        // 3. + / - *
        command = "2 + 12 / 6 - 3 * 7";
        assertEquals(-17, input(command));

        // 4. - * + /
        command = "7 - 25 * 3 + 20 / 10";
        assertEquals(-66, input(command));
    }

    int input(String command) {
        String[] commandArr = command.split(" ");
        Command command1 = new Command(commandArr);
        command1.parseComamand();
        return calculator.calculate(command1);
    }
}

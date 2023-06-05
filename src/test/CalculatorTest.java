import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import Calculator;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    String command;

    @DisplayName("calculate함수는 띄어쓰기로 파싱된 commandArr를 계산하는 함수.")
    @Test
    void calculateTest() {
        // case 테스트마다 commandArr, result 갱신해주는거 불편하다.
        // 매크로로 못 선언하나 ?
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
        Calculator calculator = Calculator.getInstance();
        String[] commandArr = command.split(" ");
        return calculator.calculate(commandArr);
    }
}
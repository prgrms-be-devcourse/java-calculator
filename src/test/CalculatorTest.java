import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import Calculator;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    String command;
    String[] commandArr;
    int result;
    @DisplayName("calculate함수는 띄어쓰기로 파싱된 commandArr를 계산하는 함수.")
    @Test
    void calculateTest() {
        // case 테스트마다 commandArr, result 갱신해주는거 불편하다.
        // 매크로로 못 선언하나 ?
        Calculator calculator = Calculator.getInstance();
        // 1. * + / -
        command = "5 * 2 + 64 / 32 - 7";
        commandArr = command.split(" ");
        result = calculator.calculate(commandArr);
        assertEquals(5, result);

        // 2. / * + /
        command = "15 / 5 * 2 + 8 / 2";
        commandArr = command.split(" ");
        result = calculator.calculate(commandArr);
        assertEquals(10, result);

        // 3. + / - *
        command = "2 + 12 / 6 - 3 * 7";
        commandArr = command.split(" ");
        result = calculator.calculate(commandArr);
        assertEquals(-17, result);

        // 4. - * + /
        command = "7 - 25 * 3 + 20 / 10";
        commandArr = command.split(" ");
        result = calculator.calculate(commandArr);
        assertEquals(-66, result);
    }
}
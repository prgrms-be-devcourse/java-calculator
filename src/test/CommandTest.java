import main.java.domain.Command;
import main.java.service.Calculator;
import main.java.service.Operator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {

    static Command command;
    static int[] compNumArr;
    static Operator[] compOptArr;
    static Calculator calculator;

    @BeforeAll
    public static void setting() {
        command = new Command(stringToArray("1 + 2 + 3"));
        compNumArr = new int[] {1, 2, 3};
        compOptArr = new Operator[] {Operator.PLUS, Operator.PLUS};
        calculator = new Calculator();
    }

    @DisplayName("parseCommand는 인자로 들어온 String array를" +
            "각각 정수와 연산자로 나눠주는 함수" +
            "Command생성할때 이미 parsing완료한다.")
    @Test
    public void parseCommandTest() {
        assertArrayEquals(compOptArr, command.optArr);
        assertArrayEquals(compNumArr, command.numberArr);
    }

    @DisplayName("makeHistory는 인자로 들어온 result와 " +
            "연산에 이용한 command를 합쳐서 String으로 리턴하는 함수")
    @Test
    public void makeHistoryTest() {
        String expectedHistory = "1 + 2 + 3 = 6";
        assertEquals(expectedHistory, command.makeHistory(calculator.calculate(command)));
    }

    public static String[] stringToArray(String input) {
        return input.split(" ");
    }
}

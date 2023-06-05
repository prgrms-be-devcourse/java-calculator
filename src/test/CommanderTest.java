import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommanderTest {

    String command;
    String[] commandArr;

    @DisplayName("isDigit함수는 input으로 들어온 String의 첫번째 문자를 검사하여 숫자인지, String인지(첫번째 문자가 char면 String) 판단한다.")
    @Test
    void isDigitTest() {
        assertTrue(Commander.isDigit("123"));
        assertFalse(Commander.isDigit("#"));
        assertFalse(Commander.isDigit("+"));
    }

    @DisplayName("check함수는 input 형식에 맞게,  숫자 연산자 숫자 연산자 가 번갈아 나오는지, 숫자라면 중간에 문자가 껴있는지 체크하고, 연산자라면 사칙연산의 연산자인지 체크한다.")
    @Test
    void checkTest() {
        command = "1 & 2";
        commandArr = command.split(" ");
        assertEquals(false, Commander.check(commandArr));
        command = "1 + 3";
        commandArr = command.split(" ");
        assertEquals(true, Commander.check(commandArr));
    }
}

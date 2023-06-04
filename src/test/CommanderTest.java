import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommanderTest {

    @Test
    void isDigitTest() {
        assertTrue(Commander.isDigit('1'));
        assertFalse(Commander.isDigit('^'));
    }

    @Test
    void checkTest() {
        assertEquals(false, Commander.check(new String[] {"1", "^"}));
        assertEquals(true, Commander.check(new String[] {"1", "+", "3"}));
    }
}

package validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateTest {
    Validate validate = new ValidateService();

    @Test
    @DisplayName("올바른 선택 번호인지")
    void isCorrectCommand() {
        String s1 = "1";
        String s2 = "2";
        String s3 = "3";
        String s4 = "4";
        String s5 = "a";
        String s6 = "#@";

        assertTrue(validate.isCorrectCommand(s1));
        assertTrue(validate.isCorrectCommand(s2));
        assertTrue(validate.isCorrectCommand(s3));

        assertFalse(validate.isCorrectCommand(s4));
        assertFalse(validate.isCorrectCommand(s5));
        assertFalse(validate.isCorrectCommand(s6));

    }

    @Test
    @DisplayName("조건에 맞는 계산식인지")
    void isCorrectFormula() {
        String s1 = "1";
        String s2 = " ";
        String s3 = "3 ! 4";
        String s4 = "3 + ";
        String s5 = "3+1";
        String s6 = "3 * 5";
        String s7 = "3 - 3 * 3 / 3 + 3";


        assertTrue(validate.isCorrectCommand(s1));

        assertFalse(validate.isCorrectCommand(s2));
        assertFalse(validate.isCorrectCommand(s3));
        assertFalse(validate.isCorrectCommand(s4));
        assertFalse(validate.isCorrectCommand(s5));

        assertTrue(validate.isCorrectFormula(s6));
        assertTrue(validate.isCorrectFormula(s7));


    }
}

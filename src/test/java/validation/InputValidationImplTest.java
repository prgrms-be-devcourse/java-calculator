package validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidationImplTest {
    private static InputValidation validation;

    @BeforeEach
    public void setup() {
        validation = new InputValidationImpl();
    }

    @Test
    void validateButton() {
        assertThrows(IllegalArgumentException.class, () ->{
            String input = "3";
            validation.validateButton(input);
        });
    }

    @Test
    void validateExpression() {
        assertThrows(IllegalArgumentException.class, () ->{
            String expression = "1 + 2 - a";
            validation.validateButton(expression);
        });
    }
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void multiply1() {
        Calculator c = new Calculator();
        assertEquals(c.multiply(2, 3), 6);
    }

    @Test
    void multiply2() {
        Calculator c = new Calculator();
        assertEquals(c.multiply(2, 3, 4), 24);
    }
}
package arithmeticTest;

import arithmetic.DivisionClass;
import arithmetic.Operator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisionClassTest {
    @Test
    public void testDivisionConstructor(){
        Operator division = new DivisionClass();
        assertEquals(3,division.getResult(6,2));
    }
}

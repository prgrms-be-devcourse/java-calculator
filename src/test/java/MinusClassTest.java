import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinusClassTest {
    @Test
    public void testMinusConstructor(){
        Operator minus = new MinusClass();
        assertEquals(3,minus.getResult(5,2));
    }
}

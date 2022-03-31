import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlusClassTest {

    @Test
    public void testPlusConstructor(){
        Operator plus = new PlusClass();
        assertEquals(5,plus.getResult(2,3));
    }
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleClassTest {
    @Test
    public void testMultipleConstructor(){
        Operator multiple = new MultipleClass();
        assertEquals(10,multiple.getResult(5,2));
    }
}

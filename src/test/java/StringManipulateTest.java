import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringManipulateTest {

    @Test
    public void testIntegerStack(){
        String string = "1 + 2 * 3";
        StringManipulator manipulator = new StringManipulator(string);
        Stack<Integer> integerStack = manipulator.getIntegerStack();

        assertEquals(getRightIntegerStack(string),integerStack);
    }

    @Test
    public void testEmptyIntegerStack(){
        StringManipulator manipulator = new StringManipulator("");
        Stack<Integer> integerStack = manipulator.getIntegerStack();

        assertEquals(new Stack<Integer>(),integerStack);
    }

    public Stack<Integer> getRightIntegerStack(String string){
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0; i<string.length(); i++){
            char nowChar = string.charAt(i);
            if ('0' <= nowChar && nowChar<='9'){
                integerStack.push(Character.getNumericValue(nowChar));
            }
        }
        return integerStack;
    }
    
}

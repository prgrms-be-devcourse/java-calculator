import console.StringManipulator;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringManipulateTest {

    private String string = "1 + 2 * 3";

    @Test
    public void testNumberStack(){
        StringManipulator manipulator = new StringManipulator(string);
        Stack<Float> numberStack = manipulator.getNumberStack();

        assertEquals(getRightNumberStack(string),numberStack);
    }

    @Test
    public void testEmptyNumberStack(){
        StringManipulator manipulator = new StringManipulator("");
        Stack<Float> numberStack = manipulator.getNumberStack();

        assertEquals(new Stack<Number>(),numberStack);
    }

    @Test
    public void testOperatorStack(){
        StringManipulator manipulator = new StringManipulator(string);
        Stack<Character> operatorStack = manipulator.getOperatorStack();

        assertEquals(getRightOperatorStack(string),operatorStack);
    }

    @Test
    public void testEmptyOperatorStack(){
        StringManipulator manipulator = new StringManipulator("");
        Stack<Character> operatorStack = manipulator.getOperatorStack();

        assertEquals(new Stack<Number>(),operatorStack);
    }

    public Stack<Float> getRightNumberStack(String string){
        Stack<Float> numberStack = new Stack<>();

        StringBuffer nowNum = new StringBuffer();

        for (int i = 0; i<string.length(); i++){
            char nowChar = string.charAt(i);
            if (('0' <= nowChar && nowChar<='9') || nowChar == '.'){
                nowNum.append(nowChar);
            }else{
                numberStack.push(Float.parseFloat(nowNum.toString()));
                nowNum = new StringBuffer();
            }
        }
        numberStack.push(Float.parseFloat(nowNum.toString()));

        return numberStack;
    }

    public Stack<Character> getRightOperatorStack(String string){
        Stack<Character> operatorStack = new Stack<>();
        for (int i = 0; i<string.length(); i++){
            char nowChar = string.charAt(i);
            if ('0' > nowChar || nowChar >'9'){
                operatorStack.push(nowChar);
            }
        }
        return operatorStack;
    }
}

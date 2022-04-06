package arithmeticTest;

import arithmetic.*;
import console.StringManipulator;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmeticOperationsTest {
    String string = "2+3*2*4-3";

    @Test
    public void testMultipleAndDivide(){
        StringManipulator stringManipulator = new StringManipulator(string);
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations(stringManipulator);
        arithmeticOperations.multipleAndDivide();

        assertEquals(getRightMultipleAndDivideStack(),arithmeticOperations.getNumberStack());
        assertEquals(getRightOperatorStack(), arithmeticOperations.getOperatorStack());
    }

    @Test
    public void testPlusAndMinus(){
        StringManipulator stringManipulator = new StringManipulator(string);
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations(stringManipulator);
        arithmeticOperations.multipleAndDivide();
        arithmeticOperations.plusAndMinus();

        assertEquals(getRightPlusAndMinusResult(),arithmeticOperations.getResult());
    }

    private Stack<Float> getRightMultipleAndDivideStack(){
        StringManipulator stringManipulator = new StringManipulator(string);
        Stack<Float> numberStack = stringManipulator.getNumberStack();
        Stack<Character> operatorStack = stringManipulator.getOperatorStack();

        Stack<Float> rightNumStack = new Stack<>();

        while(!numberStack.isEmpty() && !operatorStack.isEmpty()){
            char nowOperatorChar = operatorStack.pop();
            float nowNumber = numberStack.pop();
            Operator nowOperator = null;

            if (nowOperatorChar == '*' || nowOperatorChar == '/'){
                if (nowOperatorChar == '*'){
                    nowOperator = new MultipleClass();
                }else{
                    nowOperator = new DivisionClass();
                }
                float otherNumber = numberStack.pop();
                numberStack.push(nowOperator.getResult(otherNumber,nowNumber));
            }else{
                rightNumStack.push(nowNumber);
            }
        }
        rightNumStack.push(numberStack.pop());

        return rightNumStack;

    }

    private Float getRightPlusAndMinusResult(){
        Stack<Float> numberStack = getRightMultipleAndDivideStack();
        Stack<Character> operatorStack = getRightOperatorStack();

        Float result = numberStack.pop();

        while(!numberStack.isEmpty() && !operatorStack.isEmpty()){
            char nowOperatorChar = operatorStack.pop();
            float nowNumber = numberStack.pop();
            Operator nowOperator = null;

            if (nowOperatorChar == '+'){
                nowOperator = new PlusClass();
            }else{
                nowOperator = new MinusClass();
            }

            result = nowOperator.getResult(result,nowNumber);
        }

        return result;
    }

    private Stack<Character> getRightOperatorStack(){
        StringManipulator stringManipulator = new StringManipulator(string);
        Stack<Character> operatorStack = stringManipulator.getOperatorStack();

        Stack<Character> rightCharStack = new Stack<>();

        while(!operatorStack.isEmpty()){
            char nowOperatorChar = operatorStack.pop();

            if (nowOperatorChar == '+' || nowOperatorChar == '-'){
                rightCharStack.push(nowOperatorChar);
            }
        }

        return rightCharStack;
    }
}

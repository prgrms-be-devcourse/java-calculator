package arithmetic;

import console.StringManipulator;

import java.util.Stack;

public class ArithmeticOperations {
    private Stack<Float> numberStack;
    private Stack<Character> operatorStack;
    private Float result;

    public ArithmeticOperations(StringManipulator stringManipulator){
        numberStack = stringManipulator.getNumberStack();
        operatorStack = stringManipulator.getOperatorStack();
    }

    public Stack<Float> getNumberStack() {
        return numberStack;
    }

    public Stack<Character> getOperatorStack() {
        return operatorStack;
    }

    public void multipleAndDivide(){
        Stack<Float> newNumberStack = new Stack<>();
        Stack<Character> newOperatorStack = new Stack<>();

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
                newNumberStack.push(nowNumber);
                newOperatorStack.push(nowOperatorChar);
            }
        }
        newNumberStack.push(numberStack.pop());
        
        numberStack = newNumberStack;
        operatorStack = newOperatorStack;
    }

    public void plusAndMinus(){
        result = numberStack.pop();

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
    }

    public Float getResult(){
        return result;
    }

    public Float doArithmetic() {
        multipleAndDivide();
        plusAndMinus();

        return result;
    }
}

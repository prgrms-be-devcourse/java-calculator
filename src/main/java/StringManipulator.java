import java.util.Stack;

public class StringManipulator {
    private String string;
    private Stack<Integer> integerStack;
    private Stack<Character> operatorStack;

    public StringManipulator(){
    }

    public StringManipulator(String string) {
        this.string = string;
        initIntegerStack();
        initOperatorStack();
    }

    private void initOperatorStack() {
        operatorStack = new Stack<>();

        for (int i = 0; i<string.length(); i++){
            char nowChar = string.charAt(i);
            if ('0' > nowChar || nowChar >'9'){
                operatorStack.push(nowChar);
            }
        }
    }

    private void initIntegerStack() {
        integerStack = new Stack<>();

        for (int i = 0; i<string.length(); i++){
            char nowChar = string.charAt(i);
            if ('0' <= nowChar && nowChar<='9'){
                integerStack.push(Character.getNumericValue(nowChar));
            }
        }
    }

    public Stack<Integer> getIntegerStack() {
        if (integerStack == null){
            integerStack = new Stack<>();
        }

        return integerStack;
    }

    public Stack<Character> getOperatorStack() {
        if (operatorStack == null){
            operatorStack = new Stack<>();
        }

        return operatorStack;
    }
}

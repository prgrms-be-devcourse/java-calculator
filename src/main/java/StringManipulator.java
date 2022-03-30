import java.util.Stack;

public class StringManipulator {
    private String string;
    private Stack<Integer> integerStack;

    public StringManipulator(String string) {
        this.string = string;
        initIntegerStack();
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
}

package console;

import java.util.Stack;

public class StringManipulator {
    private String string;
    private Stack<Float> numberStack;
    private Stack<Character> operatorStack;

    public StringManipulator(){
    }

    public StringManipulator(String string) {
        this.string = string;
        initNumberStack();
        initOperatorStack();
    }

    private void initOperatorStack() {
        operatorStack = new Stack<>();

        for (int i = 0; i<string.length(); i++){
            char nowChar = string.charAt(i);
            if (nowChar == '+' || nowChar == '-' || nowChar =='*' || nowChar == '/'){
                operatorStack.push(nowChar);
            }
        }
    }

    private void initNumberStack() {
        numberStack = new Stack<>();

        StringBuffer nowNum = new StringBuffer();

        for (int i = 0; i<string.length(); i++){
            char nowChar = string.charAt(i);
            if (('0' <= nowChar && nowChar<='9') || nowChar == '.'){
                nowNum.append(nowChar);
            }else if (nowChar == '+' || nowChar == '-' || nowChar =='*' || nowChar == '/'){
                numberStack.push(Float.parseFloat(nowNum.toString()));
                nowNum = new StringBuffer();
            }
        }
        numberStack.push(Float.parseFloat(nowNum.toString()));

    }

    public Stack<Float> getNumberStack() {
        if (numberStack == null){
            numberStack = new Stack<>();
        }

        return numberStack;
    }

    public Stack<Character> getOperatorStack() {
        if (operatorStack == null){
            operatorStack = new Stack<>();
        }

        return operatorStack;
    }
}

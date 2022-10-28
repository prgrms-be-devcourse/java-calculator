package calculator.operator;

import java.util.Stack;

public class OperateManager implements Operator {

    @Override
    public boolean isMultiplyOrDivide(String s) {
        if(s.contains("*") || s.contains("/")) return true;
        return false;
    }

    @Override
    public Stack<String> multiplyOrDivide(Stack<String> origin){ //10+2*3
        // enum 변경
        Stack<String> stack = new Stack<>();
        double result;
        for(int i = 0; i < origin.size(); i++) {
            String x = origin.get(i);
            switch (x) {
                case "*":
                    result = Double.parseDouble(stack.pop()) * Double.parseDouble(origin.get(++i));
                    stack.push(String.valueOf(result));
                    break;
                case "/":
                    result = Double.parseDouble(stack.pop()) / Double.parseDouble(origin.get(++i));
                    if(Double.isInfinite(result) || Double.isNaN(result))  break;
                    stack.push(String.valueOf(result));
                    break;
                default :
                    stack.push(x);
            }
        }
        return stack;
    }

    @Override
    public double addOrSubtract (Stack<String> st) {
        double result = Double.parseDouble(st.get(0));
        for(int i = 1; i < st.size(); i+=2) {
            String op = st.get(i);
            switch (op) {
                case "+" : result += Double.parseDouble(st.get(i+1));   break;
                case "-": result -= Double.parseDouble(st.get(i+1));   break;
            }
        }
        return result;
    }
}

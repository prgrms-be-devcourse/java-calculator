package calculator.operator;

import java.util.Stack;

public interface Operator {
    boolean isMultiplyOrDivide(String s);
    Stack<String> multiplyOrDivide(Stack<String> st);
    double addOrSubtract(Stack<String> stack);
}

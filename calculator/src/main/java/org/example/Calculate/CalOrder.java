package org.example.Calculate;

import java.util.Stack;

public interface CalOrder {
    String calculateMultiplyDivide();
    int calculatePlusMinus();
    void setStack(Stack<String> expressionStack);
}

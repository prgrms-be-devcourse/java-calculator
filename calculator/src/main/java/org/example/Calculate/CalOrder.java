package org.example.Calculate;

import java.util.Stack;

public interface CalOrder {
    void calMultiplyDivide();
    int calPlusMinus();
    void setStack(Stack<String> expressionStack);
}

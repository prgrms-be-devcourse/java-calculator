package org.example.Calculate;

import java.util.Stack;

public interface CalOrder {
    void setStack(Stack<String> expressionStack);

    int calculate();
}

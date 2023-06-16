package org.example.Calculate;

import java.util.Stack;

public class CalculateImpl implements Calculate {
    CalOrder calOrder;

    public CalculateImpl(CalOrder calOrder) {
        this.calOrder = calOrder;
    }

    public int calculate(Stack<String> expressionStack) {
        calOrder.setStack(expressionStack);
        return calOrder.calculate();
    }
}

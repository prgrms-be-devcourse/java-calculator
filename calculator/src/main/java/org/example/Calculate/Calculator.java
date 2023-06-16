package org.example.Calculate;

import java.util.Stack;

public class Calculator implements Calculate {
    CalOrder calOrder;

    public Calculator(CalOrder calOrder) {
        this.calOrder = calOrder;
    }

    public int calculate(Stack<String> expressionStack) {
        calOrder.setStack(expressionStack);
        return calOrder.calculate();
    }
}

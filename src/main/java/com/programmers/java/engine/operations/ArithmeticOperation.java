package com.programmers.java.engine.operations;

import com.programmers.java.engine.domain.Operand;
import com.programmers.java.engine.domain.Operator;

public interface ArithmeticOperation {
    Operand operation(Operand a, Operand b, Operator opt);
}

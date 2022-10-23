package com.programmers.java.application;

import com.programmers.java.engine.operator.Divide;
import com.programmers.java.engine.operator.Minus;
import com.programmers.java.engine.operator.Multiply;
import com.programmers.java.engine.operator.Plus;

public class Operator implements Plus, Minus, Multiply, Divide {
    @Override
    public double divide(Double lhs, Double rhs) {

        return 0;
    }

    @Override
    public double minus(Double lhs, Double rhs) {

        return 0;
    }

    @Override
    public double multiply(Double lhs, Double rhs) {

        return 0;
    }

    @Override
    public double plus(Double lhs, Double rhs) {

        return 0;
    }
}

package com.devcourse.calc.model;

import java.util.Stack;

public interface Token {
    void deal(Stack<Integer> calculationResult);
}

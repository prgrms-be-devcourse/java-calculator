package com.programmers.java.engine.util.translator;

import com.programmers.java.engine.model.Expression;
import com.programmers.java.engine.util.Operator;

import java.util.ArrayDeque;
import java.util.Deque;

public abstract class Translator {
    protected Deque<Operator> deque;

    public Translator() {
        this.deque = new ArrayDeque<>();
    }

    public abstract Expression translate(Expression origin);
}

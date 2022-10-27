package com.programmers.calculate.engine.model;

import com.programmers.calculate.engine.model.io.Output;

public interface History {
    void save(String expression);
    void findAll(Output output);
}

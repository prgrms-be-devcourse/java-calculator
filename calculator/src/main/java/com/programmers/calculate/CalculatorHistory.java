package com.programmers.calculate;

import com.programmers.calculate.engine.io.Output;
import com.programmers.calculate.engine.model.History;

import java.util.*;

public class CalculatorHistory implements History {
    private final Map<Long, String> history = new HashMap<>();
    private Long key = 0L;
    private Console console;

    @Override
    public void save(String expression) {
        history.put(++key, expression);
    }

    @Override
    public void findAll(Output output) {
        output.printMapValues(history);
    }
}

package com.programmers.calculator.engine.io;

import java.util.Map;

public interface Output {
    void endNotification();

    void calculateResult(String s);

    void formulaList(Map<Integer, String> map);
}

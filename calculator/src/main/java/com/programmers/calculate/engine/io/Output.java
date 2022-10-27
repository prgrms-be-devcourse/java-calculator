package com.programmers.calculate.engine.io;

import java.util.Map;

public interface Output {
    void valueError();
    void printMapValues(Map<Long, String> map);
}

package com.programmers.calculate.engine.model.io;

import java.util.Map;

public interface Output {
    void printErrorMessage();
    void printMapValues(Map<Long, String> map);
}

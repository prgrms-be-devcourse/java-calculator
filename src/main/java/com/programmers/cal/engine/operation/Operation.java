package com.programmers.cal.engine.operation;

import java.util.List;

public interface Operation {
    String calculate(List<String> postfixTokens);
}

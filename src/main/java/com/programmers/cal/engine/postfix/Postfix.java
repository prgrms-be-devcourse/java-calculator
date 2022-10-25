package com.programmers.cal.engine.postfix;

import java.util.List;

public interface Postfix {
    List<String> toPostfix(List<String> tokens);
}

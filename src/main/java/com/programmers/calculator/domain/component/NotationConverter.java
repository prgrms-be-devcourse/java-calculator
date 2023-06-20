package com.programmers.calculator.domain.component;

import java.util.List;

public interface NotationConverter {
    List<String> convert(List<String> tokens);
}

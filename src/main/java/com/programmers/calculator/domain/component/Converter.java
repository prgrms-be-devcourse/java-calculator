package com.programmers.calculator.domain.component;

import java.util.List;

public interface Converter {
    List<String> convert(List<String> tokens);
}

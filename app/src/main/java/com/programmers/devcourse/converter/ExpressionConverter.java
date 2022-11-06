package com.programmers.devcourse.converter;

import java.util.List;

public interface ExpressionConverter {
    void convert(String input);

    List<String> getConvertedList();

    void clearConvertedList();
}

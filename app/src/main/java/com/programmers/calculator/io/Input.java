package com.programmers.calculator.io;

import com.programmers.calculator.model.Expression;

public interface Input {
    String inputMenu(String prompt);

    Expression inputExpression();
}

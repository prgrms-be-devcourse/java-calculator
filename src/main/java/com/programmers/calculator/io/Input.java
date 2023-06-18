package com.programmers.calculator.io;

import com.programmers.calculator.domain.Expression;
import com.programmers.calculator.domain.Menu;

public interface Input {
    Menu selectMenu();

    Expression readExpression();
}

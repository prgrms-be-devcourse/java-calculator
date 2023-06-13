package com.programmers.io;

import com.programmers.Expression;
import com.programmers.Menu;

public interface Input {
    Menu selectMenu();

    Expression readExpression();
}

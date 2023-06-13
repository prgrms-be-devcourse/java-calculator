package com.programmers.io;

import com.programmers.domain.Expression;
import com.programmers.domain.Menu;

public interface Input {
    Menu selectMenu();

    Expression readExpression();
}

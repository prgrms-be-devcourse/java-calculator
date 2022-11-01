package com.programmers.cal.engine.postfix;

import com.programmers.cal.engine.model.OriginalExpression;
import com.programmers.cal.engine.model.PostfixExpression;

public interface Postfix {
    PostfixExpression toPostfix(OriginalExpression tokens);
}

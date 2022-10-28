package com.programmers.cal.engine.postfix;

import com.programmers.cal.engine.model.OriginalExpression;
import com.programmers.cal.engine.model.PostfixExpression;

import java.util.List;

public interface Postfix {
    PostfixExpression toPostfix(OriginalExpression tokens);
}

package com.programmers.cal.engine.operation;

import com.programmers.cal.engine.model.Answer;
import com.programmers.cal.engine.model.PostfixExpression;

import java.util.List;

public interface Operation {
    Answer calculate(PostfixExpression postfixTokens);
}

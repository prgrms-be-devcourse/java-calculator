package com.programmers.cal.engine.parse;

import com.programmers.cal.engine.model.InputData;
import com.programmers.cal.engine.model.OriginalExpression;

public interface Parser {
    OriginalExpression getTokenList(InputData inputData);
}

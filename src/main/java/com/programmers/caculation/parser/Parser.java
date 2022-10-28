package com.programmers.caculation.parser;

import com.programmers.caculation.dto.ParseResponseDto;
import com.programmers.caculation.model.NumberAndOperator;

import java.util.Collection;

public interface Parser {
    ParseResponseDto parse(Collection<NumberAndOperator> numOrOp);
}

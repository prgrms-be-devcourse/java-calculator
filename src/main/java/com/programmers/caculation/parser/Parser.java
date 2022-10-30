package com.programmers.caculation.parser;

import com.programmers.caculation.dto.ParseResponseDto;
import com.programmers.caculation.model.NumberAndOperator;

import java.util.List;

public interface Parser {
    ParseResponseDto parse(List<NumberAndOperator> numOrOp);
}

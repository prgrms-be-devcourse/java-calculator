package com.programmers.caculation;

import com.programmers.Service;
import com.programmers.caculation.dto.ParseResponseDto;
import com.programmers.caculation.model.NumberAndOperator;
import com.programmers.caculation.parser.Parser;
import lombok.AllArgsConstructor;

import java.util.Collection;
@AllArgsConstructor
public class ParseService implements Service {
    private Parser parser;
    public ParseResponseDto parseRequest(Collection<NumberAndOperator> numOrOp){
        ParseResponseDto parsedExpression = parser.parse(numOrOp);
        return parsedExpression;
    }
}

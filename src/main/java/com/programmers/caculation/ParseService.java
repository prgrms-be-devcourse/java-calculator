package com.programmers.caculation;

import com.programmers.Service;
import com.programmers.caculation.dto.ParseResponseDto;
import com.programmers.caculation.model.NumberAndOperator;
import com.programmers.caculation.parser.Parser;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ParseService implements Service {
    private Parser parser;
    public ParseResponseDto parseRequest(List<NumberAndOperator> numOrOp){
        return parser.parse(numOrOp);
    }
}

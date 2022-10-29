package com.programmers.caculation;

import com.programmers.Service;
import com.programmers.caculation.dto.TokenizeRequestDto;
import com.programmers.caculation.dto.TokenizeResponseDto;
import com.programmers.caculation.model.NumberAndOperator;
import com.programmers.caculation.toeknizer.Tokenizer;
import lombok.AllArgsConstructor;

import java.util.Collection;
@AllArgsConstructor
public class TokenizeService implements Service {
    private Tokenizer tokenizer;
    TokenizeResponseDto tokenize(TokenizeRequestDto tokenizeRequestDto) throws Exception{
        String expression = tokenizeRequestDto.value;
        Collection<NumberAndOperator> tokenizedExpression = tokenizer.tokenize(expression);
        return TokenizeResponseDto.from(tokenizedExpression);
    }
}

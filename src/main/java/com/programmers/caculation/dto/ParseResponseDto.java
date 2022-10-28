package com.programmers.caculation.dto;

import com.programmers.caculation.model.NumberAndOperator;

import java.util.Collection;

public class ParseResponseDto {

    public final Collection<NumberAndOperator> parsedExpression;
    public ParseResponseDto(Collection<NumberAndOperator> parsedExpression){
        this.parsedExpression=parsedExpression;
    }
//    public static final ParseResponseDto from()
}

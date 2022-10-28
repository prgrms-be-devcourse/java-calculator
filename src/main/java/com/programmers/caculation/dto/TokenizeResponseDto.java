package com.programmers.caculation.dto;

import com.programmers.caculation.model.NumberAndOperator;
import lombok.AllArgsConstructor;

import java.util.Collection;
@AllArgsConstructor
public class TokenizeResponseDto {
    public final Collection<NumberAndOperator> value;

    public static final TokenizeResponseDto from(Collection<NumberAndOperator> value){
        return new TokenizeResponseDto(value);
    }
}

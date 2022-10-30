package com.programmers.caculation.dto;

import com.programmers.caculation.model.NumberAndOperator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class TokenizeResponseDto {
    public final List<NumberAndOperator> value;

    public static TokenizeResponseDto from(List<NumberAndOperator> value){
        return new TokenizeResponseDto(value);
    }
}

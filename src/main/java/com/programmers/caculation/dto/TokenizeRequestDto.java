package com.programmers.caculation.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TokenizeRequestDto {
    public final String value;
    public static final TokenizeRequestDto from(String input){
        return new TokenizeRequestDto(input);
    }
}

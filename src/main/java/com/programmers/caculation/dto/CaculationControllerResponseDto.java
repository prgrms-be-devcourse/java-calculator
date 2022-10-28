package com.programmers.caculation.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CaculationControllerResponseDto {
    public final String result;
    public static final CaculationControllerResponseDto from(String result){
        return new CaculationControllerResponseDto(result);
    }
}

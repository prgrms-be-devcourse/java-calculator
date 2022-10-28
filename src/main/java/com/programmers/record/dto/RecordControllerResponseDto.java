package com.programmers.record.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RecordControllerResponseDto {
    public final String allRecord;
    public static final RecordControllerResponseDto from(String input){
        return new RecordControllerResponseDto(input);
    }
}

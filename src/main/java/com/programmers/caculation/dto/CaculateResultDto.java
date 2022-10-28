package com.programmers.caculation.dto;

import lombok.AllArgsConstructor;

import java.text.DecimalFormat;

@AllArgsConstructor
public class CaculateResultDto {
    public final String value;
    private static final DecimalFormat df = new DecimalFormat("0.####");
    public static final CaculateResultDto from(Double value) {
        return new CaculateResultDto(df.format(value));
    }
}

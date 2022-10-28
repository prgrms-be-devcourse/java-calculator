package com.project.java.engine.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResultFormat {
    private final String FIXED_POINT = "%.4f";
    String expression;
    double result;

    public String formatResult() {
        String formattedResult;
        if(result == Long.MIN_VALUE) {
            // Long.MIN_VALUE 라면 오류인 문제이므로 출력하지 않음
            formattedResult = "";
        }
        else if(Math.floor(result) == result) {
            long longResult = (long) result;
            formattedResult = String.valueOf(longResult);
        } else {
            formattedResult = String.format(FIXED_POINT, result);
        }
        return formattedResult;
    }

}

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
        if(Math.floor(result) == result) {
            long longResult = (long) result;
            formattedResult = String.valueOf(longResult);
        } else {
            formattedResult = String.format(FIXED_POINT, result);
        }
        return formattedResult;
    }

}

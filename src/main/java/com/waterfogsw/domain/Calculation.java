package com.waterfogsw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Calculation {
    private Long id;
    private String formula; // 계산식
    private String result;  // 계산결과

    @Override
    public String toString() {
        return formula + " = " + result;
    }
}

package com.devcourse.engine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Menu {
    EXIT("0", "종료"),
    HISTORY("1", "조회"),
    COMPUTE("2", "계산");

    private String menuOrdinal;
    private String menuValue;
}

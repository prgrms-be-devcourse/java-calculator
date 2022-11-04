package com.programmers.java.engine.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Answer {
    private Double value;
    private String stringValue;

    @Builder
    public Answer(Double value) {
        this.value = value;
        if (checkInt()) {
            stringValue = String.valueOf(value.longValue());
        } else {
            stringValue = String.format("%.3f", value);
        }
    }

    public boolean checkInt() {
        if (this.value == Math.floor(this.value)) {
            return true;
        } else {
            return false;
        }
    }
}

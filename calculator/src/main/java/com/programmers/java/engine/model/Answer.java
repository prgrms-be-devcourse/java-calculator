package com.programmers.java.engine.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Answer {
    private Double value;

    @Builder
    public Answer(Double value) {
        this.value = value;
    }

    public boolean checkInt() {
        if (this.value == Math.floor(this.value)) {
            return true;
        } else {
            return false;
        }
    }
}

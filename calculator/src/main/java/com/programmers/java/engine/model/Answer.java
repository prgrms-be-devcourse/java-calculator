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
}

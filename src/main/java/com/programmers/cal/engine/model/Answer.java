package com.programmers.cal.engine.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Answer {
    private String answer;

    @Builder
    public Answer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return answer;
    }
}

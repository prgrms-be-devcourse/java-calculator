package com.bona.javacalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InputAndAnswer {
    private Long id;
    private String input;
    private Double answer;

    public InputAndAnswer() {
    }

    public InputAndAnswer(String input, Double answer) {
        this.input = input;
        this.answer = answer;
    }
}

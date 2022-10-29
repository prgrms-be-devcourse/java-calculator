package com.programmers.cal.engine.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Equation {
    private InputData inputData;
    private Answer answer;

    @Builder
    public Equation(InputData inputData, Answer answer) {
        this.inputData = inputData;
        this.answer = answer;
    }

    public static Equation toEquation(InputData inputData, Answer answer) {
        return Equation.builder()
                .inputData(inputData)
                .answer(answer)
                .build();
    }

    @Override
    public String toString() {
        return inputData + " = " + answer;
    }
}

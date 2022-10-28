package com.programmers.cal.engine.model;

import lombok.*;

@Getter
@NoArgsConstructor
public class InputData {
    private String inputString;

    @Builder
    public InputData(String inputString) {
        this.inputString = inputString;
    }

    public InputData toInputData(String inputString) {
        return InputData.builder()
                .inputString(inputString)
                .build();
    }

    @Override
    public String toString() {
        return inputString;
    }
}

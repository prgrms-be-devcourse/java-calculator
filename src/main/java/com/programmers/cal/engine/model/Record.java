package com.programmers.cal.engine.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class Record {
    private List<Equation> equations;

    @Builder
    public Record(List<Equation> equations) {
        this.equations = equations;
    }

    public boolean isEmpty(Record record) {
        if (record.getEquations().isEmpty()) {
            return true;
        }
        return false;
    }

}

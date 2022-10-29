package com.programmers.java.engine.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
public class History {
    private Map<StringExpression, Answer> equations = new LinkedHashMap<>();

    public void addEquation(StringExpression expression, Answer answer) {
        equations.put(expression, answer);
    }

    public List<Equation> mapToList() {
        List<Equation> equationList = new ArrayList<>();

        for (Map.Entry<StringExpression, Answer> equation : equations.entrySet()) {
            equationList.add(
                    Equation.builder()
                            .expression(equation.getKey())
                            .answer(equation.getValue())
                            .build()
            );
        }

        return equationList;
    }

    public boolean isNew(Equation equation) {
        if (equations.containsKey(equation)) {
            return false;
        } else {
            return true;
        }
    }
}

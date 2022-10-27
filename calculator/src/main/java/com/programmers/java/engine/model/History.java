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
    private Map<Expression, Answer> equations = new LinkedHashMap<>();

    public void addEquation(Expression expression, Answer answer) {
        equations.put(expression, answer);
    }

    public List<Equation> mapToList() {
        ArrayList<Equation> equationList = new ArrayList<>();

        for (Map.Entry<Expression, Answer> equation : equations.entrySet()) {
            equationList.add(
                    Equation.builder()
                            .expression(equation.getKey())
                            .answer(equation.getValue())
                            .build()
            );
        }

        return equationList;
    }

}

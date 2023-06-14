package org.example.repository;

import java.util.List;
import java.util.ArrayList;

public class MemoryEquationRepository implements EquationRepository {
    private final List<String> savedEquations = new ArrayList<>();

    @Override
    public void save(String equation ,double answer) {
        savedEquations.add(combineEquationAnswer(equation, answer));
    }

    private String combineEquationAnswer(String equation, double answer) {
        return equation + " = " + String.valueOf(answer);
    }

    @Override
    public String[] findAll() {
        return savedEquations.toArray(new String[savedEquations.size()]);
    }
}

package org.example.repository;

import java.util.List;
import java.util.ArrayList;

public class MemoryEquationRepository implements EquationRepository {
    private List<String> saveList = new ArrayList<>();

    @Override
    public void save(String equation ,double answer) {
        saveList.add(combineEquationAnswer(equation, answer));
    }

    private String combineEquationAnswer(String equation, double answer) {
        return equation + " = " + String.valueOf(answer);
    }

    @Override
    public String[] findAll() {
        String[] resultArr = saveList.toArray(new String[saveList.size()]);
        return resultArr;
    }
}

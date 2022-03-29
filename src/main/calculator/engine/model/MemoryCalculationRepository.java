package main.calculator.engine.model;

import java.util.ArrayList;
import java.util.List;

public class MemoryCalculationRepository implements CalculationRepository{
    //기억할 list 필요
    private ArrayList<String> list = new ArrayList<>();

    @Override
    public void save(String content, String result) {
        list.add(content + " = " + result);
    }

    @Override
    public List<String> findAll() {
        return list;
    }
}

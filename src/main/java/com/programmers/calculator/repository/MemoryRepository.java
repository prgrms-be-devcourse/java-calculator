package com.programmers.calculator.repository;

import com.programmers.calculator.model.CalcData;

import java.util.ArrayList;
import java.util.List;

public class MemoryRepository implements Repository {
    ArrayList<CalcData> list = new ArrayList<>();

    @Override
    public void save(CalcData calcData) {
        list.add(calcData);
    }

    @Override
    public List<CalcData> getAll() {
        return list;
    }
}
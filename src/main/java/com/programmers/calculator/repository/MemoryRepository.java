package com.programmers.calculator.repository;

import com.programmers.calculator.entity.CalcData;

import java.util.ArrayList;

public class MemoryRepository {
    ArrayList<CalcData> list = new ArrayList<>();

    public void save(CalcData calcData) {
        list.add(calcData);
    }

    public void printAll() {
        list.forEach((v) ->
                System.out.println(v.getCalcFormula() + " = " + v.getResult()));
        System.out.println();
    }
}

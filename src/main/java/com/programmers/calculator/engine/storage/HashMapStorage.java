package com.programmers.calculator.engine.storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage implements Storage {
    private final Map<Integer, String> calculationResult = new HashMap<>();
    private int mapIndex = 1;

    @Override
    public void save(String result) {
        calculationResult.put(mapIndex++, result);
    }

    @Override
    public void findAll() {
        System.out.println("################## 계산 내역 #################");
        if (mapIndex == 1) {
            System.out.println("계산 내역이 없습니다.");
            return;
        }
        calculationResult
                .forEach((k, v) -> System.out.println(k + ". " + v));
        System.out.println("###########################################");

    }
}

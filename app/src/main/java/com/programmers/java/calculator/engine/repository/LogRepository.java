package com.programmers.java.calculator.engine.repository;

import java.util.HashMap;
import java.util.Map;

public class LogRepository implements Repository{

    private static final Map<Long, String> map = new HashMap<>();
    Long index = -1L;

    @Override
    public void save(String log) {
        map.put(++index, log);
    }

    @Override
    public void printLog() {
        if (index == -1L) {
            System.out.println("계산 이력이 없습니다.\n");
        } else {
            for (Long l = 0L; l <= index; l++) {
                System.out.println(findById(l));
            }
            System.out.println();
        }
    }

    @Override
    public String findById(Long id) {
        return map.get(id);
    }
}

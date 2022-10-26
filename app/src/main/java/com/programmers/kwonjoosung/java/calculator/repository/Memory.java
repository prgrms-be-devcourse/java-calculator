package com.programmers.kwonjoosung.java.calculator.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Memory implements Repository {
    private final List<String> HISTORY = new ArrayList<>(); // 계산 결과를 저장하기 위한 자료구조(Map보다 ArrayList가 순차적으로 계산 결과를 불러오기에 더 유리하다고 생각함)
    private static int size = 0;

    @Override
    public void save(String[] expression, String result) {
        HISTORY.add(String.join(" ", expression) + " = " + result);
        size++;
    }

    @Override
    public Optional<String> getHistory(int index) {
        if (index >= size) return Optional.empty(); // Optional을 사용하는게 옳은 방법인가?
        return Optional.of(HISTORY.get(index));
    }

}

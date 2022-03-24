package com.programmers.calculator.repository;

import com.programmers.calculator.entity.CalcData;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryRepository {
    Map<Long, CalcData> map = new HashMap<>();

    public void save(CalcData calcData) {
        map.put(calcData.getId(), calcData);
    }

    public Optional<CalcData> get(long l) {
        return Optional.ofNullable(map.getOrDefault(l, null));
    }
}

package com.bona.javacalculator.repository;

import com.bona.javacalculator.model.InputAndAnswer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CalMemoryRepository implements MemoryRepository{

    private static final Map<Long, InputAndAnswer> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public InputAndAnswer save(InputAndAnswer inputAndAnswer) {
        inputAndAnswer.setId(++sequence);
        store.put(inputAndAnswer.getId(),inputAndAnswer);
        return inputAndAnswer;
    }

    @Override
    public InputAndAnswer findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<InputAndAnswer> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void clearStore() {
        store.clear();
    }

    @Override
    public int size() {
        return store.size();
    }
}

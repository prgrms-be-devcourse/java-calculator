package com.prgrms.ndy.repository;

import com.prgrms.ndy.domain.Calculation;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class HashMapCalculationRepository implements CalculationRepository {

    private long id;
    private final Map<Long, Calculation> store = new HashMap<>();

    @Override
    public Optional<Long> save(Calculation calculation) {
        log.info("save : {}", calculation);

        store.put(++id, calculation);
        calculation.setId(id);

        return Optional.of(id);
    }

    @Override
    public List<Calculation> findAll() {
        log.info("findAll");

        return new ArrayList<>(store.values());
    }

    @Override
    public int clear() {
        log.debug("clear");

        int size = store.size();
        id = 0;
        store.clear();
        return size;
    }
}

package org.calculator.repository;


import org.calculator.engine.domain.History;

import java.util.ArrayList;
import java.util.List;

public class CalculateRepositoryImpl implements CalculateRepository {
    private static final List<History> histories = new ArrayList<>();

    @Override
    public void save(History history) {
        histories.add(history);
    }

    @Override
    public List<History> getHistory() {
        return histories;
    }
}

package org.calculator.repository;


import org.calculator.engine.domain.History;

import java.util.List;

public interface CalculateRepository {

    void save(History history);

    List<History> getHistory();
}

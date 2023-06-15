package org.programmers.java.repository;

import java.util.Map;

public interface FormulaRepository {
    void save(String formulaAndResult);
    Map<Long, String> getFormulaList();
}

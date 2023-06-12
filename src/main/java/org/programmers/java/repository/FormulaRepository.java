package org.programmers.java.repository;

import java.util.List;
import java.util.Map;

public interface FormulaRepository {
    String save(String formula, String caculateValue);
    Map<Long, String> getFormulaList();
}

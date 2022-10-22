package com.programmers.java.repository;

import java.util.List;

public interface Repository {
    void save(String formula, Integer result);

    boolean haveFormulaResult(String formula);

    int findFormulaResult(String formula);

    List<String> findAllHistory();
}

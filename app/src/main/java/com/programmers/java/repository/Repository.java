package com.programmers.java.repository;

import com.programmers.java.model.History;

import java.util.List;

public interface Repository {
    void save(String formula, History history);

    boolean haveFormulaResult(String formula);

    int findFormulaResult(String formula);

    List<History> findAllHistory();
}

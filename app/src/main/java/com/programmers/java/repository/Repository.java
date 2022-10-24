package com.programmers.java.repository;

import java.util.List;

import com.programmers.java.model.History;

public interface Repository {
	void save(String formula, History history);

	boolean haveFormulaResult(String formula);

	int findFormulaResult(String formula);

	List<History> findAllHistory();
}

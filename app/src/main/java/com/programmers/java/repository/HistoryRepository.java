package com.programmers.java.repository;

import java.util.List;

import com.programmers.java.model.History;

public interface HistoryRepository {
	void save(String formula, History history);

	boolean haveResult(String formula);

	int findResult(String formula);

	List<History> findAllHistory();
}

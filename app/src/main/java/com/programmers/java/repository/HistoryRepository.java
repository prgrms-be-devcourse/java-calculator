package com.programmers.java.repository;

import java.util.List;
import java.util.Optional;

import com.programmers.java.model.History;

public interface HistoryRepository {
	void save(String formula, History history);

	Optional<History> findHistory(String formula);

	List<History> findAllHistory();
}

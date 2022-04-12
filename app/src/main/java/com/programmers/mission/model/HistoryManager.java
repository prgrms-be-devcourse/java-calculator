package com.programmers.mission.model;

import java.util.List;

public interface HistoryManager<T> {
	void save(T calculationResult);

	List<T> getHistories();
}

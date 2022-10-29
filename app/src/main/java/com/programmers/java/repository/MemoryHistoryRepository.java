package com.programmers.java.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.programmers.java.model.History;

public class MemoryHistoryRepository implements HistoryRepository {
	private static HashMap<String, History> repository = new LinkedHashMap<>();

	@Override
	public void save(String formula, History history) {
		repository.put(formula, history);
	}

	@Override
	public boolean haveResult(String formula) {
		return repository.containsKey(formula);
	}

	@Override
	public int findResult(String formula) {
		return repository.get(formula).getResult();
	}

	@Override
	public List<History> findAllHistory() {
		return new ArrayList<>(repository.values());
	}
}

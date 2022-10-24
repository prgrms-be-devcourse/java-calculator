package com.programmers.java.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.programmers.java.model.History;

public class HistoryRepository implements Repository {
	private static HashMap<String, History> repository = new LinkedHashMap<>();

	@Override
	public void save(String formula, History history) {
		repository.put(formula, history);
	}

	@Override
	public boolean haveFormulaResult(String formula) {
		return repository.containsKey(formula);
	}

	@Override
	public int findFormulaResult(String formula) {
		return repository.get(formula).getResult();
	}

	@Override
	public List<History> findAllHistory() {
		List<History> history = new ArrayList<>();

		repository.keySet()
			.forEach(i -> history.add(repository.get(i)));

		return history;
	}
}

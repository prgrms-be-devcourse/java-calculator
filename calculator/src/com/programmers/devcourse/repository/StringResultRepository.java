package com.programmers.devcourse.repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringResultRepository implements ResultRepository<String, Double> {

	private final Map<String, Double> resultMap;

	public StringResultRepository() {
		this.resultMap = new LinkedHashMap<>();

	}

	@Override
	public void save(String expression, Double result) {
		resultMap.put(expression, result);
	}

	@Override
	public Map<String, Double> getAll() {
		return new LinkedHashMap<>(this.resultMap);

	}

}

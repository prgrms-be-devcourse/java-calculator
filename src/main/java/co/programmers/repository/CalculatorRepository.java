package co.programmers.repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorRepository implements Repository {
	private static final Map<String, Double> storage = new LinkedHashMap<>();

	@Override
	public void save(String expression, Double result) {
		storage.put(expression, result);
	}

	@Override
	public Map<String, Double> read() {
		return storage;
	}
}

package com.programmers.calculator.engine.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MemoryCalculatorRepository implements CalculatorRepository {
	private Map<String, String> memory = new HashMap<>();

	@Override
	public void save(String formula, String answer) {
		Objects.requireNonNull(formula);
		Objects.requireNonNull(answer);

		memory.put(formula, answer);
	}

	@Override
	public void clear() {
		memory.clear();
	}

	@Override
	public int size() {
		return memory.size();
	}

	@Override
	public String values() {
		StringBuilder builder = new StringBuilder();

		memory.keySet().stream().forEach(s -> {
			builder.append(s + " = " + memory.get(s) + "\n");
		});

		return builder.toString();
	}

	@Override
	public String findByFormula(String formula) {
		Objects.requireNonNull(formula);

		return memory.get(formula);
	}

	@Override
	public boolean alreadyCalculated(String formula) {
		Objects.requireNonNull(formula);

		return memory.containsKey(formula);
	}
}

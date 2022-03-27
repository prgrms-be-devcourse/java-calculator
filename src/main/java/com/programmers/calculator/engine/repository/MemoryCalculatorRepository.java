package com.programmers.calculator.engine.repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MemoryCalculatorRepository implements CalculatorRepository{
	private LinkedHashMap<String, String> memory = new LinkedHashMap<>();

	@Override
	public void save(String formula, String answer) {
		memory.put(formula,answer);
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

}

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

	/**
	 * 현재까지 진행된 계산 기록들을 전부 String으로 반환
	 * @return 계산 기록
	 */
	@Override
	public String values() {
		StringBuilder builder = new StringBuilder();

		memory.keySet().stream().forEach(s -> {
			builder.append(s + " = " + memory.get(s) + "\n");
		});

		return builder.toString();
	}

	/**
	 * 기록된 연산을 반환하는 메서드
	 *
	 * @param formula
	 * @return 메모리에 저장된 정답 반환
	 */
	@Override
	public String findByFormula(String formula) {
		Objects.requireNonNull(formula);

		return memory.get(formula);
	}

	/**
	 * 이미 연산을 실시한 기록이 있는지 확인하는 메서드
	 *
	 * @param formula
	 * @return 기록이 있다면 true, 없다면 false
	 */
	@Override
	public boolean alreadyCalculated(String formula) {
		Objects.requireNonNull(formula);

		return memory.containsKey(formula);
	}
}

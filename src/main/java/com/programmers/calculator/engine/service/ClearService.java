package com.programmers.calculator.engine.service;

import java.util.Objects;

import com.programmers.calculator.engine.repository.CalculatorRepository;

public class ClearService implements CalculatorService {

	/**
	 * repository의 메모리를 clear하는 메서드
	 *
	 * @param repository
	 * @param formula
	 * @return 초기화 완료 메세지
	 */
	@Override
	public String execute(CalculatorRepository repository, String formula) {
		Objects.requireNonNull(repository);

		repository.clear();
		return "메모리 초기화 완료!\n";
	}
}

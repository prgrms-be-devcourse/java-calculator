package com.programmers.calculator.engine.service;

import java.util.Objects;

import com.programmers.calculator.engine.repository.CalculatorRepository;

public class InquiryService implements CalculatorService {

	/**
	 * 메모리에 저장되어있는 계산값들을 반환하는 메서드
	 *
	 * @param repository
	 * @param formula
	 * @return memory의 기록 반환
	 */
	@Override
	public String execute(CalculatorRepository repository, String formula) {
		Objects.requireNonNull(repository);

		return repository.values();
	}
}

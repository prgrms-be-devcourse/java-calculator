package com.programmers.calculator.engine.service;

import java.util.Objects;

import com.programmers.calculator.engine.repository.CalculatorRepository;

public class InquiryService implements CalculatorService {

	@Override
	public String execute(CalculatorRepository repository, String formula) {
		Objects.requireNonNull(repository);

		return repository.values();
	}
}

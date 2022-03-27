package com.programmers.calculator.engine.service;

import com.programmers.calculator.engine.repository.CalculatorRepository;

public class InquiryService implements CalculatorService{

	@Override
	public String execute(CalculatorRepository repository, String formula) {
		return repository.values();

	}
}

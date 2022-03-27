package com.programmers.calculator.engine.service;

import com.programmers.calculator.engine.repository.CalculatorRepository;

public class ClearService implements CalculatorService{

	@Override
	public String execute(CalculatorRepository repository) {
		repository.clear();
		return "메모리 초기화 완료!\n";
	}
}

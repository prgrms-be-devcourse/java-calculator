package com.programmers.calculator.engine.service;

import com.programmers.calculator.engine.repository.CalculatorRepository;

public interface CalculatorService {
	String execute(CalculatorRepository repository,String formula);
}

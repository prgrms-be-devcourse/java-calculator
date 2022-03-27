package com.programmers.calculator.engine.service;

import com.programmers.calculator.engine.repository.CalculatorRepository;
import com.programmers.calculator.engine.util.ArithmeticUnit;
import com.programmers.calculator.engine.Parser;

public class CalculateService implements CalculatorService {
	private ArithmeticUnit unit;

	@Override
	public String execute(CalculatorRepository repository, String formula) {
		if (repository.alreadyCalculated(formula)) {
			return repository.findByFormula(formula);
		}

		String answer = ArithmeticUnit.calculate(formula);
		repository.save(formula, answer);
		return answer;
	}
}

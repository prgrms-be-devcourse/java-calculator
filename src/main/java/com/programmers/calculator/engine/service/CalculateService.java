package com.programmers.calculator.engine.service;

import java.util.Objects;

import com.programmers.calculator.engine.repository.CalculatorRepository;
import com.programmers.calculator.engine.util.ArithmeticUnit;

public class CalculateService implements CalculatorService {
	private ArithmeticUnit unit;

	/**
	 * 이미 계산된 기록이 있을 경우 계산 된 값 기록(캐시 역할)
	 * 계산이 되지 않았다면 연산기를 통해 계산을 진행한 뒤 저장하고 답을 반환
	 *
	 * @param repository
	 * @param formula
	 * @return 입력받은 formula에 연산을 실시한 뒤 답을 반환
	 */
	@Override
	public String execute(CalculatorRepository repository, String formula) {
		Objects.requireNonNull(repository);
		Objects.requireNonNull(formula);

		if (repository.alreadyCalculated(formula)) {
			return repository.findByFormula(formula);
		}

		String answer = ArithmeticUnit.calculate(formula);
		repository.save(formula, answer);
		return answer;
	}
}

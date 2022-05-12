package com.programmers.java;

import java.util.List;
import java.util.Optional;

import com.programmers.java.engine.io.Console;
import com.programmers.java.engine.model.FormulaAndResult;
import com.programmers.java.engine.repository.MemoryFormulaRepository;
import com.programmers.java.engine.service.CalculationService;
import com.programmers.java.engine.service.FormulaValidationService;
import com.programmers.java.engine.service.PostFixService;
import com.programmers.java.engine.utils.Function;

public class Calculator implements Runnable {

	private static final int EXIT = -100;
	private static final int INVALID_INPUT = -1;
	private static final int INQUIRE = 1;
	private static final int CALCULATE = 2;

	private final FormulaValidationService formulaValidationService = new FormulaValidationService();
	private final PostFixService postFixService = new PostFixService();
	private final MemoryFormulaRepository formulaRepository = new MemoryFormulaRepository();
	private final CalculationService calculationService = new CalculationService();
	private final Console console = new Console();

	@Override
	public void run() {
		boolean isRunnable = true;

		while (isRunnable) {
			String input = console.input("1. 조회" + "\n2. 계산");
			int inputNumber = Parse(input);

			switch (inputNumber) {
				case INQUIRE: {
					inquiryHistory();
					break;
				}
				case CALCULATE: {
					calculate();
					break;
				}
				case EXIT: {
					isRunnable = false;
					break;
				}
				default: {
					console.printInfoMessage("잘못된 입력입니다.");
					break;
				}
			}
		}
	}

	private void inquiryHistory() {
		List<FormulaAndResult> history = formulaRepository.findAll();
		if (history.isEmpty()) {
			console.printInfoMessage("계산 기록이 존재하지 않습니다.");

			return;
		}
		console.printHistory(history);
	}

	private void calculate() {
		String inputFormula = console.input("식을 입력해주세요.");
		Optional<String> formulaOrEmpty = checkValidFormula(inputFormula);
		if (formulaOrEmpty.isEmpty()) {
			return;
		}

		String[] postFixFormula = postFixService.makePostFixFormula(formulaOrEmpty.get());
		long result = calculationService.calculate(postFixFormula);
		formulaRepository.save(new FormulaAndResult(inputFormula, result));

		console.printCalcResultMessage(result);
	}

	private Optional<String> checkValidFormula(String inputFormula) {
		Optional<String> formulaOrEmpty = formulaValidationService.validation(inputFormula);

		if (formulaOrEmpty.isEmpty()) {
			console.printInfoMessage("잘못된 입력입니다.");

			return Optional.empty();
		}
		return formulaOrEmpty;
	}

	private int Parse(String inputString) {
		if (inputString.isBlank()) {
			return EXIT;
		}

		if (!Function.isStrDigit(inputString)) {
			return INVALID_INPUT;
		}

		return Integer.parseInt(inputString);
	}
}

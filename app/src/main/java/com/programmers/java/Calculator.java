package com.programmers.java;

import java.util.Stack;

import com.programmers.java.exception.DivideByZeroException;
import com.programmers.java.exception.MenuInputException;
import com.programmers.java.io.Console;
import com.programmers.java.model.History;
import com.programmers.java.model.token.Token;
import com.programmers.java.model.token.letter.operator.Operator;
import com.programmers.java.repository.Repository;
import com.programmers.java.util.FormulaParser;
import com.programmers.java.util.Validator;

public class Calculator implements Runnable {
	private final String newLine = System.lineSeparator();
	private final String MENU = "1. 조회" + newLine + "2. 계산" + newLine + newLine + "선택 : ";
	private final String LOOKUP = "1";
	private final String CALCULATION = "2";
	private final String EXIT = "3";
	private final String EXIT_MESSAGE = "계산기를 종료합니다.";

	private Console console;
	private Repository repository;
	private Validator validator;
	private FormulaParser parser;

	public Calculator(Console console, Repository repository, Validator validator, FormulaParser parser) {
		this.console = console;
		this.repository = repository;
		this.validator = validator;
		this.parser = parser;
	}

	@Override
	public void run() {
		while (true) {
			console.printMenu(MENU);

			try {
				switch (console.inputMenuNumber()) {
					case LOOKUP:
						console.printHistory(repository.findAllHistory());
						break;
					case CALCULATION:
						String formula = validator.validateFormula(console.inputFormula());

						if (repository.haveFormulaResult(formula)) {
							console.printFormulaResult(repository.findFormulaResult(formula));
						} else {
							int calculateResult = calculate(parser.changeInfixToPostfix(formula));
							repository.save(formula, new History(formula, calculateResult));
							console.printFormulaResult(calculateResult);
						}
						break;
					case EXIT:
						console.printExit(EXIT_MESSAGE);
						return;
					default:
						throw new MenuInputException();
				}
			} catch (Exception e) {
				console.printErrorMessage(e.getMessage());
			}
		}
	}

	public int calculate(String[] parsedTokens) throws DivideByZeroException {
		Stack<Integer> numbers = new Stack<>();

		for (int i = 0; i < parsedTokens.length; i++) {
			String token = parsedTokens[i];

			if (!Operator.isOperator(token)) {
				numbers.push(Integer.parseInt(token));
			} else {
				int num2 = numbers.pop();
				int num1 = numbers.pop();

				Token operator = validator.validateCorrectToken(token);
				int result = ((Operator)operator).calculate(num1, num2);
				numbers.push(result);
			}
		}

		return numbers.pop();
	}
}

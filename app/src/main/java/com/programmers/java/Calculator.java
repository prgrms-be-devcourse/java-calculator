package com.programmers.java;

import java.util.List;
import java.util.Stack;

import com.programmers.java.exception.MenuInputException;
import com.programmers.java.io.Input;
import com.programmers.java.io.Menu;
import com.programmers.java.io.Message;
import com.programmers.java.io.Output;
import com.programmers.java.model.History;
import com.programmers.java.model.token.letter.Operator;
import com.programmers.java.repository.HistoryRepository;
import com.programmers.java.util.FormulaValidator;
import com.programmers.java.util.PostfixParser;

public class Calculator implements Runnable {

	private Input input;
	private Output output;
	private HistoryRepository repository;
	private FormulaValidator validator;
	private PostfixParser parser;

	public Calculator(Input input, Output output, HistoryRepository repository,
		FormulaValidator validator, PostfixParser parser) {
		this.input = input;
		this.output = output;
		this.repository = repository;
		this.validator = validator;
		this.parser = parser;
	}

	@Override
	public void run() {
		while (true) {
			output.response(Message.MENU_TABLE.getMessage());
			String chosenMenu = input.request();
			Menu menu = Menu.selectMenu(chosenMenu);

			try {
				switch (menu) {
					case LOOKUP:
						List<History> allHistory = repository.findAllHistory();
						output.responseHistory(allHistory);
						break;
					case CALCULATION:
						calculateProcess();
						break;
					case EXIT:
						output.response(Message.EXIT_MESSAGE.getMessage());
						return;
					default:
						throw new MenuInputException();
				}
			} catch (Exception e) {
				output.response(e.getMessage());
			}
		}
	}

	private void calculateProcess() throws Exception {
		output.response(Message.FORMULA_REQUEST.getMessage());
		String formula = input.request().replaceAll(" ", "");
		String validatedFormula = validator.validateFormula(formula);

		if (repository.haveResult(validatedFormula)) {
			int result = repository.findResult(validatedFormula);
			output.responseResult(result);
		} else {
			String[] postfixFormula = parser.changeInfixToPostfix(validatedFormula);
			int calculateResult = calculate(postfixFormula);
			repository.save(validatedFormula, new History(validatedFormula, calculateResult));
			output.responseResult(calculateResult);
		}
	}

	public int calculate(String[] parsedTokens) {
		Stack<Integer> numbers = new Stack<>();

		for (int i = 0; i < parsedTokens.length; i++) {
			String token = parsedTokens[i];

			if (Operator.isOperator(token)) {
				int num2 = numbers.pop();
				int num1 = numbers.pop();

				Operator operator = Operator.getOperatorType(token);
				int result = operator.calculate(num1, num2);
				numbers.push(result);
			} else {
				numbers.push(Integer.parseInt(token));
			}
		}

		return numbers.pop();
	}
}

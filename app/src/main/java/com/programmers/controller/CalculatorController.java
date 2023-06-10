package com.programmers.controller;

import com.programmers.calculator.Calculator;
import com.programmers.expression.Expression;
import com.programmers.storage.Storage;
import com.programmers.ui.InputView;
import com.programmers.ui.OutputView;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class CalculatorController {
	
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private Calculator calculator = new Calculator();
	private Storage storage = new Storage();
	
	public void run()  {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				outputView.init();
				String select = inputView.select(br);
				if (!isValidInput(select)) continue;
				Integer num = Integer.parseInt(select);
				if (num.equals(1)) view();
				else if (num.equals(2)) calculate(br);
				else {
					outputView.inputInOneAndTwo();
					continue;
				}
			}
		} catch (IOException e) {
			outputView.eof();
		}
	}
	
	private boolean isValidInput(String select) throws IOException {
		if (select.isEmpty()) throw new IOException();
		if (!select.matches("[0-9]+")){
			outputView.inputIsOnlyNumber();
			return false;
		} return true;
	}
	
	private void calculate(BufferedReader br) throws IOException {
		try {
			String str = inputView.expression(br);
			Expression expression = new Expression(str);
			List<String> postfix = calculator.changeInfixToPostfix(expression.getExpression());
			Integer result = calculator.calcPostfix(postfix);
			storage.save(expression, result);
			outputView.viewResult(result);
		} catch (IllegalArgumentException e) {
			outputView.invalidInputException();
		} catch (ArithmeticException e) {
			outputView.divideByZeroException();
		}
	}
	
	private void view() {
		Map<String, Integer> list = storage.findAll();
		outputView.viewList(list);
	}
	
}

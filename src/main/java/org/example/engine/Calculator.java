package org.example.engine;

import org.apache.commons.lang3.StringUtils;
import org.example.Console;
import org.example.engine.enums.ArithmeticOperator;
import org.example.exception.CaculatorApplicationException;
import org.example.engine.model.CalculationResult;
import org.example.engine.repository.CalculationRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator implements Runnable {
	private Console console;
	private CalculationRepository calculationRepository;

	public Calculator(Console console, CalculationRepository calculationRepository) {
		this.console = console;
		this.calculationRepository = calculationRepository;
	}

	@Override
	public void run() {

		while (true) {

			try {
				int mode = console.inputSelectMode();
				console.outputSelectResult(mode);
				switch (mode) {
					case 1:
						loadHistory();
						break;
					case 2:
						compute();
						break;
				}
			} catch (CaculatorApplicationException e1) {
				System.out.println(e1.getMessage());
				continue;
			} catch (IOException e2) {
				System.out.println(e2.getMessage());
				continue;
			}

		}

	}

	public void compute() throws IOException, CaculatorApplicationException {
		String inputExpression = console.inputExpression();
		String preprocessedExpression = preprocess(inputExpression);
		if (!validateExpression(preprocessedExpression)) {
			throw new CaculatorApplicationException("Invalid expression");
		}
		List<String> parseExpression = parseExpression(preprocessedExpression);
		List<String> postfixExpression = infixToPostfix(parseExpression);
		Double result = calculate(postfixExpression);
		System.out.println(result);
		saveHistory(new CalculationResult(inputExpression, result));
	}

	public void loadHistory() {
		List<CalculationResult> historyList = calculationRepository.findAll();
		for (CalculationResult calculationResult : historyList) {
			calculationResult.printInfo();
		}
	}

	public String preprocess(String rowExpression) {
		String preprocessedExpression = rowExpression.trim();
		preprocessedExpression = preprocessedExpression.replaceAll("\\s+", "");
		preprocessedExpression = preprocessedExpression.replaceAll("([+\\-*/])", " $1 ");

		return preprocessedExpression;
	}

	public boolean validateExpression(String expression) {
		String regex = "^\\d+(\\s*[+\\-*/]\\s*\\d+)*$";
		return Pattern.matches(regex, expression);
	}

	public List<String> parseExpression(String expression) {
		return Arrays.stream(expression.split(" ")).collect(Collectors.toList());
	}

	public List<String> infixToPostfix(List<String> infixExpression) {
		List<String> postfixExpression = new ArrayList<>();
		Stack<String> st = new Stack<>();
		for (String ele : infixExpression) {
			if (StringUtils.isNumeric(ele)) {
				postfixExpression.add(ele);
				continue;
			}

			if (st.isEmpty()) {
				st.add(ele);
				continue;
			}

			ArithmeticOperator prevOperator = ArithmeticOperator.getArithmeticOperator(st.peek());
			ArithmeticOperator tempOperator = ArithmeticOperator.getArithmeticOperator(ele);
			if (ArithmeticOperator.comparePriority(prevOperator, tempOperator) < 0) {
				st.add(ele);
			} else {
				while (!st.isEmpty())
					postfixExpression.add(st.pop());
				st.add(ele);
			}
		}

		while (!st.isEmpty())
			postfixExpression.add(st.pop());

		return postfixExpression;
	}

	public double calculate(List<String> postfixExpression) throws CaculatorApplicationException {

		Stack<String> st = new Stack<>();

		for (String ele : postfixExpression) {
			if (StringUtils.isNumeric(ele)) {
				st.add(ele);
				continue;
			}

			Double right = Double.parseDouble(st.pop());
			Double left = Double.parseDouble(st.pop());
			String arithmeticOperator = ele;
			st.add(String.valueOf(ArithmeticOperator.calculate(arithmeticOperator, left, right)));
		}

		return Double.parseDouble(st.pop());
	}

	public int saveHistory(CalculationResult calculationResult) {
		return calculationRepository.save(calculationResult);
	}

}

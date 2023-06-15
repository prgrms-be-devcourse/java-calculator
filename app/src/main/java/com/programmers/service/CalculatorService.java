package com.programmers.service;

import com.programmers.calculator.Calculator;
import com.programmers.storage.Storage;
import com.programmers.util.Formula;

import java.util.List;

public class CalculatorService {
	
	private final Calculator calculator;
	private final Storage storage;
	
	public CalculatorService() {
		this.calculator = new Calculator();
		this.storage = new Storage();
	}
	
	public Integer calculate(String stringOfFormula) {
		Formula formula = new Formula(stringOfFormula);
		List<String> postfix = calculator.changeInfixToPostfix(formula.getInfixFormula());
		Integer result = calculator.calculatePostfix(postfix);
		storage.save(formula, result);
		return result;
	}
	
	public List<String> view() {
		return storage.findAll();
	}
	
}

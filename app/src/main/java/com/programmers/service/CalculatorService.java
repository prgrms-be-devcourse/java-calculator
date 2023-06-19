package com.programmers.service;

import com.programmers.storage.Storage;
import com.programmers.calculator.Formula;

import java.util.List;

public class CalculatorService {
	
	private final Storage storage;
	
	public CalculatorService() {
		this.storage = new Storage();
	}
	
	public Integer calculate(String stringOfFormula) {
		Formula formula = new Formula(stringOfFormula);
		Integer result = formula.calcualteFormula();
		storage.save(formula);
		return result;
	}
	
	public List<String> view() {
		return storage.findAll();
	}
	
}

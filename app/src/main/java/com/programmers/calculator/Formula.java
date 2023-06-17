package com.programmers.calculator;

import com.programmers.exception.InvalidFormulaException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Formula {
	
	private static final Pattern FORMULA_REGEX = Pattern.compile("([0-9] [+|\\-|*|/] )+[0-9]");
	private static final String EQUAL = " = ";
	
	private final Calculator calculator;
	
	private String formula;
	private Integer result;
	
	public Formula(String formula) {
		isValid(formula);
		this.formula = formula;
		this.calculator = new Calculator();
	}
	
	public List<String> getInfixListFormula() {
		return Arrays.stream(formula.split(" "))
			         .collect(Collectors.toList());
	}
	
	public void isValid(String formula) {
		if (!FORMULA_REGEX.matcher(formula).matches()) throw new InvalidFormulaException("유효하지 않은 수식 입력입니다.");
	}
	
	public Integer calcualteFormula() {
		result = calculator.calculate(getInfixListFormula());
		return result;
	}
	
	public String toString() {
		return formula + EQUAL + result;
	}
	
}

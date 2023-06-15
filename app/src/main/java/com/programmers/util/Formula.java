package com.programmers.util;

import com.programmers.exception.InvalidFormulaException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Formula {
	
	private final Pattern FORMULA_REGEX = Pattern.compile("([0-9] [+|-|*|/] )+[0-9]");
	private List<String> formula;
	
	public Formula(String expression) {
		isValid(expression);
		this.formula = Arrays.stream(expression.split(" "))
			                  .collect(Collectors.toList());
	}
	
	public List<String> getInfixFormula() {
		return formula;
	}
	
	public void isValid(String formula) {
		if (!FORMULA_REGEX.matcher(formula).matches()) throw new InvalidFormulaException("유효하지 않은 수식 입력입니다.");
	}
	
	public String toString(Integer result) {
		String formulaToString = formula.stream()
									.collect(Collectors.joining(" "));
		return formulaToString + " = " + result;
	}
	
}

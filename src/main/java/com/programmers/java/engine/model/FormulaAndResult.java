package com.programmers.java.engine.model;

public class FormulaAndResult {
	private String formula;
	private long result;

	public FormulaAndResult(String form, long result) {
		this.formula = form;
		this.result = result;
	}

	@Override
	public String toString() {
		return formula + result;
	}
}

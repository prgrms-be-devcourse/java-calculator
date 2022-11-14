package com.programmers.java.model;

import java.util.Objects;

public class History {
	private String formula;
	private int result;

	public History(String formula, int result) {
		this.formula = formula;
		this.result = result;
	}

	public int getResult() {
		return result;
	}

	@Override
	public String toString() {
		return formula + "=" + result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		History history = (History)o;
		return getResult() == history.getResult() && Objects.equals(formula, history.formula);
	}

	@Override
	public int hashCode() {
		return Objects.hash(formula, getResult());
	}
}

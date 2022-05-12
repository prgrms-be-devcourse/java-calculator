package com.programmers.java.engine.service;

import static com.programmers.java.engine.utils.Function.*;

import java.util.Optional;

public class FormulaValidationService {

	public Optional<String> validation(String formula) {
		String[] separatedBySpaces = formula.split(" ");

		if (separatedBySpaces.length < 3)
			return Optional.empty();

		boolean division = false;
		for (int i = 0; i < separatedBySpaces.length; i++) {
			if (i % 2 == 1) {
				if (!isOperator(separatedBySpaces[i])) {
					return Optional.empty();
				}

				if (separatedBySpaces[i].equals("/")) {
					division = true;
				}
			} else if (!checkValidNumber(separatedBySpaces[i], division)) {
					return Optional.empty();
				}

				division = false;
			}

		if (!isStrDigit(separatedBySpaces[separatedBySpaces.length - 1])){
			return Optional.empty();
		}

		return Optional.of(formula);
	}

	private boolean checkValidNumber(String separatedBySpaces, boolean division) {
		if (!isStrDigit(separatedBySpaces)) {
			return false;
		}

		if (separatedBySpaces.equals("0") && division) {
			return false;
		}

		return true;
	}
}

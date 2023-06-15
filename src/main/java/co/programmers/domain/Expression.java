package co.programmers.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.programmers.exception.ExceptionMessage;

public class Expression {

	private static final Pattern EXPRESSION_FORMAT = Pattern.compile("(\\d+\\s[\\+\\-\\*\\/]\\s)+\\d+");
	private static final String DELIMITER = " ";
	private String expression;

	public Expression(String expression) {
		this.expression = expression;
		if (!validate()) {
			throw new ArithmeticException(ExceptionMessage.INVALID_EXPRESSION);
		}
	}

	private boolean validate() {
		Matcher matcher = EXPRESSION_FORMAT.matcher(expression);
		return matcher.matches();
	}

	public List<String> split() {
		return new ArrayList<>(List.of(expression.split(DELIMITER)));
	}

	public List<String> split(String delimiter) {
		return new ArrayList<>(List.of(expression.split(delimiter)));
	}

	public void eliminateWhiteSpace() {
		expression = expression.replaceAll("\\s", "");
	}
}

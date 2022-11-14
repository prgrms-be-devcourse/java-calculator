package com.programmers.java.model.token.letter;

import java.util.Arrays;
import java.util.function.Predicate;

import com.programmers.java.model.token.number.Numbers;

public enum Bracket implements Letter {
	OPEN_BRACKET("(", 0, t -> {
		return Numbers.isNumbers(t) || t.equals("(");
	}),
	CLOSE_BRACKET(")", 0, t -> {
		return Operator.isOperator(t) || t.equals(")");
	});

	private String type;
	private int priority;
	private Predicate<String> checkNextTokenCorrectFunction;

	Bracket(String type, int priority,
		Predicate<String> checkNextTokenCorrectFunction) {
		this.type = type;
		this.priority = priority;
		this.checkNextTokenCorrectFunction = checkNextTokenCorrectFunction;
	}

	public static Bracket getBracketType(String type) {
		return Arrays.stream(Bracket.values())
			.filter(t -> t.type.equals(type))
			.findFirst()
			.orElseThrow();
	}

	@Override
	public String getValue() {
		return type;
	}

	@Override
	public boolean checkNextTokenCorrect(String nextToken) {
		return checkNextTokenCorrectFunction.test(nextToken);
	}

	@Override
	public int getPriority() {
		return priority;
	}
}

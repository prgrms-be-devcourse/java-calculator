package com.programmers.java.model.token.letter;

import java.util.Arrays;
import java.util.function.Predicate;

import com.programmers.java.model.token.TokenType;
import com.programmers.java.model.token.number.Numbers;

public enum Bracket implements Letter {
	OPEN_BRACKET("(", 0, t -> {
		return t instanceof Numbers || t.getValue().equals("(");
	}),
	CLOSE_BRACKET(")", 0, t -> {
		return t instanceof Operator || t.getValue().equals(")");
	});

	private String type;
	private int priority;
	private Predicate<TokenType> checkNextTokenCorrectFunction;

	Bracket(String type, int priority,
		Predicate<TokenType> checkNextTokenCorrectFunction) {
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
	public boolean checkNextTokenCorrect(TokenType nextToken) {
		return checkNextTokenCorrectFunction.test(nextToken);
	}

	@Override
	public int getPriority() {
		return priority;
	}
}

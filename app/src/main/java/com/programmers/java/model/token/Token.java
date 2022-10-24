package com.programmers.java.model.token;

public abstract class Token {
	private String token;

	public Token(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public abstract boolean checkNextTokenCorrect(Token nextToken);
}

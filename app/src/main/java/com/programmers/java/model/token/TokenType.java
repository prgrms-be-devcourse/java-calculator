package com.programmers.java.model.token;

public interface TokenType {

	String getValue();

	boolean checkNextTokenCorrect(String nextToken);
}

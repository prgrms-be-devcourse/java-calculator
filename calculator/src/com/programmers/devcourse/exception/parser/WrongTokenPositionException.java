package com.programmers.devcourse.exception.parser;

public class WrongTokenPositionException extends
	ParserException {

	@Override
	public String getMessage() {
		return "계산 입력 순서가 잘못되었습니다.";
	}
}

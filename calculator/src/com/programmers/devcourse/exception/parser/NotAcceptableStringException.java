package com.programmers.devcourse.exception.parser;

public class NotAcceptableStringException extends
	ParserException {

	@Override
	public String getMessage() {
		return "숫자와 연산자만 입력값으로 사용할 수 있습니다.";
	}
}

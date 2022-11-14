package com.programmers.java.io;

public enum Message {
	MENU_TABLE("""
		1. 조회
		2. 계산
		3. 종료
		선택 :\s"""),
	FORMULA_REQUEST("계산식을 입력해주세요: "),
	EXIT_MESSAGE("계산기를 종료합니다.");

	private String message;

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}

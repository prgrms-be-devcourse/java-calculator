package com.programmers.mission.message;

public enum ErrorMessage {
	CLIENT_ERROR("잘못된 입력입니다."),
	INTERNAL_ERROR("내부적으로 문제가 발생했습니다. 다시 시도해 주세요."),
	ZERO_DIVISION_ERROR("0으로 나눌 수 없습니다.");


	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "'" + message + '\'';
	}
}

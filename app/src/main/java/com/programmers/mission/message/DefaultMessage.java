package com.programmers.mission.message;

public enum DefaultMessage {
	MENU_LIST("1.조회\n2.계산\n3.종료\n"),
	SELECT("선택 : "),
	NEW_LINE("\n"),
	NONE(""),
	EXIT("프로그램을 종료합니다 ..");

	private final String message;

	DefaultMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return this.message;
	}
}

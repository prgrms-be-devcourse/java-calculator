package com.programmers.util;

import com.programmers.exception.NotFoundMenuException;

import java.util.Arrays;

public enum Menu {
	
	VIEW("1"),
	CALCULATE("2"),
	EXIT("3");
	
	private final String select;
	
	Menu(String select) {
		this.select = select;
	}
	
	public static Menu of(String select) {
		return Arrays.stream(Menu.values())
					.filter(menu -> menu.select.equals(select))
					.findFirst()
			        .orElseThrow(() -> new NotFoundMenuException("메뉴에서 없는 선택지입니다."));
	}
	
}

package com.programmers.util;

import com.programmers.exception.NotFoundMenuException;
import com.programmers.exception.NotNumberException;

import java.util.Arrays;
import java.util.regex.Pattern;

public enum Menu {
	
	VIEW(1),
	CALCULATE(2),
	EXIT(3);
	
	private final int select;
	static final Pattern NUMBER = Pattern.compile("\\d+");
	
	Menu(int select) {
		this.select = select;
	}
	
	public static Menu of(String select) {
		isNumber(select);
		int selectNum = Integer.parseInt(select);
		return Arrays.stream(Menu.values())
					.filter(menu -> menu.select == selectNum)
					.findFirst()
			        .orElseThrow(() -> new NotFoundMenuException("메뉴에서 없는 선택지입니다."));
	}
	
	private static void isNumber(String select) {
		if (!NUMBER.matcher(select).matches()) throw new NotNumberException("선택지는 숫자만 입력할 수 있습니다.");
	}
	
}
